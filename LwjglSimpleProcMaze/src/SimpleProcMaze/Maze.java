package SimpleProcMaze;

import SimpleProcMaze.Cell;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Graphics;

public class Maze {
	private int horizontalSize;
	private int verticalSize;
	private Cell[][] cells;
	
	public Maze(int horizontalSize, int verticalSize, int cellWidth, int cellHeight) {
		this.horizontalSize = horizontalSize;
		this.verticalSize = verticalSize;
		cells = new Cell[horizontalSize][verticalSize];
		for (int i = 0; i < horizontalSize; i++) {
			for (int j = 0; j < verticalSize; j++) {
				cells[i][j] = new Cell(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
			}
		}
		cells[0][0].RemoveLeftWall();
		cells[horizontalSize-1][verticalSize-1].RemoveRightWall();
	}
	
	public void BuildMaze() {
		dig(0,0);
	}
	
	private void dig(int x, int y) {
		cells[x][y].Visit();
		List<Integer> newNeighbors = new ArrayList<Integer>();
		// Find which neighboring cells have not been visited yet
		// Right
		if (x < horizontalSize - 1) {
			if(!cells[x+1][y].HasBeenVisited()) {
				newNeighbors.add(0);
			}
		}
		// Down
		if (y < verticalSize - 1) {
			if (!cells[x][y+1].HasBeenVisited()) {
				newNeighbors.add(270);
			}
		}
		// Left
		if (x > 0) {
			if (!cells[x-1][y].HasBeenVisited()) {
				newNeighbors.add(180);
			}
		}
		// Up
		if (y > 0) {
			if (!cells[x][y-1].HasBeenVisited()) {
				newNeighbors.add(90);
			}
		}
		
		// Pick an unvisited neighboring cell to go to
		if (!newNeighbors.isEmpty()) {
			Random randomGenerator = new Random();
			int i = randomGenerator.nextInt(newNeighbors.size());
			int direction = newNeighbors.get(i);
			
			// Go to the next cell
			switch (direction) {
			case 0 : // Right
				cells[x][y].RemoveRightWall();
				cells[x+1][y].RemoveLeftWall();
				dig(x+1,y);
				break;
			case 90 : // Up
				cells[x][y].RemoveTopWall();
				cells[x][y-1].RemoveBottomWall();
				dig(x,y-1);
				break;
			case 180 : // Left
				cells[x][y].RemoveLeftWall();
				cells[x-1][y].RemoveRightWall();
				dig(x-1,y);
				break;
			case 270 : // Down
				cells[x][y].RemoveBottomWall();
				cells[x][y+1].RemoveTopWall();
				dig(x,y+1);
				break;
			}
			dig(x,y);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < horizontalSize; i++) {
			for (int j = 0; j < verticalSize; j++) {
				cells[i][j].render(g);
			}
		}
	}
}
