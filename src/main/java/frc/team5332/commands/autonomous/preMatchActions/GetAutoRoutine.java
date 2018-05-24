package main.java.frc.team5332.commands.autonomous.preMatchActions;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.routines.*;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.robot.CMap;

import java.awt.color.CMMException;

public class GetAutoRoutine extends Command {
    boolean routinePicked = false;
    Command autonmousRoutine;

    private String positionSelected, routineSelected;

    String message;

    private SendableChooser<String> positionSendable, routineSendable;

    public GetAutoRoutine(){
        positionSendable = (SendableChooser<String>)SmartDashboard.getData("Position Chooser");
        routineSendable = (SendableChooser<String>)SmartDashboard.getData("Auto Chooser");

        routinePicked = false;

    }

    @Override
    protected void execute() {
        super.execute();

        if(DriverStation.getInstance().getGameSpecificMessage().length() == 3) {

            System.out.println("GOT GAME SPECIFIC MESSAGE");
            SmartDashboard.putString("DB/String 5", "Saving Message");

            message = DriverStation.getInstance().getGameSpecificMessage();
            CMap.plateOwnership = message;
            try {
                //position = SmartDashboard.getString("DB/String 6", "M").charAt(0);
                positionSelected = positionSendable.getSelected();

                SmartDashboard.putString("Translated Position", String.valueOf(positionSelected));
                routineSelected = routineSendable.getSelected();


            } catch(Exception e){
                DriverStation.reportError("Error Getting Selected Position", e.getStackTrace());
                positionSelected = CMap.centerPos;
            }

            SmartDashboard.putString("DB/String 5", "Received Plates");

            if(routineSelected.equals(CMap.normal)){
                System.out.println("NORMAL");
                //normalPreferenceSystem();
                routinePicked = true;
            } else if(routineSelected.equals(CMap.scaleOnly)){
                System.out.println("SCALE");
                //scalePreferenceSystem();
                routinePicked = true;
            } else if(routineSelected.equals(CMap.switchOnly)) {
                System.out.println("SWITCH");
                //switchPreferenceSystem();
                routinePicked = true;
            } else {
                System.out.println("AUTO RUN");
                // autoRunPreferenceSystem();
                routinePicked = true;
            }
            //switchPreferenceSystem();
            //Scheduler.getInstance().add(new TimeDrive(.65, 0.3, -0.3));
            routinePicked = true;
        }

    }

    private void normalPreferenceSystem(){
        switch (positionSelected){

            case CMap.leftPos:
                if(CMap.plateOwnership.charAt(1) == 'L'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide(CMap.leftPos.charAt(0)));
                } else if(CMap.plateOwnership.charAt(0) == 'L') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide(CMap.leftPos.charAt(0)));
                } else {
                    Scheduler.getInstance().add(new AutoRun());
                }
                break;

            case CMap.rightPos:
                if(CMap.plateOwnership.charAt(1) == 'R'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide(CMap.rightPos.charAt(0)));
                } else if(CMap.plateOwnership.charAt(0) == 'R') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide(CMap.rightPos.charAt(0)));
                } else {
                    Scheduler.getInstance().add(new AutoRun());
                }
                break;

            case CMap.centerPos:
                Scheduler.getInstance().add(new AutoSwitchFromMiddle(message.charAt(0)));
                break;

        }
    }

    private void scalePreferenceSystem(){
        if(message.charAt(1) == positionSelected.charAt(0)){
            Scheduler.getInstance().add(new AutoScaleSameSide(positionSelected.charAt(0)));
        } else {
            Scheduler.getInstance().add(new AutoRun());
        }
    }

    private void switchPreferenceSystem(){
        if(message.charAt(0) == positionSelected.charAt(0)){
            Scheduler.getInstance().add(new AutoSwitchSameSide(positionSelected.charAt(0)));
        } else {
            if(positionSelected.charAt(0) == CMap.centerPos.charAt(0)){
                Scheduler.getInstance().add(new AutoSwitchFromMiddle(message.charAt(0)));
            } else {
                Scheduler.getInstance().add(new AutoRun());
            }
        }
    }


    private void autoRunPreferenceSystem(){
        autonmousRoutine = new AutoRun();
        routinePicked = true;
    }

    @Override
    protected boolean isFinished() {
        return routinePicked;
    }

    @Override
    protected void end() {
        Scheduler.getInstance().add(autonmousRoutine);
    }
}
