package main.java.frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class JoystickElevator extends Command {

    public JoystickElevator() {
        requires(CMap.elevator);
    }

    public void execute() {
        CMap.elevator.setMotorSpeed(CMap.operatorJoystick.getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.elevator.stopMotor();
    }

}