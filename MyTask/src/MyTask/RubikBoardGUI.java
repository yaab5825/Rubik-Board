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


public class RubikBoardGUI extends JFrame
{
    
    JPanel panel;
    JPanel buttonN;
    JPanel buttonS;
    JPanel buttonW;
    JPanel buttonE;
    
    
    JLabel p[][];
    JButton bN[];
    JButton bS[];
    JButton bW[];
    JButton bE[];
    
    int dim;
    int cnt=0;
    
    public RubikBoardGUI(int d)
    {
        dim = d;
        p = new JLabel[dim][dim];
        bN = new JButton[dim];
        bS = new JButton[dim];
        bW = new JButton[dim];
        bE = new JButton[dim];
        
        
        buttonN = new JPanel();
        buttonN.setLayout(new GridLayout(1, dim, 2, 2));
        for(int i=0; i<dim; i++)
        {
        bN[i] = new JButton("Up");
        bN[i].setBackground(Color.WHITE);
        bN[i].addActionListener(new Listener1(i));
        buttonN.add(bN[i]);
        }
        add(BorderLayout.NORTH, buttonN);
        
        
        
        
        buttonS = new JPanel();
        buttonS.setLayout(new GridLayout(1, dim, 2, 2));
        for(int i=0; i<dim; i++)
        {
        bS[i] = new JButton("Down");
        bS[i].setBackground(Color.WHITE);
        bS[i].addActionListener(new Listener2(i));
        buttonS.add(bS[i]);
        }
        add(BorderLayout.SOUTH, buttonS);
        
        
        
        buttonE = new JPanel();
        buttonE.setLayout(new GridLayout(dim, 1, 2, 2));
        for(int i=0; i<dim; i++)
        {
        bE[i] = new JButton("Right");
        bE[i].setBackground(Color.WHITE);
        bE[i].addActionListener(new Listener3(i));
        buttonE.add(bE[i]);
        }
        add(BorderLayout.EAST, buttonE);
        
        
        
        
        buttonW = new JPanel();
        buttonW.setLayout(new GridLayout(dim, 1, 2, 2));
        for(int i=0; i<dim; i++)
        {
        bW[i] = new JButton("Left");
        bW[i].setBackground(Color.WHITE);
        bW[i].addActionListener(new Listener4(i));
        buttonW.add(bW[i]);
        }
        add(BorderLayout.WEST, buttonW);
        
        
        Generate_Color();
    }
    
    
    static int[] Random_Numbers (int from, int to)
    {
        int n = to - from +1;
        int numb[] = new int[n];
        for (int i=0; i<n; i++)
        {
            numb[i]=i;
        }
        int res[] = new int[n];
        int x=n;
        SecureRandom rd = new SecureRandom();
        for (int i=0; i<n; i++)
        {
            int kf=rd.nextInt(x);
            res[i]=numb[kf];
            numb[kf]=numb[x-1];
            x--;
        }
        return res;
    }
    
    
    
    private void Generate_Color()
    {
    panel = new JPanel();
    panel.setLayout(new GridLayout(dim, dim, 2, 2));
        for(int i=0; i<dim; i++)
        {
            int num[] = Random_Numbers(0, dim-1);
            for(int j=0; j<dim; j++)
            {
                p[i][j] = new JLabel();
                p[i][j].setOpaque(true);
                if(num[j]==0)
                {
                p[i][j].setBackground(Color.PINK);
                }
                else if(num[j]==1)
                {
                p[i][j].setBackground(Color.RED);
                }
                else if(num[j]==2)
                {
                p[i][j].setBackground(Color.YELLOW);
                }
                else if(num[j]==3)
                {
                p[i][j].setBackground(Color.BLUE);
                }
                else if(num[j]==4)
                {
                p[i][j].setBackground(Color.ORANGE);
                }
                else
                {
                p[i][j].setBackground(Color.GREEN);
                }
                panel.add(p[i][j]);
            }
        }
        add(BorderLayout.CENTER, panel);
    }
    
    
    private void Shuffle()
    {
        for(int i=0; i<dim; i++)
        {
            int num[] = Random_Numbers(0, dim-1);
            for(int j=0; j<dim; j++)
            {
                if(num[j]==0)
                {
                p[i][j].setBackground(Color.PINK);
                }
                else if(num[j]==1)
                {
                p[i][j].setBackground(Color.RED);
                }
                else if(num[j]==2)
                {
                p[i][j].setBackground(Color.YELLOW);
                }
                else if(num[j]==3)
                {
                p[i][j].setBackground(Color.BLUE);
                }
                else if(num[j]==4)
                {
                p[i][j].setBackground(Color.ORANGE);
                }
                else
                {
                p[i][j].setBackground(Color.GREEN);
                }
            }
        }
    }
    
