package com.mowitnow.automower.domain.model;

import lombok.Getter;

@Getter
public class Mower {
	private Position position;
	private Orientation orientation;
	private final Lawn lawn;

	public Mower(Position position, Orientation orientation, Lawn lawn) {
		if (!lawn.isWithin(position)) {
			throw new IllegalArgumentException("Initial position is outside the lawn boundaries");
		}
		this.position = position;
		this.orientation = orientation;
		this.lawn = lawn;
	}

	public void executeCommand(Command command) {
		// TODO: Implement this method
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
