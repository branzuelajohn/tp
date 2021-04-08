package dog.pawbook.model.managedentity.program;

import static dog.pawbook.logic.commands.CommandTestUtil.VALID_NAME_BEHAVIOURAL;
import static dog.pawbook.logic.commands.CommandTestUtil.VALID_SESSION_2;
import static dog.pawbook.logic.commands.CommandTestUtil.VALID_TAG_FRIENDLY;
import static dog.pawbook.logic.commands.CommandTestUtil.VALID_TAG_QUIET;
import static dog.pawbook.testutil.TypicalEntities.ACTIVE_LISTENING;
import static dog.pawbook.testutil.TypicalEntities.APPLE;
import static dog.pawbook.testutil.TypicalEntities.BEHAVIOURAL;
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
        assertTrue(ACTIVE_LISTENING.isSameAs(ACTIVE_LISTENING));

        // different entity type -> return false
        assertFalse(ACTIVE_LISTENING.isSameAs(APPLE));

        // null -> returns false
        assertFalse(ACTIVE_LISTENING.isSameAs(null));

        // same name ,all other attributes different -> returns true
        Program editedFirstProgram = new ProgramBuilder(ACTIVE_LISTENING).withDogs()
            .withSessions("12-01-2020 18:00").withTags(VALID_TAG_FRIENDLY).build();
        assertTrue(ACTIVE_LISTENING.isSameAs(editedFirstProgram));

        // different name, all other attributes same -> returns false
        editedFirstProgram = new ProgramBuilder(ACTIVE_LISTENING).withName(VALID_NAME_BEHAVIOURAL).build();
        assertFalse(ACTIVE_LISTENING.isSameAs(editedFirstProgram));

        // name differs in case, all other attributes same -> returns false
        Program editedSecondProgram = new ProgramBuilder(BEHAVIOURAL)
            .withName(VALID_NAME_BEHAVIOURAL.toLowerCase()).build();
        assertFalse(BEHAVIOURAL.isSameAs(editedSecondProgram));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BEHAVIOURAL + " ";
        editedSecondProgram = new ProgramBuilder(BEHAVIOURAL).withName(nameWithTrailingSpaces).build();
        assertFalse(BEHAVIOURAL.isSameAs(editedSecondProgram));
    }

    @Test
    public void getName() {
        assertEquals(new Name("Active Listening"), ACTIVE_LISTENING.getName());
        assertEquals(new Name("Basic Behavioural Training"), BEHAVIOURAL.getName());
    }

    @Test
    public void equals() {
        // same values -> returns true
        Program firstProgramCopy = new ProgramBuilder(ACTIVE_LISTENING).build();
        assertEquals(firstProgramCopy, ACTIVE_LISTENING);

        // same object -> returns true
        assertEquals(ACTIVE_LISTENING, ACTIVE_LISTENING);

        // different entity type -> return false
        assertNotEquals(ACTIVE_LISTENING, APPLE);

        // null -> returns false
        assertNotEquals(ACTIVE_LISTENING, null);

        // different type -> returns false
        assertNotEquals(ACTIVE_LISTENING, 5);

        // different program -> returns false
        assertNotEquals(ACTIVE_LISTENING, BEHAVIOURAL);

        // different name -> returns false
        Program editedFirstProgram = new ProgramBuilder(ACTIVE_LISTENING).withName(VALID_NAME_BEHAVIOURAL).build();
        assertNotEquals(editedFirstProgram, ACTIVE_LISTENING);

        // different sessions -> returns false
        editedFirstProgram = new ProgramBuilder(ACTIVE_LISTENING).withSessions(VALID_SESSION_2).build();
        assertNotEquals(editedFirstProgram, ACTIVE_LISTENING);

        // different tags -> returns false
        editedFirstProgram = new ProgramBuilder(ACTIVE_LISTENING).withTags(VALID_TAG_QUIET).build();
        assertNotEquals(editedFirstProgram, ACTIVE_LISTENING);
    }

}
