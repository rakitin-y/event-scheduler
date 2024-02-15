package com.rakitin.event_scheduler.strategy.concrete_strategy;


import com.rakitin.event_scheduler.event.Event;
import com.rakitin.event_scheduler.event.EventList;
import com.rakitin.event_scheduler.strategy.OperationStrategy;

import java.time.LocalDate;
import java.util.List;

import static com.rakitin.event_scheduler.strategy.util.OperationUtil.*;

public class ShowAllEventsByDate implements OperationStrategy {
    @Override
    public void doOperation() {

        System.out.print("Введите дату для фильтрации (в формате \"ГГГГ-ММ-ДД\"): ");
        String timeStr = scanner.nextLine();

        try {
            LocalDate time = LocalDate.parse(timeStr, date);
            List<Event> eventList = EventList.getEventList();

            List<Event> eventListByDate = eventList.stream()
                    .filter(e -> e.getTime().toLocalDate().equals(time))
                    .toList();

            printListToConsole(eventListByDate);

        } catch (Exception e) {
            System.out.println("Вы ввели неверный формат времени, попробуйте снова!");
            doOperation();

        }
    }
}
