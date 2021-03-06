package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Elevator extends Subsystem {
    SpeedControllerGroup motor;
    Encoder encoder;

    public Elevator(){
        super("Elevator");
        //VictorSP motorA = new VictorSP(7);
        motor = new SpeedControllerGroup(new VictorSP(CMap.elevatorMotor1), new VictorSP(CMap.elevatorMotor2), new VictorSP(CMap.elevatorMotor3));
        //motor = new SpeedControllerGroup(motorA);
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void setMotorSpeed(double speed) {
        /*
        if (speed < -0.6) {
            motor.set(-0.6);
        } else {
            motor.set(speed);
        }*/
        motor.set(speed);
    }

    public void stopMotor(){ motor.stopMotor(); }

    public void resetEncoder(){
        encoder.reset();
    }
}
