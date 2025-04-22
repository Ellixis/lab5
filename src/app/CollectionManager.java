package app;

import java.util.ArrayDeque;
import object.Ticket;
import object.Tickets;


public class CollectionManager {
    private ArrayDeque<Ticket> collection = new ArrayDeque<>();
    private Long currentid = 0L;

    public void setCollection(Tickets collection) {
        this.collection = collection.getTickets();
    }

    public ArrayDeque<Ticket> getCollection() {
        return collection;
    }
    public void addTicket(Ticket ticket){
        collection.add(ticket);
    }
    public void setCurrentid() {
        for (Ticket ticket : collection) {
            if (ticket.getId() > currentid) {
                currentid = ticket.getId();
            }
        }
    }
    public Long getCurrentid(){
        return ++currentid;
    }

    public void clearCollection() {
        collection.clear();
        currentid = 0L;
    }

}
