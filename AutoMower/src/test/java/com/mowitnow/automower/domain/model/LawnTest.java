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
		assertTrue(lawn.isPositionInside(insidePosition));
	}

	@Test
	void positionOutsideLawn_ShouldReturnFalse() {
		Position outsidePositionX = Position.of(6, 1);
		assertFalse(lawn.isPositionInside(outsidePositionX));

		Position outsidePositionY = Position.of(1, 6);
		assertFalse(lawn.isPositionInside(outsidePositionY));
	}

	@Test
	void positionOnLawnBoundary_ShouldReturnTrue() {
		Position onBoundaryPositionX = Position.of(5, 1);
		assertTrue(lawn.isPositionInside(onBoundaryPositionX));

		Position onBoundaryPositionY = Position.of(1, 5);
		assertTrue(lawn.isPositionInside(onBoundaryPositionY));
	}
}
