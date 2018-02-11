package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.preMatchActions.GetAutoRoutine;
import main.java.frc.team5332.commands.autonomous.preMatchActions.GetPlateStatus;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.elevator.JoystickElevator;
import main.java.frc.team5332.commands.intake.SpinIntakeMotors;

public class Robot extends IterativeRobot {


    @Override
    public void robotInit() {
        //CMap.setupJoystickButtons();

        CMap.autoChooser = new SendableChooser();
        CMap.autoChooser.setName("Auto Preference System");
        CMap.autoChooser.addDefault("Normal Preference System", "Normal Preference");
        CMap.autoChooser.addObject("Scale Only", "Scale");
        CMap.autoChooser.addObject("Switch Only", "Switch");
        CMap.autoChooser.addObject("Exchange", "Exchange");
        CMap.autoChooser.addObject("Auto Run", "Auto Run");

        CMap.positionChooser = new SendableChooser();
        CMap.positionChooser.setName("Starting Position");
        CMap.positionChooser.addObject("Left", 'L');
        CMap.positionChooser.addObject("Middle", 'M');
        CMap.positionChooser.addObject("Right", 'R');

        SmartDashboard.putData(CMap.autoChooser);
        SmartDashboard.putData(CMap.positionChooser);
        System.out.println("THE CHOOSER SHOULD BE ON THE SCREEN");

    }

    public void autonomousInit(){
        //System.out.println("AUTONOMOUS STARTING");
        //CMap.autoPreference = CMap.autoChooser.getSelected(); //Get the Auto Preference From the Driver
        //CMap.startingSpot   = (char)CMap.positionChooser.getSelected(); //Get the Starting Spot of the Robot

        //Scheduler.getInstance().add(new GetPlateStatus()); //Get the Game Specific Data String
        //Scheduler.getInstance().add(new GetAutoRoutine()); //Get the Autonomous Routine based on Placement and Switch Assignments

        //Scheduler.getInstance().add(new TimeDrive(10, -.5, .5));
        //System.out.println(CMap.autoChooser.getSelected());
        //System.out.println(CMap.positionChooser.getSelected());
        System.out.println("AUTONOMOUS STARTING");
    }

    public void autonomousPeriodic(){
        System.out.println(CMap.drive.getAngle());
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        Scheduler.getInstance().add(new JoystickDrive());
        Scheduler.getInstance().add(new JoystickElevator());
        Scheduler.getInstance().add(new SpinIntakeMotors());
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();

    }

    public void testInit(){
        System.out.println("TestInit() ran");
        Scheduler.getInstance().add(new TimeDrive(10, .5, .5));
    }

    public void testPeriodic(){
        System.out.println("TestPeriodic() ran");
        Scheduler.getInstance().run();
    }
}