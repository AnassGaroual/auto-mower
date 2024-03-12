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
		switch (command) {
		case D -> turnRight();
		case G -> turnLeft();
		case A -> move();
		}
	}

	public void turnLeft() {
		this.orientation = this.orientation.turnLeft();
	}

	public void turnRight() {
		this.orientation = this.orientation.turnRight();
	}

	public void move() {
		int newX = this.position.getX();
		int newY = this.position.getY();

		switch (this.orientation) {
		case N -> newY += 1;
		case E -> newX += 1;
		case S -> newY -= 1;
		case W -> newX -= 1;
		}

		if (newX >= 0 && newY >= 0 && lawn.isWithin(Position.of(newX, newY))) {
			this.position = Position.of(newX, newY);
		}
	}

}
