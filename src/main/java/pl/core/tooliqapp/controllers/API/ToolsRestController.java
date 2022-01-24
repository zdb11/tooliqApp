package pl.core.tooliqapp.controllers.API;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.core.tooliqapp.tool.Tool;
import pl.core.tooliqapp.tool.ToolRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tools")
public class ToolsRestController {
    private final ToolRepository toolRepository;

    public ToolsRestController(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @GetMapping
    public List<Tool> getTools(){
        return toolRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tool>> getTool(@PathVariable Long id){
        Optional<Tool> tool = toolRepository.findById(id);
        if(tool.isPresent())
            return ResponseEntity.ok(tool);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Brak narzędzia z takim id");
    }
}
