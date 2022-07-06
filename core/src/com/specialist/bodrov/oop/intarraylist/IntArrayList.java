package com.specialist.bodrov.oop.intarraylist;

public class IntArrayList {

    private static final int DEFAULT_SIZE = 10;

    private int[] array = new int[DEFAULT_SIZE];

    private int size = 0;

    public void add(int i){
       if (size >= array.length){
           int[] temp = array;
           array = new int[temp.length * 2];
           System.arraycopy(temp, 0, array, 0, temp.length);
       }

       array[size++] = i;
    }

    public int get(int i){
        checkRange(i);

        return array[i];
    }

    public int size(){
        return size;
    }

    public void remove(int i){
        checkRange(i);

        System.arraycopy(array, i + 1, array, i, size - i - 1);
        size--;
    }

    private void checkRange(int i){
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException(i);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(array[i] + ", ");
        }
        String values = builder.length() > 1
                ? builder.substring(0, builder.length() - 2)
                : "";

        return "[" + values + "]";
    }


}
