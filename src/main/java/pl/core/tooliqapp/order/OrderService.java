package pl.core.tooliqapp.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.core.tooliqapp.toolCard.ToolCart;


@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void orderCart(ToolCart toolCart){
        Order order = toolCart.getOrder();
        orderRepository.save(order);
    }
    @Transactional
    public void updateStatusOrder(Order order){
        if(order.getStatus().equals(OrderStatus.NEW)){
            order.setStatus(OrderStatus.IN_PROGRESS);
            orderRepository.save(order);
        }else if(order.getStatus().equals(OrderStatus.IN_PROGRESS)){
            order.setStatus(OrderStatus.COMPLETE);
            orderRepository.save(order);
        }
    }

}
