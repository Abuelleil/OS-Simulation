package com.company;

public class Cell {
    private Robot robot;

    public Cell() {
        this.robot = null;

    }

    public Cell(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
    @Override
    public String toString() {
        if(robot != null)
            return robot.toString();

        return "n";
    }
}
