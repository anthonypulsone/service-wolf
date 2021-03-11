/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.incident;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.command.Command.CommandValue;

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
 */
public class Incident {
	/** Current state for the incident */
	private IncidentState currentState;
	/** Final instance of the NewState inner class */
	private final IncidentState newState = new NewState();
	/** Final instance of the InProgressState inner class */
	private final IncidentState inProgressState = new InProgressState();
	/** Final instance of the OnHoldState inner class */
	private final IncidentState onHoldState = new OnHoldState();
	/** Final instance of the ResolvedState inner class */
	private final IncidentState resolvedState = new ResolvedState();
	/** Final instance of the CanceledState inner class */
	private final IncidentState canceledState = new CanceledState();
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
	private ArrayList<String> incidentLog;
	/** A constant string for the new state’s name */
	public static final String NEW_NAME = "New";
	/** A constant string for the in progress state */
	public static final String IN_PROGRESS_NAME = "In Progress";
	/** A constant string for the on hold state */
	public static final String ON_HOLD_NAME = "On Hold";
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
	public static final String RESOLUTION_WORKAROUND = "Workaround";
	/** A constant string for the resolution reason of “Caller Closed” */
	public static final String RESOLUTION_CALLER_CLOSED = "Caller Closed";
	/** A constant string for the cancellation reason of “Duplicate” */
	public static final String CANCELLATION_DUPLICATE = "Duplicate";
	/** A constant string for the cancellation reason of “Unnecessary” */
	public static final String CANCELLATION_UNNECESSARY = "Unnecessary";
	/** A constant string for the cancellation reason of “Not an Incident” */
	public static final String CANCELLATION_NOT_AN_INCIDENT = "Not an Incident";
	/** A constant string for the cancellation reason of “Caller Canceled” */
	public static final String CANCELLATION_CALLER_CANCELLED = "Caller Canceled";
	/** A constant string that represents an unowned incident */
	public static final String UNOWNED = "Unowned";
	/** A constant string that represents an incident with no status reasons */
	public static final String NO_STATUS = "No Status";
	/** Static int that used to track which id ints have already been assigned */
	private static int counter = 0;

	/**
	 * Constructs a Incident from the provided title, caller, and message. Used for
	 * new incident.
	 * 
	 * @param title   String containing the title of the incident
	 * @param caller  String containing the name or id of the caller
	 * @param message String containing the message with more info about the
	 *                incident
	 * @throws IllegalArgumentException If any of the parameters are null or empty
	 *                                  strings, then an IllegalArgumentException is
	 *                                  thrown.
	 */
	public Incident(String title, String caller, String message) {
		setTitle(title);
		setCaller(caller);
		setState(NEW_NAME);
		setOwner(UNOWNED);
		setStatusDetails(NO_STATUS);
		addMessageToIncidentLog(message);
		Incident.incrementCounter();
		this.incidentId = Incident.counter;

	}

	/**
	 * Constructs an Incident with data for all fields passed. Utilized by the
	 * ServiceGroupReader class to load existing Incidents from text files
	 * 
	 * @param id            int value that is the incident's id
	 * @param state         String representation of the State of the Incident
	 * @param title         String containing the title of the Incident
	 * @param caller        String containing the name or id of the caller
	 * @param reopenCount   int containing the number of times an Incident has been
	 *                      reopened
	 * @param owner         String containing the name / id of the owner
	 * @param statusDetails String containing the details about the Incident's
	 *                      status
	 * @param incidentLog   ArrayList of Strings containing the messages that have
	 *                      been added to the incident log
	 * @throws IllegalArgumentException If there is any issue with the parameters
	 */
	public Incident(int id, String state, String title, String caller, int reopenCount,
			String owner, String statusDetails, ArrayList<String> incidentLog) {
		setTitle(title);
		setCaller(caller);
		setReopenCount(reopenCount);
		setOwner(owner);
		if (incidentLog == null) {
			throw new IllegalArgumentException();
		}
		this.incidentLog = incidentLog;
		setStatusDetails(statusDetails);
		setId(incidentId);
		setState(state);
	}

	/**
	 * Getter for the id of this
	 * 
	 * @return the incidentId
	 */
	public int getId() {
		return incidentId;
	}

