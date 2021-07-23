package hw4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import api.*;

public class BlockAddiction extends AbstractGame{

	public BlockAddiction(int height, int width, Generator gen, int preFillRows) {
		super(height, width, gen);
		if(preFillRows > 0) {
			for(int i = height-1; i > getHeight() - preFillRows; i--) {
				if(i%2 == 0) {
					for(int j = 0; j < getWidth(); j+= 2) {
						setBlock(i, j, gen.randomIcon());
					}
				}else {
					for(int j = 1; j < getWidth(); j+= 2) {
						setBlock(i, j, gen.randomIcon());
					}
				}
			}
		}
	}
	
	public BlockAddiction(int height, int width, Generator gen) {
		super(height, width, gen);
	}
/**
 * Examines the grid and returns a list of positions to be collapsed.
 * @return positions
 * 		List of positions to be collapsed	
 */
	@Override
	  public List<Position> determinePositionsToCollapse()
	  {
	    List<Position> positions = new ArrayList<>();
	    for (int row = 0; row < getHeight(); ++row)
	    {
	      if (isRowFilled(row))
	      {
	        // row forms a collapsible set, put all positions in the list
	        for (int col = 0; col < getWidth(); ++col)
	        {
	          positions.add(new Position(row, col));
	        }
	      }
	    }
	    
	    List<Position> positionMatch = new ArrayList();
	    int pairs = 0;
	    for(int row = 0; row < getHeight(); ++row) {
	    	for(int col = 0; col < getWidth(); ++col) {
	    		if(getIcon(row, col) != null) {
	    			if(row != getHeight() -1 && getIcon(row, col).matches(getIcon(row+1, col))) {
	    				pairs++;
	    				positionMatch.add(new Position(row+1, col));
	    			}
	    			if(col != getWidth() -1 && getIcon(row, col).matches(getIcon(row, col+1))) {
	    				pairs++;
	    				positionMatch.add(new Position(row, col+1));
	    			}
	    			if(row != 0 && getIcon(row, col).matches(getIcon(row-1, col))) {
	    				pairs++;
	    				positionMatch.add(new Position(row-1, col));
	    			}
	    			if(col != 0 && getIcon(row, col).matches(getIcon(row, col-1))) {
	    				pairs++;
	    				positionMatch.add(new Position(row, col-1));
	    			}
	    			if(pairs >= 2) {
	    				positionMatch.add(new Position(row, col));
	    				pairs = 0;
	    			}
	    			else{
	    				if(pairs == 1) {
	    					positionMatch.remove(positionMatch.size()-1);
	    				}
	    				pairs = 0;
	    			}
	    		}
	    	}
	    }
	    
	    for(int i = 0; i < positionMatch.size(); i++) {
	    	if(!positions.contains(positionMatch.get(i))) {
	    		positions.add(positionMatch.get(i));
	    	}
	    }
	    
	    // the algorithm above already guarantees there are no duplicates in the
	    // list, but we have to sort them
	    Collections.sort(positions);
	    return positions;
	  }
	
	 /**
	   * Determines whether the given row is completely filled (i.e., all
	   * icons are non-null).
	   * @param row
	   *   the row to be checked
	   * @return
	   *   true if all icons in the row are non-null, false otherwise
	   */
	  private boolean isRowFilled(int row)
	  {
	    for (int col = 0; col < getWidth(); ++col)
	    {
	      if (getIcon(row, col) == null)
	      {
	        return false;
	      }
	    }
	    return true;
	  }
}

