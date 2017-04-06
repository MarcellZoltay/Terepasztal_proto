package project;

import java.util.Scanner;

public class Menu implements State {

    public Menu() {
    }

    @Override
    public Status start() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("1. Start Game\n");
            System.out.print("2. Exit\n");
            choice = sc.nextInt();
            if (choice == 1) return Status.START_GAME;
            else if (choice == 2) return Status.EXIT_GAME;
        } while(choice < 1 || choice > 2);
        return null;
    }

}