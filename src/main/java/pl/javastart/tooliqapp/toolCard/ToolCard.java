package pl.javastart.tooliqapp.toolCard;


import org.springframework.stereotype.Service;

import org.springframework.web.context.annotation.SessionScope;
import pl.javastart.tooliqapp.order.Order;
import pl.javastart.tooliqapp.order.OrderStatus;
import pl.javastart.tooliqapp.tool.Tool;


@Service
@SessionScope
public class ToolCard {
    private Order order;

    public ToolCard() {
        newCard();
    }

    private void newCard(){
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
