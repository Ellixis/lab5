package object;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class Event implements Serializable {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long minAge; //Поле может быть null
    private String description; //Длина строки не должна быть больше 1491, Поле не может быть null
    private EventType eventType; //Поле может быть null

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setMinAge(Long minAge) {
        this.minAge = minAge;
    }


    @XmlElement
    public String getName() {
        return name;
    }

    @XmlElement
    public EventType getEventType() {
        return eventType;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    @XmlElement
    public Long getMinAge() {
        return minAge;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", name='" + name + '\'' +
                ", minAge=" + minAge +
                ", description='" + description + '\'' +
                ", eventType=" + eventType +
                '}';
    }
    public String toStringForCheck(){
        return name + " " + minAge + " " + description + " " + eventType;
    }
}