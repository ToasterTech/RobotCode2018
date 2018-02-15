package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Elevator extends PIDSubsystem {
    SpeedControllerGroup motor;
    Encoder encoder;

    public Elevator(){
        super("Elevator", 1, 0, 0);

        motor = new SpeedControllerGroup(new VictorSP(CMap.elevatorMotor1), new VictorSP(CMap.elevatorMotor2));
        encoder = new Encoder(CMap.elevatorEncoderPortA, CMap.elevatorEncoderPortB);

        getPIDController().setOutputRange(-0.5, 0.5);

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
        motor.set(v);
    }

    @Override
    public boolean onTarget() {
        return Math.abs(encoder.getDistance() - getSetpoint()) <= 0.5;
    }

    public void setMotorSpeed(double speed){ motor.set(speed); }

    public void stopMotor(){ motor.stopMotor(); }

    public void resetEncoder(){
        encoder.reset();
    }
}
