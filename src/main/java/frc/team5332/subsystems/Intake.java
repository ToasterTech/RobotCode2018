package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{

    public VictorSP intakeRollers, intakeAxesMotors;

    public Intake(){
        super("Intake");

        intakeRollers = new VictorSP(CMap.intakeRollers);
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
