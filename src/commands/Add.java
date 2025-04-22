package commands;

import app.App;
import app.CollectionManager;
import app.TicketFiller;
import object.Ticket;

public class Add implements Command {
    @Override
    public void execute(String argument) {
        TicketFiller ticketFiller = new TicketFiller();
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        collectionManager.setCurrentid();
        Ticket ticket = ticketFiller.ticketFill();
        collectionManager.addTicket(ticket);
        System.out.println(ticket.toString());
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию";
    }
}
