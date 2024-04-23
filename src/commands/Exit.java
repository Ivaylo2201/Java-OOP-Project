package commands;

import contracts.CommandWithoutParams;

public class Exit implements CommandWithoutParams {
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
