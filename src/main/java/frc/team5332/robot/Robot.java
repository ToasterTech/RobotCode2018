package main.java.frc.team5332.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.preMatchActions.GetAutoRoutine;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.JoystickElevator;
import main.java.frc.team5332.commands.intake.ChangeIntakeState;

public class Robot extends IterativeRobot {


    @Override
    public void robotInit() {
        CMap.setupJoystickButtons();

        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setVideoMode(VideoMode.PixelFormat.kMJPEG, 640, 360, 30);

        CMap.compressor.setClosedLoopControl(true);


    }

    @Override
    public void disabledPeriodic() {
        if(DriverStation.getInstance().isFMSAttached() && !CMap.autoRan){
            SmartDashboard.putString("DB/String 0", "Normal");
            SmartDashboard.putString("DB/String 1", "Scale");
            SmartDashboard.putString("DB/String 2", "Switch");
            SmartDashboard.putString("DB/String 3", "Auto Run");
            SmartDashboard.putString("DB/String 4", "Waiting for Plates");
            SmartDashboard.putString("DB/String 5", "'L', 'M', or 'R' below.");
        }
    }

    public void autonomousInit(){
        CMap.autoRan = true;

        Scheduler.getInstance().add(new ChangeIntakeState());
        Scheduler.getInstance().add(new GetAutoRoutine()); //Get the Autonomous Routine based on Placement and Switch Assignments
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        Scheduler.getInstance().removeAll();

        Scheduler.getInstance().add(new TurnToAngle(90));

    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();

    }

}