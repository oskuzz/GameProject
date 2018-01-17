package data;

import org.lwjgl.input.Mouse;
import static helpers.Artist.*;

public class Player {
	
	private TileGrid grid;
	
	public Player(TileGrid grid) {
		this.grid = grid;
	}
	
	public void setTile() {
		grid.setTile((int)Math.floor(Mouse.getX() / 64), (int)Math.floor((HEIGHT-Mouse.getY() - 1) / 64), TileType.Water);
	}
	
	public void Update() {
		if(Mouse.isButtonDown(0)) {
			setTile();
		}
	}
}
