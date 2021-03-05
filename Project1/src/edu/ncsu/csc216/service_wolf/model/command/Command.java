/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.command;

/**
 * Encapsulates the information about a user command that would lead to a
 * transition in the incident finite state machine. Contains the inner
 * enumeration CommandValue that has the six possible commands that can be made
 * for an incident in the incident FSM. Contains constructor and getters for the
 * fields and enumeration.
 * 
 * @author anthonypulsone
 *
 */
public class Command {

	/** String containing the information relevant to this Command */
	private String commandInformation;

	/** String containing the message relevant to this Command */
	private String commandMessage;

	/**
	 * Enumeration for CommandValue. Contains the six commands that can be chosen by
	 * the user in the ServiceWolf program.
	 * 
	 * @author provided by csc216 teaching staff
	 */
	public enum CommandValue {
		ASSIGN, HOLD, INVESTIGATE, RESOLVE, REOPEN, CANCEL
	}

	/**
	 * Constructor for a CommandValue object. Sets the fields and the CommandValue
	 * enumeration. Checks for certain cases where illegal parameters are passed and
	 * throws IAE if necessary.
	 * 
	 * @param value              CommandValue enumeration for the the Command
	 * @param commandInformation String containing additional information about the
	 *                           Command
	 * @param commandMessage     String containing a message about the Command
	 * @throws IllegalArgumentException when passed a null commandValue parameter, a
	 *                                  null or “” commandMessage parameter, a
	 *                                  CommandValue of ASSIGN, HOLD, RESOLVE,
	 *                                  CANCEL with a null or empty string
	 *                                  commandInformation, or a CommandValue of
	 *                                  INVESTIGATE and REOPEN and a non-null
	 *                                  commandInformation.
	 */
	public Command(CommandValue value, String commandInformation, String commandMessage) {

	}

	/**
	 * Getter for the Command and its CommandValue
	 * 
	 * @return CommandValue of the Command
	 */
	public CommandValue getCommand() {
		return null;
	}

	/**
	 * Getter for the commandInformation field of this Command
	 * 
	 * @return commandInformation String with information about the Command
	 */
	public String getCommandInformation() {
		return null;
	}

	/**
	 * Getter for the the commandMessage field of this Command
	 * 
	 * @return commandMessage String with information about the Command
	 */
	public String getCommandMessage() {
		return null;
	}
}
