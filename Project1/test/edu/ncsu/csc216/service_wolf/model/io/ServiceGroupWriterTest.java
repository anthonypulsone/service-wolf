/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * Test class for ServiceGroupWriter
 * 
 * @author anthonypulsone
 *
 */
public class ServiceGroupWriterTest {

	/**
	 * Test method for writeServiceGroupsToFile()
	 */
	@Test
	public void testWriteServiceGroupsToFile() {
		//setup objects
		ArrayList<ServiceGroup> groups = new ArrayList<ServiceGroup>();
		ServiceGroup s1 = new ServiceGroup("CSC IT");
		groups.add(s1);
		ServiceGroup s2 = new ServiceGroup("ITECS");
		groups.add(s2);
		ArrayList<String> log1 = new ArrayList<String>();
		log1.add("Set up piazza for Spring 2021");
		log1.add("Canceled; not an NC State IT service");
		Incident i1 = new Incident(1, "Canceled", "Piazza", "sesmith5", 0, "Unowned",
				"Not an Incident", log1);
		s1.addIncident(i1);
		ArrayList<String> log2 = new ArrayList<String>();
		log2.add("I can't install Java on my computer.");
		log2.add("Assigned to itecs1");
		log2.add("Awaiting caller's feedback on attempting to install Java from Oracle");
		Incident i2 = new Incident(2, "On Hold", "Java not installed correctly", "zmgrosec", 0,
				"itecs1", "Awaiting Caller", log2);
		s2.addIncident(i2);
		ArrayList<String> log3 = new ArrayList<String>();
		log3.add("I forgot my password and can't log into NC State accounts");
		log3.add("OIT staff member on call with support");
		Incident i3 = new Incident(3, "In Progress", "Forgot password", "jctetter", 0, "oit_staff",
				"No Status", log3);
		s2.addIncident(i3);
		//attempt to write
		try {
			ServiceGroupWriter.writeServiceGroupsToFile("test-files/incidentsactual.txt", groups);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		checkFiles("test-files/incidentsexpected.txt", "test-files/incidentsactual.txt");
	}

	/**
	 * Helper method to compare two files for the same contents
	 * 
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new FileInputStream(expFile));
				Scanner actScanner = new Scanner(new FileInputStream(actFile));) {

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
}
