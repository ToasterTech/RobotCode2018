package main.java.frc.team5332.util;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Cycle {

    double leftJoystickValue;
    double rightJoystickValue;
    double elevatorJoystickValue;

    double carriageMotorValues;
    double intakeMotorValues;

    DoubleSolenoid.Value intakeArmsOpen;
    String intakeArmsDown;

    public Cycle(){

    }


    public Cycle(double leftJoystickValue, double rightJoystickValue, double elevatorJoystickValue,
                 double carriageMotorValues, double intakeMotorValues, DoubleSolenoid.Value intakeArmsOpen, String intakeArmsDown) {
        this.leftJoystickValue = leftJoystickValue;
        this.rightJoystickValue = rightJoystickValue;
        this.elevatorJoystickValue = elevatorJoystickValue;
        this.carriageMotorValues = carriageMotorValues;
        this.intakeMotorValues = intakeMotorValues;
        this.intakeArmsOpen = intakeArmsOpen;
        this.intakeArmsDown = String.valueOf(intakeArmsDown);
    }

    public double getLeftJoystickValue() {
        return leftJoystickValue;
    }

    public void setLeftJoystickValue(double leftJoystickValue) {
        this.leftJoystickValue = leftJoystickValue;
    }

    public double getRightJoystickValue() {
        return rightJoystickValue;
    }

    public void setRightJoystickValue(double rightJoystickValue) {
        this.rightJoystickValue = rightJoystickValue;
    }

    public double getElevatorJoystickValue() {
        return elevatorJoystickValue;
    }

    public void setElevatorJoystickValue(double elevatorJoystickValue) {
        this.elevatorJoystickValue = elevatorJoystickValue;
    }

    public double getCarriageMotorValues() {
        return carriageMotorValues;
    }

    public void setCarriageMotorValues(double carriageMotorValues) {
        this.carriageMotorValues = carriageMotorValues;
    }

    public double getIntakeMotorValues() {
        return intakeMotorValues;
    }

    public void setIntakeMotorValues(double intakeMotorValues) {
        this.intakeMotorValues = intakeMotorValues;
    }

    public DoubleSolenoid.Value getIntakeArmsOpen() {
        return intakeArmsOpen;
    }

    public void setIntakeArmsOpen(DoubleSolenoid.Value intakeArmsOpen) {
        this.intakeArmsOpen = intakeArmsOpen;
    }

    public String getIntakeArmsDown() {
        return this.intakeArmsDown;
    }

    public void setIntakeArmsDown(Boolean intakeArmsDown) {
        this.intakeArmsDown = String.valueOf(intakeArmsDown);
    }
}
