public class Driver{
    public static void main(String[]args){
	QueenBoard a= new QueenBoard(0);
	System.out.println(a.getSolutionCount());
	a.solve();
	System.out.println(a.toString());
	
	QueenBoard b= new QueenBoard(1);
	System.out.println(b.getSolutionCount());
	b.solve();
	System.out.println(b.toString());

	QueenBoard c= new QueenBoard(2);
	System.out.println(c.getSolutionCount());
	c.solve();
	System.out.println(c.toString());

	QueenBoard d= new QueenBoard(3);
	System.out.println(d.getSolutionCount());
	d.solve();
	System.out.println(d.toString());

	QueenBoard e= new QueenBoard(4);
	System.out.println(e.getSolutionCount());
	e.solve();
	System.out.println(e.toString());

	QueenBoard f= new QueenBoard(5);
	System.out.println(f.getSolutionCount());
	f.solve();
	System.out.println(f.toString());

	QueenBoard g= new QueenBoard(6);
	System.out.println(g.getSolutionCount());
	g.solve();
	System.out.println(g.toString());
    }
}
