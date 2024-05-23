package enums;

import exceptions.UnsupportedCommandException;

/**
 * Enum representing different types of commands.
 */
public enum CommandTypes {
    /**
     * Command to open a file.
     */
    OPEN("open"),

    /**
     * Command to close a file.
     */
    CLOSE("close"),

    /**
     * Command to save the current state of the file.
     */
    SAVE("save"),

    /**
     * Command to save the current state of the file with a new name or location.
     */
    SAVEAS("saveas"),

    /**
     * Command to display the other commands.
     */
    HELP("help"),

    /**
     * Command to exit the application.
     */
    EXIT("exit"),

    /**
     * Command to print the shapes in the opened file.
     */
    PRINT("print"),

    /**
     * Command to create a new figure in the opened file.
     */
    CREATE("create"),

    /**
     * Command to erase a figure in the opened file.
     */
    ERASE("erase"),

    /**
     * Command to translate a figure in the opened file.
     */
    TRANSLATE("translate"),

    /**
     * Command to get all figure within a region
     */
    WITHIN("within");

    private final String command;

    CommandTypes(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    /**
     * Retrieves a command by its string value.
     *
     * @param searchCommand the command name to search for
     * @return the matching command
     * @throws UnsupportedCommandException if the command is not found
     */
    public static CommandTypes getByValue(String searchCommand) throws UnsupportedCommandException {
        for (CommandTypes command : CommandTypes.values()) {
            if (command.getCommand().equals(searchCommand)) {
                return command;
            }
        }
        throw new UnsupportedCommandException();
    }
}