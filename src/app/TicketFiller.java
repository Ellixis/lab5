package app;

import object.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
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

        System.out.println("Он возвратный? true/false/null");
        while (true) {
            text = scanner.nextLine();
            if (fillRefundable(ticket, text)) {
                break;
            } else {
                System.out.println("Введите существующий скидос:");
            }
        }
        System.out.println("Введите тип билета:" + Arrays.toString(TicketType.values()));
        while (true) {
            text = scanner.nextLine();
            if (fillType(ticket, text)) {
                break;
            } else {
                System.out.println("Введите существующий тип билета:" + Arrays.toString(TicketType.values()));
            }
        }

        System.out.println("Хотите добавить событие к билету? (да/нет)");
        String answer;
        while (true) {
            answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("да") || answer.equals("нет")) {
                break;
            } else {
                System.out.println("Ошибка: введите только 'да' или 'нет'");
                System.out.println("Хотите добавить событие к билету? (да/нет)");
            }
        }
        if (answer.equals("да")) {
            Event event = new Event();

            System.out.println("Введите название события:");
            String name = scanner.nextLine();

            System.out.println("Введите минимальный возраст (или оставьте пустым):");
            String minAge = scanner.nextLine();

            System.out.println("Введите описание события (допустимое количество символов 1491):");
            String description = scanner.nextLine();

            System.out.println("Введите тип события (" + Arrays.toString(EventType.values()) + ") или оставьте пустым:");
            String eventType = scanner.nextLine();

            while (true) {
                if (fillEvent(event, name, minAge, description, eventType)) {
                    ticket.setEvent(event);
                    break;
                } else {
                    System.out.println("Попробуйте ввести данные события снова:");

                    System.out.println("Название события:");
                    name = scanner.nextLine();

                    System.out.println("Минимальный возраст:");
                    minAge = scanner.nextLine();

                    System.out.println("Описание:");
                    description = scanner.nextLine();

                    System.out.println("Тип события:");
                    eventType = scanner.nextLine();
                }
            }
        } else {
            ticket.setEvent(null);
        }





        return ticket;
    }
    private boolean fillType(Ticket ticket, String text) {
        if (text == null || text.trim().isEmpty()) {
            System.out.println("Ошибка: тип билета не может быть пустым");
            return false;
        }
        try {
            String normalizedText = text.trim().toUpperCase();
            TicketType type = TicketType.valueOf(normalizedText);
            ticket.setType(type);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: неизвестный тип билета ");
            return false;
        }
    }

    private boolean fillRefundable(Ticket ticket, String text) {
        if (text == null || text.trim().isEmpty()) {
            ticket.setRefundable(null);
            return true;
        }
        try {
            String lowerText = text.trim().toLowerCase();

            if ("true".equals(lowerText) || "да".equals(lowerText) || "1".equals(lowerText)) {
                ticket.setRefundable(true);
                return true;
            } else if ("false".equals(lowerText) || "нет".equals(lowerText) || "0".equals(lowerText)) {
                ticket.setRefundable(false);
                return true;
            } else {
                System.out.println("Пиши true/false/да/нет/1/0");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Ошибка при разборе значения возвратности");
            return false;
        }
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
            System.out.println("ок, цены нет");
            return true;
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








    public static boolean fillEvent(Event event, String name, String minAgeStr,
                                    String description, String eventTypeStr) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Ошибка: название события не может быть пустым");
            return false;
        }
        event.setName(name.trim());

        // Проверка минимального возраста
        if (minAgeStr != null && !minAgeStr.trim().isEmpty()) {
            try {
                long minAge = Long.parseLong(minAgeStr.trim());
                if (minAge <= 0) {
                    System.out.println("Ошибка: минимальный возраст должен быть больше 0");
                    return false;
                }
                event.setMinAge(minAge);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный формат минимального возраста");
                return false;
            }
        } else {
            event.setMinAge(null);
        }


        if (description == null || description.trim().isEmpty()) {
            System.out.println("Ошибка: описание не может быть null");
            return false;
        }
        if (description.length() > 1491) {
            System.out.println("Ошибка: описание слишком длинное (максимум 1491 символ)");
            return false;
        }
        event.setDescription(description);


        if (eventTypeStr != null && !eventTypeStr.trim().isEmpty()) {
            try {
                EventType type = EventType.valueOf(eventTypeStr.trim().toUpperCase());
                event.setEventType(type);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: неизвестный тип события");
                return false;
            }
        } else {
            event.setEventType(null);
        }


        event.setId(generateUniqueId());

        return true;
    }

    private static long generateUniqueId() {
        return System.currentTimeMillis(); // Можно заменить на более надежный вариант
    }

}

