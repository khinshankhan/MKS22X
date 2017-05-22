public class Location implements Comparable<Location>{
    private int row, col; //Location
    private int distToStart, distToGoal; //Manhattan distance?
    private Location previous; //connect it
    private boolean aStar; //type of algorithm
    private int priority; //smart priority

    public int row(){
	return row;
    }
    public int col(){
	return col;
    }
    public int distToStart(){
	return distToGoal; 
    }
    public int distToGoal(){
	return distToGoal;
    }
    public int priority(){
	return priority;
    }
    public Location previous(){
	return previous;
    }

    public Location(int r, int c, Location previous , int distToStart, int distToGoal){
	row=r;
	col=c;
        this.previous=previous;
	this.distToStart=distToStart;
	this.distToGoal=distToGoal;
	priority= 0;
    }

    public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){
        this(r, c, previous, distToStart, distToGoal);
	this.aStar=aStar;
	priority=(!aStar)? distToGoal: distToStart+distToGoal;
    }

    public int compareTo(Location other){
	return priority-other.priority();
    }

    public String toString(){
	return row+" "+col+" "+distToStart+" "+distToGoal;
    }
}
