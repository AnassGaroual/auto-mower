package com.mowitnow.automower.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Position {
	private final int x;
	private final int y;
	private static final String COORDINATES_MUST_BE_POSITIVE = "Coordinates must be positive";

	private Position(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException(COORDINATES_MUST_BE_POSITIVE);
		}
		this.x = x;
		this.y = y;
	}

	public static Position of(int x, int y) {
		return new Position(x, y);
	}
}