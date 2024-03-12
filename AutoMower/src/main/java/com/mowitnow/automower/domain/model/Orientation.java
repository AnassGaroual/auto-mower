package com.mowitnow.automower.domain.model;

public enum Orientation {
	N, E, S, W;

	public Orientation turnLeft() {
		if (this.equals(N)) return Orientation.W;
		else if (this.equals(E)) return Orientation.N;
		else if (this.equals(S)) return Orientation.E;
		else  return Orientation.S;
		
	}

	public Orientation turnRight() {
		// TODO: Implement this method
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
