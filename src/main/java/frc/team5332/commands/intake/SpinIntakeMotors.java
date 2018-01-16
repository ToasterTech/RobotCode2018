package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class SpinIntakeMotors extends Command {

    public SpinIntakeMotors(){
        requires(CMap.intake);
    }

    @Override
    protected void execute() {
        if(CMap.gamepad.getRawAxis(CMap.leftTriggerAxis) >= 0.75){
            CMap.intake.spinMotors(-1);
        } else if(CMap.gamepad.getRawAxis(CMap.rightTriggerAxis) >= 0.75){
            CMap.intake.spinMotors(1);
        } else {
            CMap.intake.stopMotors();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        //Empty Because no real way to end it
    }
}
