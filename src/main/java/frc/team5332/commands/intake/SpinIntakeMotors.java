package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.sql.Time;
import java.util.Calendar;

public class SpinIntakeMotors extends Command {
    boolean leftTriggerPreviouslyPressed = false,
            rightTriggerPreviouslyPressed = false,
            motorsIntaking = false;



    public SpinIntakeMotors(){
        //requires(CMap.intake);
    }

    @Override
    protected void execute() {

        System.out.println("I AM RUNNING. I SHOULKD BE READY TO SPIN");
        System.out.println("LEFT TRIGGER: " + CMap.gamepad.getRawAxis(CMap.leftTriggerAxis) +  " at " + Calendar.getInstance().get(Calendar.SECOND));

        if(CMap.gamepad.getRawAxis(CMap.rightTriggerAxis) >= 0.75){
            if(!leftTriggerPreviouslyPressed){
                if(!motorsIntaking){
                    CMap.intake.spinMotors(1);
                } else {
                    CMap.intake.spinMotors(0);
                }

                motorsIntaking = !motorsIntaking;
                leftTriggerPreviouslyPressed = true;
            }
        } else {
            leftTriggerPreviouslyPressed = false;
        }

        /*
        if(CMap.gamepad.getRawAxis(CMap.leftTriggerAxis) >= 0.75){
            CMap.intake.spinMotors(-1);
        } else if(CMap.gamepad.getRawAxis(CMap.rightTriggerAxis) >= 0.75){
            CMap.intake.spinMotors(1);
        } else {
            CMap.intake.stopMotors();
        }*/
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        System.out.println("I AM DEAD");
    }
}
