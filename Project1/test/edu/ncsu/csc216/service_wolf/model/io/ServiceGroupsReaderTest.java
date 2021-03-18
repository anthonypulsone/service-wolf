/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * Test class for ServiceGroupsReader
 * 
 * @author anthonypulsone
 *
 */
public class ServiceGroupsReaderTest {
	/** test file 1 */
	private final String validTestFile = "test-files/incidents1.txt";
	/** test file 2 */
	private final String validTestFile2 = "test-files/incidents4.txt";
	/** test file 3 */
	private final String validTestFile3 = "test-files/incidents5.txt";
	
	/**
	 * Test method for readServiceGroupsFile
	 */
	@Test
	public void testReadServiceGroupsFile() {
		ArrayList<ServiceGroup> l = new ArrayList<ServiceGroup>();
		l = ServiceGroupsReader.readServiceGroupsFile(validTestFile2);
		assertEquals(0, l.size());
		
		
		ArrayList<ServiceGroup> l2 = new ArrayList<ServiceGroup>();
		l2 = ServiceGroupsReader.readServiceGroupsFile(validTestFile3);
		assertEquals(0, l2.size());
		
		
		
		ArrayList<ServiceGroup> list = ServiceGroupsReader.readServiceGroupsFile(validTestFile);
		assertEquals(3, list.size());
		assertEquals(4, list.get(0).getIncidents().size());
		assertEquals(1, list.get(1).getIncidents().size());
		assertEquals(1, list.get(2).getIncidents().size());
		
	}
	
	/**
	 * Test method for serviceGroupseReader()
	 */
	@Test
	public void testServiceGroupsReader() {
		ServiceGroupsReader r = new ServiceGroupsReader();
		assertNotNull(r);
	}
	
}
