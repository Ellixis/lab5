package app;

import java.util.ArrayDeque;
import object.Ticket;
import object.Tickets;


public class CollectionManager {
    private ArrayDeque<Ticket> collection = new ArrayDeque<>();
    private Long currentid = 0L;
    private Long currentprice = 0L;

    public void setCollection(Tickets tickets) {
        this.collection = tickets.getTickets();
        for (Ticket ticket : collection) {
            if (ticket.getId() > currentid) {
                currentid = ticket.getId();
            }
        }
    }

    public ArrayDeque<Ticket> getCollection() {
        return collection;
    }
    public void addTicket(Ticket ticket){
        ticket.setId(getCurrentid());
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

    public boolean isMax(Ticket ticket1) {
        for (Ticket ticket : collection) {
            if (ticket.getPrice() > currentprice) {
                currentprice = ticket.getPrice();
            }
        }
        return !((double) currentprice > (double) ticket1.getPrice());
    }
    public Ticket findTickedById(long id) {
        for (Ticket ticket : collection) {
            if (ticket.getId().equals(id)) {
                return ticket;
            }
        }
        return null;
    }
    public void removeElement(Ticket ticket) {
        collection.remove(ticket);

    }
}
