package TripBuddy.DataStructures;

public class ArrayList<E> {
    private Object[] arrayList;
    private int size;

    /**
     * Constructor for ArrayList
     * Initializes the array with size 10
     */
    public ArrayList() {
        arrayList = new Object[10];
        size = 0;
    }

    ArrayList(int size) {
        arrayList = new Object[size];
    }

    /**
     * Adds the given data to the end of the list
     *
     * @param data Data to be added
     */
    public void add(E data) {
        if (size == arrayList.length) {
            resize();
        }
        arrayList[size] = data;
        size++;
    }

    /**
     * Adds the given data to the given index
     *
     * @param data  Data to be added
     * @param index Index at which the data is to be added
     *              If index is one more than size then add at the end of the list else throw exception
     */
    public void add(E data, int index) {
        //if index is one more than size then add at the end of the list else throw exception
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arrayList.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            //shift all elements to the right
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = data;
        size++;
    }

    /**
     * Resizes the array to twice its size
     * Copies all the elements to the new array
     * and assigns the new array to the old array
     */
    private void resize() {
        Object[] temp = new Object[arrayList.length * 2];
        System.arraycopy(arrayList, 0, temp, 0, arrayList.length);
        arrayList = temp;
    }

    /**
     * Removes the given data from the list
     *
     * @param index Index of the data to be removed
     * @return Data that is removed
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E data = (E) arrayList[index];
        for (int i = index; i < size - 1; i++) {
            //shift all elements to the left
            arrayList[i] = arrayList[i + 1];
        }
        size--;
        return data;
    }

    /**
     * Returns the data at the given index
     *
     * @param index Index of the data to be returned
     *              If index is out of bounds then throw exception
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) arrayList[index];
    }

    /**
     * Returns the index of the given data
     *
     * @param data Data to be searched
     * @return Index of the given data or -1 if the data is not found
     */
    public int get(E data) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(arrayList[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
