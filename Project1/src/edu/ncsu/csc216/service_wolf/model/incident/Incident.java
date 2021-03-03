/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;

/**
 * Incident represents an Incident object managed by the system. An Incident has
 * fields that contain the necessary details and information for an Incident.
 * Also has Constructors for a brand new Incident as well a Constructor for
 * loading Incidents from a file that may be in different States and contain
 * unique field information. Class has getter and setter methods and toString.
 * Also has subclasses for IncidentState interface, and concrete classes for
 * each state in the finite state machine.
 * 
 * @author anthonypulsone
 *
 */
public class Incident {
	/** int representing the id of the incident */
	private int incidentId;
	/** String containing the title of the incident */
	private String title;
	/** String containing the name/id of the caller */
	private String caller;
	/** the count of how many times a incident has been reopened */
	private int reopenCount;
	/** String containing the owner name/id of the incident */
	private String owner;
	/** String containing the details of the incident status */
	private String statusDetails;
	/** List containing the log of each message in the IncidentLog */
	private ArrayList<String> IncidentLog;
	/** A constant string for the new state’s name */
	public static final String NEW_NAME = "New";
	/** A constant string for the in progress state */
	public static final String IN_PROGRESS_NAME = "In Progress";
	/** A constant string for the on hold state */
	public static final String ON_HOLD = "On Hold";
	/** A constant string for the resolved state */
	public static final String RESOLVED_NAME = "Resolved";
	/** A constant string for the canceled state */
	public static final String CANCELED_NAME = "Canceled";
	/** A constant string for the priority of “Awaiting Caller” */
	public static final String HOLD_AWAITING_CALLER = "Awaiting Caller";
	/** A constant string for the priority of “Awaiting Change” */
	public static final String HOLD_AWAITING_CHANGE = "Awaiting Change";
	/** A constant string for the priority of “Awaiting Vendor” */
	public static final String HOLD_AWAITING_VENDOR = "Awaiting Vendor";
	/** A constant string for the resolution reason of “Permanently Solved” */
	public static final String RESOLUTION_PERMANENTLY_SOLVED = "Permanently Solved";
	/** A constant string for the resolution reason of “Workaround” */
	public static final String WORKAROUND = "Workaround";
	/** A constant string for the resolution reason of “Caller Closed” */
	public static final String RESOLUTION_CALLER_CLOSED = "Caller Closed";
	/** A constant string for the cancellation reason of “Duplicate” */
	public static final String CANCELLATION_DUPLICATE = "Duplicate";
	/** A constant string for the cancellation reason of “Unnecessary” */
	public static final String CANCELLATION_UNNECESSARY = "Unnecessary";
	/** A constant string for the cancellation reason of “Not an Incident” */
	public static final String CANCELLATION_NOT_AN_INCIDENT = "Not an Incident";
	/** A constant string for the cancellation reason of “Caller Canceled” */
	public static final String CANCELLATION_CALLER_CANCELED = "Caller Canceled";
	/** A constant string that represents an unowned incident */
	public static final String UNOWNED = "Unowned";
	/** A constant string that represents an incident with no status reasons */
	public static final String NO_STATUS = "No Status";
	/** Static int that used to track which id ints have already been assigned */
	private static int counter = 0;

	/**
	 * @param title
	 * @param caller
	 * @param message
	 */
	public Incident(String title, String caller, String message) {

	}

	/**
	 * @param id
	 * @param state
	 * @param title
	 * @param caller
	 * @param reopenCount
	 * @param owner
	 * @param statusDetails
	 * @param incidentLog
	 */
	public Incident(int id, String state, String title, String caller, int reopenCount,
			String owner, String statusDetails, ArrayList<String> incidentLog) {

	}

	/**
	 * @return the incidentId
	 */
	public int getId() {
		return incidentId;
	}

	/**
	 * @param incidentId the incidentId to set
	 */
	private void setId(int incidentId) {
		this.incidentId = incidentId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	private void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the caller
	 */
	public String getCaller() {
		return caller;
	}

	/**
	 * @param caller the caller to set
	 */
	private void setCaller(String caller) {
		this.caller = caller;
	}

	/**
	 * @return the reopenCount
	 */
	public int getReopenCount() {
		return reopenCount;
	}

	/**
	 * @param reopenCount the reopenCount to set
	 */
	private void setReopenCount(int reopenCount) {
		this.reopenCount = reopenCount;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the statusDetails
	 */
	public String getStatusDetails() {
		return statusDetails;
	}

	/**
	 * @param statusDetails the statusDetails to set
	 */
	private void setStatusDetails(String statusDetails) {
		this.statusDetails = statusDetails;
	}

	/**
	 * @return the incidentLog
	 */
	public String getIncidentLogMessage() {
		return null;
	}

	/**
	 * @param incidentLog the incidentLog to set
	 */
	private int addMessageToIncidentLog(String message) {
		return 0;
	}

	/**
	 * 
	 */
	public static void incrementCounter() {
		counter++;
	}

	/**
	 * @param value
	 */
	public static void setCounter(int value) {

	}

	/**
	 *
	 */
	public String toString() {
		return null;
	}

	/**
	 * @param c
	 */
	public void update(Command c) {

	}
}
