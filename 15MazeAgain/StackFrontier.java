import java.util.Stack;

public class StackFrontier implements Frontier{
    private Stack<Location> values;

    public StackFrontier(){
	values = new Stack<Location>();
    }
	
    public void add(Location element){
	values.push(element);
    }
	
    public Location next(){
	return values.pop();
    }

    public boolean hasNext(){
	return values.size()!= 0;
    }
}
