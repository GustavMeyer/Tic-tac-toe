import java.util.Scanner;

class PlayOpreator {
	
	private PlayOpreator(){
	
	}
	
	static void playTicTacToe(){
		
		Scanner reader = new Scanner(System.in);
		Game_State currentGame = new Game_State();
		String move;
		
		while (!currentGame.isGameOver()){
			move = "";
			currentGame.setMoves();
			currentGame.printState();
			while (!currentGame.isValidMove(move)) {
				move = "";
				System.out.print("Player " + currentGame.getPlayerTurn() + " please enter a row (0, 1 or 2): ");
				move += reader.next();
				System.out.print("Player " + currentGame.getPlayerTurn() + " please enter a col (0, 1 or 2): ");
				move += reader.next();
			}
			currentGame.makeMove(move);
			currentGame.changePlayerTurn();
		}
		int won = currentGame.whoWon();
		if (won == 1) {
			System.out.println("Winner: X");
		} else if (won == 0){
			System.out.println("Winner: O");
		} else if (won == -1){
			System.out.println("Draw");
		}
	}
	
	
}
