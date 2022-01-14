package pl.core.tooliqapp.tool;

import javax.persistence.*;

@Entity
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String producer;
    private String description;
    @Column(length = 1024)
    private int parameterSpeed;
    private float parameterFeed;
    private String hyperlink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParameterSpeed() {
        return parameterSpeed;
    }

    public void setParameterSpeed(int parameterSpeed) {
        this.parameterSpeed = parameterSpeed;
    }

    public float getParameterFeed() {
        return parameterFeed;
    }

    public void setParameterFeed(float parameterFeed) {
        this.parameterFeed = parameterFeed;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

}