package hw4;

import api.*;

/**
 * implementation of a Snake Piece extending Abstract Piece
 * @author alexfreiberg
 *
 */
public class SnakePiece extends AbstractPiece{
/**
 * instance variable counting the number of transforms performed on a specific Snake Piece
 */
	private int count = 0;
/**
 * instance variable containing an array of possible positions for 
 * each icon of a Snake Piece after a transform
 */
	private static final Position[] sequence =
		 {
		 new Position(0, 0),
		 new Position(0, 1),
		 new Position(0, 2),
		 new Position(1, 2),
		 new Position(1, 1),
		 new Position(1, 0),
		 new Position(2, 0),
		 new Position(2, 1),
		 new Position(2, 2),
		 new Position(1, 2),
		 new Position(1, 1),
		 new Position(1, 0),
		 };
	
/**
 * constructs a new Snake Piece with the given starting position and containing the given
 * icons in the given icon array	
 * @param givenPosition
 * 		given starting position for a new Snake Piece
 * @param icons
 * 		given array of icons contained in a Snake Piece created by the basic generator
 */
	public SnakePiece(Position givenPosition, Icon[] icons) {
		super(givenPosition, icons);
		cells = new Cell[4];
		cells[0] = new Cell(icons[0], new Position(0,0));
		cells[1] = new Cell(icons[1], new Position(1,0));
		cells[2] = new Cell(icons[2], new Position(1,1));
		cells[3] = new Cell(icons[3], new Position(1,2));
		
	}

/**
 * transforms a Snake Piece by moving each icon to the next position in the instance
 * array of icon positions
 */
	@Override
	public void transform() {
		count++;
		if(count == 12) {
			count = 0;
		}
		for(int i = 0; i < cells.length; i++) {
			if(count-i >= 0) {
				cells[i].setPosition(sequence[count-i]);
			}else {
				if(count == 0) {
					cells[i].setPosition(sequence[sequence.length-i]);
				}else {
					if(i==3 && count == 2) {
						cells[i].setPosition(sequence[(sequence.length+2) - i]);
					}else {
						cells[i].setPosition(sequence[(sequence.length+1) - i]);
					}
				}
			}
		}
		
	}

}
