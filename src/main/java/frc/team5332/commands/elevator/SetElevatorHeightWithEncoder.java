package main.java.frc.team5332.commands.elevator;


import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class SetElevatorHeightWithEncoder extends Command {
    private double setpoint;


    public SetElevatorHeightWithEncoder(double targetPosition){
        super();

        setpoint = targetPosition;
        requires(CMap.elevator);

        CMap.elevator.getPIDController().enable();
    }

    public void execute(){
        CMap.elevator.getPIDController().setSetpoint(setpoint);
    }

    @Override
    protected boolean isFinished() {
        return CMap.elevator.getPIDController().onTarget();
    }

    @Override
    protected void end() {
        CMap.elevator.getPIDController().disable();
    }
}
