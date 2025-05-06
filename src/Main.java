import app.App;
import app.CollectionManager;
import app.CommandManager;
import app.ConsoleCaller;
import commands.*;
import inputOut.FileManager;

public class Main {
    public static void main(String[] args) {
        App app =  App.getApp();
        app.setCollectionManager(new CollectionManager());

        CommandManager commandManager = new CommandManager();
        app.setCommandManager(commandManager);
        app.setConsoleCaller(new ConsoleCaller());
        FileManager fileManager = new FileManager();
        app.setFileManager(fileManager);

        commandManager.registerCommand("add", new Add());
        commandManager.registerCommand("show", new Show());
        commandManager.registerCommand("save", new Save());
        commandManager.registerCommand("help", new Help());
        commandManager.registerCommand("exit", new Exit());
        commandManager.registerCommand("history", new History());
        commandManager.registerCommand("clear", new Clear());
        commandManager.registerCommand("info", new Info());
        commandManager.registerCommand("remove_by_id", new RemoveById());
        commandManager.registerCommand("remove_head", new RemoveHead());
        commandManager.registerCommand("add_if_max", new AddIfMax());
        commandManager.registerCommand("update_id", new UpdateId());
        fileManager.importCollection();
        app.start();



    }
}