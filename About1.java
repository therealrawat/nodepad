package notepad;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class About1 extends JFrame implements ActionListener {
    
    About1()
    {
        setTitle("About");
        setSize(500, 400);
        setLayout(null);
        ImageIcon img = new ImageIcon(getClass().getResource("UIM38.png"));
        setIconImage(img.getImage());
        setResizable(false);
        
        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("notepad/icons/UIM38.png"));
        Image image2 = image1.getImage().getScaledInstance(100, 75, Image.SCALE_DEFAULT);
        ImageIcon image3 = new ImageIcon(image2);
        JLabel l1 = new JLabel(image3);
        l1.setBounds(200, 20, 100, 75);
        add(l1);
        

        JLabel l3 = new JLabel("<html>Notepad<br>Version1.0<br>Developed by Priyanshu Rawat<br>UIM21222000038<br>All right reserved<br><br>This notepad is part of the mini project for semester 1. The main objective of the notepad is to proccess words in digital format into the device based on user output.");
        l3.setBounds(30, 100, 400, 200);
        l3.setFont(new Font("Arial", Font.PLAIN, 13));
        add(l3);
        
        JButton button1 = new JButton("OK");
        button1.setBackground(new Color(25, 25, 25));
        button1.setForeground(new Color(255, 255, 255));
        button1.setBounds(210, 300, 80, 25);
        button1.addActionListener(this);
        add(button1);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        this.setVisible(false);
//        new Notepad().setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new About1().setVisible(true);
    }
}
