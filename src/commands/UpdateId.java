package commands;

public class UpdateId implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "обновить значение элемента коллекции по id";
    }
}
