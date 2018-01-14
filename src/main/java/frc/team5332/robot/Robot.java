package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.commands.autonomous.GetPlateStatus;
import main.java.frc.team5332.commands.drive.JoystickDrive;

public class Robot extends IterativeRobot {
    @Override
    public void robotInit() {
        CMap.setupJoystickButtons();
    }

    public void autonomousInit(){
        Scheduler.getInstance().add(new GetPlateStatus());

    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        Scheduler.getInstance().add(new JoystickDrive());
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();
    }

    public void testInit(){

    }

    public void testPeriodic(){

    }
}