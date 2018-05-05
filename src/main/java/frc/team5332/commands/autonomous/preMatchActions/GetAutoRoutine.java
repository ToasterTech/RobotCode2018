package main.java.frc.team5332.commands.autonomous.preMatchActions;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.routines.*;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.robot.CMap;

import java.awt.color.CMMException;

public class GetAutoRoutine extends Command {
    boolean routinePicked = false;
    Command autonmousRoutine;
    String message;
    char position;

    public GetAutoRoutine(){



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
                position = SmartDashboard.getString("DB/String 6", "M").charAt(0);
            }catch(Exception e){
                position = 'M';
            }

            System.out.println(position);

            SmartDashboard.putString("DB/String 5", "Received Plates");

            if(SmartDashboard.getBoolean("DB/Button 0", false)){
                System.out.println("NORMAL");
                normalPreferenceSystem();
                routinePicked = true;
            } else if(SmartDashboard.getBoolean("DB/Button 1", false)){
                System.out.println("SCALE");
                scalePreferenceSystem();
                routinePicked = true;
            } else if(SmartDashboard.getBoolean("DB/Button 2", false)) {
                System.out.println("SWITCH");
                switchPreferenceSystem();
                routinePicked = true;
            } else {
                System.out.println("AUTO RUN");
                autoRunPreferenceSystem();
                routinePicked = true;
            }
            //switchPreferenceSystem();
            //Scheduler.getInstance().add(new TimeDrive(.65, 0.3, -0.3));
            routinePicked = true;
        }

    }

    private void normalPreferenceSystem(){
        switch (position){

            case 'L':
                if(CMap.plateOwnership.charAt(1) == 'L'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide(position));
                } else if(CMap.plateOwnership.charAt(0) == 'L') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide(position));
                } else {
                    Scheduler.getInstance().add(new AutoRun());
                }
                break;

            case 'R':
                if(CMap.plateOwnership.charAt(1) == 'R'){ //Scale
                    Scheduler.getInstance().add(new AutoScaleSameSide(position));
                } else if(CMap.plateOwnership.charAt(0) == 'R') { //Switch
                    Scheduler.getInstance().add(new AutoSwitchSameSide(position));
                } else {
                    Scheduler.getInstance().add(new AutoRun());
                }
                break;

            case 'M':
                Scheduler.getInstance().add(new AutoSwitchFromMiddle(message.charAt(0)));
                break;

        }
    }

    private void scalePreferenceSystem(){
        if(message.charAt(1) == position){
            Scheduler.getInstance().add(new AutoScaleSameSide(position));
        } else {
            Scheduler.getInstance().add(new AutoRun());
        }
    }

    private void switchPreferenceSystem(){
        if(message.charAt(0) == position){
            Scheduler.getInstance().add(new AutoSwitchSameSide(position));
        } else {
            if(position == 'L' || position == 'R'){
                Scheduler.getInstance().add(new AutoRun());
            } else {
                //Middle Starting Spot
                Scheduler.getInstance().add(new AutoSwitchFromMiddle(message.charAt(0)));
            }
        }
    }

    private void exchangePreferenceSystem(){
        if(position == 'L'){
            Scheduler.getInstance().add(null);
        } else if(position == 'R'){
            Scheduler.getInstance().add(null);
        }else if(position == 'M'){
            Scheduler.getInstance().add(null);
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
