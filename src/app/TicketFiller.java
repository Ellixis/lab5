package app;

import object.Ticket;

import java.util.Scanner;

public class TicketFiller {
    Scanner scanner = new Scanner(System.in);
    public Ticket ticketFill(){
        Ticket ticket = new Ticket();
        String text;
        System.out.println("Введите имя:");
        while (true){
            text = scanner.nextLine();
            if (fillName(ticket, text)){
                break;
            }
        }
        return ticket;
    }
    public boolean fillName(Ticket ticket, String text){
        if (text != null & !text.isEmpty()) {
            ticket.setName(text);
            return true;
        } else {
            System.out.println("Ты дурак, введи нормально");
            return false;
        }

    }

}
