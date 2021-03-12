/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;

/**
 * Test method for Command
 * 
 * @author anthonypulsone
 *
 */
public class IncidentTest {

	/** AL for testing */
	public ArrayList<String> log1 = new ArrayList<String>();
	/** AL for testing */
	public ArrayList<String> log2 = new ArrayList<String>();

	/**
	 * setup for tests
	 */
	@Before
	public void setup() {

		log1.clear();
		log1.add("My Computer fell out the window!");
		log1.add("Caller lying, he threw it out the window");
		log1.add("Computer replaced.");

		if (log2.isEmpty()) {
			log2.add("Beans are all up in my computer!");
		}

	}

	/**
	 * Test method for Incident constructor with 3 parameters
	 */
	@Test
	public void testIncidentStringStringString() {
		Incident i1 = new Incident("Broken Computer", "Billy", "My computer fell out the window");
		assertEquals("Broken Computer", i1.getTitle());
		assertEquals("Billy", i1.getCaller());
		assertEquals("- My computer fell out the window\n", i1.getIncidentLogMessages());
		assertEquals("Unowned", i1.getOwner());
		assertEquals("No Status", i1.getStatusDetails());
		assertEquals(0, i1.getReopenCount());
		assertEquals("New", i1.getState());
		assertEquals(1, i1.getId());
		// try constructing with invalid parameters
		Incident i2 = null;
		try {
			i2 = new Incident(null, "Billy", "Beans in my computer");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident("", "Billy", "Beans in my computer");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident("Broken Computer", null, "Beans in my computer");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident("Broken Computer", "", "Beans in my computer");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident("Broken Computer", "Billy", null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident("Broken Computer", "Billy", "");
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		Incident.setCounter(1);
	}

	/**
	 * Test method for Incident constructor with all parameters
	 */
	@Test
	public void testIncidentStringStringStringStringStringStringStringString() {
		Incident.setCounter(1);
		// test new incident valid
		Incident i1 = new Incident(1, "New", "Broken Computer", "Billy", 0, "Unowned", "No Status",
				log2);
		assertEquals("Broken Computer", i1.getTitle());
		assertEquals("Billy", i1.getCaller());
		assertEquals("- Beans are all up in my computer!\n", i1.getIncidentLogMessages());
		assertEquals("Unowned", i1.getOwner());
		assertEquals("No Status", i1.getStatusDetails());
		assertEquals(0, i1.getReopenCount());
		assertEquals("New", i1.getState());
		assertEquals(1, i1.getId());

		// test new incident null/invalid parameter into setters
		Incident i2 = null;
		try {
			i2 = new Incident(0, "New", "Broken Computer", "Billy", 0, "Unowned", "No Status",
					log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(-3, "New", "Broken Computer", "Billy", 0, "Unowned", "No Status",
					log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "", "Broken Computer", "Billy", 0, "Unowned", "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, null, "Broken Computer", "Billy", 0, "Unowned", "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "", "Billy", 0, "Unowned", "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", null, "Billy", 0, "Unowned", "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "", 0, "Unowned", "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", null, 0, "Unowned", "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", -1, "Unowned", "No Status",
					log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", -5, "Unowned", "No Status",
					log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", 0, "", "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", 0, null, "No Status", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", 0, "Unowned", "", log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", 0, "Unowned", null, log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", 0, "Unowned", "Awaiting Caller",
					log2);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		try {
			i2 = new Incident(1, "New", "Broken Computer", "Billy", 0, "Unowned", "No Status",
					null);
			fail();
		} catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		// future tests test: constructing other states

		Incident.setCounter(1);
	}

	/**
	 * Test method for getId()
	 */
	@Test
	public void testGetId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getTitle()
	 */
	@Test
	public void testGetTitle() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getState()
	 */
	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getCaller()
	 */
	@Test
	public void testGetCaller() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getReopenCount()
	 */
	@Test
	public void testGetReopenCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getOwner()
	 */
	@Test
	public void testGetOwner() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getStatusDetails()
	 */
	@Test
	public void testGetStatusDetails() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getIncidentLogMessage()
	 */
	@Test
	public void testGetIncidentLogMessage() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for incrementCounter()
	 */
	@Test
	public void testIncrementCounter() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for setCounter()
	 */
	@Test
	public void testSetCounter() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for toString()
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for update()
	 */
	@Test
	public void testUpdate() {
		// new to canceled
		Incident i = new Incident("Broken Monitor", "Billy", "My monitor fell out the window");
		Command c = new Command(CommandValue.CANCEL, Incident.CANCELLATION_CALLER_CANCELLED,
				"Nevermind that was my TV");
		i.update(c);
		assertEquals("Canceled", i.getState());
		assertEquals("Unowned", i.getOwner());
		assertEquals("- My monitor fell out the window\n- Nevermind that was my TV\n",
				i.getIncidentLogMessages());
		// new to in progress
		Incident i1 = new Incident("Broken Computer", "Billy", "My computer fell out the window");
		Command c1 = new Command(CommandValue.ASSIGN, "Joe", "Billy threw it out the window");
		i1.update(c1);
		assertEquals("In Progress", i1.getState());
		assertEquals("Joe", i1.getOwner());
		assertEquals("- My computer fell out the window\n- Billy threw it out the window\n",
				i1.getIncidentLogMessages());
		// in progress to in progress
		Command c1b = new Command(CommandValue.ASSIGN, "Jim", "Jim, please help Billy again");
		i1.update(c1b);
		assertEquals("In Progress", i1.getState());
		assertEquals("Jim", i1.getOwner());
		assertEquals("- My computer fell out the window\n- Billy threw it out the window\n"
				+ "- Jim, please help Billy again\n", i1.getIncidentLogMessages());
		// in progress to on hold
		Command c1c = new Command(CommandValue.HOLD, Incident.HOLD_AWAITING_CALLER,
				"Billy, why did you do that?");
		i1.update(c1c);
		assertEquals("On Hold", i1.getState());
		assertEquals(Incident.HOLD_AWAITING_CALLER, i1.getStatusDetails());
		assertEquals(
				"- My computer fell out the window\n- Billy threw it out the window\n"
						+ "- Jim, please help Billy again\n- Billy, why did you do that?\n",
				i1.getIncidentLogMessages());
		// hold to in progress
		Command c1d = new Command(CommandValue.INVESTIGATE, null, "It wasn't working");
		i1.update(c1d);
		assertEquals("In Progress", i1.getState());
		assertEquals("Jim", i1.getOwner());
		assertEquals("No Status", i1.getStatusDetails());
		assertEquals("- My computer fell out the window\n- Billy threw it out the window\n"
				+ "- Jim, please help Billy again\n- Billy, why did you do that?\n"
				+ "- It wasn't working\n", i1.getIncidentLogMessages());
		// in progress to canceled
		Command c1e = new Command(CommandValue.CANCEL, Incident.CANCELLATION_UNNECESSARY,
				"That is a toaster, Billy. We don't support toasters");
		i1.update(c1e);
		assertEquals("Canceled", i.getState());
		assertEquals("Unowned", i.getOwner());
		assertEquals(Incident.CANCELLATION_UNNECESSARY, i1.getStatusDetails());
		assertEquals("- My computer fell out the window\n- Billy threw it out the window\n"
				+ "- Jim, please help Billy again\n" + "- Billy, why did you do that?\n"
				+ "- It wasn't working\n- That is a toaster, Billy. We don't support toasters\n",
				i1.getIncidentLogMessages());
		// in progress to resolved
		Incident i2 = new Incident(4, "In Progress", "Broken Computer", "Jim", 0, "Tony", "No Status", log2);
		Command c2 = new Command(CommandValue.RESOLVE, Incident.RESOLUTION_PERMANENTLY_SOLVED, "test message");
		i2.update(c2);
		assertEquals("Resolved", i2.getState());
		assertEquals("Permanently Solved", i2.getStatusDetails());
		Command c2a = new Command(CommandValue.REOPEN, null, "test message");
		i2.update(c2a);
		assertEquals("In Progress", i2.getState());
		assertEquals("No Status", i2.getStatusDetails());
		assertEquals(1, i2.getReopenCount());
		Command c2b = new Command(CommandValue.RESOLVE, Incident.CANCELLATION_CALLER_CANCELLED, "test message");
		i2.update(c2b);
		assertEquals("Resolved", i2.getState());
		assertEquals("Caller Canceled", i2.getStatusDetails());
		Command c2c = new Command(CommandValue.CANCEL, Incident.CANCELLATION_CALLER_CANCELLED, "test message");
		i2.update(c2c);
		assertEquals("Canceled", i2.getState());
		assertEquals("Unowned", i2.getOwner());
		assertEquals(Incident.CANCELLATION_CALLER_CANCELLED, i2.getStatusDetails());
		
		
	}

}
