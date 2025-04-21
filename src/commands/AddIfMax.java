package commands;

public class AddIfMax implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции";
    }
}
