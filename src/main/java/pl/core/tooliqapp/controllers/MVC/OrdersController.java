package pl.core.tooliqapp.controllers.MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.core.tooliqapp.order.Order;
import pl.core.tooliqapp.order.OrderService;
import pl.core.tooliqapp.order.OrderStatus;

import java.util.Optional;

@Controller
public class OrdersController {
    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/zamowienia")
    public String getOrders(Model model, @RequestParam(value = "status", required = false) OrderStatus status){
        if(status!=null){
            switch (status){
                case NEW, IN_PROGRESS, COMPLETE -> model.addAttribute("orders",orderService.getOrderByStatus(status));
            }
        }else{
            model.addAttribute("orders", orderService.getAllOrders());
        }
        return "orders";
    }

    @GetMapping("/zamowienie")
    public String getOrder(Model model,@RequestParam("id") Long id ){
        Optional<Order> order = orderService.findOrderById(id);
        order.ifPresent(or->model.addAttribute("order",or));
        return "order";
    }

    @PostMapping("/zamowienie")
    public String updateStatus(Model model,@RequestParam("id") Long id){
        Optional<Order> order = orderService.findOrderById(id);
        order.ifPresent(orderService::updateStatusOrder);
        order.ifPresent(or->model.addAttribute("order",or));
        return "order";
    }
}
