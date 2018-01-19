package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import main.java.frc.team5332.robot.CMap;

/**
 * This is the drivetrain for the motor. The main objects are the leftDrive and rightDrive speedControllerGroups.
 */
public class Drivetrain extends Subsystem {
    SpeedControllerGroup leftDrive;
    SpeedControllerGroup rightDrive;

    ADXRS450_Gyro gyro;

    public Drivetrain() {
        super("Drive Train");

        leftDrive = new SpeedControllerGroup(new VictorSP(CMap.leftMotor1), new VictorSP(CMap.leftMotor2));
        rightDrive = new SpeedControllerGroup(new VictorSP(CMap.rightMotor1), new VictorSP(CMap.rightMotor2));

        leftDrive.setInverted(true);
        rightDrive.setInverted(false);

        gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
        gyro.calibrate();

        //LiveWindow.add(this);
        //LiveWindow.addChild(this, leftDrive);
        //LiveWindow.addChild(this, rightDrive);
        //LiveWindow.add(this);

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
        leftDrive.set(left);
        rightDrive.set(right);

        System.out.println(gyro.getAngle());

    }

    /**
     * This method stops the robot motors.
     */
    public void stopMotors(){
        leftDrive.stopMotor();
        rightDrive.stopMotor();
    }
}
