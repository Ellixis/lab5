package commands;

import app.App;
import app.CollectionManager;
import object.Ticket;

public class Info implements Command{
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        if (!collectionManager.getCollection().isEmpty()) {
            System.out.println("Type of collection: " + collectionManager.getCollection().getClass().getSimpleName() +
                    "\nType of elements: " + Ticket.class.getSimpleName() +
                    "\nInitialization date: " + collectionManager.findTickedById(1L).getCreationDate() +
                    "\nNumber of collection items: " + collectionManager.getCollection().size());
        } else {
            System.out.println("Коллекция пустая");
        }
    }

    @Override
    public String getDescription() {
        return "вывести информацию о коллекции";
    }
}
