/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * Test class for ServiceWolfManager
 * @author anthonypulsone
 *
 */
public class ServiceWolfManagerTest {
	/** manager singleton */
	public ServiceWolfManager manager = ServiceWolfManager.getInstance();
	
	/** setup code to clear fields and data */
	@Before
	public void setup() {
		manager.clearServiceGroups();
		manager.resetManager();
	}
	
	/**
	 * Test method for getInstance
	 */
	@Test
	public void testGetInstance() {
		assertNotNull(ServiceWolfManager.getInstance());
	}

	/**
	 * Test method for saveToFile
	 */
	@Test
	public void testSaveToFile() {
		// try saving invalid file
		try {
			manager.saveToFile("bubba.txt");
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("Unable to save file.", e.getMessage());
		}
	}

	/**
	 * Test method for loadFromFile
	 */
	@Test
	public void testLoadFromFile() {
		manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(3, manager.getServiceGroupList().length);
		assertEquals("CSC IT", manager.getServiceGroupList()[0]);
		assertEquals("ITECS", manager.getServiceGroupList()[1]);
		assertEquals("OIT", manager.getServiceGroupList()[2]);
	
	}

	/**
	 * Test method for getIncidentsAsArray
	 */
	@Test
	public void testGetIncidentsAsArray() {
		manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		String[][] a = manager.getIncidentsAsArray();
		assertEquals("2", a[0][0]);
		assertEquals("Canceled", a[0][1]);
		assertEquals("Piazza", a[0][2]);
		assertEquals("Not an Incident", a[0][3]);
		assertEquals("3", a[1][0]);
		assertEquals("New", a[1][1]);
		assertEquals("Moodle down", a[1][2]);
		assertEquals("No Status", a[1][3]);
		assertEquals(4, a.length);
		
	}

	/**
	 * Test method for getIncidentById
	 */
	@Test
	public void testGetIncidentById() {
		manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		Incident i = manager.getIncidentById(3);
		assertEquals(3, i.getId());
		assertEquals("Moodle down", i.getTitle());
		// id that doesn't exist
		assertNull(manager.getIncidentById(100));
	}

	/**
	 * Test method for executeCommand
	 */
	@Test
	public void testExecuteCommand() {
		manager = ServiceWolfManager.getInstance();
		manager.addServiceGroup("IT2");
		manager.addIncidentToServiceGroup("Broken PC", "Jim", "PC is destroyed");
		Command c1 = new Command(CommandValue.ASSIGN, "Joe", "Billy threw it out the window");
		manager.executeCommand(1, c1);
		assertEquals("In Progress", manager.getIncidentById(1).getState());
		assertEquals("Jim", manager.getIncidentById(1).getCaller());
		assertEquals("Joe", manager.getIncidentById(1).getOwner());
	}

	/**
	 * Test method for deleteIncidentById
	 */
	@Test
	public void testDeleteIncidentById() {
		manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		manager.deleteIncidentById(3);
		assertNull(manager.getIncidentById(3));
	}

	/**
	 * Test method for addIncidentToServiceGroup
	 */
	@Test
	public void testAddIncidentToServiceGroup() {
		manager = ServiceWolfManager.getInstance();
		manager.addServiceGroup("IT");
		manager.addIncidentToServiceGroup("Broken PC", "Mike", "PC is destroyed");
		assertEquals("Broken PC", manager.getIncidentById(1).getTitle());
		assertEquals("Mike", manager.getIncidentById(1).getCaller());
	}

	/**
	 * Test method for getServiceGroupName
	 */
	@Test
	public void testGetServiceGroupName() {
		manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		
		assertEquals("CSC IT", manager.getServiceGroupName());
	}

	/**
	 * Test method for editServiceGroup
	 */
	@Test
	public void testEditServiceGroup() {
		manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		
		manager.editServiceGroup("  X CSC IT DESK ");
		assertEquals("X CSC IT DESK", manager.getServiceGroupName());
		assertEquals("X CSC IT DESK", manager.getServiceGroupList()[2]);
	}

	/**
	 * Test method for addServiceGroup
	 */
	@Test
	public void testAddServiceGroup() {
		manager = ServiceWolfManager.getInstance();
		manager.addServiceGroup("IT");
		assertEquals("IT", manager.getServiceGroupName());
		manager.addServiceGroup("TECH");
		assertEquals(2, manager.getServiceGroupList().length);
		assertEquals("TECH", manager.getServiceGroupName());
	}

}
