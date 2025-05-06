package commands;

import app.App;
import app.CollectionManager;

public class FilterContainsName implements Command{
    @Override
    public void execute(String argument) {
        System.out.println("Элементы, имена которых содержат подстроку " + argument + ":");
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        collectionManager.seeNames(argument);
    }

    @Override
    public String getDescription() {
        return "вывести элементы, имя которых содержит заданную подстроку";
    }
}
