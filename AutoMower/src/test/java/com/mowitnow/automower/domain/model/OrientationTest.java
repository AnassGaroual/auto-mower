package com.mowitnow.automower.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrientationTest {

	@ParameterizedTest
	@CsvSource({ "N, W", "W, S", "S, E", "E, N" })
	void turnLeft_ShouldResultInCorrectOrientation(Orientation input, Orientation expected) {
		assertEquals(expected, input.turnLeft());
	}

	@ParameterizedTest
	@CsvSource({ "N, E", "E, S", "S, W", "W, N" })
	void turnRight_ShouldResultInCorrectOrientation(Orientation input, Orientation expected) {
		assertEquals(expected, input.turnRight());
	}

}
