package com.mowitnow.automower.domain.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MowerTest {

	private Lawn lawn;

	@BeforeEach
	void setUp() {
		lawn = new Lawn(5, 5);
	}

	@Test
	void constructor_WhenMowerPositionIsOutsideLawn_ShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Mower(Position.of(6, 6), Orientation.N, lawn);
		});
	}

	@Test
	void constructor_WhenMowerPositionIsWithinLawn_ShouldNotThrowException() {
		assertDoesNotThrow(() -> {
			new Mower(Position.of(3, 3), Orientation.N, lawn);
		});
	}

	@Test
	void executeCommand_TurnRight_ShouldChangeOrientationCorrectly() {
		Mower mower = new Mower(Position.of(1, 1), Orientation.N, lawn);
		mower.executeCommand(Command.D);
		assertEquals(Orientation.E, mower.getOrientation());
	}

	@Test
	void executeCommand_TurnLeft_ShouldChangeOrientationCorrectly() {
		Mower mower = new Mower(Position.of(1, 1), Orientation.N, lawn);
		mower.executeCommand(Command.G);
		assertEquals(Orientation.W, mower.getOrientation());
	}

	@ParameterizedTest
	@CsvSource({ "N, 1, 2, 1, 3", "E, 1, 2, 2, 2", "S, 1, 2, 1, 1", "W, 1, 2, 0, 2" })
	void executeCommand_MoveForward_ShouldChangePositionCorrectly(Orientation orientation, int startX, int startY,
			int expectedX, int expectedY) {
		Mower mower = new Mower(Position.of(startX, startY), orientation, lawn);
		mower.executeCommand(Command.A);
		assertEquals(expectedX, mower.getPosition().getX());
		assertEquals(expectedY, mower.getPosition().getY());
	}

	@Test
	void executeCommand_MoveForward_OutsideLawn_ShouldNotChangePosition() {
		Mower mower = new Mower(Position.of(5, 5), Orientation.N, lawn);
		mower.executeCommand(Command.A);
		assertEquals(5, mower.getPosition().getX());
		assertEquals(5, mower.getPosition().getY());
	}
}
