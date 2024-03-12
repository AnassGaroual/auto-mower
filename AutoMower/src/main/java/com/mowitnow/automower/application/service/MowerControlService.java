package com.mowitnow.automower.application.service;

import java.util.List;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Lawn;
import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.domain.model.Orientation;
import com.mowitnow.automower.domain.model.Position;
import com.mowitnow.automower.port.in.MowerControlPort;

public class MowerControlService implements MowerControlPort {

	private final Lawn lawn;

	public MowerControlService(Lawn lawn) {
		this.lawn = lawn;
	}

	@Override
	public Mower processMowerInstructions(int initialX, int initialY, String orientation, List<Command> commands) {
		Position initialPosition = Position.of(initialX, initialY);
		Orientation initialOrientation = Orientation.valueOf(orientation);
		Mower mower = new Mower(initialPosition, initialOrientation, this.lawn);

		for (Command command : commands) {
			mower.executeCommand(command);
		}

		return mower;
	}
}
