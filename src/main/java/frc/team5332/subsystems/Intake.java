package main.java.frc.team5332.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import main.java.frc.team5332.robot.CMap;

/**
 * This subsystem represents the intake that moves up and down
 * on the elevator.
 */
public class Intake extends Subsystem {
    VictorSP leftMotor, rightMotor;
    DigitalInput limitSwitch;


    public Intake(){
        super("Intake");
        limitSwitch = new DigitalInput(CMap.intakeLimitSwitch);

        leftMotor  = new VictorSP(CMap.leftIntakeMotor);
        rightMotor = new VictorSP(CMap.rightIntakeMotor);
    }

    protected void initDefaultCommand(){

    }

    /**
     * This method takes in the cube.
     */
    public void intakeCube(){
        leftMotor.set(-1);
        rightMotor.set(-1);
    }

    /**
     * This method removes the cube.
     */
    public void expelCube(){
        leftMotor.set(1);
        rightMotor.set(1);
    }

    /**
     * This method stops the motors from running.
     */
    public void stopMotors(){
        leftMotor.stopMotor();
        rightMotor.stopMotor();
    }

    /**
     * This method returns the status of the limit switch. If the switch
     * is pressed, then the method returns true.
     *
     * @return
     */
    public boolean cubeIsIn(){
        return limitSwitch.get();
    }
}
