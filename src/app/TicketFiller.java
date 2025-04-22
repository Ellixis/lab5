package app;

import object.Coordinates;
import object.Ticket;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class TicketFiller {
    Scanner scanner = new Scanner(System.in);

    public Ticket ticketFill() {
        Ticket ticket = new Ticket();
        Coordinates coordinates = new Coordinates();
        LocalDateTime creationDate = LocalDateTime.now();
        Date date = Date.from(creationDate.atZone(ZoneId.systemDefault()).toInstant());
        ticket.setCreationDate(date);
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

        System.out.println("Введите Price:");
        while (true) {
            text = scanner.nextLine();
            if (fillPrice(ticket, text)) {
                break;
            } else {
                System.out.println("Введите нормальный Price:");
            }
        }

        System.out.println("Введите скидос:");
        while (true) {
            text = scanner.nextLine();
            if (fillDiscount(ticket, text)) {
                break;
            } else {
                System.out.println("Введите существующий скидос:");
            }
        }



        return ticket;
    }

    private boolean fillDiscount(Ticket ticket, String text) {
        try {
            double value = Double.parseDouble(text);
            if (value <= 100 & value > 0) {
                ticket.setDiscount(value);
                return true;
            } else {
                System.out.println("Впервые вижу такую скидку");
                return false;
            }


        } catch (Exception e) {
            System.out.println("Чёт не похоже на скидку");
            return false;
        }
    }

    private boolean fillPrice(Ticket ticket, String text) {
        try {
            long value = Long.parseLong(text);
            if (value > 0) {
                ticket.setPrice(value);
                return true;
            } else {
                System.out.println("Найс цена чел");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Чёт не похоже на цену");
            return false;
        }
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
