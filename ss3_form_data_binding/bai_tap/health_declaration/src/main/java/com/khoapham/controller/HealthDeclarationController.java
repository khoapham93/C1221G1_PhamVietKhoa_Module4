package com.khoapham.controller;

import com.khoapham.service.IHealthDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HealthDeclarationController {
    @Autowired
    private IHealthDeclarationService iHealthDeclarationService;

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("healthDeclaration", this.iHealthDeclarationService.getHealthDeclaration());
        return "form";
    }
//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("create");
//        modelAndView.addObject("songForm", new SongForm());
//        return modelAndView;
//    }

//@PostMapping("/save")
//public ModelAndView saveProduct(@ModelAttribute SongForm songForm) {
//    MultipartFile multipartFile = songForm.getFilePath();
//    String fileName = multipartFile.getOriginalFilename();
//    try {
//        FileCopyUtils.copy(songForm.getFilePath().getBytes(), new File(fileUpload + fileName));
//    } catch (IOException ex) {
//        ex.printStackTrace();
//    }
//    Song song = new Song(songForm.getId(), songForm.getName(),
//            songForm.getArtist(), songForm.getGenre(),fileName);
//    iSongService.save(song);
//    ModelAndView modelAndView = new ModelAndView("/create");
//    modelAndView.addObject("songForm", songForm);
//    modelAndView.addObject("message", "Created new song successfully !");
//    return modelAndView;
//}

}
