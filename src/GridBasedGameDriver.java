import java.util.ArrayList;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class GridBasedGameDriver {

	private static final int NUM_COLS = 4;
	private static final int NUM_ROWS = 4;
	World<GameObject> world = new World<GameObject>() {
		
		@Override
		public boolean locationClicked(Location loc) {
			System.out.println("You just clicked "+loc);
			
			
			return false;
		}
		
		@Override
		public boolean keyPressed(String key, Location loc) {
			System.out.println("You just pressed the "+key+" key.");
			if(key.equals("LEFT")) {
				slideLeft();
			}
			else if(key.equals("RIGHT")) {
				slideRight();
			}
			else if(key.equals("DOWN")) {
				slideDown();
			}
			else if(key.equals("UP")) {
				slideUp();
			}
			
			return false;
		}
		
	};
	
	public static void main(String[] args) {
		new GridBasedGameDriver().start();
	}

	protected void slideLeft() {
		System.out.println("Sliding to the left!!");
		
	
	
	}

	private void start() {
		setUpGameBoard();
		world.show();// now the world is visible
	}

	private void setUpGameBoard() {
		world.setGrid(new BoundedGrid(this.NUM_ROWS,this.NUM_COLS));
		
		add2();
		add2or4();
		
		
	}

	private void add2() {
		int rCol = (int) (Math.random()*NUM_COLS),
			rRow = (int) (Math.random()*NUM_ROWS);
		Grid g = world.getGrid();
		g.put(new Location(rRow, rCol), 2);
	}

	private void add2or4() {
		Grid g = world.getGrid();
		ArrayList<Location > emptyLocs = new ArrayList();
		for(int r = 0; r<this.NUM_ROWS; r++) {
			for(int c = 0; c<this.NUM_COLS; c++) {
				Location loc = new Location(r,c);
				if(g.get(loc) == null) {
					emptyLocs.add(loc);
				}
			}
		}
		if(emptyLocs.size()<=0) {
			gameOver();
			return;
		}
		
		// list wasn't empty
		int index = (int) (Math.random()*emptyLocs.size());
		Location loc = emptyLocs.get(index);
		if(Math.random()>=.5)
			g.put(loc, 2);
		else
			g.put(loc, 4);
	}

	private void gameOver() {
		// TODO Auto-generated method stub
		
	}

}
