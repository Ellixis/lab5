package commands;

import app.App;
import app.CollectionManager;

import java.util.Objects;

public class FilterGreaterThanRefundable implements Command{
    @Override
    public void execute(String argument) {
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        if (Objects.equals(argument, "true") || Objects.equals(argument, "True")) {
            System.out.println("Билеты которые можно вернуть:");
            collectionManager.seeRefundable(true);
        } else if (Objects.equals(argument, "false") || Objects.equals(argument, "False")) {
            System.out.println("Билеты которые нельзя вернуть:");
            collectionManager.seeRefundable(false);
        }
        else {
            System.out.println("Введите true/false");
        }

    }
    @Override
    public String getDescription() {
        return "вывести элементы, значение поля refundable которых равно заданному";
    }
}
