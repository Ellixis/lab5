package commands;

import app.App;
import app.CollectionManager;
import app.TicketFiller;
import object.Ticket;

public class AddIfMax implements Command {

    @Override
    //Хуйня ебаная
    public void execute(String argument) {
        TicketFiller ticketFiller = new TicketFiller();
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        collectionManager.setCurrentid();
        Ticket ticket1 = ticketFiller.ticketFill();
        if (collectionManager.isMax(ticket1)) {
            collectionManager.addTicket(ticket1);
            System.out.println("Элемент добавлен: " + ticket1.toString());
        } else {
            System.out.println("Элемент не добавлен: он не превышает максимальный элемент коллекции.");
        }
    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }
}
