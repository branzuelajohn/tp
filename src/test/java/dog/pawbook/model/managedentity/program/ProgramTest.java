package dog.pawbook.model.managedentity.program;

import static dog.pawbook.logic.commands.CommandTestUtil.VALID_NAME_SECONDPROGRAM;
import static dog.pawbook.logic.commands.CommandTestUtil.VALID_SESSION_2;
import static dog.pawbook.logic.commands.CommandTestUtil.VALID_TAG_FRIENDLY;
import static dog.pawbook.logic.commands.CommandTestUtil.VALID_TAG_QUIET;
import static dog.pawbook.testutil.TypicalEntities.APPLE;
import static dog.pawbook.testutil.TypicalEntities.FIRSTPROGRAM;
import static dog.pawbook.testutil.TypicalEntities.SECONDPROGRAM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dog.pawbook.model.managedentity.Name;
import dog.pawbook.testutil.ProgramBuilder;

public class ProgramTest {

    @Test
    public void isSameAs() {
        // same object -> returns true
        assertTrue(FIRSTPROGRAM.isSameAs(FIRSTPROGRAM));

        // different entity type -> return false
        assertFalse(FIRSTPROGRAM.isSameAs(APPLE));

        // null -> returns false
        assertFalse(FIRSTPROGRAM.isSameAs(null));

        // same name ,all other attributes different -> returns true
        Program editedFirstProgram = new ProgramBuilder(FIRSTPROGRAM).withDogs()
            .withSessions("12-01-2020 18:00").withTags(VALID_TAG_FRIENDLY).build();
        assertTrue(FIRSTPROGRAM.isSameAs(editedFirstProgram));

        // different name, all other attributes same -> returns false
        editedFirstProgram = new ProgramBuilder(FIRSTPROGRAM).withName(VALID_NAME_SECONDPROGRAM).build();
        assertFalse(FIRSTPROGRAM.isSameAs(editedFirstProgram));

        // name differs in case, all other attributes same -> returns false
        Program editedSecondProgram = new ProgramBuilder(SECONDPROGRAM)
            .withName(VALID_NAME_SECONDPROGRAM.toLowerCase()).build();
        assertFalse(SECONDPROGRAM.isSameAs(editedSecondProgram));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_SECONDPROGRAM + " ";
        editedSecondProgram = new ProgramBuilder(SECONDPROGRAM).withName(nameWithTrailingSpaces).build();
        assertFalse(SECONDPROGRAM.isSameAs(editedSecondProgram));
    }

    @Test
    public void getName() {
        assertEquals(new Name("Basic Obedience Training"), FIRSTPROGRAM.getName());
        assertEquals(new Name("Basic Behavioural Training"), SECONDPROGRAM.getName());
    }

    @Test
    public void equals() {
        // same values -> returns true
        Program firstProgramCopy = new ProgramBuilder(FIRSTPROGRAM).build();
        assertEquals(firstProgramCopy, FIRSTPROGRAM);

        // same object -> returns true
        assertEquals(FIRSTPROGRAM, FIRSTPROGRAM);

        // different entity type -> return false
        assertNotEquals(FIRSTPROGRAM, APPLE);

        // null -> returns false
        assertNotEquals(FIRSTPROGRAM, null);

        // different type -> returns false
        assertNotEquals(FIRSTPROGRAM, 5);

        // different program -> returns false
        assertNotEquals(FIRSTPROGRAM, SECONDPROGRAM);

        // different name -> returns false
        Program editedFirstProgram = new ProgramBuilder(FIRSTPROGRAM).withName(VALID_NAME_SECONDPROGRAM).build();
        assertNotEquals(editedFirstProgram, FIRSTPROGRAM);

        // different sessions -> returns false
        editedFirstProgram = new ProgramBuilder(FIRSTPROGRAM).withSessions(VALID_SESSION_2).build();
        assertNotEquals(editedFirstProgram, FIRSTPROGRAM);

        // different tags -> returns false
        editedFirstProgram = new ProgramBuilder(FIRSTPROGRAM).withTags(VALID_TAG_QUIET).build();
        assertNotEquals(editedFirstProgram, FIRSTPROGRAM);
    }

}
