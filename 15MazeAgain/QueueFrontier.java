import java.util.ArrayDeque;

public class QueueFrontier implements Frontier{
    private ArrayDeque<Location> values;

    public QueueFrontier(){
	values = new ArrayDeque<Location>();
    }
	
    public void add(Location element){
	values.addFirst(element);
    }
	
    public Location next(){
	return values.removeLast();
    }

    public boolean hasNext(){
	return values.size()!= 0;
    }
}
