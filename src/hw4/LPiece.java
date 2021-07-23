package hw4;

import api.*;
/**
 * implementation of an L Piece extending Abstract Piece
 * @author alexfreiberg
 *
 */
public class LPiece extends AbstractPiece{
/**
 * constructs a new L Piece with the given starting position and containing
 * the given icons in an icon array	
 * @param givenPosition
 * 		given starting position for the new L Piece
 * @param icons
 * 		given array of icons created by the basic generator
 */
	
	public LPiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, icons);
		cells = new Cell[4];
		cells[0] = new Cell(icons[0], new Position(0,0));
		cells[1] = new Cell(icons[1], new Position(0,1));
		cells[2] = new Cell(icons[2], new Position(1,1));
		cells[3] = new Cell(icons[3], new Position(2,1));
		
	}
/**
 * transforms the L Piece by flipping it over its y-axis
 */
	@Override
	public void transform() {
		if(cells[0].getCol() == 0) {
			cells[0].setCol(2);
		}else if(cells[0].getCol() == 2) {
			cells[0].setCol(0);
		}
		
	}

}
