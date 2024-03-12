package com.mowitnow.automower.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Position {
	private final int x;
	private final int y;

	private Position(int x, int y) {
		// TODO: Implement this method
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public static Position of(int x, int y) {
		return new Position(x, y);
	}
}
