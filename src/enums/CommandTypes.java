package enums;

import exceptions.UnsupportedCommandException;

/**
 * Enum representing different types of commands.
 */
public enum CommandTypes {
    OPEN("open"),
    CLOSE("close"),
    SAVE("save"),
    SAVEAS("saveas"),
    HELP("help"),
    EXIT("exit"),
    PRINT("print"),
    CREATE("create"),
    ERASE("erase"),
    TRANSLATE("translate"),
    WITHIN("within");

    private final String command;

    /**
     * Constructor for CommandTypes enum.
     *
     * @param command The command string associated with the enum value.
     */
    CommandTypes(String command) {
        this.command = command;
    }

    /**
     * Gets the command string associated with the enum value.
     *
     * @return The command string.
     */
    public String getCommand() {
        return this.command;
    }

    /**
     * Gets the CommandTypes enum value corresponding to the given command string.
     *
     * @param value The command string.
     * @return The corresponding CommandTypes enum value.
     * @throws UnsupportedCommandException If the command string does not match any enum value.
     */
    public static CommandTypes getByValue(String value) throws UnsupportedCommandException {
        for (CommandTypes command : CommandTypes.values()) {
            if (command.getCommand().equals(value)) {
                return command;
            }
        }
        throw new UnsupportedCommandException();
    }
}