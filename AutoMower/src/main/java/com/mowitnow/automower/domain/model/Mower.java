package com.mowitnow.automower.domain.model;

import lombok.Getter;

@Getter
public class Mower {
	private Position position;
	private Orientation orientation;
	private final Lawn lawn;

	public Mower(Position position, Orientation orientation, Lawn lawn) {
		// TODO: Implement this method
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public void executeCommand(Command command) {
		// TODO: Implement this method
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
