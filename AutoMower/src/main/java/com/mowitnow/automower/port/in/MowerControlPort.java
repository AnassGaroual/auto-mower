package com.mowitnow.automower.port.in;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Mower;

/**
 * Interface for controlling a mower within a lawn. This port represents the
 * entry point for passing commands to a mower and getting its final state,
 * including specifying the lawn on which the mower operates.
 */
@Service
public interface MowerControlPort {
	/**
	 * Processes a list of commands for a mower positioned on a specific lawn and
	 * returns the mower's final state.
	 * 
	 * @param lawnWidth   The width of the lawn (corresponding to the upper-right
	 *                    X-coordinate).
	 * @param lawnHeight  The height of the lawn (corresponding to the upper-right
	 *                    Y-coordinate).
	 * @param initialX    The initial X-coordinate of the mower on the lawn.
	 * @param initialY    The initial Y-coordinate of the mower on the lawn.
	 * @param orientation The initial orientation of the mower.
	 * @param commands    The list of commands to be executed by the mower.
	 * @return The final state of the mower after executing all commands.
	 */
	Mower processMowerInstructions(int lawnWidth, int lawnHeight, int initialX, int initialY, String orientation,
			List<Command> commands);
}
