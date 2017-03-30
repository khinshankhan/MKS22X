public class MyLinkedList{

    LNode start;
    int size;

    public MyLinkedList(){
	start=null;
	size=0;
    }

    private class LNode{
	int val;
	LNode next;
	
	public LNode(int x){
	    val=x;
	    next=null;
	}
	
	public LNode(int x, LNode n){
	    val= x;
	    next= n;
	}
    }
    
    public boolean add(int value){
	LNode a= new LNode(value,start);
	start=a;
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public String toString(){
	String ans="[";
	LNode current = start;
        while(current.next!=null){
	//for(int i=0; i<size; i++){
	    ans+=" "+current.val+",";
	    current = current.next;
	}
	ans+=" "+current.val+" ]";
	return ans;
    }
}

