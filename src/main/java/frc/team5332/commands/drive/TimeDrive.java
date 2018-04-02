package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.robot.CMap;


public class TimeDrive extends Command {
    Timer timer;
    boolean started = false;

    private double goalSeconds;

    private double leftSpeed, rightSpeed;

    public TimeDrive(double secondsToDrive, double leftDrive, double rightDrive){
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

        //System.out.println(timer.get());
        //System.out.println(goalSeconds);
        //System.out.println();

        CMap.drive.tankDrive(leftSpeed, rightSpeed);
    }

    @Override
    protected boolean isFinished() {
        return timer.get() >= goalSeconds;
    }

    @Override
    protected void end() {
        CMap.drive.stopMotors();
    }
}
