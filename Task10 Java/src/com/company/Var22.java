package com.company;
import java.awt.*;
import java.util.*;
import java.lang.*;

public class Var22  {
    public static final Comparator<Laptop> COMPARE_BY_COUNT = new Comparator<Laptop>() {
        @Override
        public int compare(Laptop lhs, Laptop rhs) {
            return lhs.price - rhs.price;
        }
    };
    static int priceOfALL = 0;
    public static ArrayList<String> Solution(int K, int M, int R, String path) {
        /*Scanner in = new Scanner(System.in);
        System.out.print("Введите количество необходимых планшетов: ");
        int K = Integer.parseInt(in.nextLine());
        System.out.print("Введите минимальный объем памяти: ");
        int M = Integer.parseInt(in.nextLine());
        System.out.print("Введите минимальный рейтинг: ");
        int R = Integer.parseInt(in.nextLine());*/

        ArrayList<Laptop> Laptops = new ArrayList<>();
        ArrayList<Laptop> LaptopsAnswer = new ArrayList<>();
        ArrayList<String> LaptopsAnswerString = new ArrayList<>();
        FileWork file = new FileWork();
        Laptops.addAll(file.GetFile(path));

        Collections.sort(Laptops, Var22.COMPARE_BY_COUNT);

        int count = 0;
        for (int i = 0; i < Laptops.size(); i++) {
            if(Laptops.get(i).memory>=M && Laptops.get(i).rating>=R ){
                LaptopsAnswer.add(Laptops.get(i));
                priceOfALL += Laptops.get(i).price;
                count++;
            }
            if (count == K){
                break;
            }
        }

        for (int i = 0; i < LaptopsAnswer.size(); i++) {
            LaptopsAnswerString.add(LaptopsAnswer.get(i).model + " " + LaptopsAnswer.get(i).memory + " " + LaptopsAnswer.get(i).rating + " " + LaptopsAnswer.get(i).price);
        }



        return LaptopsAnswerString;


    }
    public static int getpriceOfALL(){
        return priceOfALL;
    }





}


