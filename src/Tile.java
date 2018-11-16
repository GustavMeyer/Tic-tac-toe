 class Tile {
	
	private String contents;
	
	 Tile(){
		this.contents = " ";
	}
	
	 boolean isOccupied(){
		return !contents.equals(" ");
	}
	
	 void setContents(String contents){
		this.contents = contents;
	}
	
	String getContents(){
		return contents;
	}
}
