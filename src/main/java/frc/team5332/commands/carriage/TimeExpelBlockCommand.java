package main.java.frc.team5332.commands.carriage;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class TimeExpelBlockCommand extends Command {
    double time;
    boolean timerStarted = false;
    Timer timer = new Timer();

    public TimeExpelBlockCommand(double timeToRun){
        this.time = timeToRun;
    }

    public void execute(){
        if(!timerStarted){
            timerStarted=true;
            timer.start();
        }
        System.out.println("YES IM EXPELLING");
        CMap.carriage.expelCube(-0.7);
    }

    protected boolean isFinished(){
        return timer.get() >= time;
    }

    protected void end(){
        CMap.carriage.stopMotors();
    }

}
