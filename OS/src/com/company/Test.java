package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

//Java program to control the Main Thread
public class Test {
    static Queue Ready;
    static Queue Running;
    static Queue Blocking;


    static Memory m;
    static Board x = new Board();

    public static void main(String[] args) {
        m = new Memory();
        Ready = new LinkedList();
        Running = new LinkedList();
        Blocking = new LinkedList();

        ChildThread x = new ChildThread();
        ChildThread2 y = new ChildThread2();

        x.start();
        y.start();
        // for(int i=0;i<1000;i++)
        // System.out.println("sss");

    }

}

// Child Thread class
class ChildThread extends Thread {
    @Override
    public void run() {
        Queue Ready= Test.Ready;
        Queue Running=Test.Running;
        Queue Blocking=Test.Blocking;
        Board x = Test.x;
        Memory m = Test.m;
        Robot r1;
        try {
            r1 = new Robot("abdo", 0, 0, x, m,Ready,Running,Blocking);
//
//			r1.Move(MoveInFourDirections.RIGHT);
//			System.out.println(m.memory[0].direction.toString());
//			System.out.println(m.memory[0].robot.getName());
//
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

class ChildThread2 extends Thread {
    @Override
    public void run() {
        Queue Ready= Test.Ready;
        Queue Running=Test.Running;
        Queue Blocking=Test.Blocking;
        Board x = Test.x;
        Memory m = Test.m;
        Robot r1;
        try {
            r1 = new Robot("joe", 0, 2, x, m,Ready,Running,Blocking);
            r1.Move(MoveInFourDirections.LEFT);
            System.out.println(m.memory[50].direction.toString());
            System.out.println(m.memory[50].robot.getName());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
