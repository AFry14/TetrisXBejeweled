package hw4;
import api.*;

/**
 * implementation of an I Piece extending Abstract Piece
 * @author alexfreiberg
 *
 */
public class IPiece extends AbstractPiece{
/**
 * creates a new I Piece with the given starting position and the given icons
 * contained in an icon array
 * @param givenPosition
 * 		given starting position for the new icon array
 * @param icons
 * 		given array of icons created by the basic generator
 */
	
	public IPiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, icons);
		cells = new Cell[3];
		cells[0] = new Cell(icons[0], new Position(0,1));
		cells[1] = new Cell(icons[1], new Position(1,1));
		cells[2] = new Cell(icons[2], new Position(2,1));
		
	}
/**
 * this piece does not transform
 */
	@Override
	public void transform() {
		// TODO Auto-generated method stub
		
	}
}
