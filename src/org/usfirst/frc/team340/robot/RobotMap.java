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
	//
	//Manual override ports
	//

    public static int stackerDownPort = 1;
    public static int stackerUpPort = 2;

    public static int binGrabberExpandPort = 3;
	public static int binGrabberContractPort = 4;
    public static int binGrabberLowerPort = 5;
    public static int binGrabberRaisePort = 6;  
    
    public static int fourBarArmDownPort = 9;
    public static int fourBarArmUpPort = 10;
    public static int fourBarClawClosePort = 8; 
    public static int fourBarClawOpenPort = 11;
    
    
    //
    //Motor ports
    //
    
    public static int DriveLeftA = 1;
    public static int DriveRightA = 0;
    
    public static int BinGrabberMoveCim1 = 8;
    public static int BinGrabberMoveCim2 = 5;
    
    public static int FourBarLeftMove = 3;
    public static int FourBarRightMove = 4;
    
    public static int StackerVertical = 2;
    
    //
    //Solenoid ports
    //
    
    public static int BinGrabberOpenClose = 3;
    public static int BinGrabberArmOut = 6;
    public static int BinGrabberArmIn = 1;
    public static int BinGrabberLiftUp = 2;
    public static int BinGrabberLiftDown = 5;
        
    public static int FourBarClawPortA = 0;
    public static int FourBarClawPortB = 7;
	public static final int FourBarBrakePort = 4;
	
        
    //
    //Digital i/o ports
    //
    
	
	//not plugged in
    public static int BinGrabberArmUp = 17;
    public static int BinGrabberArmDown = 16;
    
    //yes
    public static int DriveLeftEncoder1 = 8;
    public static int DriveLeftEncoder2 = 9;
    public static int DriveRightEncoder1 = 14;
    public static int DriveRightEncoder2 = 15;
    
    //yes
    public static int FourBarEncoder1 = 3;
    public static int FourBarEncoder2 = 4;
    
    //yes
    public static int StackerMinimumSensor = 5;
    
    //yes
    public static int FourBarTop = 6;
    public static int FourBarBottom = 7;
    public static int FourBarClawSensor = 2;
    
    
    public static int StackerHeightEncoder1 = 0;
    public static int StackerHeightEncoder2 = 1;
    
    //
    //Move speeds and other constant stuff
    //
    
    //40 driving units == 1 foot
    //200 driving units == robot length
    public static double DriveLeftDeadBand = .05;
    public static double DriveRightDeadBand = .05;
    
    public static double BinGrabberDownSpeed = 0.75;
    public static double BinGrabberUpSpeed = 1;
    
    public static double FourBarDownSpeed = -0.375;
    public static double FourBarUpSpeed = 0.6;
	public static int FourBarLevel1Target = 150;
	public static int FourBarLevel2Target = 300;
	public static int FourBarLevel3Target = 450;
	public static int FourBarLevel4Target = 600;
	public static int FourBarLevel5Target = 750;
	public static int FourBarArmMinEncoderValue = 100;
	
	public static int StackerNeutralTote1Target = 1;
	public static int StackerGrabTote1Target = 30;
	public static int StackerNeutralTote2Target = 240;
	public static int StackerGrabTote2Target = 275;
	public static int StackerNeutralTote3Target = 520;
	public static int StackerGrabTote3Target = 540;
	public static int StackerNeutralTote4Target = 775;
	public static int StackerGrabTote4Target = 800;
	public static int StackerMaxHeight = 800;
	public static double StackerMaxUpSpeed = 0.7;
	public static double StackerUpSpeed = .7;
	public static double StackerDownSpeed = .7;
	public static double StackerDownSpeedFast = 0;
}
