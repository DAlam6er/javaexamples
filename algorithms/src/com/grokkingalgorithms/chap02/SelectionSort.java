package com.grokkingalgorithms.chap02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Пример сортировки выбором
public class SelectionSort
{
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList()
    {
        return list;
    }

    public void setList(List<Integer> list)
    {
        this.list = list;
    }

    public void inputList()
    {
        int num;
        Scanner in = new Scanner(System.in);
        System.out.print("Input number of elements of the list: ");
        num = in.nextInt();
        System.out.println("Input integer elements of the list: ");
        for (int i = 0; i < num; i++) {
            list.add(in.nextInt());
        }
        in.close();
    }

    /**
     *
     * We work with the list and not with array due to the fact
     * in {@code selectionSort} we find the smallest element,
     * and then we delete it from the list.
     * Deleting from List is faster than from Array
     * @return index of the smallest element
     */
    // O(n)
    public int getLowestInd()
    {
        int smallest = list.get(0);
        int smallestIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < smallest) {
                smallest = list.get(i);
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    // O(n^2)
    public List<Integer> selectionSort()
    {
        List<Integer> newList = new ArrayList<>();
        int size = getList().size();
        for (int i = 0; i < size; i++) {
            int smallestInd = getLowestInd();
            newList.add(list.get(smallestInd));
            list.remove(smallestInd);
        }
        // ss.list = []
        return newList;
    }

    public static void main(String[] args)
    {
        SelectionSort ss = new SelectionSort();
        ss.inputList();
        System.out.println("Original list: " + ss.getList());
        System.out.println("Sorted array: " + ss.selectionSort());
    }
}