public class Driver{
    public static void main(String args[]){
	String a= args[0];
	MazeSolver m = new MazeSolver(a, true);
	System.out.println("DFS\n");
        m.solve(0);
	System.out.println("BFS\n");
	m = new MazeSolver(a, true);
	m.solve(1);
	System.out.println("Best First\n");
	m = new MazeSolver(a, true);
	m.solve(2);	
	System.out.println("A*\n");
	m = new MazeSolver(a, true);
	m.solve(3);
    }
}
