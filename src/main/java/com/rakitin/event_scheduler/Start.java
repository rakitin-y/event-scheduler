package com.rakitin.event_scheduler;



import com.rakitin.event_scheduler.menu.MainMenu;
import com.rakitin.event_scheduler.strategy.context.Operation;

import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
            new MainMenu(new Scanner(System.in), new Operation()).start();


    }
}
