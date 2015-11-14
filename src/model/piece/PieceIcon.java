package model.piece;

public enum PieceIcon {
	KING("king.jpg"),
	QUEEN("queen.jpg"),
	ROOK("rook.jpg"),
	KNIGHT("knight.jpg"),
	BISHOP("bishop.jpg"),
	PAWN("pawn.jpg");
	
	private String imageName;
	PieceIcon(String imageName){
		this.imageName = imageName;
	}
	public String getImageName() {
		return imageName;
	}
}
