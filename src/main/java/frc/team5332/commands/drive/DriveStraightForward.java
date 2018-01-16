package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class DriveStraightForward extends Command {

    public DriveStraightForward(){
        requires(CMap.drive);
    }

    public void execute(){
        CMap.drive.tankDrive(1, 1);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.drive.stopMotors();
    }
}
