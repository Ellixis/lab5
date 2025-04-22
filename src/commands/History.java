package commands;

import app.App;
import app.ConsoleCaller;

public class History implements Command{
    @Override
    public void execute(String argument) {
        App app =  App.getApp();
        System.out.println(App.getDequeAsString());
    }

    @Override
    public String getDescription() {
        return "вывести последние 15 команд";
    }
}
