package commands;

public class Exit implements Command{
    @Override
    public void execute(String argument) {

    }

    @Override
    public String getDescription() {
        return "завершить программу (без сохранения в файл)";
    }
}
