package com.mowitnow.automower.domain.model;

public enum Orientation {
	N, E, S, W;

	public Orientation turnLeft() {
		return switch (this) {
		case N -> W;
		case W -> S;
		case S -> E;
		case E -> N;
		};
	}

	public Orientation turnRight() {
		// TODO: Implement this method
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
