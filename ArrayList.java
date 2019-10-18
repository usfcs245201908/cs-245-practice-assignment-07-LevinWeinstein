import java.util.Arrays;

public class ArrayList<T> implements List<T>{
    T[] baseArray;
    static int DefaultSize = 128;
    int currentSize;

    public ArrayList(){
        baseArray = (T[])new Object[DefaultSize];
        currentSize = 0;
    }

    public void doubleArray(){
        int doubleSize = baseArray.length * 2;
        baseArray = Arrays.copyOf(baseArray, doubleSize);
    }

    public void add(T item){
        if (currentSize == baseArray.length)
            baseArray = Arrays.copyOf(baseArray, baseArray.length * 2);
        baseArray[currentSize++] = item;
    }

    public void add(int pos, T item){
        if (currentSize == baseArray.length)
            baseArray = Arrays.copyOf(baseArray, baseArray.length * 2);
        System.arraycopy(baseArray, pos, baseArray, pos + 1, currentSize - pos);
        baseArray[pos] = item;
        currentSize++;
    }

    public T get(int pos){
        return baseArray[pos];
    }

    public T remove(int pos){
        T item = baseArray[pos];
        System.arraycopy(baseArray, pos + 1, baseArray, pos, currentSize - pos - 1);
        currentSize--;
        return item;
    }

    public int size(){
        return currentSize;
    }
}
