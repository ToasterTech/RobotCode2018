package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

/**
 * This subsystem represents the carriage that moves up and down
 * on the elevator.
 */
public class Carriage extends Subsystem {
    SpeedControllerGroup carriageMotor;
    DigitalInput limitSwitch;

    Spark invertedMotor;
    Talon normalMotor;



    public Carriage(){
        super("Carriage");
        //limitSwitch = new DigitalInput(CMap.intakeLimitSwitch);
        invertedMotor = new Spark(CMap.rightCarriageMotor);
        normalMotor = new Talon(CMap.leftCarriageMotor);
        carriageMotor = new SpeedControllerGroup(invertedMotor, normalMotor);;
        //carriageMotor  = new SpeedControllerGroup(new VictorSP(CMap.leftCarriageMotor), new VictorSP(CMap.rightCarriageMotor));
    }

    protected void initDefaultCommand(){

    }

    /**
     * This method should be used when we are setting the motor to custom values.
     */
    public void setCarriageMotor(double motorValue){
        carriageMotor.set(motorValue);
    }

    /**
     * This method takes in the cube.
     */
    public void intakeCube(){
        carriageMotor.set(0.6);
    }

    /**
     * This method removes the cube.
     */
    public void expelCube(){
        carriageMotor.set(-1);
    }

    public double getMotorSpeed(){ return carriageMotor.get(); }

    public void expelCube(double speed){
        carriageMotor.set(speed);
    }

    /**
     * This method stops the motors from running.
     */
    public void stopMotors(){
        carriageMotor.stopMotor();
    }

    public void spinLeftMotor(double speed){
        invertedMotor.set(speed);
    }

    public void spinRightMotor(double speed){
        normalMotor.set(speed);
    }

}
