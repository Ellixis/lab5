package commands;

import app.App;
import app.CollectionManager;

public class RemoveById implements Command{
    @Override
    public void execute(String argument) {
        try {
            CollectionManager collectionManager = App.getApp().getCollectionManager();
            if (collectionManager.findTickedById(Long.parseLong(argument)) == null) {
                System.out.println("Нет такого");
            } else {
                collectionManager.removeElement(collectionManager.findTickedById(Long.parseLong(argument)));
                System.out.println("Успех");
            }
        } catch (NumberFormatException e) {
            System.out.println("набери ты его нормально");
        }
    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id";
    }
}
