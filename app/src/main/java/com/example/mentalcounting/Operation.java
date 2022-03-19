package com.example.mentalcounting;

public class Operation {

    private int left;
    private int right;
    private int answer;
    private char operator;

    public Operation () {
         int count = (int)(Math.random() * 3) + 1;
         int s;
        switch (count) {
            case (1):
                operator='+';
                left = (int)(Math.random() * 10) + 6;
                right = (int)(Math.random() * 10) + 9;
                answer = left + right;
                break;

            case (2):
                operator='-';
                left = (int)(Math.random() * 10) + 3;
                right = (int)(Math.random() * 10) + 6;
                if (left < right) {
                    s = left;
                    left = right;
                    right = s;
                }
                answer = left - right;
                break;

            case (3):
                operator='*';
                left = (int)(Math.random() * 10) + 1;
                right = (int)(Math.random() * 10) + 1;
                answer = left * right;
                break;

        }
    }


    @Override
    public String toString() {
        return left + "" + operator + "" + right + "=" ;
    }

    public int getAnswer () {
        return answer;
    }
}
