/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package awtinterf;

import com.lab2.PolandNotation.*;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

import static com.lab2.PolandNotation.*;


public class TestEventListners {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MySimpleNotebook frame = new MySimpleNotebook();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class MySimpleNotebook extends JFrame {
    public MySimpleNotebook() {
        setBounds(100, 100, 500, 500);
        //Container c = getContentPane();
        tf = new JTextField("Введите выражение сюда ", 50);
        add(tf, BorderLayout.NORTH); //компоновка
        ta = new JTextArea();
        ta.setEditable(false);
        add(ta);
        JPanel p = new JPanel();
        add(p, BorderLayout.SOUTH);
        b = new JButton("Перенести");
        calc = new JButton("Посчитать");
        clear = new JButton("Отчистить");

        p.add(b);
        p.add(calc);
        p.add(clear);

        tm = new TextMove(tf, ta);
        cl = new CalcExper(tf, ta);
        cr = new ClearAll(tf, ta);

        tf.addActionListener(tm);
        b.addActionListener(tm);
        calc.addActionListener(cl);
        clear.addActionListener(cr);
    }

    private JTextField tf;
    private JTextArea ta;
    private JButton b;
    private JButton calc;
    private JButton clear;
    private TextMove tm;
    private CalcExper cl;
    private ClearAll cr;
}

class TextMove implements ActionListener {
    private JTextField tf;
    private JTextArea ta;

    TextMove(JTextField f, JTextArea a) {
        tf = f;
        ta = a;
    }

    public void actionPerformed(ActionEvent e) {
        ta.append(tf.getText() + "\n");

    }
}

class CalcExper implements ActionListener {
    private JTextField tf;
    private JTextArea ta;

    CalcExper(JTextField f, JTextArea a) {
        tf = f;
        ta = a;
    }

    public void actionPerformed(ActionEvent e) {
        java.util.List<String> arrayExper = validateToList(tf.getText());
        System.out.println("Массив из выражения ;" + arrayExper);
        ta.append(arrayExper + " \n");
        List<String> polis = listToPOLIS(arrayExper);
        ta.append("ПОЛИЗ :" + polis + " \n");
        ta.append("Результат выражения =" + calculate(polis) + " \n");
    }

}


class ClearAll implements ActionListener {
    private JTextField tf;
    private JTextArea ta;

    ClearAll(JTextField f, JTextArea a) {
        tf = f;
        ta = a;
    }

    public void actionPerformed(ActionEvent e) {
        ta.removeAll();
    }

}

