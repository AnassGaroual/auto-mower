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
		if (command.equals(Command.G))  this.orientation = orientation.turnLeft();
		else if (command.equals(Command.D))this.orientation = orientation.turnRight();
		else {
			Position newPosition = null;
			try {
			if(orientation.equals(Orientation.N)) newPosition = Position.of(position.getX(), position.getY() + 1);
			else if(orientation.equals(Orientation.E)) newPosition = Position.of(position.getX() + 1, position.getY());
			else if(orientation.equals(Orientation.S)) newPosition = Position.of(position.getX() , position.getY() - 1);
			else newPosition = Position.of(position.getX() - 1, position.getY());
			} finally {
				if (newPosition!=null && lawn.isWithin(newPosition)) this.position = newPosition;
			}
			
		}
	}

}
