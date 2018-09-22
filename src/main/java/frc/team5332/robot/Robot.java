package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.autonomous.preMatchActions.GetAutoRoutine;
import main.java.frc.team5332.commands.autonomous.routines.AutoSwitchSameSide;
import main.java.frc.team5332.commands.drive.JoystickDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.elevator.JoystickElevator;
import main.java.frc.team5332.commands.intake.TriggerSpinCubeInIntake;

public class Robot extends IterativeRobot {

    @Override
    public void robotInit() {
        CMap.setupJoystickButtons();

        SmartDashboard.putString("DB/String 0", "Normal");
        SmartDashboard.putString("DB/String 1", "Scale");
        SmartDashboard.putString("DB/String 2", "Switch");
        SmartDashboard.putString("DB/String 3", "Auto Run");

        SmartDashboard.putString("DB/String 4", "Waiting for Plates");
        SmartDashboard.putString("DB/String 5", "'L', 'M', or 'R' below.");

        CMap.compressor.setClosedLoopControl(true);



    }

    public void disabledPeriodic(){
        SmartDashboard.putBoolean("FMS Connected", DriverStation.getInstance().isFMSAttached());


    }

    public void autonomousInit(){

        //Scheduler.getInstance().add(new ChangeIntakeState());
        Scheduler.getInstance().add(new GetAutoRoutine()); //Get the Autonomous Routine based on Placement and Switch Assignments


        //Scheduler.getInstance().add(new AutoSwitchSameSide('R'));
    }

    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }

    public void teleopInit(){
        Scheduler.getInstance().removeAll();
        Scheduler.getInstance().removeAll();

        Scheduler.getInstance().add(new JoystickDrive());
        Scheduler.getInstance().add(new JoystickElevator());
        Scheduler.getInstance().add(new TriggerSpinCubeInIntake());

        //Scheduler.getInstance().add(new TimeDrive(200, 1, 1));
        //Scheduler.getInstance().add(new RecordCommand());
    }

    public void teleopPeriodic(){
        Scheduler.getInstance().run();

    }

    public void disabledInit(){
        super.disabledInit();
    }

}