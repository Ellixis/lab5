package inputOut;


import object.Tickets;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JAXBWorker {


    private final String fileName = "col.xml";

    public String convertObjectToXml(Tickets collection) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Tickets.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter writer = new StringWriter();
        marshaller.marshal(collection, writer);
        String xmlContent = writer.toString();

        try (FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            osw.write(xmlContent);
            System.out.println("Коллекция успешно записана в файл");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }

        return xmlContent;
    }
    
    public Tickets convertXmlToObject(String text) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Tickets.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(text);
            return (Tickets) un.unmarshal(reader);
        } catch (JAXBException e) {
            String errorMessage = e.getMessage() != null ? e.getMessage() : "нет описания";

            Throwable linkedEx = e.getLinkedException();
            if (linkedEx != null) {
                errorMessage += " | Причина: " + linkedEx.getMessage();
            }

            Throwable rootCause = e.getCause();
            if (rootCause != null) {
                errorMessage += " | Корневая причина: " + rootCause.getMessage();
            }

            System.out.println("Не удалось загрузить коллекцию из файла: " + errorMessage);
            return null;
        }
//        } catch (NumberFormatException e) {
//            System.out.println("Неверный id фильма в коллекции");
//            return null;
//        }
    }

}
