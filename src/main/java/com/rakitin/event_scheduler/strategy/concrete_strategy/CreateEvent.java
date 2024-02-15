package com.rakitin.event_scheduler.strategy.concrete_strategy;


import com.rakitin.event_scheduler.event.Event;
import com.rakitin.event_scheduler.event.EventList;
import com.rakitin.event_scheduler.strategy.OperationStrategy;

import java.time.LocalDateTime;

import static com.rakitin.event_scheduler.strategy.util.OperationUtil.*;


public class CreateEvent implements OperationStrategy {
    @Override
    public void doOperation() {
        System.out.print("Введите описание события: ");
        String eventDescription = scanner.nextLine();
        System.out.print("Введите дату и время начала события (в формате \"ГГГГ-ММ-ДД ЧЧ:ММ\"): ");
        String timeInStr = scanner.nextLine();

        try {
            LocalDateTime time = LocalDateTime.parse(timeInStr, dateAndTime);
            EventList.addEventToList(new Event(eventDescription, time));

        } catch (RuntimeException e) {
            System.out.println("Вы ввели неверный формат времени, попробуйте снова!");
            doOperation();

        }
    }
}
