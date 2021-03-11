package edu.ncsu.csc216.service_wolf.model.io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * Class handles file output. Creates a file with the passed fileName and writes
 * the ServiceWolf data from the ArrayList of ServiceGroups to it in the proper
 * format.
 * 
 * @author anthonypulsone
 *
 */
public class ServiceGroupWriter {

	/**
	 * Takes the passed ArrayList of Service groups and writes them to the fileName
	 * designated by the user. Properly formats the written data to the
	 * specifications.
	 * 
	 * @param fileName the name that the user is naming the file
	 * @param list     the data in the current system state that you are writing to
	 *                 a file
	 * @throws IllegalArgumentException if unable to save to the file
	 */
	public static void writeServiceGroupsToFile(String fileName, ArrayList<ServiceGroup> list) {
		try {
			PrintStream fileWriter = new PrintStream(new File(fileName));
	
				for (int i = 0; i < list.size(); i++) {
					ServiceGroup current = list.get(i);
					ArrayList<Incident> currentList = current.getIncidents();
					fileWriter.println("# " + current.getServiceGroupName());
					for (int j = 0; j < currentList.size(); )
					fileWriter.print(currentList.get(j).toString());
				}
			fileWriter.close();
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
