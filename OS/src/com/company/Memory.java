package com.company;


public class Memory {
    MemoryCell[] memory;
    public Memory(){
        this.memory= new MemoryCell[1000];
    }
}
class MemoryCell {
    Robot robot;
    MoveInFourDirections direction;
    public MemoryCell(Robot robot,MoveInFourDirections direction){
        this.robot=robot;
        this.direction=direction;
    }
}