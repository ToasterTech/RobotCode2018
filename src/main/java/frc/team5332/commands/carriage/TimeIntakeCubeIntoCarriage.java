package main.java.frc.team5332.commands.carriage;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class TimeIntakeCubeIntoCarriage extends Command{
    double timeToSpin;
    Timer timer = new Timer();
    boolean timerStarted;


    public TimeIntakeCubeIntoCarriage(double time){
        requires(CMap.carriage);

        timerStarted = false;
    }

    public void execute(){
        if(!timerStarted){
            timerStarted = true;
            timer.reset();
            timer.start();
        }
        CMap.carriage.intakeCube();
    }

    @Override
    protected boolean isFinished() {
        return timer.get() >= timeToSpin;
    }

    @Override
    protected void end() {
        CMap.carriage.stopMotors();
    }



}