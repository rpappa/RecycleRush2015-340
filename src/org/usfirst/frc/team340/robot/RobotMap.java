package org.usfirst.frc.team340.robot;

//import edu.wpi.first.wpilibj.buttons.
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

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

    public static int binGrabberLowerPort = 3;
    public static int binGrabberRaisePort = 4;  
    
    public static int fourBarArmDownPort = 9;
    public static int fourBarArmUpPort = 10;
    public static int fourBarClawClosePort = 8; 
    public static int fourBarClawOpenPort = 11;
    
    
    //
    //Motor ports
    //
    
    public static int DriveRightA = 0;
    public static int DriveLeftA = 1;
    
    public static int StackerVertical = 2;
    
    public static int FourBarLeftMove = 3;
    public static int FourBarRightMove = 4;
    
//    public static int BinGrabberMoveCim1 = 8;
//    public static int BinGrabberMoveCim2 = 5;
    public static int BinGrabberMove = 5;
    //
    //Motor Current Channels
    public static int RightFourBarCurrentChannel = 12;
    public static int LeftFourBarCurrentChannel = 13;
    
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
    
    //yes
    public static int StackerHeightEncoder1 = 0;
    public static int StackerHeightEncoder2 = 1;
    
    //yes
    public static int StackerMinimumSensor = 2;    
    
    //yes
    public static int FourBarClawSensor = 3;
    
    //yes
    public static int DriveRightEncoder1 = 4;
    public static int DriveRightEncoder2 = 5;
    public static int DriveLeftEncoder1 = 6;
    public static int DriveLeftEncoder2 = 7;
    
    //yes
//    public static int FourBarEncoderLeft1 = 8;
//    public static int FourBarEncoderLeft2 = 9;
    public static int FourBarEncoderRight1 = 10;
    public static int FourBarEncoderRight2 = 11;
    
    //yes
    public static int FourBarBottomLeftA = 12;
    public static int FourBarBottomLeftB = 13;
    public static int FourBarBottomRightA = 19;
    public static int FourBarBottomRightB = 15;
    
    public static int FourBarTopLimit = 20;
    
    public static int BinarySwitchA = 8;
    public static int BinarySwitchB = 9;
    
    //no
    public static int BinGrabberIsRaised = 16;
    //
    //Analog ports
    //
    
    //no
    public static int FourBarLeftPot = 0;
    public static int FourBarRightPot = 1;
    
    //
    //Move speeds and other constant stuff
    //
    
    //40 driving units == 1 foot
    //200 driving units == robot length
    public static double DriveLeftDeadBand = .05;
    public static double DriveRightDeadBand = .05;
    public static double DriveStraightDistance = 20;
    public static double DriveStraightRotation = 20;
    
    public static double BinGrabberDownSpeed = -1;
    public static double BinGrabberUpSpeed = 1;
    
    public static double FourBarDownSpeed = -.75;
    public static double FourBarUpSpeed = .75 ;
	public static int FourBarLevel1Target = 150;
	public static int FourBarLevel2Target = 300;
	public static int FourBarLevel3Target = 450;
	public static int FourBarLevel4Target = 600;
	public static int FourBarLevel5Target = 750;
	public static int FourBarArmMinEncoderValue = 100;
	public static double FourBarArmMaxPotValue = 60000;
	
	public static int StackerNeutralTote1Target = 1;
	public static int StackerGrabTote1Target = 30;
	public static int StackerNeutralTote2Target = 240;
	public static int StackerGrabTote2Target = 275;
	public static int StackerNeutralTote3Target = 520;
	public static int StackerGrabTote3Target = 540;
	public static int StackerNeutralTote4Target = 775;
	public static int StackerGrabTote4Target = 800;
	public static int StackerMaxHeight = 775;//800;
	public static double StackerMaxUpSpeed = 0.7;
	public static double StackerUpSpeed = .85;
	public static double StackerDownSpeed = .85;
	public static double StackerDownSpeedFast = 0;
}
