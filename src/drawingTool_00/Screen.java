package drawingTool_00;

import java.awt.Color;
import java.awt.Point;

public class Screen extends RectangularObject {

  public Screen(Point position, int width, int height) {
    super(position, width, height);
  }

  public void draw(Color color) {
    Drawing.pen().setColor(color);
    super.draw();
  }
}
