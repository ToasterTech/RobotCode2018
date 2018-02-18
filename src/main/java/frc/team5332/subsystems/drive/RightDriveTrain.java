package main.java.frc.team5332.subsystems.drive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import main.java.frc.team5332.robot.CMap;

public class RightDriveTrain extends PIDSubsystem {
    Encoder encoder;

    VictorSP motors;

    public RightDriveTrain(){
        super("Right DriveTrain", 1, 0, 0);

        //encoder = new Encoder(CMap.rightDriveEncoderPortA, CMap.rightDriveEncoderPortB);
        motors = new VictorSP(CMap.rightDriveMotors);
        motors.setInverted(true);

    }

    public void stopMotors(){
        motors.stopMotor();
    }

    public void setMotors(double speed){
        motors.set(speed);
    }

    public double get(){
        return motors.get();
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
