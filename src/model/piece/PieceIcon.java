/**
 * @author Andy Son
 * @date Nov.14.2015
 * Enum class named PieceIcon.
 * This class gets image for each pieces,
 * such as king piece image,Queen image.
 */

package model.piece;

public enum PieceIcon {
	KING("King.png"),
	QUEEN("Queen.png"),
	ROOK("Rook.png"),
	KNIGHT("Knight.png"),
	BISHOP("Bishop.png"),
	PAWN("Pawn.png");

	private String imageName;
	/**
	 * @param imageName
	 */
	PieceIcon(String imageName){
		this.imageName = imageName;
	}
	/**
	 * @return imageName
	 */
	public String getImageName() {
		return imageName;
	}
}
