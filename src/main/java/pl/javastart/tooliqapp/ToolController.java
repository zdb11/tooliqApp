package pl.javastart.tooliqapp;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javastart.tooliqapp.tool.Tool;
import pl.javastart.tooliqapp.tool.ToolRepository;
import pl.javastart.tooliqapp.toolCard.Result;
import pl.javastart.tooliqapp.toolCard.ToolCard;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class ToolController {
    private final ToolRepository toolRepository;
    private ToolCard toolCard;

    public ToolController(ToolRepository toolRepository, ToolCard toolCard) {
        this.toolRepository = toolRepository;
        this.toolCard = toolCard;
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
        tool.ifPresent(toolCard::addTool);
        if(tool.isPresent()){
            model.addAttribute("result",new Result("Udało się!","Narzędzie zostało dodane do koszyka."));
        }else{
            model.addAttribute("result",new Result("Nie udało się!", "Narzędzie nie zostało dodane do koszyka, spróbuj ponownie."));
        }
        return "result";
    }
}
