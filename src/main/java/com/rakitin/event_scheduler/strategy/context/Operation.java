package com.rakitin.event_scheduler.strategy.context;

import com.rakitin.event_scheduler.strategy.OperationStrategy;

public class Operation {
    private OperationStrategy operation;

    public void setOperation(OperationStrategy operation) {
        this.operation = operation;
    }

    public void executeOperation() {
        operation.doOperation();
    }
}
