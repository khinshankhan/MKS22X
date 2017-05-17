public class FrontierStack implements Frontier{
    public Stack<Location> values = new Stack<Location>();
	
    public void add(Location element){
	values.push(element);
    }
	
    public Location next(){
	return values.pop();
    }

    public boolean hasNext(){
	return values.szie();
    }
}
