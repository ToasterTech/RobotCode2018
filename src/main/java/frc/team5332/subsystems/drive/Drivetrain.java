package main.java.frc.team5332.subsystems.drive;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * This is the drivetrain for the motor. The main objects are the leftDrive and rightDrive speedControllerGroups.
 */
public class Drivetrain extends PIDSubsystem {
    LeftDriveTrain leftDrive;
    RightDriveTrain rightDrive;

    ADXRS450_Gyro gyro;

    public Drivetrain() {
        super("Drive Train", 1, 0, 0);

        leftDrive  = new LeftDriveTrain();
        rightDrive = new RightDriveTrain();

        gyro = new ADXRS450_Gyro();
        gyro.calibrate();
    }

    @Override
    protected void initDefaultCommand() {

    }

    /**
     * This method drives the robot based on tank drive input.
     *
     * @param left
     * This is the double value for the left side.
     *
     * @param right
     * This is the double value for the right side.
     */
    public void tankDrive(double left, double right){
        leftDrive.setMotors(left);
        rightDrive.setMotors(right);

    }

    /**
     * This method stops the robot motors.
     */
    public void stopMotors(){
        leftDrive .stopMotors();
        rightDrive.stopMotors();
    }

    @Override
    protected double returnPIDInput() {
        return gyro.getAngle();
    }

    @Override
    protected void usePIDOutput(double v) {
        tankDrive(-v, v);
    }
}
