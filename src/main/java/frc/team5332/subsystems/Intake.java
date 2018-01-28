package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{

    public VictorSP leftIntakeRoller, rightIntakeRoller, leftIntakeAxisMotor, rightIntakeAxisMotor;

    public Intake(){
        super("Intake");

        leftIntakeRoller = new VictorSP(CMap.leftIntakeRoller);
        rightIntakeRoller = new VictorSP(CMap.rightIntakeRoller);
        leftIntakeAxisMotor  = new VictorSP(CMap.leftIntakeAxisMotor);
        rightIntakeAxisMotor = new VictorSP(CMap.rightIntakeAxisMotor);

        leftIntakeRoller.setInverted(true);
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
        leftIntakeAxisMotor.set(speed);
        rightIntakeAxisMotor.set(speed);
    }

    public void stopIntakeAxisMotors(){
        leftIntakeAxisMotor.stopMotor();
        rightIntakeAxisMotor.stopMotor();
    }

}
