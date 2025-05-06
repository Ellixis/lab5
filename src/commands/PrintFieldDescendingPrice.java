package commands;

import app.App;
import app.CollectionManager;
import object.Ticket;

import java.util.ArrayDeque;

public class PrintFieldDescendingPrice implements Command{
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        collectionManager.seePrices();
    }

    @Override
    public String getDescription() {
        return "вывести значения поля price всех элементов в порядке убывания";
    }
}
