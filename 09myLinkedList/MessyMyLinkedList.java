public class MyLinkedList{

    LNode start; //head
    LNode end; //tail
    int size;

    public MyLinkedList(){
	start=null;
	end=null;
	size=0;
    }

    private class LNode{
	int val;
	LNode next;
	LNode prev;
	
	public LNode(int x){
	    val=x;
	    next=null;
	    prev=null;
	}
	
	public LNode(int x, LNode n){
	    val= x;
	    next= n;
	    prev=next.prev;
	    next.prev=this;
	}
    }
    
    private boolean addFirst(int value){
	LNode a= new LNode(value,start);
	start=a;
	//size++;
	return true;
    }
    
    public boolean add(int value){
	LNode current=start;
	if(current==null){
	    addFirst(value);
	    //NodePrinter(start);
	}else{
	    LNode added= new LNode(value);
	    //NodePrinter(added);
	    while(current.next!=null){
		//NodePrinter(current);
		current= current.next;
	    }
	    current.next=added;
	}
	size++;
	return true;
    }

    public int size(){
	return size;
    }

    public int get(int index){
	LNode current=start;
	while(index!=0){
	    current= current.next;
	    index--;
	}
	return current.val;
    }

    public int set(int index,int newValue){
	LNode current=start;
	int temp;
	while(index!=0){
	    current= current.next;
	    index--;
	}
	temp=current.val;
	current.val=newValue;
	return temp;
    }

    public int indexOf(int value){
	LNode current=start;
	int index= 0;
	while(current.next!=null){
	    if(current.val==value){
		return index;
	    }
	    current= current.next;
	    index++;
	}
	if(current.val==value){
	    return index;
	}
	return -1;
    }

    public int remove(int index){
	LNode current=start;
	int temp;
	if(index==0){
	    temp=start.val;
	    start=start.next;
	}else{
	    while(index!=1){
		current= current.next;
		index--;
	    }
	    temp=current.next.val;
	    if(current.next.next==null){
		current.next=null;
		//System.out.println(1);
	    }else{
		current.next=current.next.next;
		//System.out.println(2);
	    }
	}
	size--;
	//System.out.println(this.toString());
	return temp;
    }
    
    public String toString(){
	String ans="[";
	LNode current = start;
	if(current!=null){
	    while(current.next!=null){
		ans+=" "+current.val+",";
		current = current.next;
	    }
	    ans+=" "+current.val+" ]";
	}else{
	    ans+="]";
	}
	return ans;
    }
 
    private void NodePrinter(LNode a){
        System.out.println(String.format("LNode \n Val: %s\n Prev: %s\n Next: %s", a.val, a.prev, a.next));
    }
}

