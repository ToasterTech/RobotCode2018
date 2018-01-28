package main.java.frc.team5332.subsystems.drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import main.java.frc.team5332.robot.CMap;

public class LeftDriveTrain extends PIDSubsystem {

    Encoder encoder;

    SpeedControllerGroup motors;

    public LeftDriveTrain(){
        super("Left Drivetrain", 1, 0, 0);

        encoder = new Encoder(CMap.leftDriveEncoderPortA, CMap.leftDriveEncoderPortB);
        motors = new SpeedControllerGroup(new VictorSP(CMap.leftMotor1), new VictorSP(CMap.leftMotor2));

    }

    public void stopMotors(){
        motors.stopMotor();
    }

    public void setMotors(double speed){
        motors.set(speed);
    }

    @Override
    protected void initDefaultCommand() {

    }

    @Override
    protected double returnPIDInput() {
        return encoder.getDistance();
    }

    @Override
    protected void usePIDOutput(double v) {
        setMotors(v);
    }
}
