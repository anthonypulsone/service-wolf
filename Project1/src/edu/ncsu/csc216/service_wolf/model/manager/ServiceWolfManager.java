package edu.ncsu.csc216.service_wolf.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupWriter;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupsReader;
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
	 * @throws IllegalArgumentException passed from the output method if thrown
	 */
	public void saveToFile(String fileName) {
		if(currentServiceGroup == null || currentServiceGroup.getIncidents().size() == 0) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		ServiceGroupWriter.writeServiceGroupsToFile(fileName, serviceGroups);
	}

	/**
	 * Loads ServiceWolf data from a file utilizing the ServiceGroupsReader class
	 * methods. Adds the loaded service groups to current groups
	 * 
	 * @param fileName the name of the file that the user is wanting to load
	 */
	public void loadFromFile(String fileName) {
		ArrayList<ServiceGroup> newGroups = ServiceGroupsReader.readServiceGroupsFile(fileName);
		for (int i = 0; i < newGroups.size(); i++) {
			addServiceGroupToListByName(newGroups.get(i));
			if (i == 0) {
				loadServiceGroup(newGroups.get(i).getServiceGroupName());
			}
		}
	}

	/**
	 * Creates and returns a 2d Array representation the Incidents in a ServiceGroup
	 * to be utilized by the GUI
	 * 
	 * @return 2d Array of Incidents
	 */
	public String[][] getIncidentsAsArray() {
		if (currentServiceGroup != null) {
			String[][] incidents = new String[currentServiceGroup.getIncidents().size()][4];
			for (int i = 0; i < currentServiceGroup.getIncidents().size(); i++) {
				Incident in = currentServiceGroup.getIncidents().get(i);
				incidents[i][0] = Integer.toString(in.getId());
				incidents[i][1] = in.getState();
				incidents[i][2] = in.getTitle();
				incidents[i][3] = in.getStatusDetails();
			}
			return incidents;
		} else {
			return null;
		}
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
		Incident i = null;
		if (currentServiceGroup != null) {
			i = currentServiceGroup.getIncidentById(id);
		}
		return i;
	}

	/**
	 * Finds the Incident with the given id and update it by passing in the given
	 * Command.
	 * 
	 * @param id the id of the Incident you are passing a the command to
	 * @param c  the command you are passing to the Incident
	 */
	public void executeCommand(int id, Command c) {
		if (currentServiceGroup != null) {
			Incident i = getIncidentById(id);
			i.update(c);
		}
	}

	/**
	 * Delete an Incident in the ServiceGroup list from a provided id
	 * 
	 * @param id the id of the Incident you are deleting
	 */
	public void deleteIncidentById(int id) {
		if (currentServiceGroup != null) {
			currentServiceGroup.deleteIncidentById(id);
		}
	}

	/**
	 * Constructs a new Incident and adds it to the current ServiceGroup
	 * 
	 * @param title   the title of the Incident
	 * @param caller  the caller of the Incident
	 * @param message the Incident message with details
	 * @throws IllegalArgumentException if thrown and passed when constructing or
	 *                                  adding incident
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		if (currentServiceGroup != null) {
			Incident incident = new Incident(title, caller, message);
			currentServiceGroup.addIncident(incident);
		}
	}

	/**
	 * Find the ServiceGroup with the given name in the list, make it the active or
	 * currentServiceGroup, and set the incident counter for that service group so
	 * that any new Incidents added to the service group are created with the next
	 * correct id.
	 * 
	 * @param serviceGroupName the name of the ServiceGroup the user is attempting
	 *                         to load
	 * @throws IllegalArgumentException if service group not found
	 */
	public void loadServiceGroup(String serviceGroupName) {
		boolean foundFlag = false;
		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroupName.equals(serviceGroups.get(i).getServiceGroupName())) {
				currentServiceGroup = serviceGroups.get(i);
				currentServiceGroup.setIncidentCounter();
				foundFlag = true;
			}
		}
		if (!foundFlag) {
			throw new IllegalArgumentException();
		}
		
		
	}

	/**
	 * Getter to return the service group name for the currentServiceGroup. If the
	 * currentServiceGroup is null, then null is returned.
	 * 
	 * @return name of ServiceGroup or null
	 */
	public String getServiceGroupName() {
		if (currentServiceGroup != null) {
			return currentServiceGroup.getServiceGroupName();
		} else {
			return null;
		}
	}

	/**
	 * Getter to return a String array of service group names in the order they are
	 * listed in the serviceGroups list. This is used by the GUI to populate the
	 * service group drop down
	 * 
	 * @return a String[] containing the names of ServiceGroups
	 */
	public String[] getServiceGroupList() {
		String[] names = new String[serviceGroups.size()];
		for (int i = 0; i < serviceGroups.size(); i++) {
			names[i] = serviceGroups.get(i).getServiceGroupName();
		}
		return names;
	}

	/**
	 * Resets serviceGroup to an empty array list. The currentServiceGroup is set to
	 * null.
	 * @throws IllegalArgumentException if called when currentServiceGroup is null
	 */
	public void clearServiceGroups() {
		serviceGroups.clear();
		currentServiceGroup = null;
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
	 * @throws IllegalArgumentException if currentServiceGroup is null
	 */
	public void editServiceGroup(String updateName) {
		if (currentServiceGroup == null) {
			throw new IllegalArgumentException("No service group selected.");
		}
		checkDuplicateServiceName(updateName);
		ServiceGroup temp = currentServiceGroup;

		temp.setServiceGroupName(updateName);
		deleteServiceGroup();
		addServiceGroupToListByName(temp);
		loadServiceGroup(temp.getServiceGroupName());
	}

	/**
	 * Adds a ServiceGroup to the ServiceGroup list in the correct alphabetic place.
	 * Helper method to be utilized by constructor, editServiceGroup name, and
	 * addServiceGroup
	 * 
	 * @param groupToAdd the ServiceGroup to be added
	 * @throws IllegalArgumentException if service group can't be added
	 */
	private void addServiceGroupToListByName(ServiceGroup groupToAdd) {
		String serviceGroupName = groupToAdd.getServiceGroupName().toLowerCase();
		if (serviceGroups.size() == 0) {
			serviceGroups.add(groupToAdd);
		} else {
			for (int i = 0; i < serviceGroups.size(); i++) {
				String nameToCompare = serviceGroups.get(i).getServiceGroupName().toLowerCase();
				if (serviceGroupName.equals(nameToCompare)) {
					throw new IllegalArgumentException("Invalid service group name.");
				} else if (serviceGroupName.compareTo(nameToCompare) < 0) {
					serviceGroups.add(i, groupToAdd);
					break;
				} else if (i == serviceGroups.size() - 1
						&& serviceGroupName.compareTo(nameToCompare) > 0) {
					serviceGroups.add(groupToAdd);
					break;
				}
			}
		}
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
		checkDuplicateServiceName(serviceGroupName);
		ServiceGroup s = new ServiceGroup(serviceGroupName);
		addServiceGroupToListByName(s);
		loadServiceGroup(s.getServiceGroupName());

	}

	/**
	 * Checks if a ServiceGroup of same name already exists. Helper method for
	 * addServiceGroup and setServiceGroup
	 * 
	 * @param name the name the user is attempting to set the ServiceGroup to
	 * @throws IllegalArgumentException if name already exists
	 */
	private void checkDuplicateServiceName(String name) {
		if (currentServiceGroup != null) {
			if(name == null || "".equals(name)) {
				throw new IllegalArgumentException("Invalid service group name.");
			}
			String serviceName = name.toLowerCase();
			for (int i = 0; i < serviceGroups.size(); i++) {
				String otherName = serviceGroups.get(i).getServiceGroupName().toLowerCase();
				if (serviceName.equals(otherName)) {
					throw new IllegalArgumentException("Invalid service group name.");
				}
			}
		}
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
		if (currentServiceGroup != null) {
			for (int i = 0; i < serviceGroups.size(); i++) {
				if (currentServiceGroup.getServiceGroupName()
						.equals(serviceGroups.get(i).getServiceGroupName())) {
					serviceGroups.remove(i);
					if (serviceGroups.isEmpty()) {
						currentServiceGroup = null;
					} else {
						
						this.currentServiceGroup = serviceGroups.get(0);
					}
				}
			}
		} else {
			throw new IllegalArgumentException("No service group selected.");
		}
	}

	/**
	 * Sets this (the singleton ServiceWolf) to null. Intended for testing.
	 */
	protected void resetManager() {
		singleton = null;
	}

}
