package pl.javastart.tooliqapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.javastart.tooliqapp.tool.Tool;
import pl.javastart.tooliqapp.tool.ToolRepository;

import java.util.Optional;

@Controller
public class ToolController {
    private final ToolRepository toolRepository;

    public ToolController(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @GetMapping("/{hyperlink}")
    public String getTool(@PathVariable String hyperlink, Model model){
        Optional<Tool> tool = toolRepository.findByHyperlink(hyperlink);
        tool.ifPresent(tl->model.addAttribute("tool",tl));
        return tool.map(tl -> "tool").orElse("redirect:/");
    }

}
