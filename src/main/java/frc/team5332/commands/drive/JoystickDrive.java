package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class JoystickDrive extends Command {

    /**
     * This command drives the drive based on the joystick input.
     */
    public JoystickDrive(){
        requires(CMap.drive);
    }

    public void execute(){
        /*
        double leftValue, rightValue, leftChange, rightChange;

        leftChange = -CMap.gamepad.getRawAxis(CMap.leftYAXis) - CMap.drive.get()[0];
        leftValue = (Math.abs(leftChange) > CMap.maxChange) ? CMap.maxChange : leftChange;
        leftValue += CMap.drive.get()[0];

        rightChange = -CMap.gamepad.getRawAxis(CMap.rightYAxis) - CMap.drive.get()[1];
        rightValue = (Math.abs(rightChange) > CMap.maxChange) ? CMap.maxChange : rightChange;
        rightValue += CMap.drive.get()[1];

        CMap.drive.tankDrive(leftValue, rightValue);
        */
        CMap.drive.tankDrive(-CMap.gamepad.getRawAxis(CMap.leftYAXis), -CMap.gamepad.getRawAxis(CMap.rightYAxis));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }
}
