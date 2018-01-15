package main.java.frc.team5332.commands.autonomous;

import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.commands.autonomous.routines.AutoScaleOppositeSide;
import main.java.frc.team5332.commands.autonomous.routines.AutoScaleSameSide;
import main.java.frc.team5332.commands.autonomous.routines.AutoSwitchFromMiddle;
import main.java.frc.team5332.commands.autonomous.routines.AutoSwitchSameSide;
import main.java.frc.team5332.robot.CMap;

public class GetAutoRoutine {

    public GetAutoRoutine(){

        switch (CMap.startingSpot){

            case "L":
                if(CMap.plateOwnership.charAt(1) == 'L'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide("L"));
                } else if(CMap.plateOwnership.charAt(0) == 'L') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide("L"));
                } else {
                    Scheduler.getInstance().add(new AutoScaleOppositeSide("R"));
                }
                break;

            case "R":
                if(CMap.plateOwnership.charAt(1) == 'R'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide("R"));
                } else if(CMap.plateOwnership.charAt(0) == 'R') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide("R"));
                } else {
                    Scheduler.getInstance().add(new AutoScaleOppositeSide("L"));
                }
                break;

            case "M":
                Scheduler.getInstance().add(new AutoSwitchFromMiddle(CMap.plateOwnership.charAt(1)));
                break;

        }

    }



}
