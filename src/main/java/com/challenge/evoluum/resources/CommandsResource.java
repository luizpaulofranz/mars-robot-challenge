package com.challenge.evoluum.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.evoluum.domain.MarsRobot;
import com.challenge.evoluum.domain.Position;
import com.challenge.evoluum.domain.exceptions.CommandInvalidExcpetion;
import com.challenge.evoluum.domain.exceptions.OutOfBorderExcpetion;

@RestController
@RequestMapping("/rest/mars")
public class CommandsResource {
	
	MarsRobot robot;
	
	@PostMapping("/{command}")
	public ResponseEntity<Position> move(@PathVariable String command) throws OutOfBorderExcpetion, CommandInvalidExcpetion{
		robot = new MarsRobot();
		robot.moveCommand(command);
		return ResponseEntity.status(HttpStatus.OK).body(robot.getCurrentPosition());
	}
	
}
