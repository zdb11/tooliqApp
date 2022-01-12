package pl.javastart.tooliqapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.tooliqapp.order.OrderRepository;
import pl.javastart.tooliqapp.order.OrderStatus;
import java.util.stream.Collectors;

@Controller
public class OrdersController {
    private final OrderRepository orderRepository;

    public OrdersController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/zamowienia")
    public String getOrders(Model model, @RequestParam(value = "status", required = false) OrderStatus status){
        if(status!=null){
            switch (status){
                case NEW -> model.addAttribute("orders",orderRepository.findAll().stream().filter(or->or.getStatus().equals(status)).collect(Collectors.toList()));
                case IN_PROGRESS -> model.addAttribute("orders",orderRepository.findAll().stream().filter(or->or.getStatus().equals(status)).collect(Collectors.toList()));
                case COMPLETE -> model.addAttribute("orders",orderRepository.findAll().stream().filter(or->or.getStatus().equals(status)).collect(Collectors.toList()));
            }
        }else{
            model.addAttribute("orders", orderRepository.findAll());
        }

        return "orders";
    }
}
