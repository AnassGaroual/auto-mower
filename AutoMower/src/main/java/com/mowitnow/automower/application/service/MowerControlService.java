package com.mowitnow.automower.application.service;

import java.util.List;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Lawn;
import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.domain.model.Orientation;
import com.mowitnow.automower.domain.model.Position;
import com.mowitnow.automower.port.in.MowerControlPort;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MowerControlService implements MowerControlPort {

	private final Lawn lawn;

	@Override
	public Mower processMowerInstructions(int initialX, int initialY, String orientation, List<Command> commands) {
		var initialPosition = Position.of(initialX, initialY);
		var initialOrientation = Orientation.valueOf(orientation);
		var mower = new Mower(initialPosition, initialOrientation, this.lawn);

		commands.forEach(mower::executeCommand);

		return mower;
	}
}
