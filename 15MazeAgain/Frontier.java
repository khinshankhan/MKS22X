public interface Frontier{
    public void add(Location value);
    public Location next();
    public boolean hasNext();
}
