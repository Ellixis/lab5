package commands;

import app.App;
import app.CollectionManager;
import app.TicketFiller;
import object.Ticket;

public class UpdateId implements Command{
    @Override
    public void execute(String argument) {
        try {
            CollectionManager collectionManager = App.getApp().getCollectionManager();
            TicketFiller ticketFiller = new TicketFiller();
            if (collectionManager.findTickedById(Long.parseLong(argument)) == null) {
                System.out.println("Нет такого");
            } else {
                long ticket_id = collectionManager.findTickedById(Long.parseLong(argument)).getId();
                Ticket ticket = ticketFiller.ticketFill();
                collectionManager.addTicket(ticket, ticket_id);
                collectionManager.removeElement(collectionManager.findTickedById(Long.parseLong(argument)));
                System.out.println("Успех");
            }
        } catch (NumberFormatException e) {
            System.out.println("набери ты его нормально");
        }
    }

    @Override
    public String getDescription() {
        return "обновить значения элемента коллекции по id";
    }
}
