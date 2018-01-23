package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.GetPlateStatus;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;

public class Robot extends IterativeRobot {
    SendableChooser autoChooser, positionChooser;


    @Override
    public void robotInit() {
        CMap.setupJoystickButtons();

        autoChooser = new SendableChooser();
        autoChooser.setName("Auto Preference System");
        autoChooser.addDefault("Normal Preference System", "Normal Preference");
        autoChooser.addObject("Scale Only", "Scale");
        autoChooser.addObject("Switch Only", "Switch");
        autoChooser.addObject("Exchange", "Exchange");
        autoChooser.addObject("Auto Run", "Auto Run");

        positionChooser = new SendableChooser();
        positionChooser.setName("Starting Position");
        positionChooser.addObject("Left", "L");
        positionChooser.addObject("Middle", "M");
        positionChooser.addObject("Right", "R");

        SmartDashboard.putData(autoChooser);
        SmartDashboard.putData(positionChooser);
        System.out.println("THE CHOOSER SHOULD BE ON THE SCREEN");

    }

    public void autonomousInit(){
        CMap.autoPreference = (String) autoChooser.getSelected();
        CMap.startingSpot   = (String) positionChooser.getSelected();

        Scheduler.getInstance().add(new GetPlateStatus());
        Scheduler.getInstance().add(new TimeDrive(5, .5, 0));
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        Scheduler.getInstance().add(new JoystickDrive());
        Scheduler.getInstance().add(new SpinIntakeMotors());
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();

        //System.out.println(CMap.gamepad.getRawAxis(CMap.leftTriggerAxis));
    }

    VictorSP testMotor;
    public void testInit(){
        testMotor = new VictorSP(CMap.rightIntakeMotor);
    }

    public void testPeriodic(){
        testMotor.set(0.5);
    }
}