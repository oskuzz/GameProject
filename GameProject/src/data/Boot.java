package data;

import static helpers.Artist.BeginSession;
import static helpers.Artist.QuickLoad;

import org.lwjgl.opengl.Display;

import helpers.Clock;

public class Boot {
	
	public Boot() {
		
		BeginSession();
		
		int[][] map = {
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 1, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 1, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 2, 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},	
		};
		
		TileGrid grid = new TileGrid(map);
		grid.setTile(6, 4, grid.getTile(5,4).getType());
		Enemy e = new Enemy(QuickLoad("UFO64"), grid.getTile(10, 10), grid, 64, 64, 7);
		Wave wave = new Wave(20, e);
		Player player = new Player(grid);
		while(!Display.isCloseRequested()) {
			Clock.update();
			grid.Draw();
			wave.Update();
			player.Update();
			
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static void main(String [] args) {
		new Boot();
	}
}
