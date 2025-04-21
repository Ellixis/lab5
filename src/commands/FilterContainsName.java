package commands;

public class FilterContainsName implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "вывести элементы, имя которых содержит заданную подстроку";
    }
}
