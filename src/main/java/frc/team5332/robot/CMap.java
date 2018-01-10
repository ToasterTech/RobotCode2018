package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import main.java.frc.team5332.subsystems.Drivetrain;

public class CMap {
    //Input Devices - Joysticks
    public static Joystick gamepad = new Joystick(0);

    public static int leftXAxis = 0; //Left X-Axis
    public static int leftYAXis = 0; //Left Y-Axis
    public static int rightXAxis = 0; //Right X-Axis
    public static int rightYAxis = 0; //Right Y-Axis

    //Input Devices - Joystick Buttons

    //Input Devices - Buttons

    //PWM Motor Ports
    public static int leftMotor1 = 0;
    public static int leftMotor2 = 1;

    public static int rightMotor1 = 2;
    public static int rightMotor2 = 3;

    //DIO Ports

    //Analog Ports

    //Relay Ports

    //Subsystems
    public static Drivetrain drive = new Drivetrain();

}
