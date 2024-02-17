package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        
        strings = new String[6];
        int arrSize = strings.length;
        for (int i = 0; i < arrSize; i++) {
            strings[i] = console.nextLine();
        }
        for (int i = 0; i < arrSize - 1; i++) {
            String temp = strings[i];
            if (temp != null) {
                for (int j = i + 1; j < arrSize ; j++) {
                    if (temp.equals(strings[j])) {
                        strings[i] = null;
                        strings[j] = null;
                    }
                }
            }
        }
        for (int i = 0; i < arrSize; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
