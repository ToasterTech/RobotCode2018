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
        CMap.drive.tankDrive(CMap.gamepad.getRawAxis(CMap.leftYAXis), CMap.gamepad.getRawAxis(CMap.rightYAxis));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }
}
