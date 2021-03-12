/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * Test class for ServiceWolfManager
 * @author anthonypulsone
 *
 */
public class ServiceWolfManagerTest {
	
	
//	/** setup method */
//	@Before
//	public void setup() {
//		
//		ServiceWolfManager manager = ServiceWolfManager.getInstance();
//		manager.loadFromFile("test-files/incidents1.txt");
//	}
	
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for loadFromFile
	 */
	@Test
	public void testLoadFromFile() {
		ServiceWolfManager manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertEquals(3, manager.getServiceGroupList().length);
		assertEquals("CSC IT", manager.getServiceGroupList()[0]);
		assertEquals("ITECS", manager.getServiceGroupList()[1]);
		assertEquals("OIT", manager.getServiceGroupList()[2]);
		
		manager.resetManager();
	}

	/**
	 * Test method for getIncidentsAsArray
	 */
	@Test
	public void testGetIncidentsAsArray() {
		ServiceWolfManager manager = ServiceWolfManager.getInstance();
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
		manager.resetManager();
	}

	/**
	 * Test method for getIncidentById
	 */
	@Test
	public void testGetIncidentById() {
		ServiceWolfManager manager = ServiceWolfManager.getInstance();
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
		
		manager.resetManager();
	}

	/**
	 * Test method for executeCommand
	 */
	@Test
	public void testExecuteCommand() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for deleteIncidentById
	 */
	@Test
	public void testDeleteIncidentById() {
		ServiceWolfManager manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		manager.deleteIncidentById(3);
		assertNull(manager.getIncidentById(3));
		manager.resetManager();
	}

	/**
	 * Test method for addIncidentToServiceGroup
	 */
	@Test
	public void testAddIncidentToServiceGroup() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for loadServiceGroup
	 */
	@Test
	public void testLoadServiceGroup() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for getServiceGroupName
	 */
	@Test
	public void testGetServiceGroupName() {
		ServiceWolfManager manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		
		assertEquals("CSC IT", manager.getServiceGroupName());
		
		manager.resetManager();
	}

	/**
	 * Test method for getServiceGroupList
	 */
	@Test
	public void testGetServiceGroupList() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for clearServiceGroups
	 */
	@Test
	public void testClearServiceGroups() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for editServiceGroup
	 */
	@Test
	public void testEditServiceGroup() {
		ServiceWolfManager manager = ServiceWolfManager.getInstance();
		try {
			manager.loadFromFile("test-files/incidents1.txt");
		} catch (IllegalArgumentException e) {
			fail();
		}
		manager.loadServiceGroup("CSC IT");
		
		manager.editServiceGroup("  X CSC IT DESK ");
		assertEquals("X CSC IT DESK", manager.getServiceGroupName());
		assertEquals("X CSC IT DESK", manager.getServiceGroupList()[2]);
		
		
		manager.resetManager();
	}

	/**
	 * Test method for addServiceGroup
	 */
	@Test
	public void testAddServiceGroup() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for deleteServiceGroup
	 */
	@Test
	public void testDeleteServiceGroup() {
		fail("Not yet implemented");
	}

}
