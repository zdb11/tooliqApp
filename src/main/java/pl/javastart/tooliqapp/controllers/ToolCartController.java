package pl.javastart.tooliqapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.tooliqapp.toolCard.Person;
import pl.javastart.tooliqapp.toolCard.ToolCart;
import pl.javastart.tooliqapp.toolCard.ToolCartService;


@Controller
public class ToolCartController {
    private final ToolCart toolCart;
    private final ToolCartService toolCartService;

    public ToolCartController(ToolCart toolCart, ToolCartService toolCartService) {
        this.toolCart = toolCart;
        this.toolCartService = toolCartService;
    }

    @PostMapping("/zamowienie")
    public String getToolCart(Person person, Model model){
        toolCart.getOrder().setFullName(person.getFullName());
        toolCart.getOrder().setDepartment(person.getDepartment());
        toolCartService.orderCart(toolCart);
        model.addAttribute("toolCart", toolCart.getOrder().getTools());
        toolCart.newCart();
        return "tool-cart";
    }
}
