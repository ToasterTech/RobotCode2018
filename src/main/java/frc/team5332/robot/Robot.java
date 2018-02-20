package main.java.frc.team5332.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.preMatchActions.GetAutoRoutine;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.elevator.JoystickElevator;

public class Robot extends IterativeRobot {


    @Override
    public void robotInit() {
        CMap.setupJoystickButtons();

        CameraServer.getInstance().startAutomaticCapture();
        /*
        CMap.autoChooser = new SendableChooser();
        CMap.autoChooser.setName("Auto Preference System");
        CMap.autoChooser.addDefault("Normal Preference System", "Normal");
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

        */
        SmartDashboard.putString("DB/String 0", "Normal");
        SmartDashboard.putString("DB/String 1", "Scale");
        SmartDashboard.putString("DB/String 2", "Switch");
        SmartDashboard.putString("DB/String 3", "Auto Run");
        SmartDashboard.putString("DB/String 4", "Waiting for Plates");
        SmartDashboard.putString("DB/String 5", "'L', 'M', or 'R' below.");

    }

    public void autonomousInit(){
        //System.out.println("AUTONOMOUS STARTING");
        //CMap.autoPreference = CMap.autoChooser.getSelected(); //Get the Auto Preference From the Driver
        //CMap.startingSpot   = (char)CMap.positionChooser.getSelected(); //Get the Starting Spot of the Robot

        Scheduler.getInstance().add(new GetAutoRoutine()); //Get the Autonomous Routine based on Placement and Switch Assignments

        //Scheduler.getInstance().add(new TimeDrive(10, -.5, .5));
        //System.out.println(CMap.autoChooser.getSelected());
        //System.out.println(CMap.positionChooser.getSelected());
        System.out.println("AUTONOMOUS STARTING");
    }

    public void autonomousPeriodic(){
        //System.out.println(CMap.drive.getAngle());
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        System.out.println("TeleopInit() started");
        Scheduler.getInstance().removeAll();

        Scheduler.getInstance().add(new JoystickDrive());
        Scheduler.getInstance().add(new JoystickElevator());
        //Scheduler.getInstance().add(new SpinIntakeMotors());
        //Scheduler.getInstance().add(new TestMotorInput(8));

        System.out.println("TeleopInit() finished");
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();
        //System.out.println("Arms Open: " + CMap.armsOpenTime);

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