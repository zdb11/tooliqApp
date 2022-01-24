package pl.core.tooliqapp.order;

import pl.core.tooliqapp.tool.Tool;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

     public static OrderApiDto toApiDto(Order order){
        OrderApiDto apiDto = new OrderApiDto();
        apiDto.setId(order.getId());
        apiDto.setFullName(order.getFullName());
        apiDto.setDepartment(order.getDepartment());
        apiDto.setStatus(order.getStatus());
        List<String> orderedToolsDto = new ArrayList<>();

        for (Tool tool : order.getTools()) {
            String toolName = tool.getName();
            String toolProducer = tool.getProducer();
            String orderedTool = toolName+" "+toolProducer;
            orderedToolsDto.add(orderedTool);
        }

        apiDto.setOrderedTools(orderedToolsDto);
        return apiDto;
    }
}
