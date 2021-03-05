package edu.ncsu.csc216.service_wolf.model.io;

import java.util.ArrayList;

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
		return null;
	}

	/**
	 * Constructs a service group for the passed serviceGroupString.
	 * 
	 * @param serviceGroupString the String containing the serviceGroup
	 * @return a ServiceGroup object for the passed String
	 */
	private static ServiceGroup processServiceGroup(String serviceGroupString) {
		return null;
	}

	/**
	 * Construcs the Incident objects for each ServiceGroup
	 * 
	 * @param incidentString String representation of an Incident
	 * @return a constructed Incident object for the String
	 */
	private static Incident processIncident(String incidentString) {
		return null;

	}
}
