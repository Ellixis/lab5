package commands;

import app.App;
import app.CollectionManager;
import object.Ticket;

import java.util.ArrayDeque;



public class RemoveHead implements Command{
    @Override
    public void execute(String argument) {
        collectionManager.getCollection()
        if (tickets.getTickets().isEmpty()) {
            System.out.println("Очередь пуста - нечего удалять");
            return;
        }
        String firstElement = deque.getFirst();
        System.out.println("Удаляемый элемент: " + firstElement);

        deque.removeFirst();
        System.out.println("Элемент успешно удален");
    }

    @Override
    public String getDescription() {
        return "вывести первый элемент коллекции и удалить его";
    }
}
