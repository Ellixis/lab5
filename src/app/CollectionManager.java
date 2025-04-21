package app;

import java.util.ArrayDeque;
import object.Ticket;
import object.Tickets;


public class CollectionManager {
    private ArrayDeque<Ticket> collection = new ArrayDeque<>();

    public void setCollection(Tickets collection) {
        this.collection = collection.getTickets();
    }

    public ArrayDeque<Ticket> getCollection() {
        return collection;
    }
    public void addTicket(Ticket ticket){
        collection.add(ticket);
    }

}
