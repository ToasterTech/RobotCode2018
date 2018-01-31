package main.java.frc.team5332.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import main.java.frc.team5332.robot.CMap;

public class EncoderDrive extends Command {
    double setpoint;


    public EncoderDrive(double targetValue){
        requires(CMap.drive);
        setpoint = targetValue;
    }

    public void execute(){
        CMap.drive.getPIDController().disable(); //Disable Gyro PID
        CMap.drive.enableEncoderPID();
        CMap.drive.setSetpointEncoderDrivePID(setpoint);
    }

    @Override
    protected boolean isFinished() {
        return CMap.drive.getEncoderPIDOnTarget();
    }

    @Override
    protected void end() {
        CMap.drive.disableEncoderPID();
        CMap.drive.resetEncoders();
    }
}
