package com.mowitnow.automower.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mowitnow.automower.domain.model.Command;
import com.mowitnow.automower.domain.model.Mower;
import com.mowitnow.automower.domain.model.Orientation;
import com.mowitnow.automower.port.in.MowerControlPort;

class MowerControlServiceTest {

	@Test
	void processMowerInstructions_ReturnsCorrectFinalState() {
		MowerControlPort service = new MowerControlService();
		Mower finalMower = service.processMowerInstructions(5, 5, 1, 2, "N", List.of(Command.G, Command.A, Command.G,
				Command.A, Command.G, Command.A, Command.G, Command.A, Command.A));

		assertEquals(1, finalMower.getPosition().getX());
		assertEquals(3, finalMower.getPosition().getY());
		assertEquals(Orientation.N, finalMower.getOrientation());
	}
}
