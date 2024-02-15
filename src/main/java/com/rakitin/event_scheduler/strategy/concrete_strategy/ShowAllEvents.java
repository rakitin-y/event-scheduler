package com.rakitin.event_scheduler.strategy.concrete_strategy;


import com.rakitin.event_scheduler.event.EventList;
import com.rakitin.event_scheduler.strategy.OperationStrategy;

import static com.rakitin.event_scheduler.strategy.util.OperationUtil.printListToConsole;

public class ShowAllEvents implements OperationStrategy {
    @Override
    public void doOperation() {
        printListToConsole(EventList.getEventList());
    }
}
