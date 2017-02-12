public class QueenBoard{
    private int[][]board;
    private int solutionCount,size;
    
    public QueenBoard(int size){
	board = new int[size][size];
	this.size=size;//could use board.length but that's typing, lol i forgot i made this :')
	/*EXTRA, board is filled with 0s already
	for(int r=0; r<size;r++){
	    for(int c=0; c<size;c++)
		board[r][c]=0;
	}
	*/
	solutionCount=0;//also extra, but might as well
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve(){
	return solveH(0);
    }
    
    private boolean solveH(int col){
	return false;
    }

    private void invalidator(int r, int c){
	//horizontal right
	for(int co=c; co<board.length; co++)
	    board [r][co]+=1;
	//vertical down
	for(int ro=r; ro<board.length; ro++)
	    board[ro][c]+=1;
	//horizontal left
	for(int co=c; co>=0; co--)
	    board[r][co]+=1;
	//vertical up
	for(int ro=r; ro>=0; ro--)
	    board[ro][c]+=1;
	//VIO DIAGS
        for(int ro=r, co=c; ro>=0&&co>=0; ro--, co--)
	    board[ro][co]+=1;
	for(int ro=r, co=c; ro<board.length&&co<board.length; ro++, co++)
	    board[ro][co]+=1;
	for(int ro=r, co=c; ro>=0&&co<board.length; ro--, co++)
	    board[ro][co]+=1;
	for(int ro=r, co=c; ro<board.length&&co>=0; ro++, co--)
	    board[ro][co]+=1;
	//re places queen in position
	board[r][c]=-1;
	
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	int a= (solutionCount > 0) ? solutionCount : -1;
	solutionCount=0;
    	return a;
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	/*
  public static String toString(int[][]board, int size){
	String s="";
	for(int r=0; r<size;r++){
	    for(int c=0;c<size;c++){
	        s+=((board[r][c]==-1) ? "Q" : "_");
		s+=((c==size-1) ? "\n" : "");
	    }
	}
    return s;
    }
  public static void main(String[] args)
  {
    int size=4;
    int[][]board=new int[][]{{ 1, -1, 1, 1},{ 1, 3, 5, -1},{ -1, 0, 7, 8},{ 0, 0, -1, 9}};
    System.out.print(toString(board,size));
  }
	*/
	String s="";
	for(int r=0; r<size;r++){
	    for(int c=0;c<size;c++){
	        s+=((board[r][c]==-1) ? "Q" : "_");
		s+=((c==size-1) ? "\n" : "");
	    }
	}
	return s;
    }
}
