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

        double turnAngle = (platePosition == 'L') ? 1 : -1;

        System.out.println(platePosition);
        if(platePosition == 'R'){


            addParallel(new TimeElevator(.75, 1));
            addSequential(new TimeDrive(1.5, 1, 1));
            addSequential(new TimeDrive(3, 0.3, 0.3));
            addSequential(new TimeExpelBlockCommand(5));
        } else {
            addSequential(new AutoRun());
            /*
            addSequential(new TimeDrive(0.5, 0 ,0.5));
            addSequential(new TimeDrive(1.5, .7, .7));
            addSequential(new TimeDrive(1, 0.3, 0));
            addParallel(new TimeElevator(.75, 1));
            addSequential();*/
            /*addSequential(new TimeDrive(1, -.3, .3));
            addSequential(new TimeDrive(2, .3, .3));
            addSequential(new TurnToAngle(0));
            addSequential(new TimeElevator(2, -1));
            addSequential(new TimeDrive(3, 0.2, 0.2));
            addSequential(new TimeExpelBlockCommand(5));*/
        }




    }

    @Override
    protected void end() {
        super.end();

        System.out.println("AUTO FINISHED");
        SmartDashboard.putString("DB/String 5", "Auto Finished");
    }
}
