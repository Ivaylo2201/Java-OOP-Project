package enums;

import exceptions.UnsupportedCommandException;

/**
 * Enum representing different types of commands.
 */
public enum CommandTypes {
    /**
     * Command to open a file.
     */
    OPEN,

    /**
     * Command to close a file.
     */
    CLOSE,

    /**
     * Command to save the current state of the file.
     */
    SAVE,

    /**
     * Command to save the current state of the file with a new name or location.
     */
    SAVEAS,

    /**
     * Command to display the other commands.
     */
    HELP,

    /**
     * Command to exit the application.
     */
    EXIT,

    /**
     * Command to print the shapes in the opened file.
     */
    PRINT,

    /**
     * Command to create a new figure in the opened file.
     */
    CREATE,

    /**
     * Command to erase a figure in the opened file.
     */
    ERASE,

    /**
     * Command to translate a figure in the opened file.
     */
    TRANSLATE,

    /**
     * Command to get all figure within a region
     */
    WITHIN;

    /**
     * Retrieves a command by its string value.
     *
     * @param searchCommand the command name to search for
     * @return the matching command
     * @throws UnsupportedCommandException if the command is not found
     */
    public static CommandTypes getByValue(String searchCommand) throws UnsupportedCommandException {
        for (CommandTypes commandType : CommandTypes.values()) {
            if (commandType.name().equalsIgnoreCase(searchCommand)) {
                return commandType;
            }
        }
        throw new UnsupportedCommandException();
    }
}