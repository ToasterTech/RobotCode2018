package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{

    public VictorSP leftIntakeMotor, rightIntakeMotor;


    public Intake(){
        super("Intake");

        leftIntakeMotor = new VictorSP(CMap.leftIntakeMotor);
        rightIntakeMotor = new VictorSP(CMap.rightIntakeMotor);

    }

    protected void initDefaultCommand(){

    }

    public void spinMotors(double speed){
        leftIntakeMotor.set(speed);
        rightIntakeMotor.set(speed);
    }

    public void stopMotors(){
        leftIntakeMotor.stopMotor();
        rightIntakeMotor.stopMotor();
    }

}
