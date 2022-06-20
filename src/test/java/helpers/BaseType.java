package helpers;

/**
 * It can cast T object to int or double if possible
 * @param <T>
 */
public class BaseType<T> {
    T obj;

    public BaseType(T obj) {
        this.obj = obj;
    }

    public int getInteger() {
        return (int) this.obj;
    }

    public double getDouble() {
        return (double) this.obj;
    }
}
