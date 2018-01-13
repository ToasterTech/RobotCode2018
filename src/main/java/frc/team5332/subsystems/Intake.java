package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem {
    DigitalInput limitSwitch;

    public Intake(){
        limitSwitch = new DigitalInput(CMap.intakeLimitSwitch);
    }

    protected void initDefaultCommand(){

    }

    public void intakeCube(){

    }

    public boolean cubeIsIn(){
        return limitSwitch.get();
    }
}
