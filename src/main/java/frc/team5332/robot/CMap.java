package main.java.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import main.java.frc.team5332.commands.carriage.IntakeCubeIntoCarriage;
import main.java.frc.team5332.commands.intake.CloseArms;
import main.java.frc.team5332.commands.intake.ExpelBlockCommand;
import main.java.frc.team5332.commands.intake.IntakeBlockCommand;
import main.java.frc.team5332.commands.intake.OpenArms;
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
    public static int leftTriggerAxis = 2;
    public static int rightTriggerAxis = 3;

    //Input Devices - Joystick Buttons
    private static int greenButton = 1;
    private static int redButton = 2;
    private static int blueButton = 3;
    private static int yellowButton = 4;

    private static int leftBumper  = 5;
    private static int rightBumper = 6;


    private static JoystickButton intakeButton = new JoystickButton(gamepad ,leftBumper);
    private static JoystickButton closeArmsButton = new JoystickButton(gamepad, rightBumper);
    //Input Devices - Buttons

    //PWM Motor Ports
    public static int leftMotor1 = 0;
    public static int leftMotor2 = 1;

    public static int rightMotor1 = 2;
    public static int rightMotor2 = 3;

    public static int leftCarriageMotor = 7;
    public static int rightCarriageMotor = 7;

    public static int leftIntakeMotor = 5;
    public static int rightIntakeMotor = 4;

    //DIO Ports
    public static int intakeLimitSwitch = 0;


    //Analog Ports

    //Relay Ports

    //Pnematic Ports
    public static int leftSolenoid = 0;
    public static int rightSolenoid = 1;


    //Subsystems
    public static Drivetrain drive = new Drivetrain();
    public static Intake intake = new Intake();

    public static Carriage carriage;// = new Intake();


    //Other Miscellaneous Objects
    public static String plateOwnership = "";
    public static String startingSpot = "";
    public static String autoPreference = "";

    public static void setupJoystickButtons(){
        intakeButton.whenPressed(new OpenArms());
        closeArmsButton.whenPressed(new CloseArms());
        //expelButton.whileHeld(new ExpelBlockCommand());
    }
}
