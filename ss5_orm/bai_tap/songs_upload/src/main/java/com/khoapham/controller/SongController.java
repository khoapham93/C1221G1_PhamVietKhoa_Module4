package com.khoapham.controller;

import com.khoapham.model.Song;
import com.khoapham.model.SongForm;
import com.khoapham.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
        modelAndView.addObject("songForm", new SongForm());
        return modelAndView;
    }
@PostMapping("/save")
public ModelAndView saveSong(@ModelAttribute SongForm songForm) {
    MultipartFile multipartFile = songForm.getFilePath();
    String fileName = multipartFile.getOriginalFilename();
    try {
        FileCopyUtils.copy(songForm.getFilePath().getBytes(), new File(fileUpload + fileName));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    Song song = new Song(songForm.getId(), songForm.getName(),
            songForm.getArtist(), songForm.getGenre(),fileName);
    iSongService.save(song);
    ModelAndView modelAndView = new ModelAndView("/create");
    modelAndView.addObject("songForm", songForm);
    modelAndView.addObject("message", "Created new song successfully !");
    return modelAndView;
}

}
