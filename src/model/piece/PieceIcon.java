package model.piece;

public enum PieceIcon {
	KING("King.png"),
	QUEEN("Queen.png"),
	ROOK("Rook.png"),
	KNIGHT("Knight.png"),
	BISHOP("Bishop.png"),
	PAWN("Pawn.png");

	private String imageName;
	PieceIcon(String imageName){
		this.imageName = imageName;
	}
	public String getImageName() {
		return imageName;
	}
}
