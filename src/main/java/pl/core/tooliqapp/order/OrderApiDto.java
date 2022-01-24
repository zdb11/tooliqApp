package pl.core.tooliqapp.order;


import java.util.List;

public class OrderApiDto {
    private Long id;
    private String fullName;
    private String department;
    private OrderStatus status;
    private List<String> orderedTools;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<String> getOrderedTools() {
        return orderedTools;
    }

    public void setOrderedTools(List<String> orderedTools) {
        this.orderedTools = orderedTools;
    }
}
