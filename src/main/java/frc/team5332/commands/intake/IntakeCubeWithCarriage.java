package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class IntakeCubeWithCarriage extends Command {

    public IntakeCubeWithCarriage(){

    }

    @Override
    protected void execute() {
        System.out.println("COMMAND IS RUNNING");
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
