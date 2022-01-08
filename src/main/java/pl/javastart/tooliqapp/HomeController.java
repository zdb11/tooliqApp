package pl.javastart.tooliqapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.tooliqapp.tool.ToolRepository;


@Controller
public class HomeController {
    private final ToolRepository toolRepository;

    public HomeController(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @GetMapping("/")
    public String toolList(Model model){
        model.addAttribute("tools", toolRepository.findAll());
        return "index";
    }

}
