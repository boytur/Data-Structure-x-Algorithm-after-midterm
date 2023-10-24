public interface Collection {
    public void add(int value);
    public void add(int index, int value);
    public int get(int index);
    public void set(int index, int value);
    public void remove(int value);
    public int indexOf(int value);
    public int size();
    public int max_size();
    public boolean isEmpty();
    public boolean isFull();
    public void show();
}