    private void check2()
     {
        int check[] = new int[2];
        for(int i=0; i<2; i++)
        {
           check[i]=0;
        }
        for(int i=0; i<2; i++)
        {
         if(p[i][0].getBackground()==p[i][1].getBackground() || p[0][i].getBackground()==p[1][i].getBackground())
                    {
                        check[i]=1;
                    }            
        }
            if(check[0]==1&&check[1]==1)
        {
                JOptionPane.showMessageDialog(null, "You have Win!   Number of steps are: "+cnt);
                Shuffle();
                cnt=0;
        }
    }
    
    
    
     private void check4()
     {
        int check[] = new int[4];
        for(int i=0; i<4; i++)
        {
            check[i]=0;
        }
        for(int i=0; i<4; i++)
        {
                    if(p[i][0].getBackground()==p[i][1].getBackground()
                            &&p[i][1].getBackground()==p[i][2].getBackground()
                            &&p[i][2].getBackground()==p[i][3].getBackground()
                            ||p[0][i].getBackground()==p[1][i].getBackground()
                            &&p[1][i].getBackground()==p[2][i].getBackground()
                            &&p[2][i].getBackground()==p[3][i].getBackground())
                    {
                        check[i]=1;
                    }            
        }
            if(check[0]==1&&check[1]==1&&check[2]==1&&check[3]==1){
                JOptionPane.showMessageDialog(null, "You have Win!   Number of steps are: "+cnt);
                Shuffle();
                cnt=0;
        }
    }
     
     
    private void check6()
    {
        int check[] = new int[6];
        for(int i=0; i<6; i++){check[i]=0;}
        for(int i=0; i<6; i++)
        {
                    if(p[i][0].getBackground()==p[i][1].getBackground()
                            &&p[i][1].getBackground()==p[i][2].getBackground()
                            &&p[i][2].getBackground()==p[i][3].getBackground()
                            &&p[i][3].getBackground()==p[i][4].getBackground()
                            &&p[i][4].getBackground()==p[i][5].getBackground()
                            ||p[0][i].getBackground()==p[1][i].getBackground()
                            &&p[1][i].getBackground()==p[2][i].getBackground()
                            &&p[2][i].getBackground()==p[3][i].getBackground()
                            &&p[3][i].getBackground()==p[4][i].getBackground()
                            &&p[4][i].getBackground()==p[5][i].getBackground()){
                        check[i]=1;
                    }            
        }
            if(check[0]==1&&check[1]==1&&check[2]==1&&check[3]==1&&check[4]==1&&check[5]==1){
                JOptionPane.showMessageDialog(null, "You have Win!   Number of steps are: "+cnt);
                Shuffle();
                cnt=0;
        }
    }
     
     
    

    class Listener1 implements ActionListener
    {
        private final int o;
        public Listener1(int i) 
        {
            this.o = i;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            cnt=cnt+1;
            Color a;
            a = p[dim-1][o].getBackground();
            for(int i=dim-1; i>0; i--)
            {
                p[i][o].setBackground(p[i-1][o].getBackground());
            }
            p[0][o].setBackground(a);
            if(dim == 6)
            {
                check6();
            }
            else if(dim==4)
            {
                check4();
            }
            else if(dim==2)
            {
                check2();
            }
        }
    }
    
    class Listener2 implements ActionListener 
    {
        private final int o;
        public Listener2(int i) {
            this.o = i;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            cnt=cnt+1;
            Color a;
            a = p[0][o].getBackground();
            for(int i=0; i<dim-1; i++)
            {
                p[i][o].setBackground(p[i+1][o].getBackground());
            }
            p[dim-1][o].setBackground(a);
            if(dim == 6)
            {
                check6();
            }
            else if(dim==4)
            {
                check4();
            }
            else if(dim==2){
                check2();
            }
        }
    }
     
    class Listener3 implements ActionListener 
    {
        private final int o;
        public Listener3(int i) 
        {
            this.o = i;
        }
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            cnt=cnt+1;
            Color a;
            a = p[o][0].getBackground();
            for(int i=0; i<dim-1; i++)
            {
                p[o][i].setBackground(p[o][i+1].getBackground());
            }
            p[o][dim-1].setBackground(a);
            if(dim == 6){check6();}
            else if(dim==4){check4();}
            else if(dim==2){check2();}
        }
    }
     
    class Listener4 implements ActionListener 
    {
        private final int o;
        public Listener4(int i) {
            this.o = i;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            cnt=cnt+1;
            Color a;
            a = p[o][dim-1].getBackground();
            for(int i=dim-1; i>0; i--)
            {
                p[o][i].setBackground(p[o][i-1].getBackground());
            }
            p[o][0].setBackground(a);
            if(dim == 6){check6();}
            else if(dim==4){check4();}
            else if(dim==2){check2();}
        }
    }
    
    
    
}
