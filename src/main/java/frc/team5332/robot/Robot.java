package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.elevator.JoystickElevator;
import main.java.frc.team5332.commands.intake.TriggerSpinCubeInIntake;

public class Robot extends IterativeRobot {
    SendableChooser<Integer> autoChooser, positionChooser;

    @Override
    public void robotInit() {
        CMap.setupJoystickButtons();

        autoChooser = new SendableChooser<>();
        autoChooser.addDefault("Auto Run", CMap.autoRun);
        autoChooser.addObject("Switch Only", CMap.switchOnly);
        autoChooser.addObject("Scale Only", CMap.scaleOnly);
        autoChooser.addObject("Normal Auto", CMap.normal);

        positionChooser = new SendableChooser<>();
        positionChooser.addDefault("Center", CMap.centerPos);
        positionChooser.addObject("Left", CMap.leftPos);
        positionChooser.addObject("Right", CMap.rightPos);

        SmartDashboard.putData("Auto Chooser", autoChooser);
        SmartDashboard.putData("Position Chooser", positionChooser);

        //UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        //camera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 360, 30);

        CMap.compressor.setClosedLoopControl(true);

        while(!DriverStation.getInstance().isDSAttached()){
            //Wait for DS to Connect
        }



    }

    public void disabledPeriodic(){
        SmartDashboard.putBoolean("FMS Connected", DriverStation.getInstance().isFMSAttached());


    }

    public void autonomousInit(){

        //Scheduler.getInstance().add(new ChangeIntakeState());
        //Scheduler.getInstance().add(new TimeElevator(2, 1));
        //Scheduler.getInstance().add(new GetAutoRoutine()); //Get the Autonomous Routine based on Placement and Switch Assignments

        System.out.println(autoChooser.getSelected());
        System.out.println(positionChooser.getSelected());
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().removeAll();



        //Scheduler.getInstance().add(new TurnToAngle(90));
        Scheduler.getInstance().add(new JoystickDrive());
        Scheduler.getInstance().add(new JoystickElevator());
        Scheduler.getInstance().add(new TriggerSpinCubeInIntake());
        //Scheduler.getInstance().add(new RecordCommand());
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();

    }

    public void disabledInit(){
        super.disabledInit();
    }

}