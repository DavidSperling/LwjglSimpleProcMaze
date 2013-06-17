package SimpleProcMaze;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {
	private Maze maze = null;

	public Game(String title) {
		super(title);
	}
	
	@Override
	public void init(GameContainer arg0) throws SlickException {
		maze = new Maze(50,38,16,16);
		maze.BuildMaze();
	}
	
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {

	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		maze.render(g);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game("Maze"));
		
		app.setDisplayMode(800, 608, false);
		app.setAlwaysRender(true);
		
		app.start();
	}

}
