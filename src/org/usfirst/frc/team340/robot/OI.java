package org.usfirst.frc.team340.robot;

import org.usfirst.frc.team340.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	//Init controller 1
	Joystick xBoxDriverController1 = new Joystick(0);
	//Init controller buttons
	Button buttonA1 = new JoystickButton(xBoxDriverController1, 1);
	Button buttonB1 = new JoystickButton(xBoxDriverController1, 2);
    Button buttonX1 = new JoystickButton(xBoxDriverController1, 3);
    Button buttonY1 = new JoystickButton(xBoxDriverController1, 4);
    Button buttonLB1 = new JoystickButton(xBoxDriverController1, 5);
    Button buttonRB1 = new JoystickButton(xBoxDriverController1, 6);
    Button buttonBack1 = new JoystickButton(xBoxDriverController1, 7);
    Button buttonStart1 = new JoystickButton(xBoxDriverController1, 8);
    Button buttonLeftStick1 = new JoystickButton(xBoxDriverController1, 9);
	
	//Get values for driving and rotating
	public double getDriveMove() {
		xBoxDriverController1.setRumble(RumbleType.kLeftRumble, 1);
		return xBoxDriverController1.getRawAxis(0);
	}
	public double getDriveRotate() {
		return xBoxDriverController1.getRawAxis(1);
	}
	
	public class RightTrig1 extends Button {
		public boolean get() {
			return xBoxDriverController1.getRawAxis(3) < -.5;
		}
	}

	RightTrig1 rightTrig1 = new RightTrig1();

	public class LeftTrig1 extends Button {
		public boolean get() {
			return xBoxDriverController1.getRawAxis(3) > .5;
		}
	}

	LeftTrig1 leftTrig1 = new LeftTrig1();

	//Init controller 2
	Joystick xBoxCoDriverController1 = new Joystick(1);
	//Init Controller buttons
	Button buttonA2 = new JoystickButton(xBoxCoDriverController1, 1);
    Button buttonB2 = new JoystickButton(xBoxCoDriverController1, 2);
    Button buttonX2 = new JoystickButton(xBoxCoDriverController1, 3);
    Button buttonY2 = new JoystickButton(xBoxCoDriverController1, 4);
    Button buttonLB2 = new JoystickButton(xBoxCoDriverController1, 5);
    Button buttonRB2 = new JoystickButton(xBoxCoDriverController1, 6);
    Button buttonBack2 = new JoystickButton(xBoxCoDriverController1, 7);
    Button buttonStart2 = new JoystickButton(xBoxCoDriverController1, 8);
    
    public class RightTrig2 extends Button {
		public boolean get() {
			return xBoxCoDriverController1.getRawAxis(3) < -.5;
		}
	}

	RightTrig2 rightTrig2 = new RightTrig2();

	public class LeftTrig2 extends Button {
		public boolean get() {
			return xBoxCoDriverController1.getRawAxis(3) > .5;
		}
	}

	LeftTrig2 leftTrig2 = new LeftTrig2();
	Joystick manualOveride = new Joystick(2);
    Button binGrabberContract = new JoystickButton(manualOveride, RobotMap.binGrabberContractPort);
    Button binGrabberExpand = new JoystickButton(manualOveride, RobotMap.binGrabberExpandPort);
    Button binGrabberLower = new JoystickButton(manualOveride, RobotMap.binGrabberLowerPort);
    Button binGrabberRaise = new JoystickButton(manualOveride, RobotMap.binGrabberRaisePort);
    Button fourBarArmDown = new JoystickButton(manualOveride, RobotMap.fourBarArmDownPort);
    Button fourBarArmUp = new JoystickButton(manualOveride, RobotMap.fourBarArmUpPort);
    Button fourBarClawClose = new JoystickButton(manualOveride, RobotMap.fourBarClawClosePort);
    Button fourBarClawOpen = new JoystickButton(manualOveride, RobotMap.fourBarClawOpenPort);
    Button stackerDown = new JoystickButton(manualOveride, RobotMap.stackerDownPort);
//    Button stackerUp = new JoystickButton(manualOveride, RobotMap.stackerUpPort);
//    Button stackerIn = new JoystickButton(manualOveride, RobotMap.stackerInPort);
//    Button stackerOut = new JoystickButton(manualOveride, RobotMap.stackerOutPort);
//    Button button8 = new JoystickButton(manualOveride, 8);
//    Button button8 = new JoystickButton(manualOveride, 8);
    public OI() {
    	
        //////////////
        //  Driver  //
        //////////////
    	
    	buttonA1.whenPressed(new StackerToMax());
    	buttonB1.whenPressed(new StackerToMin());
    	buttonY1.whenPressed(new MO_StackerDown());
    	buttonY1.whenReleased(new MO_StackerStop());
    	buttonX1.whenPressed(new MO_StackerUp());
    	buttonX1.whenReleased(new MO_StackerStop());
    	buttonStart1.whenPressed(new StackerGoToPosition(100, 10));
        
    	
    	
    	
        /////////////////
        //  Co-Driver  //	
        /////////////////
        
    	rightTrig2.whenPressed(new CGScoreTote());
    	
        ///////////////////////
        //  Manual Override  //
        ///////////////////////
    	binGrabberContract.whenPressed(new MO_BinGrabberContractGrabber());
    	binGrabberExpand.whenPressed(new MO_BinGrabberExpandGrabber());
    	binGrabberLower.whenPressed(new MO_BinGrabberLowerGrabber());
    	binGrabberLower.whenReleased(new MO_BinGrabberStopMoving());
    	binGrabberRaise.whenPressed(new MO_BinGrabberRaiseGrabber());
    	binGrabberRaise.whenReleased(new MO_BinGrabberStopMoving());
    	fourBarArmDown.whenPressed(new MO_FourBarArmDown());
    	fourBarArmDown.whenReleased(new MO_FourBarArmStop());
    	fourBarArmUp.whenPressed(new MO_FourBarArmUp());
    	fourBarArmUp.whenReleased(new MO_FourBarArmStop());
    	fourBarClawClose.whenPressed(new MO_FourBarClawClose());
    	fourBarClawOpen.whenPressed(new MO_FourBarClawOpen());
    	stackerDown.whenPressed(new MO_StackerDown());
    	stackerDown.whenReleased(new MO_StackerStop());
//    	stackerIn.whenPressed(new MO_StackerIn());
//    	stackerIn.whenReleased(new MO_StackerStop());
//    	stackerOut.whenPressed(new MO_StackerOut());
//    	stackerOut.whenReleased(new MO_StackerStop());
//    	stackerUp.whenPressed(new MO_StackerUp());
//    	stackerUp.whenReleased(new MO_StackerStop());
    	
    }
}












