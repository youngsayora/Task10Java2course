package com.company;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Var15 {

    public static String[][] Solution15(String path) {
        FileWork file = new FileWork();
        return TriangleToString(getFourQuarter(convertToTriangle(file.GetFile15(path))));

    }
    public static List<Triangle> convertToTriangle(ArrayList<String[]> a)
    {
        Triangle temp;
        List<Triangle> b=new ArrayList<Triangle>();
        for (int i=0;i<a.size();i++) {
            temp=new Triangle();
            temp.setDot(Integer.parseInt(a.get(i)[0]), Integer.parseInt(a.get(i)[1]), 0);
            temp.setDot(Integer.parseInt(a.get(i)[2]), Integer.parseInt(a.get(i)[3]), 1);
            temp.setDot(Integer.parseInt(a.get(i)[4]), Integer.parseInt(a.get(i)[5]), 2);
            b.add(temp);
        }
        return b;
    }
    public static List<Triangle> getFourQuarter(List<Triangle> a)
    {
        int z,x,y;
        List<Triangle> b=new ArrayList<>();
        for (int i=0;i<a.size();i++) {
            z = a.get(i).getX(0) * (a.get(i).getY(1) - a.get(i).getY(0)) - (a.get(i).getX(1) - a.get(i).getX(0)) * a.get(i).getY(0);
            x = a.get(i).getX(1) * (a.get(i).getY(2) - a.get(i).getY(1)) - (a.get(i).getX(2) - a.get(i).getX(1)) * a.get(i).getY(1);
            y = a.get(i).getX(2) * (a.get(i).getY(0) - a.get(i).getY(2)) - (a.get(i).getX(0) - a.get(i).getX(2)) * a.get(i).getY(2);
            if ((x > 0 && y > 0 && z > 0) || (x < 0 && y < 0 && z < 0) || (x == 0 && y == 0 && z == 0)) b.add(a.get(i));
        }
        return b;
    }
    public static String[][] TriangleToString(List<Triangle> a)
    {
        String[][] b=new String[a.size()][6];
        for (int i=0;i<a.size();i++) {
            b[i][0]=Integer.toString(a.get(i).getX(0));
            b[i][1]=Integer.toString(a.get(i).getY(0));
            b[i][2]=Integer.toString(a.get(i).getX(1));
            b[i][3]=Integer.toString(a.get(i).getY(1));
            b[i][4]=Integer.toString(a.get(i).getX(2));
            b[i][5]=Integer.toString(a.get(i).getY(2));
        }
        return b;
    }




}

