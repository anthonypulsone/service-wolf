/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.service_group;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * Test class for ServiceGroup
 * 
 * @author anthonypulsone
 *
 */
public class ServiceGroupTest {
	/** test incident 1 */
	Incident i1;
	/** test incident 2 */
	Incident i2;
	/** test incident 3 */
	ServiceGroup s;
	/** AL for testing */
	public ArrayList<String> log1 = new ArrayList<String>();

	/**
	 * setup for tests
	 */
	@Before
	public void setup() {
		Incident.setCounter(1);
		i1 = new Incident("Broken Computer", "Billy", "Spilled rootbeer on it");
		i2 = new Incident("Taco sauce in keys", "Jimbo", "Hot sauce squirted on keys");
		s = new ServiceGroup("   IT Help     ");
		log1.clear();
		log1.add("Beans are all up in my computer!");

	}

	/**
	 * Test method for ServiceGroup constructor
	 */
	@Test
	public void testServiceGroup() {

		ServiceGroup s1 = new ServiceGroup("  IT Admins ");
		try {
			s1.addIncident(i1);
			s1.addIncident(i2);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals("Broken Computer", s1.getIncidentById(1).getTitle());
		assertEquals("IT Admins", s1.getServiceGroupName());
		Incident.setCounter(1);
	}

	/**
	 * Test method for setIncidentCounter
	 */
	@Test
	public void testSetIncidentCounter() {

		Incident i3 = new Incident(7, "New", "Broken Computer", "Billy", 0, "Unowned", "No Status",
				log1);
		s.addIncident(i1);
		s.addIncident(i3);
		s.setIncidentCounter();
		Incident i4 = new Incident("Taco sauce in keys", "Jimbo", "Hot sauce squirted on keys");
		s.addIncident(i4);
		assertEquals(8, i4.getId());
	}

	/**
	 * Test method for setServiceGroupName
	 */
	@Test
	public void testSetServiceGroupName() {
		assertEquals("IT Help", s.getServiceGroupName());
		s.setServiceGroupName("IT Desk  ");
		assertEquals("IT Desk", s.getServiceGroupName());
	}

	/**
	 * Test method for getServiceGroupName
	 */
	@Test
	public void testGetServiceGroupName() {
		assertEquals("IT Help", s.getServiceGroupName());
	}

	/**
	 * Test method for executeCommand
	 */
	@Test
	public void testExecuteCommand() {
		s.addIncident(i1);
		s.addIncident(i2);
		Command c1 = new Command(CommandValue.ASSIGN, "Joe", "Billy threw it out the window");
		s.executeCommand(2, c1);
		assertEquals("In Progress", i2.getState());
		assertEquals("Joe", i2.getOwner());	
	}

}
