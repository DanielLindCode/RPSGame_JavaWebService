package com.example.demo;

public class matchBean {

	// States
	private int gameCount = 0;
	private int win = 0;
	private int loss = 0;
	private int tie = 0;

	// Method for adding result
	public void addResult(String matchResut)
	{
		gameCount += 1;

		switch (matchResut)
		{
		case "win":
			win += 1;
			break;
		case "loss":
			loss += 1;
			break;
		case "tie":
			tie += 1;
			break;
		}
	}

	// Setters
	public void setLoss(int loss) {
		this.loss = loss;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}

	
	public String toJsonString() 
	{
		String pattern = "{ \"Match\": \"%s\", \"Wins\": \"%s\", \"Losses\": \"%s\", \"Ties\": \"%s\" }";

		String out = String.format(pattern, Integer.toString(this.gameCount), this.win, this.loss, this.tie);

		return out;
	}

}
