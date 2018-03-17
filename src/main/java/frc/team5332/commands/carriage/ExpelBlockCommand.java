package main.java.frc.team5332.commands.carriage;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class ExpelBlockCommand extends Command {

    public ExpelBlockCommand(){

    }

    public void execute(){
        CMap.carriage.expelCube();
    }

    protected boolean isFinished(){
        return false;
    }

    protected void end(){
        CMap.carriage.stopMotors();
    }

}
