package edu.ncsu.csc216.service_wolf.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * 
 * 
 * @author anthonypulsone
 *
 */
public class ServiceWolfManager {
	
	/**
	 * 
	 */
	private ArrayList<ServiceGroup> serviceGroups;
	
	/**
	 * 
	 */
	private ServiceGroup currentServiceGroup;
	
	/**
	 * 
	 */
	private ServiceWolfManager() {
		
	}
	
	/**
	 * @return
	 */
	public static ServiceWolfManager getInstance() {
		return null;
	}
	
	/**
	 * @param fileName
	 */
	public void saveToFile(String fileName) {
		
	}
	
	/**
	 * @param fileName
	 */
	public void loadFromFile(String fileName) {
		
	}
	
	/**
	 * @return
	 */
	public String[][] getIncidentsAsArray() {
		return null;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Incident getIncidentById(int id) {
		return null;
	}
	
	/**
	 * @param id
	 * @param c
	 */
	public void executeCommand(int id, Command c) {
		
	}
	
	/**
	 * @param id
	 */
	public void deleteIncidentById(int id) {
		
	}
	
	/**
	 * @param tile
	 * @param caller
	 * @param message
	 */
	public void addIncidentToServiceGroup(String tile, String caller, String message) {
		
	}
	
	/**
	 * @param serviceGroupName
	 */
	public void loadServiceGroup(String serviceGroupName) {
		
	}
	
	/**
	 * @return
	 */
	public String getServiceGroupName() {
		return null;
	}
	
	/**
	 * @return
	 */
	public String[] getServiceGroupList() {
		return null;
		
	}
	
	/**
	 * 
	 */
	public void clearServiceGroups() {
		
	}
	
	/**
	 * @param updateName
	 */
	public void editServiceGroup(String updateName) {
		
	}
	
	/**
	 * @param name
	 */
	private void addServiceGroupToListByName(ServiceGroup name) {
		
	}
	
	/**
	 * @param serviceGroupName
	 */
	public void addServiceGroup(String serviceGroupName) {
		
	}
	
	private void checkDuplicateServiceName(String name) {
		
	}
	
	/**
	 * 
	 */
	public void deleteServiceGroup() {
		
	}
	
	/**
	 * 
	 */
	protected void resetManager() {
		
	}
	
}
