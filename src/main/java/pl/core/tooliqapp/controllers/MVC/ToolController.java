package pl.core.tooliqapp.controllers.MVC;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.core.tooliqapp.tool.Tool;
import pl.core.tooliqapp.tool.ToolRepository;
import pl.core.tooliqapp.toolCard.Result;
import pl.core.tooliqapp.toolCard.ToolCart;

import java.util.Optional;

@Controller
public class ToolController {
    private final ToolRepository toolRepository;
    private final ToolCart toolCart;

    public ToolController(ToolRepository toolRepository, ToolCart toolCart) {
        this.toolRepository = toolRepository;
        this.toolCart = toolCart;
    }

    @GetMapping("/tool/{hyperlink}")
    public String getTool(@PathVariable String hyperlink, Model model){
        Optional<Tool> tool = toolRepository.findByHyperlink(hyperlink);
        tool.ifPresent(tl->model.addAttribute("tool",tl));
        return tool.map(tl -> "tool").orElse("redirect:/home");
    }

    @GetMapping("/saveTool/{id}")
    public String saveTool(@PathVariable Long id, Model model){
        Optional<Tool> tool = toolRepository.findById(id);
        tool.ifPresent(toolCart::addTool);
        if(tool.isPresent()){
            model.addAttribute("result",new Result("Udało się!","Narzędzie zostało dodane do koszyka."));
        }else{
            model.addAttribute("result",new Result("Nie udało się!", "Narzędzie nie zostało dodane do koszyka, spróbuj ponownie."));
        }
        return "result";
    }
}
