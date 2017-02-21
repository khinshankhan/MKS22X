import java.util.Arrays;
public class KnightBoard{
    private int[][]board;
    int moves[][] = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    int sr;
    int sc;
    //helps with string
    boolean solver=false;
    
    public KnightBoard(int startingRows,int startingCols){
	sr=startingRows;
	sc=startingCols;
        board = new int[sr][sc];
	//checkingFill();
	//sorter(board);
    }
    /*
    public void checkingFill(){
	for(int r=0; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=1;
	    }
	}
	for(int r=1; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=1000;
	    }
	}
	for(int r=2; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=100;
	    }
	}
	for(int r=3; r<sr;r++){
	    for(int c=0;c<sc;c++){
		board[r][c]=10;
	    }
	}
    }
    */
    public String toString(){
	String s="";
	for(int r=0; r<sr;r++){
	    for(int c=0;c<sc;c++){
		if(board[r][c]<10){
		    s+="   "+board[r][c]+" ";
		}
		if(!(board[r][c]<10)&&
		   board[r][c]<100){
		    s+="  "+board[r][c]+" ";
		}
	        if(!(board[r][c]<10||
		     board[r][c]<100)&&
		   board[r][c]<1000){
		    s+=" "+board[r][c]+" ";
		}
		if(!(board[r][c]<10||
		     board[r][c]<100||
		     board[r][c]<1000)&&
		   board[r][c]<10000){
		    s+=+board[r][c]+" ";
		}
		s+=((c==sc-1) ? "\n" : "");
	    }
	}
	return s;
    }
    //will become 'fast' once i get it to work
    public void solve(){
	solveH(0,0,1);
	if(!solver)
	    clear();
    }
    //from a old commit, i can prolly make this work if
    //im pruning the tree
    public boolean valid (int r, int c){
	return r >= 0 && r < sr && c >= 0 && c < sc && board[r][c] == 0;
    }
    //n is level because im free :')
    //helper method
    public boolean solveH(int r, int c, int n){
	board[r][c] = n;
	//base case
	if (n == sr * sc){
	    solver=true;
	    return true;
	}
	
	/*JUST NEED THE SMART PART NOW HAHA*/

	int tree[][]=new int[8][3];
	for (int i=0; i<8;i++){
	    tree[i][0] = 0;
	    tree[i][1] = c + moves[i][0];
	    tree[i][2] = r + moves[i][1];
	    if (valid (tree[i][1], tree[i][2]))
		for (int j=0;j<8;j++){
		    if (valid (tree[i][1] + moves[j][0],tree[i][2] + moves[j][1]))
			tree[i][0]++;
		}
	}
	//sorter(tree);
	//i KNOW i have to sort somewhere, but where
	//def not here tho^
	
	//ngl following stackoverflow post
	for (int i=0;i<8;i++){
	    if (valid (tree[i][1], tree[i][2]) && solveH (tree[i][1], tree[i][2], n + 1))
		return true;
	}
	//failure
	board[r][c] = 0;
	return false;
    }
    //2d array sorter
    public void sorter(int a[][]){
	for(int i=0; i<a.length; i++)
	    Arrays.sort(a[i]);
	int len=a[0].length-1;
	for(int i=0, j=1; j<a.length;i++,j++){
	    if(a[i][len]>a[j][0]){
		int t=a[i][len];
		a[i][len]=a[j][0];
		a[j][0]=t;
		sorter(a);
	    }
	}
    }
    //debug printers
    public void debugPrinter(int a[][]){
	for (int r=0; r < a.length; r++){
	    for (int c=0; c < a[r].length; c++)
		System.out.printf ("%6d ", a[r][c]);
	    System.out.printf("\n");
	}
    }
    public void debugPrinter(){
	for (int r=0; r < sr; r++){
	    for (int c=0; c < sc; c++)
		System.out.printf ("%6d ", board[r][c]);
	    System.out.printf("\n");
	}
    }
    //in case of failure of solveH
    private void clear(){
	for(int r=0; r<sr;r++){
	    for(int c=0; c<sc;c++)
		board[r][c]=0;
	}
    }

    public static void main(String args[]){
	int a= Integer.parseInt(args[0]);
	int b= Integer.parseInt(args[1]);
	KnightBoard c=new KnightBoard(a,b);
	c.solveH(0,0,1);
	c.debugPrinter();
	//System.out.println(c);
    }
}
