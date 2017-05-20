public class MazeSolver{
    private Maze maze;
    private boolean animation;

    public MazeSolver(String filename) {
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate) {
	maze = new Maze(filename);
	animation = animate;
    }

    public void solve() {
	solve(1);
    }

    public void solve(int i) {
	//will work out all algos later
    }

    public String toString() {
	if (animation) {
	    return maze.toString(100);
	}
	return maze.toString();
    }
}

    
