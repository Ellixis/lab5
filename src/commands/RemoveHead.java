package commands;

public class RemoveHead implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "вывести первый элемент коллекции и удалить его";
    }
}
