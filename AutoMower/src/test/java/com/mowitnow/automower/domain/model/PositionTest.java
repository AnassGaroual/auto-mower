package com.mowitnow.automower.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PositionTest {

	@Test
	void createPosition_WithValidCoordinates_ShouldSucceed() {
		Position position = Position.of(0, 0);
		assertNotNull(position);
		assertEquals(0, position.getX());
		assertEquals(0, position.getY());
	}

	@Test
	void createPosition_WithNegativeX_ShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> Position.of(-1, 0));
	}

	@Test
	void createPosition_WithNegativeY_ShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> Position.of(0, -1));
	}
}
