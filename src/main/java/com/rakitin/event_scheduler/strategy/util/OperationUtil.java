package com.rakitin.event_scheduler.strategy.util;


import com.rakitin.event_scheduler.event.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public final class OperationUtil {
    public static final Scanner scanner = new Scanner(System.in);
    public static final DateTimeFormatter dateAndTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void printListToConsole(List<Event> eventList) {
        if (!eventList.isEmpty()) {
            AtomicInteger i = new AtomicInteger(1);
            eventList.stream()
                    .map(event -> {
                        LocalTime localTime = event.getTime().toLocalTime();
                        LocalDate localDate = event.getTime().toLocalDate();
                        return String.format("%d. [ ] %s - %s %s", i.getAndIncrement(), event.getEventDescription(), localDate, localTime);
                    })
                    .forEach(System.out::println);

        } else System.out.println("Список задач пуст!");
    }

}
