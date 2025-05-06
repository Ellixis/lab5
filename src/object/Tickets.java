package object;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayDeque;

@XmlRootElement()
public class Tickets implements Serializable {

    private ArrayDeque<Ticket> collection;

    public void setTickets(ArrayDeque<Ticket> collection) {
        this.collection = collection;
    }

    @XmlElement(name = "ticket")
    public ArrayDeque<Ticket> getTickets() {
        return collection;
    }
}