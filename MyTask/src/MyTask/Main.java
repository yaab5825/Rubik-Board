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
public class Main 
{
    
    public static void main(String[] args)
    {
        
        RubikBoard gui;
        gui = new RubikBoard();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.getContentPane().setBackground(Color.YELLOW);
        gui.setSize(300, 150);
        gui.setVisible(true);
        gui.setTitle("Rubik Board");
        gui.setLocationRelativeTo(null);
        JLabel label = new JLabel ("Please Select Board Size");
        gui.add(label);
    }
    
}
