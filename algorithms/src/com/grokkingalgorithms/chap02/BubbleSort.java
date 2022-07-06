package com.grokkingalgorithms.chap02;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] matrix = new int[] {-100, 8, -8, -300};
        bubbleSort(matrix);
        System.out.println(Arrays.toString(matrix));
    }

    private static void bubbleSort(int[] m)
    {
        int i;
        boolean reshuffled;
        // Внешний цикл обеспечивает работу всего алгоритма
        for (int j = 0; j < m.length; j++) {
            reshuffled = false;
            // Внутренний цикл отвечает за перебор элементов
            // 0 <= i <= (m.length - 2) на первой итерации
            // 0 <= i <= (m.length - 3) на второй итерации (последний элемент уже отсортирован)
            for (i = 0; i < m.length - 1 - j; i++) {
                if (m[i] > m[i + 1]) {
                    m[i] ^= m[i + 1];
                    m[i + 1] ^= m[i];
                    m[i] ^= m[i + 1];
                    reshuffled = true;
                }
            }
            if (!reshuffled) break;
        }
    }
}
