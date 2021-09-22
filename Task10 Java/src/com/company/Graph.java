package com.company;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Graph extends JFrame{
    private  JLabel label1=new JLabel("Введите исходные данные или возьмите их из файла");
    private JButton WriteTextBut= new JButton("Ввести данные");
    private JTextArea area1 = new JTextArea(10, 30);
    private JTextArea area2 = new JTextArea(10, 30);
    private JTextArea area3 = new JTextArea(10, 30);
    private JButton accept= new JButton("Подтвердить");
    private JButton ReadArrayFromFileBut15= new JButton("Взять данные из файла для 15");
    private JButton ReadArrayFromFileBut22= new JButton("Взять данные из файла для 22");
    private JButton task15but= new JButton("Задание 15");
    private JButton task22but= new JButton("Задание 22");
    private JTable jTable1= new JTable();
    ArrayList<String> text22 = new ArrayList<>();
    ArrayList<String[]> text15 = new ArrayList<>();
    FileWork filework = new FileWork();

    public void graphics() {
        JFrame frame = new JFrame("Лабораторная номер 10");
        frame.setSize(340, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.setVisible(true);
        WriteTextBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Создаем новый контейнер JFrame
                JFrame jfrm = new JFrame("Ввод текста");
                //Устанавливаем диспетчер компоновки
                jfrm.getContentPane().setLayout(new FlowLayout());
                //Устанавливаем размер окна
                jfrm.setSize(600, 250);
                //Устанавливаем завершение программы при закрытии окна
                jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Создаем новую таблицу на основе двумерного массива данных и заголовков
                //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/

                //panel.add(jTable1);

                //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                JScrollPane jscrlp = new JScrollPane(area1);

                //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                jfrm.getContentPane().add(jscrlp);
                jfrm.add(accept);
                //Отображаем контейнер
                jfrm.setVisible(true);
                accept.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        File file = new File("C:\\Users\\olegf\\IdeaProjects\\Task10 Java\\src\\com\\company\\tempFile.txt");
                        FileWriter fr = null;
                        try {
                            fr = new FileWriter(file);
                            fr.write(area1.getText());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }finally{
                            try {
                                fr.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                        text22 = filework.GetFile22("C:\\Users\\olegf\\IdeaProjects\\Task10 Java\\src\\com\\company\\tempFile.txt");
                        text15 = filework.GetFile15("C:\\Users\\olegf\\IdeaProjects\\Task10 Java\\src\\com\\company\\tempFile.txt");


                    }
                });

            }
        });

        task15but.addActionListener(new ActionListener() {
                                           public void actionPerformed(ActionEvent e) {
                                               Var15 var15 = new Var15();
                                               String [] headers = {"x1","y1","x2","y2","x3","y3"};
                                               String [][] answer = var15.Solution15("C:\\Users\\olegf\\IdeaProjects\\Task10 Java\\src\\com\\company\\in15.txt");
                                               //Создаем новый контейнер JFrame
                                               JFrame jfrm = new JFrame("Массив с ответом");
                                               //Устанавливаем диспетчер компоновки
                                               jfrm.getContentPane().setLayout(new FlowLayout());
                                               //Устанавливаем размер окна
                                               jfrm.setSize(300, 170);
                                               //Устанавливаем завершение программы при закрытии окна
                                               jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                               //Создаем новую таблицу на основе двумерного массива данных и заголовков
                                               //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/
                                               jTable1 = new JTable(answer, headers);
                                               //panel.add(jTable1);

                                               //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                                               JScrollPane jscrlp = new JScrollPane(jTable1);
                                               //Устаналиваем размеры прокручиваемой области
                                               jTable1.setPreferredScrollableViewportSize(new Dimension(250, 100));
                                               //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                                               jfrm.getContentPane().add(jscrlp);
                                               //Отображаем контейнер
                                               jfrm.setVisible(true);

                                           }
                                       });
        task22but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Var22 var22 = new Var22();

                //Создаем новый контейнер JFrame
                JFrame jfrm = new JFrame("Введите данные");
                //Устанавливаем диспетчер компоновки
                jfrm.getContentPane().setLayout(new FlowLayout());
                //Устанавливаем размер окна
                jfrm.setSize(250, 300);
                //Устанавливаем завершение программы при закрытии окна
                jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Создаем новую таблицу на основе двумерного массива данных и заголовков
                //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/
                JLabel label22_1=new JLabel("Введите исходные данные");
                JLabel label22_2=new JLabel("Количество:");
                JTextField textfforK=new JTextField("",20);
                JLabel label22_3=new JLabel("Мин. объем памяти:");
                JTextField textfforM=new JTextField("",20);
                JLabel label22_4=new JLabel("Мин. рейтинг:");
                JTextField textfforR=new JTextField("",20);
                JButton accept1= new JButton("Подтвердить");

                jTable1.setPreferredScrollableViewportSize(new Dimension(250, 100));
                //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                jfrm.getContentPane().add(label22_1);
                jfrm.getContentPane().add(label22_2);
                jfrm.getContentPane().add(textfforK);
                jfrm.getContentPane().add(label22_3);
                jfrm.getContentPane().add(textfforM);
                jfrm.getContentPane().add(label22_4);
                jfrm.getContentPane().add(textfforR);
                jfrm.getContentPane().add(accept1);
                //Отображаем контейнер
                jfrm.setVisible(true);
                accept1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {


                        ArrayList<String> answer = var22.Solution(Integer.parseInt(textfforK.getText()),Integer.parseInt(textfforM.getText()),Integer.parseInt(textfforR.getText()),"C:\\Users\\olegf\\IdeaProjects\\Task10 Java\\src\\com\\company\\in22.txt");
                        //Создаем новый контейнер JFrame
                        JFrame jfrm1 = new JFrame("Массив с ответом");
                        //Устанавливаем диспетчер компоновки
                        jfrm1.getContentPane().setLayout(new FlowLayout());
                        //Устанавливаем размер окна
                        jfrm1.setSize(400, 300);
                        //Устанавливаем завершение программы при закрытии окна
                        jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        //Создаем новую таблицу на основе двумерного массива данных и заголовков
                        //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/

                        //panel.add(jTable1);

                        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                        JScrollPane jscrlp = new JScrollPane(area2);
                        for (int i =0;i<answer.size();i++) {

                                area2.append(answer.get(i) + "\n");
                            }

                        JLabel label22_1_1=new JLabel("Цена за всё: "+Integer.toString(var22.getpriceOfALL()));
                                            jfrm1.getContentPane().add(jscrlp);
                        jfrm1.getContentPane().add(label22_1_1);


                                            jfrm1.setVisible(true);
                    }
                });

            }
        });






        panel.add(label1);
        //panel.add(area1);
        panel.add(WriteTextBut);
        panel.add(ReadArrayFromFileBut15);
        panel.add(ReadArrayFromFileBut22);
        panel.add(task15but);
        panel.add(task22but);
        frame.add(panel);
    }
}
