package SimpleProcMaze;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Wall {
	private Rectangle wallRectangle;
	
	public Wall(float f, float g, float h, float i) {
		wallRectangle = new Rectangle(f, g, h, i);
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0xFFFFFF));
		g.fill(wallRectangle);
	}
}
