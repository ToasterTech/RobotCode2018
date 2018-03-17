package main.java.frc.team5332.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{


    VictorSP leftIntakeRoller, rightIntakeRoller;
    Solenoid intakeSolenoids;

    public DigitalInput limitSwitchA, limitSwitchB;

    public Intake(){
        super("Intake");

        intakeSolenoids = new Solenoid(CMap.intakeSolenoid);

        leftIntakeRoller = new VictorSP(CMap.intakeRollerLeft);
        leftIntakeRoller.setInverted(true);

        rightIntakeRoller = new VictorSP(CMap.intakeRollerRight);



    }

    protected void initDefaultCommand(){

    }

    public void spinRollers(double speed){
        leftIntakeRoller.set(speed);
        rightIntakeRoller.set(speed);
    }

    public void stopRollers(){
        leftIntakeRoller.stopMotor();
        rightIntakeRoller.stopMotor();
    }

    public void changeIntakeArmState(boolean newState){
        intakeSolenoids.set(newState);
    }

}
