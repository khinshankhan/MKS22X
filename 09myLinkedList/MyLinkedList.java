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
	LNode current;
	head;
	for(int i=0; i<n; i++)
	    current=current.next;
	return current;
    }


    private void addAfter(LNode location, LNode toBeAdded){
	toBeAdded.prev=location.next;
    }


    private void remove(LNode target){/*complete this*/}


    public String toString(){ /*complete this*/  return "";}

    public boolean add(int value){ 
        LNode last= new LNode(value);
	addAfter(tail, last);
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

    public int indexOf(int value){/*complete this*/ return 0;}

    public int remove(int index){/*complete this*/ return 0;}

    public void add(int index,int value){/*complete this*/ return 0;}


}
