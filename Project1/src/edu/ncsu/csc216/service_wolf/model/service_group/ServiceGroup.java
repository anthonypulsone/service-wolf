package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * Class for an object representing a ServiceGroup. Contains a list of Incident
 * objects and a name for the group. Class has constructor and methods to edit
 * fields, modify the incident list.
 * 
 * @author anthonypulsone
 *
 */
public class ServiceGroup {
	/** ArrayList containing the Incidents in a service group */
	private ArrayList<Incident> incidents;

	/** the name of the service group */
	private String serviceGroupName;

	/**
	 * Constructor for ServiceGroup. Constructs a new empty ServiceGroup with the
	 * name of the group passed as a String
	 * 
	 * @param name the name of the ServiceGroup
	 * @throws IllegalArgumentException if null or empty String is passed
	 */
	public ServiceGroup(String name) {

	}

	/**
	 * Will set the counter for the Incident instances to the value of the maximum
	 * id in the list of Incidents for the service group + 1.
	 */
	public void setIncidentCounter() {

	}

	/**
	 * Setter for the name of the ServiceGroup
	 * 
	 * @param name String you are setting the name to
	 */
	public void setServiceGroupName(String name) {

	}

	/**
	 * Getter for the ServiceGroupName
	 * 
	 * @return name of the ServiceGroup as a String
	 */
	public String getServiceGroupName() {
		return serviceGroupName;
	}

	/**
	 * Method to add an incident to this ServiceGroup. adds the incident to the list
	 * in sorted order by id. The list will be maintained in sorted order, so you
	 * will be able to add a new incident in order by finding the appropriate index
	 * for adding the incident. If an incident already exists with the given id, an
	 * IllegalArgumentException will be thrown with the message of “Incident cannot
	 * be created.”.
	 * 
	 * @param incident the incident you are adding
	 * @throws IllegalArgumentException if an incident already exists with that id
	 */
	public void addIncident(Incident incident) {

	}

	/**
	 * Getter for the ArrayList of Incidents
	 * 
	 * @return ArrayList containing the Incident objects
	 */
	public ArrayList<Incident> getIncidents() {
		return null;
	}

	/**
	 * Get an Incident object in the ServiceGroup list from a provided id. returns
	 * the Incident in the list with the given id. If there is no Incident with that
	 * id, the method returns null.
	 * 
	 * @param id the id of the Incident that is being searched for
	 * @return the Incident if found or null if not
	 */
	public Incident getIncidentById(int id) {
		return null;
	}

	/**
	 * Delete an incident in the ServiceGroup list from a provided id
	 * 
	 * @param id the id of the incident you are deleting
	 */
	public void deleteIncidentById(int id) {

	}

	/**
	 * Finds the Incident with the given id and update it by passing in the given Command.
	 * 
	 * @param id the id of the Incident you are passing a the command to
	 * @param c the command you are passing to the Incident
	 */
	public void executeCommand(int id, Command c) {

	}

}
