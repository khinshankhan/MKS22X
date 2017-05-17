public class FrontierQueue implements Frontier{
    public ArrayDeque<Location> values = new ArrayDeque<Location>();
	
    public void add(Location element){
	values.addFirst(element);
    }
	
    public Location next(){
	return values.removeLast();
    }

    public boolean hasNext(){
	return values.size()!=0;
}
