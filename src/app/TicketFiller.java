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
        int x;
        double y;
        while (true) {
            try {
                x = scanner.nextInt();
                y = scanner.nextDouble();
                if (y < -174){
                    System.out.println("hue");

                } else {
                    coordinates.setX(x);
                    coordinates.setY(y);
                    break;
                }
            }catch (Exception e){
                System.out.println("JHGFjevfhew");
            }

        }
        fillCoordinates(ticket, coordinates);{

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

    public void fillCoordinates(Ticket ticket, Coordinates coordinates) {
        ticket.setCoordinates(coordinates);
            }


}


