public class KnightBoard{
    private int[][]board;
    int sr;
    int sc;
    boolean solve;

    public KnightBoard(int startingRows,int startingCols){
	sr=startingRows;
	sc=startingCols;
        board = new int[sr][sc];
	solve=false;
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

    public void solve(){
	solveH(0,0,1);

    } 

    // level is the # of the knight
    private boolean solveH(int row ,int col, int level){
	if (level > sr * sc){
	    solve=true;
	    return true;}
	if (row < 0 || row > sr - 1 || col < 0 || col > sc - 1){
	    return false;}
	if(board[col][row] == 0){
           board[col][row] = level;
	   if(takeAnL(row,col,level)){
	       solve=false;
	       return false;}
	}
	board[row][col] = 0;
	return solve;
    }

    private boolean takeAnL(int r, int c, int L){
	L+=1;
	return (solveH(r+2, c+1, L) || 
		solveH(r+1, c+2, L) || 
		solveH(r-2, c-1, L) ||
		solveH(r-1, c+2, L) || 
		solveH(r-1, c-2, L) || 
		solveH(r+2, c-1, L) ||
		solveH(r-2, c+1, L) || 
		solveH(r+1, c-2, L));
    }

    private void clear(){
	for(int r=0; r<sr;r++){
	    for(int c=0; c<sc;c++)
		board[r][c]=0;
	}
    }
    public static void main(String[] args){
	KnightBoard a= new KnightBoard(5,5);
	a.solve();
	System.out.println(a.toString());
    }
}
