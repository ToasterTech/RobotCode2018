package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.Calendar;
import main.java.frc.team5332.robot.CMap;

public class SpinIntakeRollers extends Command {
    boolean timeBased;

    double motorSpeed;

    public SpinIntakeRollers(double speed){
        motorSpeed = speed;
    }


    @Override
    protected void execute() {
        CMap.intake.spinRollers(motorSpeed);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.intake.stopRollers();
    }
}
