package executors;

import exceptions.UnsupportedCommandException;
import commands.*;
import interfaces.CommandWithParams;
import interfaces.CommandWithoutParams;
import enums.CommandTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * The CommandExecutor class is responsible for executing various commands.
 */
public class CommandExecutor {
    private final HashMap<CommandTypes, CommandWithoutParams> commandsWithoutParams = new HashMap<>();
    private final HashMap<CommandTypes, CommandWithParams> commandsWithParams = new HashMap<>();

    /**
     * Constructs a new CommandExecutor object and initializes the supported commands.
     */
    public CommandExecutor() {
        this.commandsWithParams.put(CommandTypes.OPEN, new Open());
        this.commandsWithoutParams.put(CommandTypes.CLOSE, new Close());
        this.commandsWithoutParams.put(CommandTypes.SAVE, new Save());
        this.commandsWithParams.put(CommandTypes.SAVEAS, new SaveAs());
        this.commandsWithoutParams.put(CommandTypes.HELP, new Help());
        this.commandsWithoutParams.put(CommandTypes.EXIT, new Exit());
        this.commandsWithoutParams.put(CommandTypes.PRINT, new Print());
        this.commandsWithParams.put(CommandTypes.CREATE, new Create());
        this.commandsWithParams.put(CommandTypes.ERASE, new Erase());
        this.commandsWithParams.put(CommandTypes.TRANSLATE, new Translate());
        this.commandsWithParams.put(CommandTypes.WITHIN, new Within());
    }

    /**
     * Executes the given command along with the
     * arguments if it exists in one of the hashmaps.
     *
     * @param commands An array of strings representing the command and its arguments.
     */
    public void execute(String[] commands) {
        try {
            CommandTypes command = CommandTypes.getByValue(commands[0].toLowerCase());
            List<String> args = new ArrayList<>(List.of(commands)).subList(1, commands.length);

            if (this.commandsWithoutParams.containsKey(command))
                this.commandsWithoutParams.get(command).execute();
            else
                this.commandsWithParams.get(command).execute(args);

        } catch (UnsupportedCommandException _) {
            System.out.println(commands[0] + " is not supported");
        }
    }
}
