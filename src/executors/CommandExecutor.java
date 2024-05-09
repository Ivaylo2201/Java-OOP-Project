package executors;

import commands.*;
import contracts.CommandWithParams;
import contracts.CommandWithoutParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * The CommandExecutor class is
 * responsible for executing various commands.
 */
public class CommandExecutor {
    private final HashMap<String, CommandWithoutParams> commandsWithoutParams = new HashMap<>();
    private final HashMap<String, CommandWithParams> commandsWithParams = new HashMap<>();

    /**
     * Constructs a new CommandExecutor object
     * and initializes the supported commands.
     */
    public CommandExecutor() {
        this.commandsWithParams.put("open", new Open());
        this.commandsWithoutParams.put("close", new Close());
        this.commandsWithoutParams.put("save", new Save());
        this.commandsWithParams.put("saveas", new SaveAs());
        this.commandsWithoutParams.put("help", new Help());
        this.commandsWithoutParams.put("exit", new Exit());
        this.commandsWithoutParams.put("print", new Print());
        this.commandsWithParams.put("create", new Create());
        this.commandsWithParams.put("erase", new Erase());
        this.commandsWithParams.put("translate", new Translate());
        this.commandsWithParams.put("within", new Within());
    }

    /**
     * Executes the given command along with the
     * arguments if it exists in one of the hashmaps.
     * @param commands An array of strings representing the commands and their arguments.
     */
    public void execute(String[] commands) {
        String command = commands[0].toLowerCase();
        List<String> args = new ArrayList<>(List.of(commands)).subList(1, commands.length);

        if (this.commandsWithoutParams.containsKey(command)) {
            this.commandsWithoutParams.get(command).execute();
        } else if (this.commandsWithParams.containsKey(command)) {
            this.commandsWithParams.get(command).execute(args);
        } else {
            System.out.println(command + " is not supported");
        }
    }
}
