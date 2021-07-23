package hw4;

import api.*;

/**
 * implementation of a Diagonal Piece extending Abstract Piece
 * @author alexfreiberg
 *
 */

public class DiagonalPiece extends AbstractPiece{
/**
 * constructs a new Diagonal Piece with the given starting position and containing
 * the given icons in the icon array
 * @param givenPosition
 * 		given starting position of the new Diagonal Piece
 * @param icons
 * 		given array of random icons from the basic generator
 */
	
	public DiagonalPiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, icons);
		cells = new Cell[2];
		cells[0] = new Cell(icons[0], new Position(0,0));
		cells[1] = new Cell(icons[1], new Position(1,1));
		
	}

/**
 * transforms the Diagonal Piece by flipping it over its y-axis
 */
	@Override
	public void transform() {
		// TODO Auto-generated method stub
		if(cells[0].getCol() == 0) {
			cells[0].setRowCol(0, 1);
			cells[1].setRowCol(1, 0);
		}else if(cells[0].getCol() == 1) {
			cells[0].setRowCol(0, 0);
			cells[1].setRowCol(1, 1);
		}
		

	}
}
