public class QueenBoard{
    private int[][]board;
    private int solutionCount,size;
    
    public QueenBoard(int size){
	board = new int[size][size];
	this.size=size;
	for(int r=0; r<size;r++){
	    for(int c=0; c<size;c++)
		board[r][c]=0;
	}
	solutionCount=0;
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

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	int a= (solutionCount > 0) ? solutionCount : -1;
	solutionCount=0;
    	return a;
    }

    private void diag1(int r, int c){
	while(r!=0){
	    r++;
	    c++;
	    board[r][c]+=1;
	}
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	for(int r=0; r<size;r++){
	    for(int c=0;c<size;c++){
    	return "";
    }
}
