package com.khoapham.controller;

import com.khoapham.dto.SongFormDto;
import com.khoapham.model.Song;
import com.khoapham.model.SongForm;
import com.khoapham.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class SongController {
    @Value("${upload-file}")
    private String fileUpload;

    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String goList(Model model) {
        List<Song> songs = iSongService.findAll();
        model.addAttribute("songs", songs);
        return "list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("songFormDto", new SongFormDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveSong(@ModelAttribute @Validated SongFormDto songFormDto,
                                 BindingResult bindingResult) {
        new SongFormDto().validate(songFormDto, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/create");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("songFormDto", songFormDto);

        } else {
            SongForm songForm = new SongForm();
            BeanUtils.copyProperties(songFormDto, songForm);

            MultipartFile multipartFile = songForm.getFilePath();
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(songForm.getFilePath().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Song song = new Song(songForm.getId(), songForm.getName(),
                    songForm.getArtist(), songForm.getGenre(), fileName);
            iSongService.save(song);

            modelAndView.addObject("message", "Created new song successfully !");
        }

        return modelAndView;
    }

    @PostMapping(value = "/delete")
    public String delete(Song song, RedirectAttributes redirect) {
        iSongService.remove(song.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        Song song = this.iSongService.findById(id);

        SongFormDto songFormDto
                = new SongFormDto(song.getId(),
                song.getName(),
                song.getArtist(),
                song.getGenre(), null
        );
        model.addAttribute("songFormDto", songFormDto);

        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated SongFormDto songFormDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect,
                         Model model) {

        new SongFormDto().validate(songFormDto, bindingResult);

        if (bindingResult.hasErrors()) {
            // model.addAttribute("songFormDto", songFormDto);
            return "/edit";
        } else {

            SongForm songForm = new SongForm();
            BeanUtils.copyProperties(songFormDto, songForm);

            MultipartFile multipartFile = songForm.getFilePath();
            String fileName = multipartFile.getOriginalFilename();
            try {
                FileCopyUtils.copy(songForm.getFilePath().getBytes(), new File(fileUpload + fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Song song = new Song(songForm.getId(), songForm.getName(),
                    songForm.getArtist(), songForm.getGenre(), fileName);
            iSongService.save(song);
            redirect.addFlashAttribute("success", "Update song successfully!");
            return "redirect:/";
        }

    }
}
