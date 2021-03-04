package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

/**
 * @author anthonypulsone
 *
 */
public class ServiceGroup {
	/** ArrayList containing the Incidents in a service group */
	private ArrayList<Incident> incidents;
	
	/** the name of the service group */
	private String serviceGroupName;
	
	/**
	 * @param name
	 */
	public ServiceGroup(String name) {
		
	}
	
	/**
	 * 
	 */
	public void setIncidentCounter() {
		
	}
	
	/**
	 * @param name
	 */
	public void setServiceGroupName(String name) {
		
	}
	
	/**
	 * @return
	 */
	public String getServiceGroupName() {
		return serviceGroupName;
	}
	
	/**
	 * @param incident
	 */
	public void addIncident(Incident incident) {
		
	}
	
	/**
	 * @return
	 */
	public ArrayList<Incident> getIncidents() {
		return null;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Incident getIncidentsById(int id) {
		return null;
	}
	
	/**
	 * @param id
	 */
	public void deleteIncidentById(int id) {
		
	}
	
	/**
	 * @param id
	 * @param c
	 */
	public void executeCommand(int id, Command c) {
		
	}
	
}
