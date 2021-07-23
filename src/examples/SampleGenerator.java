package examples;
import java.awt.Color;

import api.Icon;
import api.Generator;
import api.Position;
import api.Piece;
import hw4.*;
/**
 * Very simple implementation of the Generator interface generates
 * only red icons and only instance of SamplePiece.
 */
public class SampleGenerator implements Generator
{
  @Override
  public Piece getNext(int width)
  {
    // start off in the middle of the grid, one row above the top
	Icon[] array = {new Icon(Color.RED), new Icon(Color.BLUE), new Icon(Color.BLACK), new Icon(Color.GREEN)};
    return new SnakePiece(new Position(-1, width /2), array);
  }

  @Override
  public Icon randomIcon()
  {
    return new Icon(Color.RED);
  }
  
}
