package inputOut;


import object.Tickets;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;

public class JAXBWorker {


    private final String fileName = "col.xml";
    
    public String convertObjectToXml(Tickets collection) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Tickets.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


        OutputStream os = new ByteArrayOutputStream();
        marshaller.marshal(collection, os);

        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")) {
            writer.write(os.toString());
            System.out.println("Коллекция успешно записана в файл");
        } catch (IOException e) {
            System.out.println("Не удалось записать коллекцию в файл");
        }


        return os.toString();
    }
    
    public Tickets convertXmlToObject(String text) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tickets.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(text);
            return (Tickets) un.unmarshal(reader);
        } catch (JAXBException e) {
            System.out.println("Не удалось загрузить коллекцию из файла");
            return null;
        } catch (NumberFormatException e) {
            System.out.println("Неверный id фильма в коллекции");
            return null;
        }
    }

}
