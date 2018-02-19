package main.java.frc.team5332.commands.autonomous.preMatchActions;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

import java.sql.Driver;

public class GetPlateStatus extends Command{

    public GetPlateStatus(){
        super("Get Plate Status");
    }

    @Override
    protected void execute() {
        System.out.println("GETTING PLATE STATUS");
    }

    @Override
    protected boolean isFinished() {
        return DriverStation.getInstance().getGameSpecificMessage().length() == 3;
    }

    @Override
    protected void end() {
        System.out.println("Plate Status Received: " + DriverStation.getInstance().getGameSpecificMessage());
    }
}
