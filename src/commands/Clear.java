package commands;

import app.App;
import app.CollectionManager;

public class Clear implements Command{
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        if (collectionManager.getCollection().isEmpty()) {
            System.out.println("Он уже пустой");
        } else {
            collectionManager.clearCollection();
            System.out.println("Коллекция очищена");
        }
    }
    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
