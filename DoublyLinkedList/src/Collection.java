public interface Collection {
    public void add(int value);
    public void add(int index, int value);
    public int get(int index);
    public void set(int index, int value);
    public void remove(int value);
    public boolean find(int value);
    public int size();
    public boolean isEmpty();
    public void show();
    public void show_backward();
}