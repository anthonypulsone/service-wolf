package edu.ncsu.csc216.service_wolf.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * Class handles file input. Reads a file of saved ServiceWolf data line by line
 * and determines what is a ServiceGroup, an Incident, or a Message Log. Calls
 * the proper constructors to create objects with the correct relationships.
 * Contains static methods and has no explicit composition relationship to the
 * other Classes.
 * 
 * @author anthonypulsone
 *
 */
public class ServiceGroupsReader {

	/**
	 * Reads the input file and determines what each line contains. Passes line to
	 * proper helper method to construct the proper objects for the Incidents and
	 * ServiceGroups in the .txt file. Ignores any lines that cannot be constructed.
	 * 
	 * @param fileName the name of the file you are looking to read
	 * @return an ArrayList containing the ServiceGroups and their Incidents
	 * @throws IllegalArgumentException if file is unable to be loaded
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String fileName) {
		Scanner fileReader;
		ArrayList<ServiceGroup> groupList = new ArrayList<ServiceGroup>();
		try {
			fileReader = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		
		fileReader.useDelimiter("\\r?\\n?[#]");
		
		while (fileReader.hasNext()) {
			try {
				groupList.add(processServiceGroup(fileReader.next()));
			} catch (IllegalArgumentException | NoSuchElementException e) {
				groupList.clear();
				return groupList;
			}

		}

		fileReader.close();
		return groupList;
	}

	/**
	 * Constructs a service group for the passed serviceGroupString.
	 * 
	 * @param serviceGroupString the String containing the serviceGroup
	 * @return a ServiceGroup object for the passed String
	 */
	private static ServiceGroup processServiceGroup(String serviceGroupString) {
		Scanner groupScanner = new Scanner(serviceGroupString);

		ServiceGroup group = new ServiceGroup(groupScanner.nextLine().trim());
		groupScanner.useDelimiter("\\r?\\n?[*]");
		while (groupScanner.hasNext()) {
			//try {
				group.addIncident(processIncident(groupScanner.next()));
			//} catch (IllegalArgumentException e) {
			//	continue;
			//}
		}

		groupScanner.close();
		return group;
	}

	/**
	 * Construcs the Incident objects for each ServiceGroup
	 * 
	 * @param incidentString String representation of an Incident
	 * @return a constructed Incident object for the String
	 */
	private static Incident processIncident(String incidentString) {

		Scanner incidentScanner = new Scanner(incidentString);
		Scanner incidentInfo = new Scanner(incidentScanner.nextLine().trim());

		incidentInfo.useDelimiter(",");
		try {
			// get the Incident parameters from comma separated list
			int id = incidentInfo.nextInt();
			String state = incidentInfo.next().trim();
			String title = incidentInfo.next().trim();
			String caller = incidentInfo.next().trim();
			int reopenCount = incidentInfo.nextInt();
			String owner = incidentInfo.next().trim();
			String statusDetails = incidentInfo.next().trim();
			// get message log from rest of incidentScanner
			incidentScanner.useDelimiter("\\r?\\n?[-]");
			ArrayList<String> messageLog = new ArrayList<String>();
			while (incidentScanner.hasNext()) {
				messageLog.add(incidentScanner.next().trim());
			}
			// attempt to construct incident IAE is thrown to caller of processIncident if
			// invalid and is skipped
			Incident incident = new Incident(id, state, title, caller, reopenCount, owner,
					statusDetails, messageLog);
			incidentScanner.close();
			incidentInfo.close();
			return incident;
			// catch any mismatch exception and throw IAE to caller
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException();
		} 

	}
}
