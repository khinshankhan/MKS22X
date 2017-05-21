public class Driver{
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    
    private static void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    
    public static void main(String args[]){
	String a= args[0];
	MazeSolver m = new MazeSolver(a, true);
	System.out.println(CLEAR_SCREEN);
	System.out.println("DFS\n");
	wait(500);
        m.solve(0);
	System.out.println(CLEAR_SCREEN);
	System.out.println("BFS\n");
	wait(500);
	m = new MazeSolver(a, true);
	m.solve(1);
	System.out.println(CLEAR_SCREEN);
	System.out.println("Best First\n");
	wait(500);
	m = new MazeSolver(a, true);
	m.solve(2);
	System.out.println(CLEAR_SCREEN);
	System.out.println("A*\n");
	wait(500);
	m = new MazeSolver(a, true);
	m.solve(3);
    }
}
