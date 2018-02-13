package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{

    public SpeedControllerGroup intakeRollers;

    public VictorSP intakeAxesMotors;

    public Intake(){
        super("Intake");

        VictorSP leftIntakeRoller = new VictorSP(CMap.intakeRollerLeft);
        leftIntakeRoller.setInverted(true);

        intakeRollers = new SpeedControllerGroup(new VictorSP(CMap.intakeRollerRight), leftIntakeRoller);
        intakeAxesMotors = new VictorSP(CMap.intakeAxes);

    }

    protected void initDefaultCommand(){

    }

    public void spinRollers(double speed){
        intakeRollers.set(speed);
    }

    public void stopRollers(){
        intakeRollers.stopMotor();
    }

    public void spinIntakeAxisMotors(double speed){
        intakeAxesMotors.set(speed);
    }

    public void stopIntakeAxisMotors(){
        intakeAxesMotors.stopMotor();
    }

}
