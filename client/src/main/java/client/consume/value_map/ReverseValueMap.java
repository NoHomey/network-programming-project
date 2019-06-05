package client.consume.value_map;

public interface ReverseValueMap {
    public Object valueFromIndex(int index);

    public int size();

    public void clear();
}