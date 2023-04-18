package net.swofty.exceptions;

public class SwoftyFunctionNotFound extends Exception {
	public SwoftyFunctionNotFound(String passedThroughFunction) {
		super("Could not find a database function by the reference " + passedThroughFunction);
	}
}
