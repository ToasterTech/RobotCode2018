package main.java.frc.team5332.commands.autonomous.routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import main.java.frc.team5332.commands.carriage.TimeExpelBlockCommand;
import main.java.frc.team5332.commands.drive.TimeDrive;
import main.java.frc.team5332.commands.drive.TurnToAngle;
import main.java.frc.team5332.commands.elevator.TimeElevator;
import main.java.frc.team5332.commands.teleopCommandGroups.TimeIntakeCube;


public class AutoScaleSameSide extends CommandGroup {

    public AutoScaleSameSide(char robotPosition){
        SmartDashboard.putString("DB/String 5", "Auto Scale Same Side Running");
        System.out.println("Auto Scale Same Side Running");

        double turnAngle = (robotPosition == 'R') ? -1 : 1;



        addSequential(new TimeDrive(3, 1, 1));
        addParallel(new TimeElevator(1.5, 1));
        if (robotPosition == 'R'){
            addSequential(new TimeDrive(.5, 0, 1));
        } else {
            addSequential(new TimeDrive(.5, 1, 0));
        }
        addSequential(new TimeDrive(1.5, 0.3, 0.3));
        addSequential(new TimeExpelBlockCommand(3));

        addSequential(new TimeDrive(1, -0.3, -0.3));
        addSequential(new TimeElevator(.75, -.5));

        //Stuff to get the second cube
        //addSequential(new TimeDrive(0.5, -0.5, -0.5));
        //addSequential(new TimeElevator(1.5, -2));
        //addSequential(new TurnToAngle((robotPosition == 'R') ? 135 : -135));
        //addSequential(new TimeIntakeCube(1.5));

    }

    @Override
    protected void end() {
        super.end();
        SmartDashboard.putString("DB/String 5", "Autonomous Finished");
    }



}
