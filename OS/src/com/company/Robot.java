package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
public class Robot {
    private String name;
    private int Fuel;
    private int Memorypointer=-1;
    private Memory m;
    private Queue Ready;
    private Queue Running;
    private Queue Blocking;
    private static int isFueling =1;
    int i;
    int j;
    Board board;
    public Robot(String name, int i, int j, Board x,Memory m,Queue Ready,Queue Running,Queue Blocking) throws IOException {
        this.name = name;
        this.Fuel = 250;
        this.i = i;
        this.j = j;
        this.board = x;
        this.board.board[i][j].setRobot(this);
        this.m=m;
        this.Ready=Ready;
        this.Running=Running;
        this.Blocking=Blocking;
        System.out.println(this.getName()+" started on position"+i+"         "+j);
        writeSequence(this.getName()+" started");
    }
    public String getName() {
        return name;
    }
    public int getFuel() {
        return Fuel;
    }
    public void Move(MoveInFourDirections R) throws IOException {
        Ready.add(this);
        while(!Ready.peek().equals(this)){
        }
        Ready.poll();
        Running.add(this);
        switch (R) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            default:
                break;
        }

    }
    private void moveUp() throws IOException {

        int newI = ((this.i - 1) +10 )% 10;
        moves(newI, j,MoveInFourDirections.UP);

    }
    private void moveDown() throws IOException {
        int newI = (this.i + 1) % 10;
        moves(newI, j,MoveInFourDirections.DOWN);

    }
    private void moveLeft() throws IOException {
        int newJ = ((this.j - 1) +10) % 10;
        moves(i, newJ,MoveInFourDirections.LEFT);
    }
    private void moveRight() throws IOException {
        int newJ = (this.j + 1) % 10;
        moves(i, newJ,MoveInFourDirections.RIGHT);

    }
    private void moves(int newI, int newJ,MoveInFourDirections R)  throws IOException  {
        Cell old = board.getCell(this.i, this.j);
        Cell news = board.getCell(newI, newJ);
        if (board.getCell(newI, newJ).getRobot() != null) {
            System.out.println(this.getName()+"want to enter a cell which is occupied ");
            writeSequence(this.getName()+"want to enter a cell which is occupied ");

        } else {
            if(this.Fuel!=0) {
                old.setRobot(null);
                news.setRobot(this);
                this.i = newI;
                this.j = newJ;
                Printer();
                this.Fuel=this.Fuel-250;
                MemoryCell x =new MemoryCell(this,R);
                if(this.name.equals("abdo")){
                    this.Memorypointer= (this.Memorypointer+1)%50;
                    m.memory[Memorypointer]=x;
                }else{

                    this.Memorypointer= ((this.Memorypointer+1)%50)+50;
                    m.memory[Memorypointer]=x;
                    this.Memorypointer=Memorypointer-50;
                }
            }
            else {
                System.out.println(this.getName()+"has no enough Fuel ,will call reFuel method");
                writeSequence(this.getName()+"has no enough Fuel ,will call reFuel method");
                Running.poll();
                Blocking.add(this);
                reFuel();
                Blocking.poll();
                Running.add(this);
            }
        }

    }
    private void Printer() throws IOException {
        System.out.println("Location of "+this.name+" is:x-axis "+i+" ,y-axis "+j);
        writeSequence(this.getName()+"Location of "+this.name+" is:x-axis "+i+" ,y-axis "+j);


    }
    public void reFuel() throws IOException {

        this.down();
        for(int i=0;i<100000;i++) {
            this.Fuel=1000;
        }
        System.out.println(this.getName()+"is refueling now ");
        writeSequence(this.getName()+"is refueling now");
        this.up();
    }
    public void down() throws IOException {
        Boolean f=false;
        if(isFueling<=0) {
            f=true;

            while(true) {
                if(isFueling>0) {
                    break;
                }


            }
        }
        if(f) {
            System.out.println(this.getName()+"was block and is free");
            writeSequence(this.getName()+" was blocked and is free");
        }
        else {
            System.out.println(this.getName()+"was free called down without block");
            writeSequence(this.getName()+" was free called down without block");
        }
        isFueling--;
    }
    public void up( ) throws IOException {
        isFueling++;
        System.out.println(this.getName()+"called UP");
        writeSequence(this.getName()+" called UP");
    }
    public static void writeSequence(String x) throws IOException {
        File dir = new File("sequence.txt");
        FileWriter filewriter = new FileWriter(dir, true);

        BufferedWriter bw = new BufferedWriter(filewriter);
        PrintWriter out = new PrintWriter(bw);
        out.print(x+"\n");
        out.flush();
        out.close();
        filewriter.close();
    }


}
