public class QueenBoard{
    private int[][]board;
    private int solutionCount,size;
    boolean ran=false;
    
    public QueenBoard(int size){
	this.size=size;//could use board.length but that's typing, lol i forgot i made this :')
	if(size<0){
	    System.out.println("Negative length boards don't exist.");
	    return;
	}
	board = new int[size][size];
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
    public void solve(){
	solveH(0);
	return;
    }
    
    private boolean solveH(int col){
	//base case
	if (col >= size){
	    return true;
	}
	for(int r=0; r<size; r++){
	    //recursive step
	    if(valid(r,col)){
		setQueen(r,col);
		if(solveH(col + 1)){
		    return true;
		}
		else{
		    remQueen(r,col);
		}
	    }
	}
	return false;
    }

    private void setQueen(int r, int c){
	invalidator(r,c);
    }

    private void remQueen(int r, int c){
	if(queen(r,c))
	    purify(r,c);
    }
    
    private boolean valid(int r, int c){
	return board[r][c]==0;
    }

    private boolean queen(int r, int c){
	return board[r][c]==-1;
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

    private void purify(int r, int c){
	//horizontal right
	for(int co=c; co<board.length; co++)
	    board [r][co]-=1;
	//vertical down
	for(int ro=r; ro<board.length; ro++)
	    board[ro][c]-=1;
	//horizontal left
	for(int co=c; co>=0; co--)
	    board[r][co]-=1;
	//vertical up
	for(int ro=r; ro>=0; ro--)
	    board[ro][c]-=1;
	//VIO DIAGS
        for(int ro=r, co=c; ro>=0&&co>=0; ro--, co--)
	    board[ro][co]-=1;
	for(int ro=r, co=c; ro<board.length&&co<board.length; ro++, co++)
	    board[ro][co]-=1;
	for(int ro=r, co=c; ro>=0&&co<board.length; ro--, co++)
	    board[ro][co]-=1;
	for(int ro=r, co=c; ro<board.length&&co>=0; ro++, co--)
	    board[ro][co]-=1;
	//re places queen in position
	board[r][c]=0;	
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	int a=-1;
	if(ran){
	    a= (solutionCount >= 0) ? solutionCount : -1;
	    if(size<0)
		a=-1;
	}
	clear();
	
	return a;
    }
    
    public void countSolutions(){
	ran=true;
        clear();
	solveC(0);
	int a= (solutionCount > 0) ? solutionCount : -1;
	if(size==2||size==3)
	    a=0;
	solutionCount=a;
    }
    
    private void solveC(int col){
	//base case
	if (col == size){
	    solutionCount++;
	    return;
	}
	for(int r=0; r<size; r++){
	    //recursive step
	    if(valid(r,col)){
		setQueen(r,col);
		solveC(col+1);
		remQueen(r,col);	
	    }
	}
	return;
    }
    
    private void clear(){
	for(int r=0; r<size;r++){
	    for(int c=0; c<size;c++)
		board[r][c]=0;
	}
    }

    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String s="";
	for(int r=0; r<size;r++){
	    for(int c=0;c<size;c++){
	        s+=((board[r][c]==-1) ? "Q " : "_ ");
		s+=((c==size-1) ? "\n" : "");
	    }
	}
	return s;
    }
}
