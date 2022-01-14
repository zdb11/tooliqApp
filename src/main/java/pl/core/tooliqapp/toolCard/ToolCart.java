package pl.core.tooliqapp.toolCard;


import org.springframework.stereotype.Service;

import org.springframework.web.context.annotation.SessionScope;
import pl.core.tooliqapp.order.Order;
import pl.core.tooliqapp.order.OrderStatus;
import pl.core.tooliqapp.tool.Tool;


@Service
@SessionScope
public class ToolCart {
    private Order order;

    public ToolCart() {
        newCart();
    }

    public void newCart(){
        order = new Order();
        order.setStatus(OrderStatus.NEW);
    }

    public void addTool(Tool tool){
        order.getTools().add(tool);
    }

    public Order getOrder() {
        return order;
    }

}
