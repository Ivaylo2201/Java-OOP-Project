package enums;

import exceptions.UnsupportedCommandException;

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

    CommandTypes(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    public static CommandTypes getByValue(String value) throws UnsupportedCommandException {
        for (CommandTypes command : CommandTypes.values()) {
            if (command.getCommand().equals(value)) {
                return command;
            }
        }
        throw new UnsupportedCommandException();
    }
}