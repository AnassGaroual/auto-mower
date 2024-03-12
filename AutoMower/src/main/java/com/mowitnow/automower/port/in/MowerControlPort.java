package com.mowitnow.automower.port.in;

import java.util.List;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Mower;

/**
 * Interface for controlling a mower within a lawn. This port represents the
 * entry point for passing commands to a mower and getting its final state.
 */
public interface MowerControlService {
	/**
	 * Processes a list of commands for a mower positioned on a lawn and returns the
	 * mower's final state.
	 * 
	 * @param initialX    The initial X-coordinate of the mower.
	 * @param initialY    The initial Y-coordinate of the mower.
	 * @param orientation The initial orientation of the mower.
	 * @param commands    The list of commands to be executed by the mower.
	 * @return The final state of the mower after executing all commands.
	 */
	Mower processMowerInstructions(int initialX, int initialY, String orientation, List<Command> commands);
}
