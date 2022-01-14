package pl.core.tooliqapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.core.tooliqapp.order.Order;
import pl.core.tooliqapp.order.OrderRepository;
import pl.core.tooliqapp.order.OrderService;
import pl.core.tooliqapp.order.OrderStatus;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class OrdersController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public OrdersController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/zamowienia")
    public String getOrders(Model model, @RequestParam(value = "status", required = false) OrderStatus status){
        if(status!=null){
            switch (status){
                case NEW, IN_PROGRESS, COMPLETE -> model.addAttribute("orders",orderRepository.findAll().stream().filter(or->or.getStatus().equals(status)).collect(Collectors.toList()));
            }
        }else{
            model.addAttribute("orders", orderRepository.findAll());
        }

        return "orders";
    }
    @GetMapping("/zamowienie")
    public String getOrder(Model model,@RequestParam("id") Long id ){
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(or->model.addAttribute("order",or));
        return "order";
    }
    @PostMapping("/zamowienie")
    public String updateStatus(Model model,@RequestParam("id") Long id){
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(orderService::updateStatusOrder);
        order.ifPresent(or->model.addAttribute("order",or));
        return "order";
    }
}
