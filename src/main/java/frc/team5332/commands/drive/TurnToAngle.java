package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class TurnToAngle extends Command {
    double setpoint;

    public TurnToAngle(double targetAngle){
        setpoint = targetAngle;
        requires(CMap.drive);
    }

    public void execute(){

        CMap.drive.getPIDController().enable();
        CMap.drive.getPIDController().setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished() {
        return CMap.drive.getPIDController().onTarget();
    }

    @Override
    protected void end() {
        CMap.drive.getPIDController().disable();
        CMap.drive.resetGyro();
    }
}

