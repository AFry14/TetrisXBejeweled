package hw4;
import api.*;
/**
 * implementation of all methods able to be performed on any given piece implementing the 
 * piece interface
 * @author alexfreiberg
 *
 */
public abstract class AbstractPiece implements Piece{
/**
 * instance variable for the position of the given piece
 */
	private Position position;
/**
 * instance variable for the  array of cells that make up a specific piece
 */
	protected Cell[] cells;
/**
 * instance variable for the array of icons each of which is contained in a cell
 * of a specific piece
 */
	private Icon[] icons;
/**
 * assigns the starting position and the icons contained for any given piece extending
 * this class	
 * @param givenPosition
 * 		starting position for any specific piece
 * @param givenIcons
 * 		array of icons contained in any specific piece
 */
	protected AbstractPiece(Position givenPosition, Icon[] givenIcons) {
		position = givenPosition;
		icons = givenIcons;
	}
/**
 * returns the position of a specific piece in the grid
 * @return position
 * 		position of a specific piece	
 */
	public Position getPosition() {
		return position;
	}
/**
 * Returns a deep copy of the Cell objects in this piece.
 * @return copy
 * 		deep copy of the cell objects that make up a this piece
 */
	public Cell[] getCells() {
		Cell[] copy = new Cell[cells.length];
		for(int i = 0; i < cells.length; i++) {
			copy[i] = new Cell(cells[i]);
		}
		return copy;
	}
/**
 * Returns a new array of Cell objects representing the icons in this piece with 
 * their absolute positions (relative positions plus position of bounding box).
 * @return Absolute
 * 		array of Cell objects representing the icons in this piece with absolute positions
 */
	public Cell[] getCellsAbsolute() {
		Cell[] Absolute = new Cell[cells.length];
		for(int i = 0; i < cells.length; i++) {
			int absCol = cells[i].getCol() + position.col();
			int absRow = cells[i].getRow() + position.row();
			Absolute[i] = new Cell(cells[i].getIcon(), new Position(absRow, absCol));
		}
		return Absolute;
	}
/**
 * Sets the cells in this piece, making a deep copy of the given array.
 * @param givenCells
 * 		new cells for this piece
 */
	public void setCells(Cell[] givenCells) {
		cells = new Cell[cells.length];
		for(int i = 0; i < cells.length; i++) {
			cells[i] = new Cell(givenCells[i]);
		}
	}
/**
 * Shifts the position of this piece down (increasing the row) by one. No bounds checking is done.
 */
	public void shiftDown() {
		position = new Position(position.row()+1, position.col());
	}
/**
 * Shifts the position of this piece left (decreasing the column) by one. No bounds checking is done.
 */
	public void shiftLeft() {
		position = new Position(position.row(), position.col()-1);
	}
/**
 * Shifts the position of this piece right (increasing the column) by one. No bounds checking is done.	
 */
	public void shiftRight() {
		position = new Position(position.row(), position.col()+1);
	}
/**
 * Transforms this piece without altering its position according to the rules of the game to be implemented. 
 * Typical operations would be rotation or reflection. No bounds checking is done.
 */
	abstract public void transform();
/**
 * Cycles the icons within the cells of this piece. Each icon is shifted forward to the next 
 * cell (in the original ordering of the cells). The last icon wraps around to the first cell.
 */
	public void cycle() {
		Icon prev = icons[icons.length-1];
		for(int i = icons.length-1; i > 0; i--) {
			icons[i] = icons[i-1];
		}
		icons[0] = prev;
		for(int i = 0; i < cells.length; i++) {
			cells[i].setIcon(icons[i]);
		}	
	}
/**
 * Returns a deep copy of this object having the correct runtime type.
 * @return s
 * 		deep copy of the piece
 */
	public Piece clone() {
		 
		 try
		 {
			 // call the Object clone() method to create a shallow copy...
			 AbstractPiece s = (AbstractPiece) super.clone();
			 // ...then make it into a deep copy
			 // (note there is no need to copy the position,
			 // since Position is immutable, but we have to deep-copy the cell array
			 // by making new Cell objects
			 s.cells = new Cell[cells.length];
			 for (int i = 0; i < cells.length; ++i){
				 
				 s.cells[i] = new Cell(cells[i]);
			 }
			 return s;
		 }
		 catch (CloneNotSupportedException e)
		 {
			 // can't happen, since we know the superclass is cloneable
			 return null;
		 }
		 
	}
}
