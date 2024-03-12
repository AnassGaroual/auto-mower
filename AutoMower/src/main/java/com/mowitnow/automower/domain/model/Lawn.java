package com.mowitnow.automower.domain.model;

public record Lawn(int upperRightX, int upperRightY) {

	public boolean isWithin(Position position) {
		// TODO: Implement this method
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
