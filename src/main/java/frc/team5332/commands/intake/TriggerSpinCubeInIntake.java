package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.robot.CMap;

public class TriggerSpinCubeInIntake extends Command{

    int leftRollerAxis, rightRollerAxis;

    public TriggerSpinCubeInIntake(){
        requires(CMap.intake);
        leftRollerAxis = 2;
        rightRollerAxis = 3;
    }

    @Override
    protected void execute() {
        if(CMap.gamepad.getRawAxis(2) > 0.0){
            CMap.intake.spinLeftRoller(-CMap.gamepad.getRawAxis(2));
            CMap.intake.spinRightRoller(-CMap.gamepad.getRawAxis(2));
            CMap.carriage.spinLeftMotor(CMap.gamepad.getRawAxis(2));
            CMap.carriage.spinRightMotor(-CMap.gamepad.getRawAxis(2));
        } else {
            CMap.intake.spinLeftRoller(CMap.gamepad.getRawAxis(3));
            CMap.intake.spinRightRoller(CMap.gamepad.getRawAxis(3));
            CMap.carriage.spinLeftMotor(-CMap.gamepad.getRawAxis(3));
            CMap.carriage.spinRightMotor(CMap.gamepad.getRawAxis(3));
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        CMap.intake.stopRollers();
        CMap.carriage.stopMotors();
    }
}
