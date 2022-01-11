package pl.javastart.tooliqapp.toolCard;

import org.springframework.stereotype.Service;
import pl.javastart.tooliqapp.order.Order;
import pl.javastart.tooliqapp.order.OrderRepository;


@Service
public class ToolCartService {
    private final OrderRepository orderRepository;

    public ToolCartService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void orderCart(ToolCart toolCart){
        Order order = toolCart.getOrder();
        orderRepository.save(order);
    }
}
