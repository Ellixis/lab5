package object;

public class Event {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long minAge; //Поле может быть null
    private String description; //Длина строки не должна быть больше 1491, Поле не может быть null
    private EventType eventType; //Поле может быть null
}