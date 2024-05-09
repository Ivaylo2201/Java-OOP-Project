package commands;

import contracts.CommandWithoutParams;

/**
 * The Exit class represents a
 * command to exit the application.
 */
public class Exit implements CommandWithoutParams {
    /**
     * Closes the application
     * after a short delay.
     */
    @Override
    public void execute() {
        try {
            System.out.println("Exiting the application...");
            Thread.sleep(600);
            System.exit(0);
        } catch (InterruptedException e) {
            System.out.println("An error has occurred!");
        }
    }
}
