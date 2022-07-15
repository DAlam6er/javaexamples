package com.stepik.javabasecourse.strings;

public class AsciiCharSequence implements java.lang.CharSequence {
    private final byte[] sequence;

    public AsciiCharSequence(byte[] sequence)
    {
        this.sequence = sequence.clone();
    }

    @Override
    public int length() {
        return sequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) sequence[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] newSeq = new byte[end - start];
        int j = 0;
        for (int i = start; i < end; i++) {
            newSeq[j++] = sequence[i];
        }
        return new AsciiCharSequence(newSeq);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (byte b : sequence) {
            sb.append(Character.valueOf((char) b));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello

        //проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }

}
