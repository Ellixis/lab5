package inputOut;

import app.TicketFiller;
import object.Coordinates;
import object.Event;
import object.Ticket;
import object.Tickets;

public class TicketsChecker {
    public static boolean checkTickets(Tickets tickets){

        for (Ticket ticket: tickets.getTickets()){
            if (!checkTicket(ticket)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkTicket(Ticket ticket){
        Ticket ticket_new = new Ticket();
        if (ticket.getEvent()==null){
            return TicketFiller.fillName(ticket_new, ticket.getName()) &
                    TicketFiller.fillType(ticket_new, ticket.getType().name()) &
                    TicketFiller.fillRefundable(ticket_new, String.valueOf(ticket.getRefundable())) &
                    TicketFiller.fillDiscount(ticket_new, String.valueOf(ticket.getDiscount())) &
                    TicketFiller.fillPrice(ticket_new, String.valueOf(ticket.getPrice())) &
                    TicketFiller.fillCoordinates(ticket_new, new Coordinates(), String.valueOf(ticket.getCoordinates().getX())+ " " + String.valueOf(ticket.getCoordinates().getY())) ;

        } else {
            return TicketFiller.fillName(ticket_new, ticket.getName()) &
                    TicketFiller.fillType(ticket_new, ticket.getType().name()) &
                    TicketFiller.fillRefundable(ticket_new, String.valueOf(ticket.getRefundable())) &
                    TicketFiller.fillDiscount(ticket_new, String.valueOf(ticket.getDiscount())) &
                    TicketFiller.fillPrice(ticket_new, String.valueOf(ticket.getPrice())) &
                    TicketFiller.fillCoordinates(ticket_new, new Coordinates(), String.valueOf(ticket.getCoordinates().getX()) + " " + String.valueOf(ticket.getCoordinates().getY())) &
                    TicketFiller.fillEvent(new Event(), ticket.getEvent().toStringForCheck().split(" ")[0], ticket.getEvent().toStringForCheck().split(" ")[1], ticket.getEvent().toStringForCheck().split(" ")[2], ticket.getEvent().toStringForCheck().split(" ")[3]);
        }


    }

}
