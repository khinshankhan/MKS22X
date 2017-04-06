public class MyLinkedList{

    private class LNode{
	LNode next,prev;
	int value;

	public LNode(int value){
	    this.value=value;
	}

	public String toString(){
	    return value+"";
	}
    }

    LNode head,tail;
    int size;

    public MyLinkedList(){
	head= tail= null;
	size= 0;
    }

    public int size(){
	return size;
    }

    private LNode getNthNode(int n){
	LNode current= head;
	if(size != 0){
	    int a= size/2;
	    if(n<= a){
		for(int i=0; i<n; i++)
		    current=current.next;
	    }else{
		current=tail;
		n=size-1-n;
		for(int i=0; i<n; i++)
		    current=current.prev;
	    }
	}
	return current;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	toBeAdded.prev= location;
	toBeAdded.next= location.next;
	location.next= toBeAdded;
    }

    /*
      LNode a= new LNode(value);
      a.prev= getNthNode(index);
      a.next= getNthNode(index).next;
      getNthNode(index).next= a;
    */

    private int remove(LNode target){
	int temp= target.next.value;
	target.next.next.prev=target;
	target.next=target.next.next;
	size--;
	return temp;
    }


    public String toString(){
	String ans="[";
	LNode current = head;
	if(current!=null){
	    while(current.next!=null){
		ans+=" "+current.value+",";
		current = current.next;
	    }
	    ans+=" "+current.value+" ]";
	}else{
	    ans+="]";
	}
	return ans;
    }

    public boolean add(int value){ 
	LNode last= new LNode(value);
	if(size!=0){
	    addAfter(tail, last);
	    tail= last;
	}else{
	    head= tail= last;
	}
	size++;
	//System.out.println(this.toString()+"\nSize: "+this.size());
	return true;
    }

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int value){
	LNode target= getNthNode(index);
	int ans= target.value;
	target.value= value;
	return ans;
    }

    public int indexOf(int value){
	LNode current=head;
	int index= 0;
	while(current.next!=null){
	    if(current.value==value){
		return index;
	    }
	    current= current.next;
	    index++;
	}
	if(current.value==value){
	    return index;
	}
	return -1;
    }

    public int remove(int index){
	int temp;
	if(index==0){
	    temp= head.value;
	    head.next.prev= null;
	    head= head.next;
	    size--;
	}else if(index==size-1){
	    temp= tail.value;
	    tail.prev.next= null;
	    tail= tail.prev;
	    size--;
	}else{
	    LNode dummy= getNthNode(index-1);
	    temp= remove(dummy);
	}
	return temp;
    }

    public void add(int index,int value){
	if(index==0){
	    LNode a= head;
	    addAfter(head, new LNode(value));
	    remove(0);
	    addAfter(head, a);
	    size++;
	}else if(index==size){
	    add(value);
	    size--;
	}else{
	    addAfter(getNthNode(index-1),new LNode(value));
	}
	size++;
    }
 
    private void NodePrinter(LNode a){
        System.out.println(String.format("LNode \n Val: %s\n Prev: %s\n Next: %s", a.value, a.prev, a.next));
    }

}
