package org.usfirst.frc.team340.robot;

//import edu.wpi.first.wpilibj.buttons.
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//Manual override ports
	public static int binGrabberContractPort = 1;
    public static int binGrabberExpandPort = 2;
    public static int binGrabberLowerPort = 3;
    public static int binGrabberRaisePort = 4;    
    public static int fourBarArmDownPort = 6;
    public static int fourBarArmUpPort = 7;
    public static int fourBarClawClosePort = 8; 
    public static int fourBarClawOpenPort = 9;
    public static int stackerDownPort = 10;
    public static int stackerUpPort = 5;
    public static int stackerInPort = 11;
//    public static int stackerOutPort = 11;
    
    //Motor ports
    public static int DriveLeftA = 0;
    public static int DriveLeftB = 1;
    public static int DriveRightA = 2;
    public static int DriveRightB = 3;
    
    public static int BinGrabberMoveSim1 = 4;
    public static int BinGrabberMoveSim2 = 5;
    
    public static int FourBarLeftMove = 6;
    public static int FourBarRightMove = 7;
    
    public static int StackerVertical = 8;
    //Solenoid ports
    public static int BinGrabberOpenClose = 0;
    public static int StackerSolenoidInOut = 1;
    public static int FourBarRotatorPort = 2;
    public static int FourBarClawPort = 3;
    public static int StackerInOut = 4;
    
    //Digital i/o ports
    public static int BinGrabberArmUp = 0;
    public static int BinGrabberArmDown = 1;
    public static int DriveLeftBannerPort = 2;
    public static int DriveRightBannerPort = 3;
    public static int FourBarBottomLeft = 12;
    public static int FourBarBottomRight = 13;
    public static int StackerMinimumSensor = 10;
    public static int StackerToteSensor = 11;
    
    //Encoder ports
    public static int DriveLeftEncoder1 = 4;
    public static int DriveLeftEncoder2 = 5;
    public static int DriveRightEncoder1 = 6;
    public static int DriveRightEncoder2 = 7;
    public static int FourBarEncoder1 = 8;
    public static int FourBarEncoder2 = 9;
    //public static int FourBarRightEncoder1 = 10;
    //public static int FourBarRightEncoder2 = 11;
    public static int StackerHeightEncoder1 = 14;
    public static int StackerHeightEncoder2 = 15;
    
    //Move speeds and other constant stuff
    public static double BinGrabberDownSpeed = .75;
    public static double BinGrabberUpSpeed = 1;
    public static double FourBarDownSpeed = .75;
    public static double FourBarUpSpeed = 1;
	public static int fourBarArmMaxEncoderValue = 100;
}
