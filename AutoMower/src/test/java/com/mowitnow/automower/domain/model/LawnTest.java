package com.mowitnow.automower.domain.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LawnTest {

	private Lawn lawn;

	@BeforeEach
	void setUp() {
		lawn = new Lawn(5, 5);
	}

	@Test
	void positionWithinLawn_ShouldReturnTrue() {
		Position insidePosition = Position.of(1, 1);
		assertTrue(lawn.isWithin(insidePosition));
	}

	@Test
	void positionOutsideLawn_ShouldReturnFalse() {
		Position outsidePositionX = Position.of(6, 1);
		assertFalse(lawn.isWithin(outsidePositionX));

		Position outsidePositionY = Position.of(1, 6);
		assertFalse(lawn.isWithin(outsidePositionY));
	}

	@Test
	void positionOnLawnBoundary_ShouldReturnTrue() {
		Position onBoundaryPositionX = Position.of(5, 1);
		assertTrue(lawn.isWithin(onBoundaryPositionX));

		Position onBoundaryPositionY = Position.of(1, 5);
		assertTrue(lawn.isWithin(onBoundaryPositionY));
	}
}
