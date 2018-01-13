package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem {
    VictorSP leftMotor, rightMotor;
    DigitalInput limitSwitch;

    public Intake(){
        limitSwitch = new DigitalInput(CMap.intakeLimitSwitch);

        leftMotor  = new VictorSP(CMap.leftIntakeMotor);
        rightMotor = new VictorSP(CMap.rightIntakeMotor);
    }

    protected void initDefaultCommand(){

    }

    public void intakeCube(){
        leftMotor.set(-1);
        rightMotor.set(-1);
    }

    public void stopMotors(){
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

    public boolean cubeIsIn(){
        return limitSwitch.get();
    }
}
