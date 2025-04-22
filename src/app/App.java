package app;

import inputOut.FileManager;

import java.util.*;

public class App {
    private static App app;
    private CommandManager commandManager;
    private ConsoleCaller consoleCaller;
    private CollectionManager collectionManager;
    private FileManager fileManager;
    Scanner scanner = new Scanner(System.in);
    private static ArrayDeque<String> deque = new ArrayDeque<>();

    public static String getDequeAsString() {
        return deque.toString();
    }

    private App() {
    }

    public static App getApp() {
        if (app == null) {
            app = new App();
        }
        return app;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
    public CommandManager getCommandManager() {
        return commandManager;
    }


    public void setConsoleCaller(ConsoleCaller consoleCaller) {
        this.consoleCaller = consoleCaller;
    }
    public ConsoleCaller getConsoleCaller() {
        return consoleCaller;
    }


    public CollectionManager getCollectionManager() {
        return collectionManager;
    }
    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public static void AddDeque(String argument) {
        deque.add(argument);
    }

    public void start() {

        while (true) {
            try {
                String text = scanner.nextLine().toLowerCase().trim();
                if (text.equals("exit")) {
                    break;
                }


                consoleCaller.call(text);
            } catch (NoSuchElementException e) {
                System.out.println("Ctrl + D. ");
                break;
            }
        }
    }
}
