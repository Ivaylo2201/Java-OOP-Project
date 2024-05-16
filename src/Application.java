import executors.CommandExecutor;

import java.util.Scanner;

/**
 * The Application class represents the entry point of the program.
 */
public class Application {
    /**
     * The main method of the program.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        CommandExecutor ce = new CommandExecutor();
        Scanner scanner = new Scanner(System.in);
        String[] commands;

        System.out.println("Welcome! Use 'help' to see the list of commands\n");

        while (true) {
            try {
                System.out.print("> ");
                commands = scanner.nextLine().split(" ");

                System.out.println();
                ce.execute(commands);
                System.out.println();
            } catch (Exception e) {
                System.out.println("An error has occurred!\n");
            }
        }
    }
}
