package com.rakitin.event_scheduler.strategy.concrete_strategy;


import com.rakitin.event_scheduler.event.Event;
import com.rakitin.event_scheduler.event.EventList;
import com.rakitin.event_scheduler.strategy.OperationStrategy;

import java.util.List;

import static com.rakitin.event_scheduler.strategy.util.OperationUtil.*;

public class DeleteEvent implements OperationStrategy {
    @Override
    public void doOperation() {
        System.out.print("Введите номер события для удаления: ");
        int id = scanner.nextInt();
        List<Event> eventList = EventList.getEventList();

        try {
            String eventDescription = eventList.get(id - 1).getEventDescription();
            EventList.deleteEventFromList(id - 1);

            System.out.printf("Событие \"%s\" успешно удалено!\n", eventDescription);

        } catch (Exception e) {
            System.out.println("Под данным индексом события не существует!\nПопробуйте снова");

        }
    }
}
