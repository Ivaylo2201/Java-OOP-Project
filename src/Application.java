import executors.CommandExecutor;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        CommandExecutor ce = new CommandExecutor();
        Scanner scanner = new Scanner(System.in);
        String[] commands;

        System.out.println("Welcome! Use 'help' to see the list of commands\n");

        while (true) {
            try {
                commands = scanner.nextLine().split(" ");

                System.out.println();
                ce.execute(commands);
                System.out.println();
            } catch (Exception e) {
                System.out.println("An error has occurred!");
            }
        }
    }
}
