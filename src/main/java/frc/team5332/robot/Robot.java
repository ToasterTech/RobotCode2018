package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;
import main.java.frc.team5332.commands.autonomous.GetPlateStatus;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.intake.SpinIntakeMotors;

public class Robot extends IterativeRobot {
    @Override
    public void robotInit() {
        CMap.setupJoystickButtons();
    }

    public void autonomousInit(){
        //Scheduler.getInstance().add(new GetPlateStatus());
        Scheduler.getInstance().add(new TimeDrive(5, .5, 0));
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        Scheduler.getInstance().add(new JoystickDrive());
        //Scheduler.getInstance().add(new SpinIntakeMotors());
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();

        CMap.intake.spinMotors(-1);
        System.out.println(CMap.gamepad.getRawAxis(CMap.leftTriggerAxis));
    }

    VictorSP testMotor;
    public void testInit(){
        testMotor = new VictorSP(CMap.rightIntakeMotor);
    }

    public void testPeriodic(){
        testMotor.set(0.5);
    }
}