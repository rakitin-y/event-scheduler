package com.rakitin.event_scheduler.menu;


import com.rakitin.event_scheduler.strategy.OperationStrategy;
import com.rakitin.event_scheduler.strategy.context.Operation;
import com.rakitin.event_scheduler.strategy.concrete_strategy.CreateEvent;
import com.rakitin.event_scheduler.strategy.concrete_strategy.DeleteEvent;
import com.rakitin.event_scheduler.strategy.concrete_strategy.ShowAllEvents;
import com.rakitin.event_scheduler.strategy.concrete_strategy.ShowAllEventsByDate;

import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final Operation operation;
    private static final HashMap<Integer, OperationStrategy> operationStrategy = new HashMap<>();

    static {
        operationStrategy.put(1, new CreateEvent());
        operationStrategy.put(2, new ShowAllEvents());
        operationStrategy.put(3, new ShowAllEventsByDate());
        operationStrategy.put(4, new DeleteEvent());
    }

    public MainMenu(Scanner scanner, Operation operation) {
        this.scanner = scanner;
        this.operation = operation;

    }

    private void printMenu() {
        System.out.println("Добро пожаловать в приложение \"Планировщик событий\"!");
        System.out.println("1. Добавить событие");
        System.out.println("2. Просмотреть список событий");
        System.out.println("3. Фильтр по дате");
        System.out.println("4. Удалить событие");
        System.out.println("5. Выход");

    }

    public void start() {
        if (scanner != null) {
            printMenu();
            int key = 0;
            do {
                System.out.print("Выберите действие (введите номер): ");
                try {
                    key = scanner.nextInt();
                    if (key > 0 && key < 5) {
                        operation.setOperation(operationStrategy.get(key));
                        operation.executeOperation();
                    }
                } catch (Exception e) {
                    System.out.println("Вы ввели неверное значение меню...");
                    scanner.nextLine();
                }
            } while (key != 5);
            System.out.println("До свидания!");
        }
    }
}

