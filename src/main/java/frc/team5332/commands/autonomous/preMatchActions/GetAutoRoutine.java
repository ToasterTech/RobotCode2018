package main.java.frc.team5332.commands.autonomous.preMatchActions;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.commands.autonomous.routines.*;
import main.java.frc.team5332.robot.CMap;

import java.awt.color.CMMException;

public class GetAutoRoutine extends Command {
    boolean routinePicked = false;

    public GetAutoRoutine(){

        if(CMap.autoPreference.equals("Normal")){
            normalPreferenceSystem();
        } else if(CMap.autoPreference.equals("Scale")){
            scalePreferenceSystem();
        } else if(CMap.autoPreference.equals("Switch")){
            switchPreferenceSystem();
        } else if(CMap.autoPreference.equals("Exchange")){
        exchangePreferenceSystem();
        }

        routinePicked = true;

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
    }

    @Override
    protected boolean isFinished() {
        return routinePicked;
    }
}
