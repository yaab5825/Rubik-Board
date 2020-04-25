/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTask;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.SecureRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author zafar
 */


public class RubikBoard extends JFrame 
{

    private JButton button1;
    private JButton button2;
    private JButton button3;
    
    public RubikBoard()
    {
      
        setLayout(new FlowLayout());
        
        button1 = new JButton("2x2 size");
        button1.setBackground(Color.PINK);
        add(button1);
        event1 e1 = new event1();
        button1.addActionListener(e1);
        
        
        button2 = new JButton("4x4 size");
        button2.setBackground(Color.GREEN);
        add(button2);
        event2 e2 = new event2();
        button2.addActionListener(e2);
        
        
        button3 = new JButton("6x6 size");
        button3.setBackground(Color.RED);
        add(button3);
        event3 e3 = new event3();
        button3.addActionListener(e3);
        
    }
    
    
    
   
    public class event1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e1)
        {
            RubikBoardGUI gui1;
            gui1 = new RubikBoardGUI(2);
            gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui1.setLocationRelativeTo(null);
            gui1.setSize(300, 300);
            gui1.setVisible(true);
            gui1.setTitle("2*2 Case");
        }
    }
    
    
    public class event2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e2)
        {
            RubikBoardGUI gui1;
            gui1 = new RubikBoardGUI(4);
            gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui1.setLocationRelativeTo(null);
            gui1.setSize(450, 450);
            gui1.setVisible(true);
            gui1.setTitle("4*4 Case");
        }
    }
    
    
    public class event3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e3)
        {
            RubikBoardGUI gui1;
            gui1 = new RubikBoardGUI(6);
            gui1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui1.setLocationRelativeTo(null);
            gui1.setSize(570, 570);
            gui1.setVisible(true);
            gui1.setTitle("6*6 Case");
        }
    }
    
    
}
