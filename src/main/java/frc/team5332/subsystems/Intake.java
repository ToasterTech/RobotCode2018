package main.java.frc.team5332.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{

    public SpeedControllerGroup intakeRollers;

    VictorSP leftIntakeRoller, rightIntakeRoller;
    public DigitalInput limitSwitchA, limitSwitchB;
    public VictorSP intakeAxesMotors;

    public Intake(){
        super("Intake");

        leftIntakeRoller = new VictorSP(CMap.intakeRollerLeft);
        leftIntakeRoller.setInverted(true);

        rightIntakeRoller = new VictorSP(CMap.intakeRollerRight);

        limitSwitchA = new DigitalInput(CMap.windowMotorLimitSwitchA);
        limitSwitchB =  new DigitalInput(CMap.windowMotorLimitSwitchB);

        intakeAxesMotors = new VictorSP(CMap.intakeAxes);

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

    public void spinIntakeAxisMotors(double speed){
        intakeAxesMotors.set(speed);
    }

    public void stopIntakeAxisMotors(){
        intakeAxesMotors.stopMotor();
    }

}
