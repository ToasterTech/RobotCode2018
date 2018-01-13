package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;


public class TimeDrive extends Command {
    Timer timer;
    boolean started = false;

    private int goalSeconds;

    private double leftSpeed, rightSpeed;

    public TimeDrive(int secondsToDrive, double leftDrive, double rightDrive){
            super("Timed Drive");

            this.goalSeconds = secondsToDrive;
            this.leftSpeed   = leftDrive;
            this.rightSpeed  = rightDrive;

            timer = new Timer();

            requires(CMap.drive);
    }

    public void execute(){
        if(!started){
            timer.start();
            started = true;
        }
        CMap.drive.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        if(timer.get() >= goalSeconds) {
            return true;
        }

        return false;
    }

    @Override
    protected void end() {
        CMap.drive.stopMotors();
    }
}
