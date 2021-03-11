/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.command;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;

/**
 * Test class for Command class
 * 
 * @author anthonypulsone
 *
 */
public class CommandTest {

	/**
	 * Test method for Command constructor
	 */
	@Test
	public void testCommand() {
		// valid test construct assign with message and info
		Command c1 = new Command(CommandValue.ASSIGN, "info", "message");
		assertEquals(CommandValue.ASSIGN, c1.getCommand());
		assertEquals("info", c1.getCommandInformation());
		assertEquals("message", c1.getCommandMessage());
		// valid test construct hold with message and info
		Command c2 = new Command(CommandValue.HOLD, "info", "message");
		assertEquals(CommandValue.HOLD, c2.getCommand());
		assertEquals("info", c2.getCommandInformation());
		assertEquals("message", c2.getCommandMessage());
		// valid test construct resolve with message and info
		Command c3 = new Command(CommandValue.RESOLVE, "info", "message");
		assertEquals(CommandValue.RESOLVE, c3.getCommand());
		assertEquals("info", c3.getCommandInformation());
		assertEquals("message", c3.getCommandMessage());
		// valid test construct hold with message and info
		Command c4 = new Command(CommandValue.CANCEL, "info", "message");
		assertEquals(CommandValue.CANCEL, c4.getCommand());
		assertEquals("info", c4.getCommandInformation());
		assertEquals("message", c4.getCommandMessage());
		// valid test construct investigate with message and no info
		Command c5 = new Command(CommandValue.INVESTIGATE, null, "message");
		assertEquals(CommandValue.INVESTIGATE, c5.getCommand());
		assertEquals(null, c5.getCommandInformation());
		assertEquals("message", c5.getCommandMessage());
		// valid test construct reopen with message and no info
		Command c6 = new Command(CommandValue.REOPEN, null, "message");
		assertEquals(CommandValue.REOPEN, c6.getCommand());
		assertEquals(null, c6.getCommandInformation());
		assertEquals("message", c6.getCommandMessage());
		// invalid test null command value
		Command c7 = null;
		try {
			c7 = new Command(null, "info", "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c7);
		}
		// invalid test null / empty command message
		Command c8 = null;
		try {
			c8 = new Command(CommandValue.ASSIGN, "info", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c8);
		}
		try {
			c8 = new Command(CommandValue.ASSIGN, "info", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c8);
		}
		// invalid test assign with message an null / empty info
		Command c9 = null;
		try {
			c9 = new Command(CommandValue.ASSIGN, "", "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c9);
		}
		try {
			c9 = new Command(CommandValue.ASSIGN, null, "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c9);
		}
		// invalid test hold with message an null / empty info
		Command c10 = null;
		try {
			c10 = new Command(CommandValue.HOLD, "", "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c10);
		}
		try {
			c10 = new Command(CommandValue.HOLD, null, "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c10);
		}
		// invalid test resolve with message and null / empty info
		Command c11 = null;
		try {
			c11 = new Command(CommandValue.RESOLVE, "", "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c11);
		}
		try {
			c11 = new Command(CommandValue.RESOLVE, null, "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c11);
		}
		// invalid test cancel with message and null / empty info
		Command c12 = null;
		try {
			c12 = new Command(CommandValue.RESOLVE, "", "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c12);
		}
		try {
			c12 = new Command(CommandValue.RESOLVE, null, "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c12);
		}
		// invalid test investigate has command info when should be null
		Command c13 = null;
		try {
			c13 = new Command(CommandValue.INVESTIGATE, "info", "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c13);
		}
		// invalid test reopen has command info when should be null
		Command c14 = null;
		try {
			c14 = new Command(CommandValue.REOPEN, "info", "message");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(c14);
		}
		
	}


	/**
	 * Test method for getCommand()
	 */
	@Test
	public void testGetCommand() {
		Command c1 = new Command(CommandValue.ASSIGN, "info", "message");
		assertEquals(CommandValue.ASSIGN, c1.getCommand());
		Command c2 = new Command(CommandValue.HOLD, "info", "message");
		assertEquals(CommandValue.HOLD, c2.getCommand());
	}

	/**
	 * Test method for getCommandInformation()
	 */
	@Test
	public void testGetCommandInformation() {
		Command c1 = new Command(CommandValue.ASSIGN, "info", "message");
		assertEquals("info", c1.getCommandInformation());
		Command c2 = new Command(CommandValue.INVESTIGATE, null, "message");
		assertNull(c2.getCommandInformation());
	}

	/**
	 * Test method for getCommandMessage()
	 */
	@Test
	public void testGetCommandMessage() {
		Command c1 = new Command(CommandValue.ASSIGN, "info", "message");
		assertEquals("message", c1.getCommandMessage());
		Command c2 = new Command(CommandValue.HOLD, "info", "message");
		assertEquals("message", c2.getCommandMessage());
	}

}
