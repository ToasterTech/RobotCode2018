package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import main.java.frc.team5332.commands.carriage.IntakeCubeIntoCarriage;
import main.java.frc.team5332.subsystems.Carriage;
import main.java.frc.team5332.subsystems.Drivetrain;

public class CMap {
    //Input Devices - Joysticks
    public static Joystick gamepad = new Joystick(0);



    public static int leftXAxis = 0; //Left X-Axis
    public static int leftYAXis = 1; //Left Y-Axis
    public static int rightXAxis = 4; //Right X-Axis
    public static int rightYAxis = 5; //Right Y-Axis

    //Input Devices - Joystick Buttons
    private int greenButton = 1;
    private int redButton;
    private int blueButton;
    private int yellowButton;



    public static JoystickButton intakeButton = new JoystickButton(gamepad ,0);


    //Input Devices - Buttons

    //PWM Motor Ports
    public static int leftMotor1 = 0;
    public static int leftMotor2 = 1;

    public static int rightMotor1 = 2;
    public static int rightMotor2 = 3;

    public static int leftIntakeMotor = 4;
    public static int rightIntakeMotor = 5;

    //DIO Ports
    public static int intakeLimitSwitch = 0;


    //Analog Ports

    //Relay Ports

    //Subsystems
    public static Drivetrain drive = new Drivetrain();
    public static Carriage carriage;// = new Intake();


    //Other Miscellaneous Objects
    public static String plateOwnership = "";


    public static void setupJoystickButtons(){
        intakeButton.whileHeld(new IntakeCubeIntoCarriage());
    }
}
