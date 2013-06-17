package SimpleProcMaze;

import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Cell {
	private boolean visited;
	private boolean hasRightWall;
	private boolean hasBottomWall;
	private boolean hasLeftWall;
	private boolean hasTopWall;
	
	private Wall rightWall;
	private Wall bottomWall;
	private Wall leftWall;
	private Wall topWall;
	
	private Rectangle boundary;
	
	public Cell(int xPosition, int yPosition, int width, int height) {
		boundary = new Rectangle(xPosition, yPosition, width, height);
		visited = false;
		hasRightWall = true;
		hasBottomWall = true;
		hasLeftWall = true;
		hasTopWall = true;
		
		rightWall = new Wall(boundary.getX() + boundary.getWidth() * 7 / 8, boundary.getY(), boundary.getWidth() / 8, boundary.getHeight());
		bottomWall = new Wall(boundary.getX(), boundary.getY() + boundary.getHeight() * 7 / 8, boundary.getWidth(), boundary.getHeight() / 8);
		leftWall = new Wall(boundary.getX(), boundary.getY(), boundary.getWidth() / 8, boundary.getHeight());
		topWall = new Wall(boundary.getX(), boundary.getY(), boundary.getWidth(), boundary.getHeight()/8);
	}
	
	public void RemoveRightWall() {
		hasRightWall = false;
	}
	
	public void RemoveBottomWall() {
		hasBottomWall = false;
	}
	
	public void RemoveLeftWall() {
		hasLeftWall = false;
	}
	
	public void RemoveTopWall() {
		hasTopWall = false;
	}
	
	public void Visit() {
		visited = true;
	}
	
	public boolean HasRightWall() {
		return hasRightWall;
	}
	
	public boolean HasBottomWall() {
		return hasBottomWall;
	}
	
	public boolean HasLeftWall() {
		return hasLeftWall;
	}
	
	public boolean HasTopWall() {
		return hasTopWall;
	}
	
	public boolean HasBeenVisited() {
		return visited;
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0xFFFFFF));
		if (!HasBeenVisited()) {
			g.fill(boundary);
		}
		if (HasRightWall()) {
			rightWall.render(g);
		}
		if (HasBottomWall()) {
			bottomWall.render(g);
		}
		if (HasLeftWall()) {
			leftWall.render(g);
		}
		if (HasTopWall()) {
			topWall.render(g);
		}
	}
}
