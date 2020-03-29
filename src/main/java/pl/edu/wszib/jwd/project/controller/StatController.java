package pl.edu.wszib.jwd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.jwd.project.dao.SelectedColorDao;
import pl.edu.wszib.jwd.project.model.SelectedColor;

import java.util.Collection;

@Controller
public class StatController {

    @Value("${app.title.stat}")
    private String title;
    @Autowired
    SelectedColorDao selectedColorDao;

    @GetMapping("/stat")
    public String staticPage(Model model){
        Iterable<SelectedColor> selectedColors=  selectedColorDao.findAll();
        Collection<SelectedColor>selectedColorCollection = (Collection<SelectedColor>) selectedColors;

        model.addAttribute("title",title);

        return "stat";
    }
}
