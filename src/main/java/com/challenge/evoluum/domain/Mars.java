package com.challenge.evoluum.domain;

import org.springframework.stereotype.Component;

import com.challenge.evoluum.domain.exceptions.OutOfBorderExcpetion;

@Component
public class Mars {
	
	private Position currentPosition;
	private final int LIMIT_WEST = 0;
	private final int LIMIT_EAST = 4;
	private final int LIMIT_NORTH = 4;
	private final int LIMIT_SOUTH = 0;

	public Mars() {
		this.currentPosition = new Position(0, 0, 'N');
	}
	
	public Position moveCommand(String command) throws OutOfBorderExcpetion {
		
		for (int i = 0; i < command.length(); i++) {
			switch (command.charAt(i)) {
			case 'L':
				this.turnLeft();
				break;
			case 'R':
				this.turnRight();
				break;
			case 'M':
				this.move(1);
				break;
			default:
				break;
			}
		}
		
		return currentPosition;
	}
	
	public void move(int steps) throws OutOfBorderExcpetion {
		switch (this.currentPosition.getDirection()) {
		case 'N':
			this.moveNorth(steps);
			break;
		case 'W':
			this.moveWest(steps);
			break;
		case 'S':
			this.moveSouth(steps);
			break;
		case 'E':
			this.moveEast(steps);
			break;
		default:
			break;
		}
	}
	
	public void turnLeft() {
		char currentDir = currentPosition.getDirection();
		switch (currentDir) {
		case 'N':
			currentPosition.setDirection('W');
			break;
		case 'W':
			currentPosition.setDirection('S');
			break;
		case 'S':
			currentPosition.setDirection('E');
			break;
		case 'E':
			currentPosition.setDirection('N');
			break;
		}
	}
	
	public void turnRight() {
		char currentDir = currentPosition.getDirection();
		switch (currentDir) {
		case 'N':
			currentPosition.setDirection('E');
			break;
		case 'E':
			currentPosition.setDirection('S');
			break;
		case 'S':
			currentPosition.setDirection('W');
			break;
		case 'W':
			currentPosition.setDirection('N');
			break;
		}
	}
	
	public void moveNorth(int steps) throws OutOfBorderExcpetion {
		int curY = currentPosition.getY();
		if (curY + steps <= LIMIT_NORTH ) {
			currentPosition.setY(currentPosition.getY() + steps);
		} else {
			throw new OutOfBorderExcpetion();
		}
	}
	
	public void moveSouth(int steps) throws OutOfBorderExcpetion {
		int curY = currentPosition.getY();
		if (curY - steps >= LIMIT_SOUTH ) {
			currentPosition.setY(currentPosition.getY() - steps);
		} else {
			throw new OutOfBorderExcpetion();
		}
	}
	
	public void moveWest(int steps) throws OutOfBorderExcpetion {
		int curX = currentPosition.getX();
		if (curX - steps >= LIMIT_WEST ) {
			currentPosition.setX(currentPosition.getX() - steps);
		} else {
			throw new OutOfBorderExcpetion();
		}
	}
	
	public void moveEast(int steps) throws OutOfBorderExcpetion {
		int curX = currentPosition.getX();
		if (curX + steps <= LIMIT_EAST ) {
			currentPosition.setX(currentPosition.getX() + steps);
		} else {
			throw new OutOfBorderExcpetion();
		}
	}
}
