package com.rakitin.event_scheduler.menu;


import com.rakitin.event_scheduler.strategy.context.Operation;
import com.rakitin.event_scheduler.strategy.concrete_strategy.CreateEvent;
import com.rakitin.event_scheduler.strategy.concrete_strategy.DeleteEvent;
import com.rakitin.event_scheduler.strategy.concrete_strategy.ShowAllEvents;
import com.rakitin.event_scheduler.strategy.concrete_strategy.ShowAllEventsByDate;

import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final Operation operation;

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
            while (true) {
                System.out.print("Выберите действие (введите номер): ");
                int key = 0;
                try {
                    key = scanner.nextInt();
                } catch (RuntimeException e) {
                    scanner.nextLine();
                }

                switch (key) {
                    case 1:
                        operation.setOperation(new CreateEvent());
                        operation.executeOperation();
                        break;
                    case 2:
                        operation.setOperation(new ShowAllEvents());
                        operation.executeOperation();
                        break;
                    case 3:
                        operation.setOperation(new ShowAllEventsByDate());
                        operation.executeOperation();
                        break;
                    case 4:
                        operation.setOperation(new DeleteEvent());
                        operation.executeOperation();
                        break;
                    case 5:
                        System.out.println("До свидания!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Вы ввели неверное значение меню...");

                }
            }
        }
    }
}
