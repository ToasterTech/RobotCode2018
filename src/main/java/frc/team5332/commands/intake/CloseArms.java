package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.robot.CMap;

public class CloseArms extends Command {

    boolean timerStarted = false;

    public CloseArms(){
        CMap.closeArmsTimer = new Timer();
        requires(CMap.intake);
    }

    @Override
    protected void execute() {

        if(!timerStarted){
            CMap.closeArmsTimer.start();
            timerStarted = true;
        }
        CMap.intake.spinIntakeAxisMotors(1);
        CMap.armsOpenTime -= 1;
        System.out.println("RUNNING");
    }

    @Override
    protected boolean isFinished() {
        //return !CMap.intake.limitSwitchA.get();
        return CMap.closeArmsTimer.get() >= 3;
    }

    @Override
    protected void end() {
        CMap.closeArmsTimer.reset();
        timerStarted = false;
        CMap.intake.stopIntakeAxisMotors();
        System.out.println("DONE");
        //Scheduler.getInstance().add(new SpinIntakeMotors());
    }
}
