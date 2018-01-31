package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.preMatchActions.GetAutoRoutine;
import main.java.frc.team5332.commands.autonomous.preMatchActions.GetPlateStatus;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.intake.SpinIntakeMotors;

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
        positionChooser.addObject("Left", 'L');
        positionChooser.addObject("Middle", 'M');
        positionChooser.addObject("Right", 'R');

        SmartDashboard.putData(autoChooser);
        SmartDashboard.putData(positionChooser);
        System.out.println("THE CHOOSER SHOULD BE ON THE SCREEN");

    }

    public void autonomousInit(){
        CMap.autoPreference = (String) autoChooser.getSelected(); //Get the Auto Preference From the Driver
        CMap.startingSpot   = (char)positionChooser.getSelected(); //Get the Starting Spot of the Robot

        Scheduler.getInstance().add(new GetPlateStatus()); //Get the Game Specific Data String
        Scheduler.getInstance().add(new GetAutoRoutine()); //Get the Autonomous Routine based on Placement and Switch Assignments
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

    }

    public void testInit(){
    }

    public void testPeriodic(){

    }
}