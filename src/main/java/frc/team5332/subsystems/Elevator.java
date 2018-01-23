package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Elevator extends PIDSubsystem {
    VictorSP motor;
    Encoder encoder;

    public Elevator(){
        super("Elevator", 1, 0, 0);

        motor = new VictorSP(CMap.elevatorMotor);
        encoder = new Encoder(CMap.elevatorEncoderPortA, CMap.elevatorEncoderPortB);

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

    public void setMotorSpeed(double speed){ motor.setSpeed(speed); }

    public void stopMotor(){ motor.stopMotor(); }
}
