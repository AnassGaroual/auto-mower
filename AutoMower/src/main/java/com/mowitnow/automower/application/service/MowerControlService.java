package com.mowitnow.automower.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Lawn;
import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.domain.model.Orientation;
import com.mowitnow.automower.domain.model.Position;
import com.mowitnow.automower.port.in.MowerControlPort;

@Service
public class MowerControlService implements MowerControlPort {

	@Override
	public Mower processMowerInstructions(int lawnWidth, int lawnHeight, int initialX, int initialY, String orientation,
			List<Command> commands) {
		Lawn lawn = new Lawn(lawnWidth, lawnHeight);
		var initialPosition = Position.of(initialX, initialY);
		var initialOrientation = Orientation.valueOf(orientation);
		var mower = new Mower(initialPosition, initialOrientation, lawn);

		commands.forEach(mower::executeCommand);

		return mower;
	}
}
