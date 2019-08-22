package com.challenge.evoluum.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.challenge.evoluum.domain.exceptions.CommandInvalidExcpetion;
import com.challenge.evoluum.domain.exceptions.OutOfBorderExcpetion;

public class MarsRobotTest {
	
	MarsRobot robot;
	Position currentPos;
	Position expectedPos;
	
	@Before
	public void creation() {
		robot = new MarsRobot();
	}

	@Test
	public void testM() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("M");
		expectedPos = new Position(0,1,'N');
		//System.out.println("currentPos x: "+currentPos.getX()+" - y: "+currentPos.getY()+" - dir: "+currentPos.getDirection());
		//System.out.println("expectedPos x: "+expectedPos.getX()+" - y: "+expectedPos.getY()+" - dir: "+expectedPos.getDirection());
		assertEquals(currentPos, expectedPos);
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testMLM() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("MLM");
	}
	
	@Test
	public void testRMMLMR() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("RMMLMR");
		expectedPos = new Position(2,1,'E');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testRMMLMMLMLM() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("RMMLMMLMLM");
		expectedPos = new Position(1,1,'S');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testMMMMMMMMMMMMMMMMM() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("MMMMMMMMRMMMMMMMMML");
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testRRMMMMMMM() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("RRMMMMMMM");
	}
	
	@Test
	public void testRRRRMMRMMMLL() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("RRRRMMRMMMLL");
		expectedPos = new Position(3,2,'W');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testRMMMMLMMMM() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("RMMMMLMMMM");
		expectedPos = new Position(4,4,'N');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testRMMMMMLMMMM() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("RMMMMMLMMMM");
	}
	
	@Test(expected = CommandInvalidExcpetion.class)
	public void testN() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("N");
	}
	
	@Test(expected = CommandInvalidExcpetion.class)
	public void testE() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("E");
	}
	
	@Test(expected = CommandInvalidExcpetion.class)
	public void testS() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("S");
	}
	
	@Test(expected = CommandInvalidExcpetion.class)
	public void testW() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("W");
	}
	
	@Test(expected = CommandInvalidExcpetion.class)
	public void testMMRMMQ() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		currentPos = robot.moveCommand("MMRMMQ");
	}

	@Test
	public void testTurnRight1() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		robot.turnRight();
		currentPos = robot.getCurrentPosition();
		expectedPos = new Position(0,0,'E');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testTurnLeft2() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		robot.turnLeft();
		robot.turnLeft();
		currentPos = robot.getCurrentPosition();
		expectedPos = new Position(0,0,'S');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testTurnRight3Left5() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		robot.turnRight();
		robot.turnRight();
		robot.turnRight();
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
		currentPos = robot.getCurrentPosition();
		expectedPos = new Position(0,0,'S');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testMoveNorth3() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		robot.move(3);
		currentPos = robot.getCurrentPosition();
		expectedPos = new Position(0,3,'N');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testMoveEast4() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		robot.turnRight();
		robot.move(4);
		currentPos = robot.getCurrentPosition();
		expectedPos = new Position(4,0,'E');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testMoveWest2() throws OutOfBorderExcpetion, CommandInvalidExcpetion {
		robot.turnLeft();
		robot.move(2);
	}
}
