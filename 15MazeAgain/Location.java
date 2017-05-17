public class Location implements Comparable<Location>{
    private int row, col;
    private int distToGoal;
    private int distToStart; 
    private Location previous;
    private boolean aStar;
    private int priority;

    public int distToGoal(){
	return distToGoal;
    }
    public int distToStart(){
	return distToGoal; 
    }

    public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){
	row=r;
	col=c;
        this.previous=previous;
	this.distToStart=distToStart;
	this.distToGoal=distToGoal;
	this.aStar=aStar;
	priority=(!aStar)? distToStart: distToStart+distToGoal;
    }

    public int compareTo(Location other){
	    return priority-other.priority();
    }
}
