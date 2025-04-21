package app;

import commands.Command;

public class ConsoleCaller {

    private final CommandManager commandManager = App.getApp().getCommandManager();

    public void call(String text) {
        String[] request = text.toLowerCase().split(" ");
        String argument = "";

        if (request.length > 1) {
            argument = request[1].trim();
        }

        try {
            Command command = commandManager.getCommandByKey(request[0]);
            command.execute(argument);
        } catch (NullPointerException e) {
            System.out.println("Попробуйте почитать help");
        }
    }
}
