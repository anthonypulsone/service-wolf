package edu.ncsu.csc216.service_wolf.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * Class for Managing the ServiceGroups and their Incidents. Implements
 * Singleton design pattern, so there will only be one instance of this class
 * that will interact with ServiceWolfGUI. Class contains methods to interact
 * with ServiceGroups and their Incidents
 * 
 * @author anthonypulsone
 *
 */
public class ServiceWolfManager {
	
	/** singleton instance of ServiceWolfManager */
	private static ServiceWolfManager singleton;
	/** ArrayList that contains a list of ServiceGroups in this */
	private ArrayList<ServiceGroup> serviceGroups;

	/** the current selected ServiceGroup in the GUI */
	private ServiceGroup currentServiceGroup;

	/**
	 * Constructor for ServiceWolfManager. Utilized once by the GUI to construct the
	 * Singleton instance of this class
	 */
	private ServiceWolfManager() {
		this.serviceGroups = new ArrayList<ServiceGroup>();
	}

	/**
	 * Static method to return the singleton instance of ServiceWolfManager
	 * 
	 * @return ServiceWolfManager object
	 */
	public static ServiceWolfManager getInstance() {
		if (singleton == null) {
			singleton = new ServiceWolfManager();
		}
		return singleton;
	}

	/**
	 * Saves the current ServiceWolf data to a file by utilizing the methods in the
	 * ServiceGroupsWriter class.
	 * 
	 * @param fileName the fileName the user is writing the ServiceWolf data to
	 * @throws IllegalArgumentException if passed from the output method if thrown
	 */
	public void saveToFile(String fileName) {
		
	}

	/**
	 * Loads ServiceWolf data from a file utilizing the ServiceGroupsReader class
	 * methods.
	 * 
	 * @param fileName the name of the file that the user is wanting to load
	 */
	public void loadFromFile(String fileName) {

	}

	/**
	 * Creates and returns a 2d Array representation the Incidents in a ServiceGroup
	 * to be utilized by the GUI
	 * 
	 * @return 2d Array of Incidents
	 */
	public String[][] getIncidentsAsArray() {
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
	 * Finds the Incident with the given id and update it by passing in the given
	 * Command.
	 * 
	 * @param id the id of the Incident you are passing a the command to
	 * @param c  the command you are passing to the Incident
	 */
	public void executeCommand(int id, Command c) {

	}

	/**
	 * Delete an Incident in the ServiceGroup list from a provided id
	 * 
	 * @param id the id of the Incident you are deleting
	 */
	public void deleteIncidentById(int id) {

	}

	/**
	 * Constructs a new Incident and adds it to the current ServiceGroup
	 * 
	 * @param tile    the title of the Incident
	 * @param caller  the caller of the Incident
	 * @param message the Incident message with details
	 */
	public void addIncidentToServiceGroup(String tile, String caller, String message) {

	}

	/**
	 * Find the ServiceGroup with the given name in the list, make it the active or
	 * currentServiceGroup, and set the incident counter for that service group so
	 * that any new Incidents added to the service group are created with the next
	 * correct id.
	 * 
	 * @param serviceGroupName the name of the ServiceGroup the user is attempting
	 *                         to load
	 */
	public void loadServiceGroup(String serviceGroupName) {

	}

	/**
	 * Getter to return the service group name for the currentServiceGroup. If the
	 * currentServiceGroup is null, then null is returned.
	 * 
	 * @return name of ServiceGroup or null
	 */
	public String getServiceGroupName() {
		return null;
	}

	/**
	 * Getter to return a String array of service group names in the order they are
	 * listed in the serviceGroups list. This is used by the GUI to populate the
	 * service group drop down
	 * 
	 * @return a String[] containing the names of ServiceGroups
	 */
	public String[] getServiceGroupList() {
		return null;

	}

	/**
	 * Resets serviceGroup to an empty array list. The currentServiceGroup is set to
	 * null.
	 */
	public void clearServiceGroups() {

	}

	/**
	 * Updates the currentServiceGroup’s name to the given value. As part of this,
	 * there are checks that the updateName is not a duplicate with an existing
	 * service group or null or the empty string. The service group is moved to the
	 * appropriate location in the serviceGroup list. This should be done by
	 * removing it and re adding it to the appropriate location. The serviceGroup is
	 * then loaded as the currentServiceGroup by calling the loadServiceGroup(String
	 * serviceGroupName) method.
	 * 
	 * @param updateName the name that the ServiceGroup is being changed to
	 */
	public void editServiceGroup(String updateName) {

	}

	/**
	 * Adds a ServiceGroup to the ServiceGroup list in the correct alphabetic place.
	 * Helper method to be utilized by constructor, editServiceGroup name, and
	 * addServiceGroup
	 * 
	 * @param groupToAdd the ServiceGroup to be added
	 */
	private void addServiceGroupToListByName(ServiceGroup groupToAdd) {

	}

	/**
	 * Creates a new ServiceGroup with the given name and adds it to the
	 * serviceGroup list in sorted order by name. The serviceGroup is then loaded as
	 * the currentServiceGroup by calling the loadServiceGroup(String
	 * serviceGroupName) method. If there is already a service group with the same
	 * name (utilizes checkDuplicateServiceName) or if the name is null or an empty
	 * string, an IllegalArgumentException is thrown with the message “Invalid
	 * service group name.” Case should be ignored in comparisons for the same name.
	 * 
	 * @param serviceGroupName the name of the ServiceGroup you are adding (String)
	 * @throws IllegalArgumentException if name is null, empty, or a duplicate name
	 */
	public void addServiceGroup(String serviceGroupName) {

	}

	/**
	 * Checks if a ServiceGroup of same name already exists. Helper method for
	 * addServiceGroup and setServiceGroup
	 * 
	 * @param name the name the user is attempting to set the ServiceGroup to
	 * @throws IllegalArgumentException if name already exists
	 */
	private void checkDuplicateServiceName(String name) {

	}

	/**
	 * This method deletes the currentServiceGroup. The currentServiceGroup is
	 * updated to the service group at index 0 or null if there are no service
	 * groups left. If the currentServiceGroup is null when attempting to delete,
	 * throw an IAE with the message “No service group selected.”
	 * 
	 * @throws IllegalArgumentException if no service group is selected when
	 *                                  attempting to delete a ServiceGroup
	 */
	public void deleteServiceGroup() {

	}

	/**
	 * Sets this (the singleton ServiceWolf) to null. Intended for testing.
	 */
	protected void resetManager() {

	}

}
