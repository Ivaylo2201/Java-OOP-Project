package commands;

import contracts.CommandWithoutParams;

public class Exit implements CommandWithoutParams {
    @Override
    public void execute() {
        int exitDelay = 600;
        int exitCode = 0;

        try {
            System.out.println("Exiting the application...");
            Thread.sleep(exitDelay);
            System.exit(exitCode);
        } catch (InterruptedException e) {
            System.out.println("An error has occurred!");
        }
    }
}
