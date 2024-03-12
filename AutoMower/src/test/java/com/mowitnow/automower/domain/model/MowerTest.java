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

}
