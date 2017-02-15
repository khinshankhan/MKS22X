public class KnightBoard{
    private int[][]board;
    int sr;
    int sc;

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
	        s+=((board[r][c]<10&&board[r][c]>0) ? ""+board[r][c] : " "+board[r][c]);
		s+=((c==sc-1) ? "\n" : "");
	    }
	}
	return s;
    }

    public void solve(){
	solveH(0,0,0);
	return;
    } 

    // level is the # of the knight
    private boolean solveH(int row ,int col, int level){
	return false;
    }
    public static void main(String[] args){
	KnightBoard a= new KnightBoard(2,2);
	System.out.println(a.toString());
    }
}
