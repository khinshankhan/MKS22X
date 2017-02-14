public class Driver{
    public static void main(String[]args){
	QueenBoard a= new QueenBoard(Integer.parseInt(args[0]));
	a.countSolutions();
	System.out.println("num solutions: "+a.getSolutionCount());
	a.solve();
	System.out.println("Board:\n"+a.toString());
    }
}
