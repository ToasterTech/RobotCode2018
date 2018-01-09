package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Drivetrain extends Subsystem {
    public SpeedControllerGroup leftDrive = new SpeedControllerGroup(new VictorSP(CMap.leftMotor1), new VictorSP(CMap.leftMotor2));
    public SpeedControllerGroup rightDrive = new SpeedControllerGroup(new VictorSP(CMap.rightMotor1), new VictorSP(CMap.rightMotor2));


    public Drivetrain() {
        super();
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void tankDrive(){

    }
}
