package com.mowitnow.automower.domain.model;

public record Lawn(int upperRightX, int upperRightY) {

	public boolean isPositionInside(Position position) {
		return (position.getX() <= upperRightX && position.getY() <= upperRightY);
	}
}
