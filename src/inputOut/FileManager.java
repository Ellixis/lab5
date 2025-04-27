package inputOut;


import app.App;
import app.CollectionManager;
import app.CommandManager;
import app.ConsoleCaller;
import jakarta.xml.bind.SchemaOutputResolver;
import object.Tickets;
import jakarta.xml.bind.JAXBException;

import java.io.*;
import java.util.Scanner;


public class FileManager {


    private final String fileName = "col.xml";

  
    private final CollectionManager collectionManager = App.getApp().getCollectionManager();
    private final CommandManager commandManager = App.getApp().getCommandManager();
    private final ConsoleCaller consoleCaller = App.getApp().getConsoleCaller();

    private String text;


    public void importCollection() {
        File file = null;
        try {
            file = new File(fileName);
        } catch (NullPointerException e) {
            System.out.println("Не передано имя файла. Программа будет завершена");
            System.exit(0);
        }

        if (file != null) {
            if (file.exists()) {
                if (!file.canRead()){
                    System.out.println("Ошибка: Нет прав доступа к файлу. Программа будет завершена");
                    System.exit(0);
                } else {
                    fileReader(file);
                    textToObject();
                }
            } else {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("Неверное имя файла. Программа будет завершена");
                    System.exit(0);
                }
            }
        }
    }

    
    public void fileReader(File file) {
        try {
            Scanner scanner = new Scanner(file, "UTF-8");
            scanner.useDelimiter("<!--target-->");
            if (scanner.hasNext()) {
                text = scanner.next();
            }
        } catch (FileNotFoundException e){
            System.out.println("Ошибка: отсутствует файл");
        }
    }



    public void textToObject() {
        if (text != null) {

            JAXBWorker jaxbWorker = new JAXBWorker();
            Tickets tickets = jaxbWorker.convertXmlToObject(text);
            if ((tickets != null) && (tickets.getTickets() != null)) {
                    if (TicketsChecker.checkTickets(tickets)){
                        collectionManager.setCollection(tickets);
                        System.out.println("Коллекция успешно импортирована из файла");
                    } else {
                        System.out.println("Коллекция не была импортирована");
                    }


                }

            }
        }



    public void fileWriter() {
        JAXBWorker jaxbWorker = new JAXBWorker();
        File file = new File("./" + fileName);
        CollectionManager collectionManager = App.getApp().getCollectionManager();
        Tickets tickets = new Tickets();
        tickets.setTickets(collectionManager.getCollection());
        if (tickets.getTickets().isEmpty()) {
            if (file.exists()) {
                try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")) {
                    writer.write("");
                    System.out.println("Коллекция пуста, файл очищен");
                } catch (IOException e) {
                    System.out.println("Не удалось очистить файл");
                }
            } else {
                System.out.println("Коллекция пуста");
            }
        } else {
            try {
                jaxbWorker.convertObjectToXml(tickets);
            } catch (JAXBException e) {
                System.out.println("Не удалось записать коллекцию в файл");
            }
        }
    }
}