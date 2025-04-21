package commands;

import app.App;
import inputOut.FileManager;

public class Save implements Command{
    @Override
    public void execute(String argument) {
        FileManager fileManager = App.getApp().getFileManager();
        fileManager.fileWriter();
    }

    @Override
    public String getDescription() {
        return "";
    }
}
