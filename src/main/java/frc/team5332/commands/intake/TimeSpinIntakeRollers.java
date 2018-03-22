package main.java.frc.team5332.commands.intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class TimeSpinIntakeRollers extends Command {
    Timer spinTimer = new Timer();
    boolean timerStarted;

    double timeToSpin;
    double motorSpeed;

    public TimeSpinIntakeRollers(double speed, double time){
        motorSpeed = speed;
        timeToSpin = time;

        timerStarted = false;
    }


    @Override
    protected void execute() {
        if(!timerStarted){
            spinTimer.reset();
            spinTimer.start();
            timerStarted = true;
        }
        CMap.intake.spinRollers(motorSpeed);

    }

    @Override
    protected boolean isFinished() {
        return spinTimer.get() >= timeToSpin;
    }

    @Override
    protected void end() {
        CMap.intake.stopRollers();
    }
}
