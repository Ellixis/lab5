package commands;

import app.App;
import app.CollectionManager;
import object.Ticket;
import java.util.ArrayDeque;

public class RemoveHead implements Command{
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        ArrayDeque<Ticket> collection = collectionManager.getCollection();
        System.out.println(collection.peek()+ " удалён");
        collection.remove();

    }

    @Override
    public String getDescription() {
        return "вывести первый элемент коллекции и удалить его";
    }
}
