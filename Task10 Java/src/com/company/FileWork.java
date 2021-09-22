package com.company;
import java.io.*;
import java.util.*;

public class FileWork {

    public void SetFile(ArrayList<ArrayList<String>> MyArray, String path){

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(path),true);
            for (int i =0;i<MyArray.size();i++){
                for (int j = 0; j< MyArray.get(i).size(); j++) {

                    out.print(MyArray.get(i).get(j) + " ");
                }
                if(MyArray.get(i).size() != 0)
                    out.println();


            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Laptop> GetFile ( String path){
        ArrayList<Laptop> value = new ArrayList<>();
        File file = new File(path);
        try {

            int count=0;
            Scanner size2scanner = new Scanner(file);
            while(size2scanner.hasNextLine()) {
                size2scanner.nextLine();
                count++;
            }
            size2scanner.close();




            Scanner scanner = new Scanner(file);

            for (int i = 0; i < count; i++) {
                String[] numbers = scanner.nextLine().split(" ");
                Laptop temp = new Laptop();
                temp.model = numbers[0];
                temp.memory = Integer.parseInt(numbers[1]);
                temp.rating = Integer.parseInt(numbers[2]);
                temp.price = Integer.parseInt(numbers[3]);
                value.add(temp);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return value;
    }

    public ArrayList<String[]> GetFile15 ( String path){
        ArrayList<String[]> arr = new ArrayList();

        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String[] stroka = new String[6];
                String[] numbers = scanner.nextLine().split(" ");
                int i = 0;
                for(String word: numbers)

                {
                    stroka[i] = word;
                    i++;
                }
                arr.add(stroka);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }
    public ArrayList<String> GetFile22 ( String path){
        ArrayList<String> arr = new ArrayList();

        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                String stroka = scanner.nextLine();
                arr.add(stroka);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arr;
    }


}




