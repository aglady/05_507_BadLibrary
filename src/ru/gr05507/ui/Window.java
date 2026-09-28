package ru.gr05507.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame implements BookView{

    private JPanel panel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JButton button;
    private JTextArea area;

    public Window(){

        panel = new JPanel();

        area = new JTextArea();

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label1.setText("Автор");
        label2.setText("Название");
        label3.setText("Год издания");
        label4.setText("Дополнительно");

        field1 = new JTextField();
        field2 = new JTextField();
        field3 = new JTextField();
        field4 = new JTextField();

        button = new JButton();
        button.setText("Добавить");

        list = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1000,500));

        GroupLayout gl = new GroupLayout(panel);
        panel.setVisible(true);
        panel.setLayout(gl);

        gl.setAutoCreateGaps(true);

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(10)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(gl.createSequentialGroup()
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4))
                        .addGroup(gl.createSequentialGroup()
                                .addComponent(field1)
                                .addComponent(field2)
                                .addComponent(field3)
                                .addComponent(field4))
                        .addComponent(button))
                .addGap(10)
        );

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(10)
                .addGroup(gl.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label3)
                        .addComponent(label4))
                .addGroup(gl.createParallelGroup()
                        .addComponent(field1)
                        .addComponent(field2)
                        .addComponent(field3)
                        .addComponent(field4)
                )
                .addComponent(button)
        );

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        button.addActionListener(e -> {
            String text1 = field1.getText();
            String text2 = field2.getText();
            String text3 = field3.getText();
            String text4 = field4.getText();
            if(text1 == null || text1.isBlank()){
                JOptionPane.showMessageDialog(this, "Введите автора");
                return;
            }
            if(text2 == null || text2.isBlank()){
                JOptionPane.showMessageDialog(this, "Введите название");
                return;
            }
            if(text3 == null || text3.isBlank()){
                JOptionPane.showMessageDialog(this, "Введите год издания");
                return;
            }

            list.add( (list.size() + 1) + ". " + text1 + " " + text2 + " " + text3 + " " + text4);
            area.setText("");
            for(String elem: list){
                area.append(elem + "\n");
            }
        });
        setLocationRelativeTo(null);
        pack();
    }

    @Override
    public String getAuthor() {
        return "";
    }

    @Override
    public String getYear() {
        return "";
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public void clearInput() {

    }

    @Override
    public void showBooks(List<Book> books) {

    }

    @Override
    public void showError(String Message) {

    }
}
