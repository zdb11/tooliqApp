package pl.javastart.tooliqapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.tooliqapp.toolCard.Person;
import pl.javastart.tooliqapp.toolCard.ToolCart;
import pl.javastart.tooliqapp.order.OrderService;


@Controller
public class ToolCartController {
    private final ToolCart toolCart;
    private final OrderService orderService;

    public ToolCartController(ToolCart toolCart, OrderService orderService) {
        this.toolCart = toolCart;
        this.orderService = orderService;
    }

    @PostMapping("/koszyk")
    public String getToolCart(Person person, Model model){
        toolCart.getOrder().setFullName(person.getFullName());
        toolCart.getOrder().setDepartment(person.getDepartment());
        orderService.orderCart(toolCart);
        model.addAttribute("toolCart", toolCart.getOrder().getTools());
        toolCart.newCart();
        return "tool-cart";
    }
}
