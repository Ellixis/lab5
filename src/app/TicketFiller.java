package app;

import object.Coordinates;
import object.Ticket;

import java.util.Scanner;

public class TicketFiller {
    Scanner scanner = new Scanner(System.in);

    public Ticket ticketFill() {
        Ticket ticket = new Ticket();
        Coordinates coordinates = new Coordinates();
        String text;

        System.out.println("Введите имя:");
        while (true) {
            text = scanner.nextLine();
            if (fillName(ticket, text)) {
                break;
            }
        }

        System.out.println("Введите координаты:");
        while (true) {
            text = scanner.nextLine();

            if (fillCoordinates(ticket, coordinates, text)) {
                break;
            } else {
                System.out.println("ВВедите нормальные координаты");
            }
        }

        return ticket;
    }

    public boolean fillName(Ticket ticket, String text) {
        if (text != null & !text.isEmpty()) {
            ticket.setName(text);
            return true;
        } else {
            System.out.println("Ты дурак, введи нормально");
            return false;
        }

    }

    public boolean fillCoordinates(Ticket ticket, Coordinates coordinates, String text) {
        String[] parts = text.split(" ");
        if (parts.length >= 2) {
            try {
                int x = Integer.parseInt(parts[0]);
                double y = Double.parseDouble(parts[1]);

                if (y < -174) {
                    System.out.println("hue");
                    return false;
                } else {
                    coordinates.setX(x);
                    coordinates.setY(y);
                    ticket.setCoordinates(coordinates);
                    return true;
                }
            } catch (Exception e) {
                System.out.println("JHGFjevfhew");
                return false;
            }
        } else {
            System.err.println("Строка должна содержать два числа, разделённых пробелом!");
            return false;
        }
    }
}
