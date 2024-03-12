package com.mowitnow.automower.domain.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Position {
	private final int x;
	private final int y;

	private Position(int x, int y) {
		if (x >= 0 && y >= 0) {
			this.x = x;
			this.y = y;
		} else
			throw new IllegalArgumentException();
	}

	public static Position of(int x, int y) {
		return new Position(x, y);
	}
}
