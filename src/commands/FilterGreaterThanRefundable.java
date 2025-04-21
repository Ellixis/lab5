package commands;

public class FilterGreaterThanRefundable implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "вывести элементы, значение поля refundable которых больше заданного";
    }
}
