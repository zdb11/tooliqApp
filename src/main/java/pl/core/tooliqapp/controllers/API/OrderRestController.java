package pl.core.tooliqapp.controllers.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.core.tooliqapp.order.Order;
import pl.core.tooliqapp.order.OrderMapper;
import pl.core.tooliqapp.order.OrderApiDto;
import pl.core.tooliqapp.order.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderApiDto> getOrders(){
        return orderService.getAllOrders().stream().map(OrderMapper::toApiDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<OrderApiDto>> getOrder(@PathVariable Long id){
        Optional<Order> order = orderService.findOrderById(id);
        if(order.isPresent())
            return ResponseEntity.ok(order.map(OrderMapper::toApiDto));
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Brak zamówienia z takim id");
    }
}
