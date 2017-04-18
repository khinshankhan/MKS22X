public class Driver{

    public static void main(String [] args){
	//Testing: constructor, toString, size, add, get, remove
	
	MyLinkedList a= new MyLinkedList();
	System.out.println(a.toString()+"\nSize: "+a.size());//[], size=0
	for(int i=0; i<20; i++){
	    a.add(i);
	    if(a.get(a.size()-1)%2==0)
		a.remove(a.size()-1);
	    //System.out.println(a);//Check if all nums arent odd
	}
	
	System.out.println(a+"\nSize: "+a.size());//odds 0-20 in order, size=10
	
	//Testing: set, indexOf, add(i,v); reinforce others
	for(int i=0; i<10; i++){
	    a.set(i,i*100);
	}
	
	System.out.println(a+"\nSize: "+a.size());//mulitples of 100, size=10
	for(int i=0; i<10; i++){
	    a.set(i,a.indexOf(i*100));
	}
	
        System.out.println(a+"\nSize: "+a.size());//0-9 in order, size=10
	a.remove(1);
	a.add(1,1);
	for(int i=0; i<10; i++){
	    a.add(0,i*-1-1);
	}
	a.add(a.size(),10);
	
	System.out.println(a+"\nSize: "+a.size());//-10-10 in order, size=21
	
	//Testing: Iterator
	MyLinkedList data = new MyLinkedList();
	int i = 0;
	while(i < 15){
	    data.add(i);
	    i++;
	}

	System.out.println("\nContents: "+data);
	System.out.println("Standard loop:");

	for(int n = 0; n < data.size(); n++){
	    System.out.print(data.get(n)+" ");
	}
	System.out.println();
	System.out.println("for-each loop:");
	for(Integer s : data){
	    System.out.print(s+" ");
	}
	//should be same
    }

}
