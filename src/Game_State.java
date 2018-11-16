import java.util.ArrayList;

class Game_State {
	
	private Tile[][] game;
	private int playerTurn;
	private ArrayList<String> moves;
	private boolean gameOver;
	private boolean noWinner;
	
	Game_State(){
		game = new Tile[3][3];
		for (int row = 0; row <= 2; row++){
			for (int col = 0; col <= 2; col++){
				game[row][col] = new Tile();
			}
		}
		playerTurn = 1;
		moves = new ArrayList<>(0);
		gameOver = false;
		noWinner = false;
	}
	
	String getPlayerTurn() {
		if (playerTurn == 1) {
			return "X";
		} else {
			return "O";
		}
	}
	
	void changePlayerTurn() {
		
		this.playerTurn = (playerTurn+1)%2;
	}
	
	void setMoves(){
		moves.clear();
		for (int row = 0; row <=  2; row++) {
			for (int col = 0; col <= 2; col++) {
				if (!game[row][col].isOccupied()) {
					moves.add(Integer.toString(row)+ Integer.toString(col));
				}
			}
		}
	}
	
	boolean isGameOver(){
		boolean colWin = true, rowWin = true, diagonalWin1 = true, diagonalWin2 = true, full = true;
		String player;
		
		if (playerTurn == 1){
			player = "O";
		} else {
			player = "X";
		}
		
		for (int row = 0; row <=  2; row++) {
			for (int col = 0; col <= 2; col++) {
				full = full && game[row][col].isOccupied();
				colWin = colWin && game[col][row].getContents().equals(player);
				rowWin = rowWin && game[row][col].getContents().equals(player);
				if (row == col) {
					diagonalWin1 = diagonalWin1 && game[row][col].getContents().equals(player);
				}
				if (row + col == 2) {
					diagonalWin2 = diagonalWin2 && game[row][col].getContents().equals(player);
				}
			}
			if (rowWin || colWin) {
				gameOver = true;
				return true;
			}
		}
		
		if (diagonalWin1 || diagonalWin2) {
			gameOver = true;
			return true;
		}
		if (full) {
			gameOver = true;
			noWinner = true;
			return true;
		}
		
		return false;
	}
	
	int whoWon(){
		if (gameOver){
			if (noWinner){
			    return -1;
			} else {
				return (playerTurn + 1) % 2;
			}
		} else {
			return -2;
		}
	}
	
	boolean isValidMove(String move){
		return moves.contains(move);
	}
	
	void makeMove(String move){
		int row = Character.getNumericValue(move.charAt(0));
		int col = Character.getNumericValue(move.charAt(1));
		
		String player;
		if (playerTurn == 1){
			player = "X";
		} else {
			player = "O";
		}
		
		game[row][col].setContents(player);
		
	}
	
	void printState(){
		
		String line = "-------------";
		System.out.println();
		System.out.println(line);
		for (int row = 0; row <=  2; row++) {
			for (int col = 0; col <= 2; col++) {
				System.out.print("| " + game[row][col].getContents()+" ");
			}
			System.out.println("|");
			System.out.println(line);
		}
		System.out.println();
	}
	
	
}
