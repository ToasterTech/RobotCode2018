package main.java.frc.team5332.subsystems.drive;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * This is the drive for the motor. The main objects are the leftDrive and rightDrive speedControllerGroups.
 */
public class DriveTrain extends PIDSubsystem {
    LeftDriveTrain leftDrive;
    RightDriveTrain rightDrive;

    ADXRS450_Gyro gyro;

    public DriveTrain() {
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

    public void resetEncoders(){
        leftDrive.encoder.reset();
        rightDrive.encoder.reset();
    }

    public void resetGyro(){
        gyro.reset();
    }

    @Override
    protected double returnPIDInput() {
        return gyro.getAngle();
    }

    @Override
    protected void usePIDOutput(double v) {
        tankDrive(-v, v);
    }

    public void enableEncoderPID(){
        this.getPIDController().disable();
        leftDrive.getPIDController().enable();
        rightDrive.getPIDController().enable();
    }

    public void setSetpointEncoderDrivePID(double setpoint){
        leftDrive.getPIDController().setSetpoint(setpoint);
        rightDrive.getPIDController().setSetpoint(setpoint);
    }

    public boolean getEncoderPIDOnTarget(){
        return leftDrive.onTarget() && rightDrive.onTarget();
    }

    public void disableEncoderPID(){
        leftDrive.getPIDController().disable();
        rightDrive.getPIDController().disable();
    }


    public double[] get(){
        return new double[]{leftDrive.get(), rightDrive.get()};
    }

    public double getAngle(){return gyro.getAngle(); }
}
