package main.java.frc.team5332.commands.carriage;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class IntakeCubeIntoCarriage extends Command{

    public IntakeCubeIntoCarriage(){
        requires(CMap.carriage);
    }

    public void execute(){
        CMap.carriage.intakeCube();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.carriage.stopMotors();
    }



}