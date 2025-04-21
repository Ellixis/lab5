package commands;

import app.App;
import object.Ticket;

import java.util.ArrayDeque;

public class Show implements Command {
    @Override
    public void execute(String argument) {
        ArrayDeque<Ticket> collection = App.getApp().getCollectionManager().getCollection();
        System.out.println(collection);
    }

    @Override
    public String getDescription() {
        return "";
    }
}
