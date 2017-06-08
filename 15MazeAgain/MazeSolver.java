public class MazeSolver{
    private Maze maze;
    private boolean animation;
    private int[][] moves = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

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
        printer();
        Frontier storage;
	boolean aStar= false;
	switch(i){ //choosing structure
	case 0: storage = new StackFrontier();
	    break;
	case 1: storage = new QueueFrontier();
	    break;
	case 2: storage = new PriorityQueueFrontier(false);
	    break;
	case 3: storage = new PriorityQueueFrontier(false);
	    aStar = true;
	    break;
	default: storage = new PriorityQueueFrontier(false); //wasnt sure about 4?
	    aStar = true;
	    break;
	}
	storage.add(maze.getStart());
	int sr= maze.getStart().row();//start row
	int sc= maze.getStart().col();//start col
	int er= maze.getEnd().row();//end row
	int ec= maze.getEnd().col();//end col
	while (storage.hasNext()){
	    Location current = storage.next();
	    int row= current.row();
	    int col= current.col();
	    int dist= Math.abs(er- row)+ Math.abs(ec- col);
	    if(dist == 0){
		maze.set(er, ec, 'E');
		while(current != maze.getStart()){
		    current= current.previous();
		    maze.set(current.row(), current.col(), '@');
		    printer();
		}
		maze.set(sr, sc, 'S');
	        printer();
		return;
	    }
	    int moved = 0;
	    for (int[] move : moves) {
		try{
		    int r = row + move[0];
		    int c = col + move[1];
		    if (maze.get(r, c) == ' '){
			int startDist= Math.abs(sr- r)+ Math.abs(sc- c);
			int endDist= Math.abs(er- r)+ Math.abs(ec- c);
			storage.add(new Location(r, c, current, startDist, endDist, aStar));
			maze.set(r , c, '?');
                    }
		}catch (IndexOutOfBoundsException e){}
	    }
	    char setter= (moved==0) ? '.' : '@';
	    maze.set(row, col, setter);
	    printer();
	}
    }

    public String toString() {
	if (animation) {
	    return maze.toString(100);
	}
	return maze.toString();
    }
    public void printer(){
	if(animation){
	    System.out.println(this.toString());
	}
    }
}

    
