package bankproject;

import java.sql.*;
import java.util.jar.Attributes.Name;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;

import javax.swing.*;

class Framework{
        Framework(){ 
            JFrame f =new JFrame();
            f.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel1 = new JPanel();
            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                   Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 0),
                    getWidth(), getHeight(), new Color(0, 0,0, 255), true);
                   Graphics2D g2d = (Graphics2D)g;
                   g2d.setPaint(p);
                   g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            panel1.setBounds(400, 200, 700, 450);
            JLabel f1 = new JLabel("BOM");
            f1.setBounds(315, 50, 300, 50);
            f1.setFont(new Font("Comic Sans MS ", Font.PLAIN, 30));
            JLabel f2 = new JLabel("WELCOME TO BANK OF MONEY");
            f2.setBounds(115, 110, 500, 50);
            f2.setFont(new Font("Comic Sans MS ", Font.PLAIN, 30));
            JButton b = new JButton("INSERT CARD");
            b.setBounds(115, 200, 500, 50);
            b.setBackground(Color.BLACK);
            b.setForeground(Color.white); 
            JButton b1 = new JButton("USE UPI ID");
            b1.setBounds(115, 300, 500, 50);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.white);
            panel1.setLayout(null);
            panel1.add(b1);
            panel1.add(f1);
            panel1.add(f2);
            panel1.add(b);
            panel.setLayout(null);
            panel.add(panel1);
            f.setContentPane(panel);
            f.setVisible(true);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SecondPage();
                }
            });
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    SecondPage();
                }
            });
        } 
        void SecondPage()
        {
            JFrame f1 =new JFrame();
            f1.setVisible(true);
            f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                   Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 0),
                    getWidth(), getHeight(), new Color(0, 0,0, 255), true);
                   Graphics2D g2d = (Graphics2D)g;
                   g2d.setPaint(p);
                   g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            f1.setContentPane(panel);
            JPanel panel1 = new JPanel();
            panel.setLayout(null);
            panel.add(panel1);
            panel1.setLayout(null);
            panel1.setBounds(400, 200, 700, 450);
            JLabel l1 = new JLabel("ENTER YOUR UPI ID");
            l1.setBounds(215, 150, 300, 30);
            l1.setFont(new Font("Comic Sans MS ", Font.PLAIN, 30));
            JLabel l2 = new JLabel();
            l2.setBounds(200, 180, 200, 20);
            l2.setFont(new Font("Comic Sans MS ", Font.PLAIN, 10));
            JTextArea a = new JTextArea();
            a.setBackground(Color.BLACK);
            a.setForeground(Color.white);
            a.setBounds(200, 200, 300, 50);
            JButton b1 = new JButton("NEXT");
            b1.setBounds(300, 300, 100, 50);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.white);
            panel1.add(a);
            panel1.add(l1);
            panel1.add(b1);
            panel1.add(l2);
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String upi_id = a.getText();
                    try {
                        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upi", "root",
                                "root");
                        Statement stmt = conn.createStatement();
                        String query1 = "select * from account";
                        ResultSet rs = stmt.executeQuery(query1);
                        while(rs.next()){
                            System.out.print(upi_id);
                            System.out.println(rs.getString("upi_id").trim());
                            if(upi_id.equals(rs.getString("upi_id").trim())){
                                ThirdPage();
                            }
                        }
                        l2.setText("*ID NOT FOUND");
                    } catch (Exception e5) {
                        System.out.print(e5);
                    }
                }
            });
        } 
        int amt=0;
        void ThirdPage(){
            JFrame f1 =new JFrame();
            f1.setVisible(true);
            f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                   Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 0),
                    getWidth(), getHeight(), new Color(0, 0,0, 255), true);
                   Graphics2D g2d = (Graphics2D)g;
                   g2d.setPaint(p);
                   g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            f1.setContentPane(panel);
            JPanel panel1 = new JPanel();
            panel.setLayout(null);
            panel.add(panel1);
            panel1.setLayout(null);
            panel1.setBounds(400, 200, 700, 450);
            JLabel l1 = new JLabel("ENTER YOUR AMOUNT");
            l1.setBounds(275, 0, 200, 50);
            l1.setFont(new Font("Comic Sans MS ", Font.PLAIN, 15));
            JButton b1 = new JButton("1");
            b1.setBounds(225, 50, 50, 50);
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.white);
            JButton b2 = new JButton("2");
            b2.setBounds(325, 50, 50, 50);
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.white);
            JButton b3 = new JButton("3");
            b3.setBounds(425, 50, 50, 50);
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.white);
            JButton b4 = new JButton("4");
            b4.setBounds(225, 150, 50, 50);
            b4.setBackground(Color.BLACK);
            b4.setForeground(Color.white);
            JButton b5 = new JButton("5");
            b5.setBounds(325, 150, 50, 50);
            b5.setBackground(Color.BLACK);
            b5.setForeground(Color.white);
            JButton b6 = new JButton("6");
            b6.setBounds(425, 150, 50, 50);
            b6.setBackground(Color.BLACK);
            b6.setForeground(Color.white);
            JButton b7 = new JButton("7");
            b7.setBounds(225, 250, 50, 50);
            b7.setBackground(Color.BLACK);
            b7.setForeground(Color.white);
            JButton b8 = new JButton("8");
            b8.setBounds(325, 250, 50, 50);
            b8.setBackground(Color.BLACK);
            b8.setForeground(Color.white);
            JButton b9 = new JButton("9");
            b9.setBounds(425, 250, 50, 50);
            b9.setBackground(Color.BLACK);
            b9.setForeground(Color.white);
            JButton b10 = new JButton("X");
            b10.setBounds(225, 350, 50, 50);
            b10.setBackground(Color.BLACK);
            b10.setForeground(Color.white);
            JButton b11 = new JButton("0");
            b11.setBounds(325, 350, 50, 50);
            b11.setBackground(Color.BLACK);
            b11.setForeground(Color.white);
            JButton b12 = new JButton("->");
            b12.setBounds(425, 350, 50, 50);
            b12.setBackground(Color.BLACK);
            b12.setForeground(Color.white);
            panel1.add(l1);
            panel1.add(b1);
            panel1.add(b2);
            panel1.add(b3); 
            panel1.add(b4);
            panel1.add(b5);
            panel1.add(b6);
            panel1.add(b7);
            panel1.add(b8);
            panel1.add(b9);
            panel1.add(b10);
            panel1.add(b11);
            panel1.add(b12);
            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+1;
                    l1.setText(""+amt);
                }
            });
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+2;
                    l1.setText(""+amt);
                }
            });
            b3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+3;
                    l1.setText(""+amt);
                }
            });
            b4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+4;
                    l1.setText(""+amt);
                }
            });
            b5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+5;
                    l1.setText(""+amt);
                }
            });
            b6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+6;
                    l1.setText(""+amt);
                }
            });
            b7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+7;
                    l1.setText(""+amt);
                }
            });
            b8.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+8;
                    l1.setText(""+amt);
                }
            });
            b9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+9;
                    l1.setText(""+amt);
                }
            });
            b10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=amt/10;
                    l1.setText(""+amt);
                }
            });
            b11.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    amt=(amt*10)+0;
                    l1.setText(""+amt);
                }
            });
            b12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/upi", "root",
                                "root");
                        Statement stmt = conn.createStatement();
                        String query1 = "select * from account";
                        ResultSet rs = stmt.executeQuery(query1);
                        while(rs.next()){
                            if(amt<= rs.getInt("account_balance")-100){
                                FourthPage();
                            }
                        }
                    } catch (Exception e5) {
                        System.out.print(e5);
                    }
                }
            });
        }
        void FourthPage(){
            JFrame f1 =new JFrame();
            f1.setVisible(true);
            f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                   Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 0),
                    getWidth(), getHeight(), new Color(0, 0,0, 255), true);
                   Graphics2D g2d = (Graphics2D)g;
                   g2d.setPaint(p);
                   g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            f1.setContentPane(panel);
            JPanel panel1 = new JPanel();
            panel.setLayout(null);
            panel.add(panel1);
            panel1.setLayout(null);
            panel1.setBounds(400, 200, 700, 450);
            JLabel l1 = new JLabel("TRANSITION COMPLETED");
            l1.setBounds(105, 100, 300, 50);
            l1.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
            panel1.add(l1);
            JLabel l2 = new JLabel("TAKE YOUR MONEY");
            l2.setBounds(105, 200, 300, 50);
            l2.setFont(new Font("Comic Sans MS ", Font.PLAIN, 20));
            panel1.add(l1);
            panel1.add(l2);
        }
}
public class Atminterface{
    public static void main(String[] args) {  
        Framework f1 = new Framework();
    }
}
/*
JFrame f1 =new JFrame();
            f1.setVisible(true);
            f1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel panel = new JPanel() {
                protected void paintComponent(Graphics g) {
                   Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 0),
                    getWidth(), getHeight(), new Color(0, 0,0, 255), true);
                   Graphics2D g2d = (Graphics2D)g;
                   g2d.setPaint(p);
                   g2d.fillRect(0, 0, getWidth(), getHeight());
                }
            };
            f1.setContentPane(panel);
            JPanel panel1 = new JPanel();
            panel.setLayout(null);
            panel.add(panel1);
            panel1.setLayout(null);
            panel1.setBounds(400, 200, 700, 450);
 */