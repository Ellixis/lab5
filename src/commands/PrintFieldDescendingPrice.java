package commands;

public class PrintFieldDescendingPrice implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "вывести значения поля price всех элементов в порядке убывания";
    }
}
