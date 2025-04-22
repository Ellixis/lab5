package commands;

import app.App;
import app.ConsoleCaller;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.stream.Collectors;


public class History implements Command{
    @Override
    public void execute(String argument) {
        System.out.println(getLast15Commands());
    }

    public static String getLast15Commands() {
        ArrayDeque<String> deque = App.getDeque();
        StringBuilder result = new StringBuilder();

        Iterator<String> iterator = deque.descendingIterator();

        // Выводим максимум 15 последних команд
        int count = 0;
        while (iterator.hasNext() && count < 15) {
            result.insert(0,iterator.next() + " "); // Добавляем в начало для сохранения порядка
            count++;
        }

        return result.toString();
    }



    @Override
    public String getDescription() {
        return "вывести последние 15 команд";
    }
}
