package main.java.frc.team5332.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{


    VictorSP leftIntakeRoller, rightIntakeRoller;
    Solenoid intakeSolenoids;
    DoubleSolenoid openCloseSolenoid;

    public DigitalInput limitSwitchA, limitSwitchB;

    public Intake(){
        super("Intake");

        openCloseSolenoid = new DoubleSolenoid(CMap.openCloseSolenoidA, CMap.openCloseSolenoidB);

        intakeSolenoids = new Solenoid(CMap.intakeSolenoid);
        intakeSolenoids.set(false);

        leftIntakeRoller = new VictorSP(CMap.intakeRollerLeft);
        leftIntakeRoller.setInverted(false);

        rightIntakeRoller = new VictorSP(CMap.intakeRollerRight);
        rightIntakeRoller.setInverted(true);

    }

    protected void initDefaultCommand(){

    }

    public void spinRollers(double speed){
        leftIntakeRoller.set(speed);
        rightIntakeRoller.set(speed);
    }

    public double getRollerSpeed() {return leftIntakeRoller.get(); }

    public void spinLeftRoller(double speed){
        leftIntakeRoller.setSpeed(speed);
    }

    public void spinRightRoller(double speed){
        rightIntakeRoller.setSpeed(speed);
    }

    public void stopRollers(){
        leftIntakeRoller.stopMotor();
        rightIntakeRoller.stopMotor();
    }

    public void changeIntakeArmState(boolean newState){
        intakeSolenoids.set(newState);
    }

    public void changeIntakeArmState(){
        intakeSolenoids.set(!intakeSolenoids.get());
    }

    public void changeOpenCloseIntakeState(){
        if(openCloseSolenoid.get() == DoubleSolenoid.Value.kForward || openCloseSolenoid.get() == DoubleSolenoid.Value.kOff){
            openCloseSolenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            openCloseSolenoid.set(DoubleSolenoid.Value.kForward);
        }
    }

    public void changeOpenCloseIntakeState(DoubleSolenoid.Value newValue){
        openCloseSolenoid.set(newValue);
    }

    /**
     * Return the state of the solenoid that controls the arms being up or down.
     *
     * @return Whether the arms are up or down.
     */
    public boolean getIntakeArmUpOrDownState(){
        return intakeSolenoids.get();
    }

    /**
     * Return the state of the solenoid that controls the arms being open or closed.
     *
     * @return Whehter the arms are open or closed.
     */
    public DoubleSolenoid.Value getIntakeArmOpenOrClosedState(){
        return openCloseSolenoid.get();
    }

}
