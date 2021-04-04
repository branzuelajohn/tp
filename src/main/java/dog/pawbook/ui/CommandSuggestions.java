package dog.pawbook.ui;

import dog.pawbook.logic.commands.AddDogCommand;
import dog.pawbook.logic.commands.AddOwnerCommand;
import dog.pawbook.logic.commands.AddProgramCommand;
import dog.pawbook.logic.commands.DeleteDogCommand;
import dog.pawbook.logic.commands.DeleteOwnerCommand;
import dog.pawbook.logic.commands.DeleteProgramCommand;
import dog.pawbook.logic.commands.DropCommand;
import dog.pawbook.logic.commands.EditDogCommand;
import dog.pawbook.logic.commands.EditOwnerCommand;
import dog.pawbook.logic.commands.EditProgramCommand;
import dog.pawbook.logic.commands.EnrolCommand;
import dog.pawbook.logic.commands.ExitCommand;
import dog.pawbook.logic.commands.FindCommand;
import dog.pawbook.logic.commands.HelpCommand;
import dog.pawbook.logic.commands.ListCommand;
import dog.pawbook.logic.commands.ScheduleCommand;
import dog.pawbook.logic.commands.ViewCommand;

/**
 * A class containing command keywords to be matched with for autocompletion.
 */
public class CommandSuggestions {

    public static String[] getSuggestions() {
        return new String[] {
            AddDogCommand.COMMAND_WORD + " dog",
            AddOwnerCommand.COMMAND_WORD + " owner",
            AddProgramCommand.COMMAND_WORD + " program",
            DeleteDogCommand.COMMAND_WORD + " dog",
            DeleteOwnerCommand.COMMAND_WORD + " owner",
            DeleteProgramCommand.COMMAND_WORD + " program",
            EditDogCommand.COMMAND_WORD + " dog",
            EditOwnerCommand.COMMAND_WORD + " owner",
            EditProgramCommand.COMMAND_WORD + " program",
            ExitCommand.COMMAND_WORD,
            HelpCommand.COMMAND_WORD,
            FindCommand.COMMAND_WORD,
            ViewCommand.COMMAND_WORD,
            ScheduleCommand.COMMAND_WORD,
            EnrolCommand.COMMAND_WORD,
            DropCommand.COMMAND_WORD,
            ListCommand.COMMAND_WORD,
            ListCommand.COMMAND_WORD + " dog",
            ListCommand.COMMAND_WORD + " owner",
            ListCommand.COMMAND_WORD + " program",
        };
    }



}
