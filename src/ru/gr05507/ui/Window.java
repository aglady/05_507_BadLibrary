package ru.gr05507.ui;

import ru.gr05507.domain.Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Window extends JFrame implements BookView{

    private JPanel panel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel labelStatus;
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JButton button;
    private JTextArea area;
    private final BookController controller;

    public Window(BookController controller){
        this.controller = controller;
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

        labelStatus = new JLabel();


        field1 = new JTextField();
        field2 = new JTextField();
        field3 = new JTextField();
        field4 = new JTextField();

        button = new JButton();
        button.setText("Добавить");


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,300));

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
        area.setEditable(false);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(area), BorderLayout.CENTER);
        add(labelStatus, BorderLayout.SOUTH);
        button.addActionListener(e -> {
            controller.addBookClicked();
        });
        field1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                controller.inputChanged();
            }
        });
        field2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                controller.inputChanged();
            }
        });
        field3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                controller.inputChanged();
            }
        });
        setLocationRelativeTo(null);
        pack();
    }

    @Override
    public String getAuthor() {
        return field1.getText();
    }

    @Override
    public String getBookTitle() {
        return field2.getText();
    }

    @Override
    public String getYear() {
        return field3.getText();
    }

    @Override
    public String getInfo() {
        return field4.getText();
    }

    @Override
    public void clearInput() {
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
    }

    @Override
    public void showBooks(List<Book> books) {
        area.setText("");
        var i = 1;
        for(var book: books){
            area.append(i++ + ": ");
            area.append(book.author());
            area.append(" | ");
            area.append(book.title());
            area.append(" | ");
            area.append("" + book.year());
            if (book.info() != null && !book.info().isBlank()) {
                area.append(" | ");
                area.append(book.info());
            }
            area.append(System.lineSeparator());
        }
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void render(BookFormState state) {
        button.setEnabled(state.addEnabled());
        labelStatus.setText(state.status());
        if (state.erorr() != null){
            showError(state.erorr());
        }
    }
}
