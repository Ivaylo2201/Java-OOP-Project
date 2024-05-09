package commands;

import contracts.CommandWithoutParams;

/**
 * The Help class represents a command to
 * display information about supported commands.
 */
public class Help implements CommandWithoutParams {
    /**
     * Print the supported commands
     * to the console
     */
    @Override
    public void execute() {
        String sb = """
            The following commands are supported:
            open <file>                   Opens <file>.
            close                         Closes currently opened file.
            save                          Saves the currently opened file.
            saveas <file>                 Saves the currently opened file in <file>.
            help                          Prints this information.
            exit                          Exits the program.
            print                         Prints all figures from the currently opened file.
            create <properties>           Creates a new figure with the provided properties.
            erase <n>                     Erases figure with id of <n>.
            translate <n?> <args>         Translates the figure with id of <n> or all if <n> is not provided.
            within <option> <properties>  Prints all figures within the region.
            """;
        System.out.print(sb);
    }
}
