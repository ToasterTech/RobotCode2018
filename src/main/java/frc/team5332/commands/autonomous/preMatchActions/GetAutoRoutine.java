package main.java.frc.team5332.commands.autonomous.preMatchActions;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.routines.*;
import main.java.frc.team5332.robot.CMap;

import java.awt.color.CMMException;

public class GetAutoRoutine extends Command {
    boolean routinePicked = false;

    public GetAutoRoutine(){



        routinePicked = false;

    }

    @Override
    protected void execute() {
        super.execute();

        if(DriverStation.getInstance().getGameSpecificMessage().length() == 3) {
            SmartDashboard.putString("DB/String 5", "Received Plates");
            if (SmartDashboard.getBoolean("DB/Button 0", false)) {
                System.out.println("NORMAL PREFERENCE SYSTEM");
                routinePicked = true;
            } else if (SmartDashboard.getBoolean("DB/Button 1", false)) {
                System.out.println("SCALE SYSTEM");
                routinePicked = true;
            } else if (SmartDashboard.getBoolean("DB/Button 2", false)) {
                System.out.println("SWITCH SYSTEM");
                routinePicked = true;
            } else if (SmartDashboard.getBoolean("DB/Button 3", false)) {
                System.out.println("AUTO RUN");
                routinePicked = true;
            }
        }

    }

    private void normalPreferenceSystem(){
        switch (CMap.startingSpot){

            case 'L':
                if(CMap.plateOwnership.charAt(1) == 'L'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide());
                } else if(CMap.plateOwnership.charAt(0) == 'L') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide());
                } else {
                    Scheduler.getInstance().add(new AutoScaleOppositeSide());
                }
                break;

            case 'R':
                if(CMap.plateOwnership.charAt(1) == 'R'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide());
                } else if(CMap.plateOwnership.charAt(0) == 'R') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide());
                } else {
                    Scheduler.getInstance().add(new AutoScaleOppositeSide());
                }
                break;

            case 'M':
                Scheduler.getInstance().add(new AutoSwitchFromMiddle());
                break;

        }
    }

    private void scalePreferenceSystem(){
        if(Character.toString(CMap.plateOwnership.charAt(1)).equals(String.valueOf(CMap.startingSpot))){
            Scheduler.getInstance().add(new AutoScaleSameSide());
        } else {
            Scheduler.getInstance().add(new AutoScaleOppositeSide());
        }
    }

    private void switchPreferenceSystem(){
        if(Character.toString(CMap.plateOwnership.charAt(0)).equals(String.valueOf(CMap.startingSpot))){
            Scheduler.getInstance().add(new AutoSwitchSameSide());
        } else {
            if(CMap.startingSpot == 'L' || CMap.startingSpot == 'R'){
                Scheduler.getInstance().add(new AutoSwitchOppositeSide());
            } else {
                //Middle Starting Spot
                Scheduler.getInstance().add(new AutoSwitchFromMiddle());
            }
        }
    }

    private void exchangePreferenceSystem(){
        if(CMap.startingSpot == 'L'){
            Scheduler.getInstance().add(null);
        } else if(CMap.startingSpot == 'R'){
            Scheduler.getInstance().add(null);
        }else if(CMap.startingSpot == 'M'){
            Scheduler.getInstance().add(null);
        }
    }

    private void autoRunPreferenceSystem(){
        Scheduler.getInstance().add(new AutoRun());
        routinePicked = true;
    }

    @Override
    protected boolean isFinished() {
        return routinePicked;
    }

    @Override
    protected void end() {
        System.out.println("Received Auto routine");
    }
}
