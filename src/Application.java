import executors.CommandExecutor;

import java.util.Scanner;

/**
 * The Application class represents the entry point of the program.
 * It handles user input and executes commands accordingly.
 */
public class Application {
    /**
     * Runs the main logic of the application.
     * This method initializes the CommandExecutor, reads user input from the console,
     * and executes the commands until the program is terminated.
     */
    public void run() {
        CommandExecutor ce = new CommandExecutor();
        Scanner scanner = new Scanner(System.in);
        String[] commands;

        System.out.println("Welcome! Use 'help' to see the list of commands\n");

        while (true) {
            System.out.print("> ");
            commands = scanner.nextLine().split(" ");

            System.out.println();
            ce.execute(commands);
            System.out.println();
        }
    }
}
