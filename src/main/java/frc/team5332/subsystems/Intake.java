package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

public class Intake extends Subsystem{

    public VictorSP leftIntakeMotor, rightIntakeMotor;
    public Solenoid leftSolenoid, rightSolenoid;
    public Compressor compressor;

    public Intake(){
        super("Intake");

        leftIntakeMotor = new VictorSP(CMap.leftIntakeMotor);
        rightIntakeMotor = new VictorSP(CMap.rightIntakeMotor);

        leftIntakeMotor.setInverted(true);

        leftSolenoid = new Solenoid(CMap.leftSolenoid);
        rightSolenoid = new Solenoid(CMap.rightSolenoid);

        compressor = new Compressor();
        compressor.setClosedLoopControl(true);
        compressor.start();
    }

    protected void initDefaultCommand(){

    }

    public void spinMotors(double speed){
        leftIntakeMotor.set(speed);
        rightIntakeMotor.set(speed);
    }

    public void changeStatus(boolean status){
        leftSolenoid.set(status);
        rightSolenoid.set(status);
    }

    public boolean getSolenoidStatus(){
        return leftSolenoid.get() && rightSolenoid.get();
    }

    public void stopMotors(){
        leftIntakeMotor.stopMotor();
        rightIntakeMotor.stopMotor();
    }

}
