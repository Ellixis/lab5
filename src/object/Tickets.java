package object;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayDeque;
import java.util.LinkedList;

@XmlRootElement()
public class Tickets {

    private ArrayDeque<Ticket> collection;

    public void setTickets(ArrayDeque<Ticket> collection) {
        this.collection = collection;
    }

    @XmlElement(name = "ticket")
    public ArrayDeque<Ticket> getTickets() {
        return collection;
    }
}