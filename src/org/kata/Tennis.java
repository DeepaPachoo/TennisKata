package org.kata;

public class Tennis {

	protected static String player1Name;
	protected static String player2Name;

	private static int[] scoreArray = { 0, 15, 30, 40, 50 };
	protected static int p1CurrentScore;
	protected static int p2CurrentScore;
	
	protected static boolean isDeuce = false;
	protected static boolean isP1Adv = false;
	protected static boolean isP2Adv = false;
	
	protected static int p1SetWon;
	protected static int p2SetWon;

	
	public static void applyScore(String playerName) {

		if (playerName.equalsIgnoreCase(player1Name)) {
			
			if(isDeuce){
				isP1Adv = true;
				isDeuce = false;
				isP2Adv = false;
				return;
			}else  if(isP1Adv){
				p1SetWon++;
				resetAll();
				return;
			} else if (isP2Adv){
				isDeuce = true;
				isP2Adv = false;
				return;
			}

			p1CurrentScore = findNextScore(p1CurrentScore);

			if ( p1CurrentScore == 50 && p2CurrentScore < 40) {
				p1SetWon++;
				resetAll();
			}else if (p1CurrentScore == 40 && p2CurrentScore == 40){
				isDeuce = true;
				isP1Adv = false;
				isP2Adv = false;
			}

		} else if (playerName.equalsIgnoreCase(player2Name)) {
			if(isDeuce){
				isP2Adv = true;
				isDeuce = false;
				return;
			}else if(isP2Adv){
				p2SetWon++;
				resetAll();
				return;
			} else if(isP1Adv){
				isDeuce = true;
				isP1Adv = false;
				return;
			}

			p2CurrentScore = findNextScore(p2CurrentScore);

			if ( p2CurrentScore == 50 && p1CurrentScore < 40) {
				p2SetWon++;
				resetAll();
			}else if (p2CurrentScore == 40 && p1CurrentScore == 40){
				isDeuce = true;
				isP1Adv = false;
				isP2Adv = false;
			}
	
		}
	}
	
	private static void resetAll(){
		p1CurrentScore = 0;
		p2CurrentScore = 0;
		isDeuce = false;
		isP2Adv = false;
		isP1Adv = false;
	}

	private static int findNextScore(int currentScore) {

		boolean returnScore = false;
		for(int score : scoreArray){
			
			if(returnScore){
				return score;
			}
			if(score == currentScore){
				returnScore = true;
			}
		}
		
		return 0;
	}
	
	public void testPlayer1ScoreIncrease(){
		applyScore(player1Name);
		
		System.out.println("TESTING PLAYER 1 SCORE INCREASE TO 15:");
		System.out.println(player1Name +"'s current Score is:: " + p1CurrentScore);
		System.out.println(player2Name +"'s current Score is:: " + p2CurrentScore);
		
		System.out.println(player1Name +"'s advantage is:: " + isP1Adv);
		System.out.println(player2Name+"'s advantage is:: " + isP2Adv);
		System.out.println("The Game is deuce? " + isDeuce);	
		
		System.out.println("Number of sets won by "+ player1Name + " is :: " + p1SetWon);
		System.out.println("Number of sets won by "+ player2Name + " is :: "  + p2SetWon+"\n");
		//resetAll();
	}
	
	public void testPlayer2ScoreIncrease(){
		
		for(int i=0;i<3;i++){
			applyScore(player2Name);
		}
		System.out.println("TESTING PLAYER 2 SCORE INCREASE TO 40:");
		System.out.println(player1Name +"'s current Score is:: " + p1CurrentScore);
		System.out.println(player2Name +"'s current Score is:: " + p2CurrentScore);
		
		System.out.println(player1Name +"'s advantage is:: " + isP1Adv);
		System.out.println(player2Name+"'s advantage is:: " + isP2Adv);
		System.out.println("The Game is deuce? " + isDeuce);	
		
		System.out.println("Number of sets won by "+ player1Name + " is :: " + p1SetWon);
		System.out.println("Number of sets won by "+ player2Name + " is :: "  + p2SetWon+"\n");
		resetAll();
	}
	
