package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.Calendar;

public class SpinIntakeMotors extends Command {
    boolean leftTriggerPreviouslyPressed = false,
            rightTriggerPreviouslyPressed = false,
            motorsIntaking = false,
            motorsExpelling = false;



    public SpinIntakeMotors(){
        requires(CMap.intake);
    }

    @Override
    protected void execute() {

        //System.out.println("I AM RUNNING. I SHOULKD BE READY TO SPIN");
        //System.out.println("LEFT TRIGGER: " + CMap.gamepad.getRawAxis(CMap.leftTriggerAxis) +  " at " + Calendar.getInstance().get(Calendar.SECOND));

        if(CMap.gamepad.getRawAxis(CMap.leftTriggerAxis) >= 0.75 && !motorsExpelling){
            if(!leftTriggerPreviouslyPressed){
                if(!motorsIntaking){
                    CMap.intake.spinRollers(1);
                } else {
                    CMap.intake.spinRollers(0);
                }

                motorsIntaking = !motorsIntaking;
                leftTriggerPreviouslyPressed = true;
            }
        } else {
            leftTriggerPreviouslyPressed = false;
        }

        if(CMap.gamepad.getRawAxis(CMap.rightTriggerAxis) >= 0.75 && !motorsIntaking){
            if(!rightTriggerPreviouslyPressed){
                if(!motorsIntaking){
                    CMap.intake.spinRollers(-1);
                } else {
                    CMap.intake.spinRollers(0);
                }

                motorsExpelling = !motorsExpelling;
                rightTriggerPreviouslyPressed = true;
            }
        } else {
            rightTriggerPreviouslyPressed = false;
        }

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
