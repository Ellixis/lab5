import app.App;
import app.CollectionManager;
import app.CommandManager;
import app.ConsoleCaller;
import commands.Add;
import commands.Save;
import commands.Show;
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
        fileManager.importCollection();

        app.start();



    }
}