package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void Grid(){
        JFrame F = new JFrame();
        JLabel L= new JLabel();
        JPanel P = new JPanel(new GridLayout());
        L.add(P);
        P.setBounds(567, 100, 200, 70);
        F.add(L);
        L.setVisible(true);
        P.setOpaque(false);
        L.setVisible(true);
        L.setOpaque(false);
        F.setVisible(true);
        F.setTitle("a7eih");
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        F.revalidate();
    }
    public static void main(String[]args){
        Grid();
    }
}