	public void testPlayer1Advantage(){
		//Increase the score of player 1 to 40
		
		for(int i=0;i<3;i++){
			applyScore(player1Name);
		}
		
		for(int i=0;i<3;i++){
			applyScore(player2Name);
		}

		//Player 1 Adv
		applyScore(player1Name);
		
		//Player 2 Adv
		applyScore(player2Name);

		//Player 1 Adv
		applyScore(player1Name);
		
		System.out.println("TESTING PLAYER 1 SCORING ADVANTAGE:");
		System.out.println(player1Name +"'s current Score is:: " + p1CurrentScore);
		System.out.println(player2Name +"'s current Score is:: " + p2CurrentScore);
		
		System.out.println(player1Name +"'s advantage is:: " + isP1Adv);
		System.out.println(player2Name+"'s advantage is:: " + isP2Adv);
		System.out.println("The Game is deuce? " + isDeuce);	
		
		System.out.println("Number of sets won by "+ player1Name + " is :: " + p1SetWon);
		System.out.println("Number of sets won by "+ player2Name + " is :: "  + p2SetWon+"\n");
		resetAll();
	}
	
	public void testDeuce(){
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player1Name);
		}
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player2Name);
		}
		
		//Player 1 Adv
		applyScore(player1Name);
		
		//Player 2 Adv
		applyScore(player2Name);

		System.out.println("TESTING PLAYERS SCORING DUCE:");
		System.out.println(player1Name +"'s current Score is:: " + p1CurrentScore);
		System.out.println(player2Name +"'s current Score is:: " + p2CurrentScore);
		
		System.out.println(player1Name +"'s Advantage is:: " + isP1Adv);
		System.out.println(player2Name+"'s Advantage is:: " + isP2Adv);
		System.out.println("The Game is deuce? " + isDeuce);	
		
		System.out.println("Number of sets won by "+ player1Name + " is :: " + p1SetWon);
		System.out.println("Number of sets won by "+ player2Name + " is :: "  + p2SetWon+"\n");
		resetAll();
	}
	
	public void testPlayer1NumberOfWins(){
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player1Name);
		}
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player2Name);
		}
		
		//Player 1 Adv
		applyScore(player1Name);
		
		//Player 2 Adv
		applyScore(player2Name);


		applyScore(player1Name);
		
		applyScore(player2Name);
		
		//player1 Adv
		applyScore(player1Name);
		//player1 set won
		applyScore(player1Name);
		
		System.out.println("TESTING PLAYER 1 SCORING 1 WIN:");
		System.out.println(player1Name +"'s current Score is :: " + p1CurrentScore);
		System.out.println(player2Name +"'s current Score is :: " + p2CurrentScore);
		
		System.out.println(player1Name +"'s Advantage is :: " + isP1Adv);
		System.out.println(player2Name+"'s Advantage is :: " + isP2Adv);
		System.out.println("The Game is deuce? " + isDeuce);	
		
		System.out.println("Number of sets won by "+ player1Name + " is :: " + p1SetWon);
		System.out.println("Number of sets won by "+ player2Name + " is :: "  + p2SetWon+"\n");
		resetAll();
	}
	
	public void testPlayer1AdditionalWins(){
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player1Name);
		}
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player2Name);
		}
									
		//player1 Adv
		applyScore(player1Name);
		//player1 set won
		applyScore(player1Name);
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player1Name);
		}
		
		//Increase the score of player 1 to 40
		for(int i=0;i<3;i++){
			applyScore(player2Name);
		}
		
		//player1 Adv
		applyScore(player1Name);
		//player1 set won
		applyScore(player1Name);
		
		System.out.println("TESTING PLAYER 1 SCORING ADDITIONAL WINs:"); 
		System.out.println(player1Name +"'s current Score is :: " + p1CurrentScore);
		System.out.println(player2Name +"'s current Score is :: " + p2CurrentScore);
		
		System.out.println(player1Name +"'s Advantage is :: " + isP1Adv);
		System.out.println(player2Name+"'s Advantage is :: " + isP2Adv);
		System.out.println("The Game is deuce? " + isDeuce);	
		
		System.out.println("Number of sets won by "+ player1Name + " is :: " + p1SetWon);
		System.out.println("Number of sets won by "+ player2Name + " is :: "  + p2SetWon+"\n");
		resetAll();
	}
	public static void main(String args[]){
		
		Tennis tennis = new Tennis();
		
		player1Name = "Deepa";
		player2Name = "Lakshmi";

		
		//Testing Scores 
		tennis.testPlayer1ScoreIncrease();
		tennis.testPlayer2ScoreIncrease();
		tennis.testPlayer1Advantage();
		tennis.testDeuce();
		tennis.testPlayer1NumberOfWins();
		tennis.testPlayer1AdditionalWins();
		
	}
}
