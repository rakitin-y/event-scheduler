package com.rakitin.event_scheduler.event;


import java.time.LocalDateTime;


public class Event {

    private String eventDescription;
    private LocalDateTime time;

    public Event(String eventDescription, LocalDateTime time) {
        this.eventDescription = eventDescription;
        this.time = time;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
