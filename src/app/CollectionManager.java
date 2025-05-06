package app;

import java.util.*;

import object.Ticket;
import object.Tickets;


public class CollectionManager {
    private ArrayDeque<Ticket> collection = new ArrayDeque<>();
    private Long currentid = 0L;
    private Long currentprice = 0L;

    public void setCollection(Tickets collection) {
        this.collection = collection.getTickets();
    }

    public ArrayDeque<Ticket> getCollection() {
        return collection;
    }
    public void addTicket(Ticket ticket){
        ticket.setId(getCurrentid());
        collection.add(ticket);
    }
    public void addTicket(Ticket ticket, long id){
        ticket.setId(id);
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
    public void seePrices() {
        List<Long> PricesList = new ArrayList<>();
        for (Ticket ticket : collection) {
            PricesList.add(ticket.getPrice());
        }
        PricesList.sort(Collections.reverseOrder());
        System.out.println(PricesList);
    }
    public void seeRefundable(boolean ref){
        ArrayDeque<Ticket> refList= new ArrayDeque<>();
        for (Ticket ticket : collection) {
           if (ticket.getRefundable() == ref) {
               refList.add(ticket);
           }
        }
        System.out.println(refList);
    }
    public void seeNames(String ticket_name){
        ArrayDeque<Ticket> nameList= new ArrayDeque<>();
        for (Ticket ticket : collection) {
            if (ticket.getName().contains(ticket_name)) {
                nameList.add(ticket);
            }
        }
        if (!nameList.isEmpty()) {
            System.out.println(nameList);
        }
        else {
            System.out.println("Таких элементов нет");
        }
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
