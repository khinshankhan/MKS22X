public class Driver{
    public static void main(String[]args){
	QueenBoard a= new QueenBoard(-5);
	a.solve();
	System.out.println(a.getSolutionCount());
	System.out.println(a.toString());
	
	QueenBoard b= new QueenBoard(0);
	b.solve();
	System.out.println(b.getSolutionCount());
	System.out.println(b.toString());

	QueenBoard c= new QueenBoard(1);
	System.out.println(c.getSolutionCount());
	c.solve();
	System.out.println(c.toString());

	QueenBoard d= new QueenBoard(3);
	d.solve();
	System.out.println(d.getSolutionCount());
	System.out.println(d.toString());

	QueenBoard e= new QueenBoard(4);
	e.solve();
	System.out.println(e.getSolutionCount());
	System.out.println(e.toString());

	QueenBoard f= new QueenBoard(5);
	f.solve();
	System.out.println(f.getSolutionCount());
	System.out.println(f.toString());

	QueenBoard g= new QueenBoard(10);
	g.solve();
	System.out.println(g.getSolutionCount());
	System.out.println(g.toString());
    }
}
