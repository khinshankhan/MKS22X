public class KnightBoard{
    private int[][]board;
    int sr;
    int sc;
    //helps with string
    boolean solver=false;

    //constructor
    public KnightBoard(int startingRows,int startingCols){
	sr=startingRows;
	sc=startingCols;
        board = new int[sr][sc];
    }

    //blank if you never called solve or when there is no solution
    public String toString(){
	String s="";
	for(int r=0; r<sr;r++){
	    for(int c=0;c<sc;c++){
	        s+=((board[r][c]<10) ? " "+board[r][c]+" " :board[r][c]+" ");
		s+=((c==sc-1) ? "\n" : "");
	    }
	}
	return s;
    }
    
    //will solve or clear board from work
    public void solve(){
	solveH(0,0,1);
	if(!solver)
	    clear();
    } 

    // level is the # of the knight
    //the solve helper
    private boolean solveH(int row ,int col, int level){
	if (level > sr * sc){
	    solver=true;
	    return true;
	}
	if(board[row][col]<=0){
	    board[row][col]=level;
	    level+=1;
	    if(takeAnL1(row,col,level)||takeAnL2(row,col,level)||takeAnL3(row,col,level)||takeAnL4(row,col,level))
		return true;
	    board[row][col] = 0;
	}
	return false;
    }

    //these Ls are designed to make solutions take less time
    //checks if off board and then solveH with mvmt
    private boolean takeAnL1(int r, int c, int L){
	if(r+1<sr&&c+2<sc){
	    if(solveH(r+1, c+2, L))
	    return true;
	}
	if(r+2<sr&&c+1<sc){
	    if(solveH(r+2, c+1, L))
	    return true;
	}
	return false;
    }

    private boolean takeAnL2(int r, int c, int L){
	if(c-1>=0&&r+2<sr){
	    if(solveH(r+2, c-1, L))
		return true;
	}
	if(c-2>=0&&r+1<sr){
	    if(solveH(r+1, c-2, L))
		return true;
	}
	return false;
    }
    
    private boolean takeAnL3(int r, int c, int L){
	if(r-1>=0&&c+2<sc){
	    if(solveH(r-1, c+2, L))
		return true;
	}
	if(r-2>=0&&c+1<sc){
	    if(solveH(r-2, c+1, L))
		return true;
	}
	return false;
    }

    private boolean takeAnL4(int r, int c, int L){
	boolean s=false;
	if(r-1>=0&&c-2>=0){
	    if(solveH(r-1, c-2, L))
		return true;
	}
	if(r-2>=0&&c-1>=0){
	    if(solveH(r-2, c-1, L))
		return true;
	}
	return s;
    }
    
    //So you dont go off board, in hindsight, maybe it would help to put this inside the other Ls
    public boolean preventL(int r, int c){
	return !(r >= sr || c >= sc);
    }

    //clears the board
    private void clear(){
	for(int r=0; r<sr;r++){
	    for(int c=0; c<sc;c++)
		board[r][c]=0;
	}
    }
}
