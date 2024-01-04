package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String piDigits = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
        char[] digitsArray = piDigits.substring(2).toCharArray();
        int[] counts = countDigits(digitsArray);
//        System.out.println("Number of 3s: " + counts[3]);
//        System.out.println("Number of 5s: " + counts[5]);
//        System.out.println("Most rare digit: " + findMostRareDigit(counts));
//        System.out.println("Sorted digits array: " + Arrays.toString(sortDigitsArray(digitsArray)));
        TextView output = findViewById(R.id.output);
        output.setText("Number of 3s: " + counts[3]+
                "\nNumber of 5s: " + counts[5] +
                "\nMost rare digit: " + findMostRareDigit(counts)+
                "\nSorted digits array: " + Arrays.toString(sortDigitsArray(digitsArray)));

    }

    // Преобразуем число Пи с большим числом цифр после запятой в массив символов
    public static int[] countDigits(char[] digitsArray) {
        int[] counts = new int[10];

        for (char digit : digitsArray) {
            int charVal = (int) Character.getNumericValue(digit); // конвертация char в int
            counts[charVal]++; // массив counts, содержт количество вхождений каждой цифры (от 0 до 9) в массиве digitsArray.
        }
        return counts;
    }
    // Находим самую редкую цифру в массиве digitsArray с помощью функции findMostRareDigit.
    public static char findMostRareDigit(int[] counts) {
        int maxIndex = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] < counts[maxIndex]) {
                maxIndex = i;
            }
        }
        return (char) (maxIndex + '0');
    }
    // Сортируем массив digitsArray в обратном порядке с помощью функции sortDigitsArray.
    public static char[] sortDigitsArray(char[] digitsArray) {
        Arrays.sort(digitsArray);
//        System.out.println(Arrays.toString(digitsArray));
        for (int i = 0; i < digitsArray.length / 2; i++) {
            char temp = digitsArray[i];
            digitsArray[i] = digitsArray[digitsArray.length - 1 - i];
            digitsArray[digitsArray.length - 1 - i] = temp;
//            System.out.println(Arrays.toString(digitsArray));
        }
        return digitsArray;
    }
}