	/**
	 * Setter for the id of this
	 * 
	 * @param incidentId the incidentId to set
	 * @throws IllegalArgumentException if Id less than 1
	 */
	private void setId(int incidentId) {
		if (incidentId <= 0) {
			throw new IllegalArgumentException();
		}
		if (incidentId > Incident.counter) {
			Incident.setCounter(incidentId + 1);
		}
		this.incidentId = incidentId;
	}

	/**
	 * Getter for the this Incident title
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Setter for this Incident title
	 * 
	 * @param title the title to set
	 * @throws IllegalArgumentException if parameter is null or empty
	 */
	private void setTitle(String title) {
		if (title == null || "".equals(title)) {
			throw new IllegalArgumentException();
		}
		this.title = title;
	}

	/**
	 * Getter for this Incident state
	 * 
	 * @return a String containing the State of the Incident
	 */
	public String getState() {
		return null;
	}

	/**
	 * Setter for currentState field. To be used in the constructor for file i/o.
	 * Finds the proper State for the String containing the name of the State
	 * 
	 * @param state the String representing the state you are attempting to set this
	 *              to
	 * @throws IllegalArgumentException if parameter is null or empty or not a state
	 */
	public void setState(String state) {
		if (state.equals(NEW_NAME) && this.statusDetails.equals(NO_STATUS)) {
			this.currentState = newState;
		} else if (state.equals(IN_PROGRESS_NAME) && this.statusDetails.equals(NO_STATUS)) {
			this.currentState = inProgressState;
		} else if (state.equals(ON_HOLD_NAME) && (this.statusDetails.equals(HOLD_AWAITING_CALLER)
				|| this.statusDetails.equals(HOLD_AWAITING_CHANGE)
				|| this.statusDetails.equals(HOLD_AWAITING_VENDOR))) {
			this.currentState = onHoldState;
		} else if (state.equals(RESOLVED_NAME)
				&& (this.statusDetails.equals(RESOLUTION_PERMANENTLY_SOLVED)
						|| this.statusDetails.equals(RESOLUTION_WORKAROUND)
						|| this.statusDetails.equals(RESOLUTION_CALLER_CLOSED))) {
			this.currentState = resolvedState;
		} else if (state.equals(CANCELED_NAME) && (this.statusDetails.equals(CANCELLATION_DUPLICATE)
				|| this.statusDetails.equals(CANCELLATION_UNNECESSARY)
				|| this.statusDetails.equals(CANCELLATION_NOT_AN_INCIDENT)
				|| this.statusDetails.equals(CANCELLATION_CALLER_CANCELLED))) {
			this.currentState = canceledState;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Getter for the caller of this Incident
	 * 
	 * @return the caller
	 */
	public String getCaller() {
		return caller;
	}

	/**
	 * Setter for the caller of this Incident
	 * 
	 * @param caller the caller to set
	 * @throws IllegalArgumentException if parameter is null or empty
	 */
	private void setCaller(String caller) {
		if (caller == null || "".equals(caller)) {
			throw new IllegalArgumentException();
		}
		this.caller = caller;
	}

	/**
	 * Getter for the reopenCount of this Incident
	 * 
	 * @return the reopenCount
	 */
	public int getReopenCount() {
		return reopenCount;
	}

	/**
	 * Setter for the reopenCount of this Incident
	 * 
	 * @param reopenCount the reopenCount to set
	 * @throws IllegalArgumentException if reopenCount < 0
	 */
	private void setReopenCount(int reopenCount) {
		if (reopenCount < 0) {
			throw new IllegalArgumentException();
		}
		this.reopenCount = reopenCount;
	}

	/**
	 * Getter for the owner of this Incident
	 * 
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Setter for the owner of this Incident
	 * 
	 * @param owner the owner to set
	 * @throws IllegalArgumentException if owner null or empty
	 */
	private void setOwner(String owner) {
		if (owner == null || "".equals(owner)) {
			throw new IllegalArgumentException();
		}
		this.owner = owner;
	}

	/**
	 * Getter for the statusDetails of this Incident
	 * 
	 * @return the statusDetails
	 */
	public String getStatusDetails() {
		return statusDetails;
	}

	/**
	 * Setter for the statusDetails of this Incident
	 * 
	 * @param statusDetails the statusDetails to set
	 */
	private void setStatusDetails(String statusDetails) {
		this.statusDetails = statusDetails;
	}

	/**
	 * Gets the ArrayList of Strings incidentLog as a String
	 * 
	 * @return the incidentLog messages as a String
	 */
	public String getIncidentLogMessages() {
		String log = null;
		for(int i = 0; i < incidentLog.size(); i++) {
			log = "- " + incidentLog.get(i) + "\n";
		}
		return log;
	}

	/**
	 * Adds a String message to the ArrayList of Strings containing the log of
	 * messages for this Incident
	 * 
	 * @param message the incidentLog to set
	 * @return an int value
	 * @throws IllegalArgumentException if parameter null or empty
	 */
	private int addMessageToIncidentLog(String message) {
		if (message == null || "".equals(message)) {
			throw new IllegalArgumentException();
		}
		incidentLog.add(message);
		return incidentLog.size();
	}

	/**
	 * Increments the counter for Incident id's that have been assigned. Always
	 * called by constructor when new Incident is created.
	 */
	public static void incrementCounter() {
		counter++;
	}

	/**
	 * Setter for the counter
	 * 
	 * @param value the int value being assigned to the counter
	 */
	public static void setCounter(int value) {
		Incident.counter = value;
	}

	/**
	 * Overrides the default toString for a class specific implementation of the
	 * method
	 */
	@Override
	public String toString() {
		return null;
	}

	/**
	 * Calls the updateState method for this Incident's currentState. Can throw the
	 * UnsupportedOperationException from the updateState method if thrown due to an
	 * attempt to change to an illegal state.
	 * 
	 * @param c the command that is to be passed to the updateState method
	 * @throws UnsupportedOperationException if the currentState determines that the
	 *                                       transition, as encapsulated by the
	 *                                       Command, is not appropriate for the FSM
	 */
	public void update(Command c) {
		currentState.updateState(c);
	}

	/**
	 * Interface for states in the Incident State Pattern. All concrete incident
	 * states must implement the IncidentState interface. The IncidentState
	 * interface should be a private interface of the Incident class.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
	 */
	private interface IncidentState {

		/**
		 * Update the Incident based on the given Command. An
		 * UnsupportedOperationException is thrown if the Command is not a valid action
		 * for the given state.
		 * 
		 * @param command Command describing the action that will update the Incident's
		 *                state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 *                                       for the given state.
		 */
		void updateState(Command command);

		/**
		 * Returns the name of the current state as a String.
		 * 
		 * @return the name of the current state as a String.
		 */
		String getStateName();

	}

	/**
	 * Represents the new state, the first state of the ServiceWolf FSM. Overrides
	 * the updateState and getStateName methods from the IncidentState interface in
	 * order to enforce the state transition rules for each specific State.
	 * 
	 * @author anthonypulsone
	 *
	 */
	private class NewState implements IncidentState {

		/**
		 * Allows the state to be changed to the state specified by the command if valid
		 * If invalid an exception is thrown to the method that called updateState
		 * 
		 * @param command the command that is attempting to be executed
		 * @throws UnsupportedOperationException if the Command is not a valid operation
		 *                                       for the given state.
		 */
		@Override
		public void updateState(Command command) {
			try {
				if (command.getCommand() == CommandValue.ASSIGN) {
					setOwner(command.getCommandInformation());
					addMessageToIncidentLog(command.getCommandMessage());
					currentState = inProgressState;
				} else if (command.getCommand() == CommandValue.CANCEL) {
					setStatusDetails(command.getCommandInformation());
					addMessageToIncidentLog(command.getCommandMessage());
					currentState = canceledState;
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				throw new UnsupportedOperationException();
			}
		}

		/**
		 * Getter for the name of the State
		 * 
		 * @return a String containing the State's name
		 */
		@Override
		public String getStateName() {
			return NEW_NAME;
		}
	}

	/**
	 * Represents the in progress state of the ServiceWolf FSM. Overrides the
	 * updateState and getStateName methods from the IncidentState interface in
	 * order to enforce the state transition rules for each specific State.
	 * 
	 * @author anthonypulsone
	 *
	 */
	private class InProgressState implements IncidentState {

		/**
		 * Allows the state to be changed to the state specified by the command if valid
		 * If invalid an exception is thrown to the method that called updateState
		 * 
		 * @param command the command that is attempting to be executed
		 * @throws UnsupportedOperationException if the Command is not a valid operation
		 *                                       for the given state.
		 */
		@Override
		public void updateState(Command command) {
			try {
				if (command.getCommand() == CommandValue.HOLD) {
					setStatusDetails(command.getCommandInformation());
					addMessageToIncidentLog(command.getCommandMessage());
					currentState = onHoldState;
				} else if (command.getCommand() == CommandValue.RESOLVE) {
					setStatusDetails(command.getCommandInformation());
					addMessageToIncidentLog(command.getCommandMessage());
					currentState = resolvedState;
				} else if (command.getCommand() == CommandValue.ASSIGN) {
					setOwner(command.getCommandInformation());
					addMessageToIncidentLog(command.getCommandMessage());

					currentState = inProgressState;
				} else if (command.getCommand() == CommandValue.CANCEL) {
					setStatusDetails(command.getCommandInformation());
					addMessageToIncidentLog(command.getCommandMessage());
					setOwner(UNOWNED);
					currentState = canceledState;
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				throw new UnsupportedOperationException();
			}
		}

		/**
		 * Getter for the name of the State
		 * 
		 * @return a String containing the State's name
		 */
		@Override
		public String getStateName() {
			return IN_PROGRESS_NAME;
		}

	}

	/**
	 * Represents the on hold state of the ServiceWolf FSM. Overrides the
	 * updateState and getStateName methods from the IncidentState interface in
	 * order to enforce the state transition rules for each specific State.
	 * 
	 * @author anthonypulsone
	 *
	 */
	private class OnHoldState implements IncidentState {

		/**
		 * Allows the state to be changed to the state specified by the command if valid
		 * If invalid an exception is thrown to the method that called updateState
		 * 
		 * @param command the command that is attempting to be executed
		 * @throws UnsupportedOperationException if the Command is not a valid operation
		 *                                       for the given state.
		 */
		@Override
		public void updateState(Command command) {
			try {
				if (command.getCommand() == CommandValue.INVESTIGATE) {
					addMessageToIncidentLog(command.getCommandMessage());
					setStatusDetails(NO_STATUS);
					currentState = inProgressState;
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				throw new UnsupportedOperationException();
			}
		}

		/**
		 * Getter for the name of the State
		 * 
		 * @return a String containing the State's name
		 */
		@Override
		public String getStateName() {
			// TODO Auto-generated method stub
			return ON_HOLD_NAME;
		}

	}

	/**
	 * Represents the resolved state of the ServiceWolf FSM. Overrides the
	 * updateState and getStateName methods from the IncidentState interface in
	 * order to enforce the state transition rules for each specific State.
	 * 
	 * @author anthonypulsone
	 *
	 */
	private class ResolvedState implements IncidentState {

		/**
		 * Allows the state to be changed to the state specified by the command if valid
		 * If invalid an exception is thrown to the method that called updateState
		 * 
		 * @param command the command that is attempting to be executed
		 * @throws UnsupportedOperationException if the Command is not a valid operation
		 *                                       for the given state.
		 */
		@Override
		public void updateState(Command command) {
			try {
				if (command.getCommand() == CommandValue.REOPEN) {
					setStatusDetails(NO_STATUS);
					addMessageToIncidentLog(command.getCommandMessage());
					currentState = inProgressState;
				} else if (command.getCommand() == CommandValue.CANCEL) {
					setOwner(UNOWNED);
					setStatusDetails(command.getCommandInformation());
					addMessageToIncidentLog(command.getCommandMessage());
					currentState = canceledState;
				} else {
					throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				throw new UnsupportedOperationException();
			}

		}

		/**
		 * Getter for the name of the State
		 * 
		 * @return a String containing the State's name
		 */
		@Override
		public String getStateName() {
			return RESOLVED_NAME;
		}

	}

	/**
	 * Represents the canceled state of the ServiceWolf FSM. Overrides the
	 * updateState and getStateName methods from the IncidentState interface in
	 * order to enforce the state transition rules for each specific State.
	 * 
	 * @author anthonypulsone
	 *
	 */
	private class CanceledState implements IncidentState {

		/**
		 * Throws an UnsupportedOperationException since you can not change a canceled
		 * Incident
		 * 
		 * @param command the command that is attempting to be executed
		 * @throws UnsupportedOperationException if the Command is not a valid operation
		 *                                       for the given state.
		 */
		@Override
		public void updateState(Command command) {
			throw new UnsupportedOperationException();
		}

		/**
		 * Getter for the name of the State
		 * 
		 * @return a String containing the State's name
		 */
		@Override
		public String getStateName() {
			return CANCELED_NAME;
		}

	}
}
