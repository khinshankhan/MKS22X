public class Driver{

    public static void main(String [] args){
	MyLinkedList alpha= new MyLinkedList();
	alpha.add(110);
	alpha.add(72);
	alpha.add(60);
	alpha.add(17);
	alpha.add(51);
	System.out.println(alpha.add(5));
	System.out.println(alpha.toString()+"\nSize: "+alpha.size());
	//System.out.println(alpha.indexOf(60));
	//System.out.println(alpha.indexOf(5));
	//System.out.println(alpha.indexOf(0));
	//System.out.println(alpha.get(0));
	//System.out.println(alpha.set(0, 900));
	//System.out.println(alpha.get(0));
	//System.out.println(alpha.get(1));
	//System.out.println(alpha.get(2));
	//System.out.println(alpha.get(4));
	//System.out.println(alpha.set(4, 500));
	//System.out.println(alpha.get(4));
	//System.out.println(alpha.get(0));
	//System.out.println(alpha.indexOf(500));
	//System.out.println(alpha.toString()+"\nSize: "+alpha.size());
	System.out.println(alpha.remove(2));
	System.out.println(alpha.remove(0));
	System.out.println(alpha.remove(alpha.size()-1));
	alpha.add(0,101);
	System.out.println(alpha.toString()+"\nSize: "+alpha.size());
	alpha.add(3,50);
	System.out.println(alpha.toString()+"\nSize: "+alpha.size());
	//MyLinkedList beta= new MyLinkedList();
	//System.out.println(beta.toString()+"\nSize: "+beta.size());
    }
}
