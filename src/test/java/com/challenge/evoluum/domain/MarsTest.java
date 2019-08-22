package com.challenge.evoluum.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.challenge.evoluum.domain.exceptions.OutOfBorderExcpetion;

public class MarsTest {
	
	Mars matrix;
	Position currentPos;
	Position expectedPos;
	
	@Before
	public void creation() {
		matrix = new Mars();
	}

	@Test
	public void testM() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("M");
		expectedPos = new Position(0,1,'N');
		//System.out.println("currentPos x: "+currentPos.getX()+" - y: "+currentPos.getY()+" - dir: "+currentPos.getDirection());
		//System.out.println("expectedPos x: "+expectedPos.getX()+" - y: "+expectedPos.getY()+" - dir: "+expectedPos.getDirection());
		assertEquals(currentPos, expectedPos);
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testMLM() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("MLM");
	}
	
	@Test
	public void testRMMLMR() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("RMMLMR");
		expectedPos = new Position(2,1,'E');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testRMMLMMLMLM() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("RMMLMMLMLM");
		expectedPos = new Position(1,1,'S');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testMMMMMMMMMMMMMMMMM() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("MMMMMMMMRMMMMMMMMML");
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testRRMMMMMMM() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("RRMMMMMMM");
	}
	
	@Test
	public void testRRRRMMRMMMLL() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("RRRRMMRMMMLL");
		expectedPos = new Position(3,2,'W');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test
	public void testRMMMMLMMMM() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("RMMMMLMMMM");
		expectedPos = new Position(4,4,'N');
		assertEquals(currentPos, expectedPos);
	}
	
	@Test(expected = OutOfBorderExcpetion.class)
	public void testRMMMMMLMMMM() throws OutOfBorderExcpetion {
		currentPos = matrix.moveCommand("RMMMMMLMMMM");
	}

}
