package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import main.java.frc.team5332.commands.carriage.IntakeCubeIntoCarriage;
import main.java.frc.team5332.commands.intake.ExpelBlockCommand;
import main.java.frc.team5332.commands.intake.IntakeBlockCommand;
import main.java.frc.team5332.subsystems.Carriage;
import main.java.frc.team5332.subsystems.Drivetrain;
import main.java.frc.team5332.subsystems.Intake;

public class CMap {
    //Input Devices - Joysticks
    public static Joystick gamepad = new Joystick(0);



    public static int leftXAxis = 0; //Left X-Axis
    public static int leftYAXis = 1; //Left Y-Axis
    public static int rightXAxis = 4; //Right X-Axis
    public static int rightYAxis = 5; //Right Y-Axis

    //Input Devices - Joystick Buttons
    private static int greenButton = 1;
    private static int redButton;
    private static int blueButton;
    private static int yellowButton;



    private static JoystickButton intakeButton = new JoystickButton(gamepad ,greenButton);
    private static JoystickButton expelButton = new JoystickButton(gamepad, 1);

    //Input Devices - Buttons

    //PWM Motor Ports
    public static int leftMotor1 = 0;
    public static int leftMotor2 = 1;

    public static int rightMotor1 = 2;
    public static int rightMotor2 = 3;

    public static int leftCarriageMotor = 4;
    public static int rightCarriageMotor = 5;

    public static int leftIntakeMotor = 6;
    public static int rightIntakeMotor = 7;

    //DIO Ports
    public static int intakeLimitSwitch = 0;


    //Analog Ports

    //Relay Ports

    //Subsystems
    public static Drivetrain drive = new Drivetrain();
    public static Intake intake = new Intake();

    public static Carriage carriage;// = new Intake();


    //Other Miscellaneous Objects
    public static String plateOwnership = "";


    public static void setupJoystickButtons(){
        intakeButton.whileHeld(new IntakeBlockCommand());
        expelButton.whileHeld(new ExpelBlockCommand());
    }
}
