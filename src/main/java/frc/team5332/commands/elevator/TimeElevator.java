package main.java.frc.team5332.commands.elevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;


public class TimeElevator extends Command {
    Timer timer;
    boolean started = false;

    private double goalSeconds;

    private double motorSpeed;

    public TimeElevator(double secondsToDrive, double motorSpeed){
            super("Timed Drive");

            this.goalSeconds = secondsToDrive;
            this.motorSpeed   = motorSpeed;

            timer = new Timer();

            requires(CMap.elevator);
    }

    public void execute(){
        if(!started){
            timer.start();
            started = true;
        }

        System.out.println(timer.get());

        CMap.elevator.setMotorSpeed(motorSpeed);
    }

    @Override
    protected boolean isFinished() {
        return timer.get() >= goalSeconds;
    }

    @Override
    protected void end() {
        CMap.elevator.stopMotor();
    }
}
