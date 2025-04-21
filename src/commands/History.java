package commands;

public class History implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "вывести последние 15 команд";
    }
}
