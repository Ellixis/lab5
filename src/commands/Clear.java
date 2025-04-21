package commands;

public class Clear implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "очистить коллекцию";
    }
}
