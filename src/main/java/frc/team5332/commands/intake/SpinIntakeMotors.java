package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.util.Calendar;
import main.java.frc.team5332.robot.CMap;

public class SpinIntakeMotors extends Command {




    public SpinIntakeMotors(){
        //requires(CMap.intake);
    }

    @Override
    protected void execute() {

        //System.out.println("I AM RUNNING. I SHOULKD BE READY TO SPIN");
        //System.out.println("LEFT TRIGGER: " + CMap.gamepad.getRawAxis(CMap.leftTriggerAxis) +  " at " + Calendar.getInstance().get(Calendar.SECOND));

        if(CMap.gamepad.getRawAxis(CMap.leftTriggerAxis) >= 0.75 && !CMap.motorsExpelling){
            if(!CMap.leftTriggerPreviouslyPressed){
                if(!CMap.motorsIntaking){
                    CMap.intake.spinRollers(1);
                } else {
                    CMap.intake.spinRollers(0);
                }

                CMap.motorsIntaking = !CMap.motorsIntaking;
                CMap.leftTriggerPreviouslyPressed = true;
            }
        } else {
            CMap.leftTriggerPreviouslyPressed = false;
        }

        if(CMap.gamepad.getRawAxis(CMap.rightTriggerAxis) >= 0.75 && !CMap.motorsIntaking){
            if(!CMap.rightTriggerPreviouslyPressed){
                if(!CMap.motorsExpelling){
                    CMap.intake.spinRollers(-1);
                } else {
                    CMap.intake.spinRollers(0);
                }

                CMap.motorsExpelling = !CMap.motorsExpelling;
                CMap.rightTriggerPreviouslyPressed = true;
            }
        } else {
            CMap.rightTriggerPreviouslyPressed = false;
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
