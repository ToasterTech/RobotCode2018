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

    public GetAutoRoutine(){

        routinePicked = false;

    }

    @Override
    protected void execute() {
        super.execute();

        if(DriverStation.getInstance().getGameSpecificMessage().length() == 3) {
            CMap.plateOwnership = DriverStation.getInstance().getGameSpecificMessage();
            positionSelected    = SmartDashboard.getString("DB/String 9", "M").toUpperCase();

            SmartDashboard.putString("DB/String 5", "Received Plates");
            if (SmartDashboard.getBoolean("DB/Button 0", false)) {
                SmartDashboard.putString("DB/String 6", "NORMAL PREFERENCE SYSTEM");
                normalPreferenceSystem();
                routinePicked = true;
            } else if (SmartDashboard.getBoolean("DB/Button 1", false)) {
                SmartDashboard.putString("DB/String 6", "SCALE SYSTEM");
                scalePreferenceSystem();
                routinePicked = true;
            } else if (SmartDashboard.getBoolean("DB/Button 2", false)) {
                SmartDashboard.putString("DB/String 6", "SWITCH SYSTEM");
                switchPreferenceSystem();
                routinePicked = true;
            } else if (SmartDashboard.getBoolean("DB/Button 3", false)) {
                SmartDashboard.putString("DB/String 6", "AUTO RUN");
                autoRunPreferenceSystem();
                routinePicked = true;
            }
        } else {
            SmartDashboard.putString("DB/String 5", "Waiting for Plates");
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
