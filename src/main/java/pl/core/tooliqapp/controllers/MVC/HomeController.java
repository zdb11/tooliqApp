package pl.core.tooliqapp.controllers.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.core.tooliqapp.tool.ToolRepository;
import pl.core.tooliqapp.toolCard.ToolCart;


@Controller
public class HomeController {
    private final ToolRepository toolRepository;
    private final ToolCart toolCart;

    public HomeController(ToolRepository toolRepository, ToolCart toolCart) {
        this.toolRepository = toolRepository;
        this.toolCart = toolCart;
    }

    @GetMapping("/home")
    public String toolList(Model model){
        model.addAttribute("tools", toolRepository.findAll());
        model.addAttribute("toolCart", toolCart.getOrder().getTools());
        return "index";
    }

}
