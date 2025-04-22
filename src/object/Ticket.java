package object;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.util.Date;

@XmlRootElement
public class Ticket {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long price; //Поле может быть null, Значение поля должно быть больше 0
    private Double discount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 100
    private Boolean refundable; //Поле может быть null
    private TicketType type; //Поле не может быть null
    private Event event; //Поле может быть null


    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public int compareTo(Ticket ticket) {
        return Long.compare(this.id, ticket.getId());
    }
    public void setId(Long id) {
        this.id = id;
    }
    @XmlElement
    public Long getId() {
        return id;
    }
    @XmlElement
    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    @XmlElement
    public Double getDiscount() {
        return discount;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
    @XmlElement
    public Long getPrice() {
        return price;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;

    }
    @XmlElement
    public Date getCreationDate() {
        return creationDate;
    }
    @XmlElement
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public TicketType getType() {
        return type;
    }

    public Event getEvent() {
        return event;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", discount=" + discount +
                ", refundable=" + refundable +
                ", type=" + type +
                ", event=" + event +
                '}';
    }
}