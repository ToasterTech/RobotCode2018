package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.ExpelBlockCommand;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.EncoderDrive;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.robot.CMap;

public class AutoSwitchFromMiddle extends CommandGroup {

    public AutoSwitchFromMiddle(char platePosition){
        System.out.println("AUTO SWITCH MIDDLE");
        SmartDashboard.putString("DB/String 5", "Auto Switch From Middle");

        double turnAngle = (platePosition == 'L') ? 45 : -45;


        addSequential(new TimeDrive(0.5, .5, .5));
        addSequential(new TurnToAngle(turnAngle));
        addSequential(new TimeDrive(0.5, 1, 1));
        addSequential(new TurnToAngle(0));
        addParallel(new TimeElevator(2, -1));
        addParallel(new TimeDrive(3, 0.7, 0.7));
        addSequential(new TimeExpelBlockCommand(5));

        

    }

    @Override
    protected void end() {
        super.end();

        SmartDashboard.putString("DB/String 5", "Auto Finished");
    }
}
