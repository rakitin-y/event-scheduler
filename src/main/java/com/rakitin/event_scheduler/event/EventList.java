package com.rakitin.event_scheduler.event;


import java.util.ArrayList;
import java.util.List;

public class EventList {
    private static final List<Event> eventList = new ArrayList<>();

    public static List<Event> getEventList() {
        return new ArrayList<>(eventList);
    }

    public static void deleteEventFromList(int id) {
        eventList.remove(id);
    }

    public static void addEventToList(Event event) {
        eventList.add(event);
    }
}
