package com.example.demo;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class rpsController {

	private matchBean match = new matchBean();
	
	// The game
	@RequestMapping(method = RequestMethod.POST, value = "/rps")
	public String rpsGame(String playerMove) 
	{		
		String[] rps = { "rock", "paper", "scissors" };
		String computerMove = rps[new Random().nextInt(rps.length)];


		if (playerMove.equals(computerMove)) 
		{			
			match.addResult("tie");

			return "PLAYER: " + playerMove +
					"<br>" +
					"COMPUTER: " + computerMove +
					"<br>" +
					"THE GAME WAS A TIE!";

		} else if (playerMove.equals("rock")) 
		{
			if (computerMove.equals("paper")) 
			{				
				match.addResult("loss");
				
				return "PLAYER: " + playerMove +
						"<br>" +
						"COMPUTER: " + computerMove +
						"<br>" +
						"YOU LOSE!";

			} else if (computerMove.equals("scissors")) 
			{
				match.addResult("win");

				return "PLAYER: " + playerMove +
						"<br>" +
						"COMPUTER: " + computerMove +
						"<br>" +
						"YOU WIN!";
			}
		} else if (playerMove.equals("paper")) 
		{
			if (computerMove.equals("rock")) 
			{
				match.addResult("win");

				return "PLAYER: " + playerMove +
						"<br>" +
						"COMPUTER: " + computerMove +
						"<br>" +
						"YOU WIN!";

			} else if (computerMove.equals("scissors")) 
			{
				match.addResult("loss");

				return "PLAYER: " + playerMove +
						"<br>" +
						"COMPUTER: " + computerMove +
						"<br>" +
						"YOU LOSE!";
			}
		} else if (playerMove.equals("scissors")) 
		{
			if (computerMove.equals("paper")) 
			{
				match.addResult("win");

				return "PLAYER: " + playerMove + 
						"<br>" + 
						"COMPUTER: " + computerMove +
						"<br>" + 
						"YOU WIN!";

			} else if (computerMove.equals("rock")) 
			{
				match.addResult("loss");

				return "PLAYER: " + playerMove +
						"<br>" + 
						"COMPUTER: " + computerMove + 
						"<br>" +
						"YOU LOSE!";
			}
		}
		return "Something whent wrong!";
	}

	@RequestMapping(
			value = "/rps",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String showMatches() 
	{
		String result = "";

		result += match.toJsonString() + ",";
		
		if (result.length() > 2) 
		{
			result = result.substring(0, result.length() - 1);
		}
		
		result = "{ \"Games\":  [" + result + "] }";

		return result;
	}

}
