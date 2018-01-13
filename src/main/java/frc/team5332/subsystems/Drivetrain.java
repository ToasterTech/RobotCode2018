package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import main.java.frc.team5332.robot.CMap;

public class Drivetrain extends Subsystem {
    SpeedControllerGroup leftDrive = new SpeedControllerGroup(new VictorSP(CMap.leftMotor1), new VictorSP(CMap.leftMotor2));
    SpeedControllerGroup rightDrive = new SpeedControllerGroup(new VictorSP(CMap.rightMotor1), new VictorSP(CMap.rightMotor2));


    public Drivetrain() {
        super();

        LiveWindow.add(leftDrive);
        LiveWindow.add(rightDrive);


    }

    @Override
    protected void initDefaultCommand() {

    }

    public void tankDrive(double left, double right){
        leftDrive.set(left);
        rightDrive.set(right);
    }

    public void stopMotors(){
        leftDrive.stopMotor();
        rightDrive.stopMotor();
    }
}
