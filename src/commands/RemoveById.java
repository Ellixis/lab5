package commands;

public class RemoveById implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "удалить элемент из коллекции по его id";
    }
}
