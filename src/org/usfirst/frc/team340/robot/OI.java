package org.usfirst.frc.team340.robot;

import org.usfirst.frc.team340.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.PrintCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI {

	// Init and construct controller 1 Driver -----------------------------------------------
	Joystick xBoxDriverController1 = new Joystick(0);
	// Init and construct controller buttons
	Button buttonA1 = new JoystickButton(xBoxDriverController1, 1);
	Button buttonB1 = new JoystickButton(xBoxDriverController1, 2);
	Button buttonX1 = new JoystickButton(xBoxDriverController1, 3);
	Button buttonY1 = new JoystickButton(xBoxDriverController1, 4);
	Button buttonLB1 = new JoystickButton(xBoxDriverController1, 5);
	Button buttonRB1 = new JoystickButton(xBoxDriverController1, 6);
	Button buttonBack1 = new JoystickButton(xBoxDriverController1, 7);
	Button buttonStart1 = new JoystickButton(xBoxDriverController1, 8);
	Button buttonLeftStick1 = new JoystickButton(xBoxDriverController1, 9);
	
	////ButtonA1 Toggle////
	public boolean buttonA1Pressed = false;
	
	public class ButtonA1First extends Button{
		public boolean get(){return buttonA1.get() && !buttonA1Pressed;}
	};
	ButtonA1First buttonA1F= new ButtonA1First();
	
	public class ButtonA1Second extends Button{
		public boolean get(){return buttonA1.get() && buttonA1Pressed;}
	}
	ButtonA1Second buttonA1S= new ButtonA1Second();

	//Turn Driver triggers to buttons
	public class RightTrig1 extends Button {
		public boolean get() {
			return xBoxDriverController1.getRawAxis(3) > .5;
		}
	}
	RightTrig1 rightTrig1 = new RightTrig1();

	public class LeftTrig1 extends Button {
		public boolean get() {
			return xBoxDriverController1.getRawAxis(2) > .5;
		}
	}
	LeftTrig1 leftTrig1 = new LeftTrig1();

	//Turn Dpad directions to buttons for driver
	public class DriverUpDPad extends Button {
		public boolean get() {
			return xBoxDriverController1.getPOV() >= 315
					|| (xBoxDriverController1.getPOV() > -1 && 
							xBoxDriverController1.getPOV() <= 45);
		}
	}
	Button driverUpDPad = new DriverUpDPad();

	public class DriverDownDPad extends Button {
		public boolean get() {
			return xBoxDriverController1.getPOV() > 90
					&& xBoxDriverController1.getPOV() < 270;
		}
	}
	Button driverDownDPad = new DriverDownDPad();
	
	// Init  and construct controller 2 Codriver -----------------------------------------------------
	Joystick xBoxCoDriverController1 = new Joystick(1);
	// Init and construct Controller buttons
	Button buttonA2 = new JoystickButton(xBoxCoDriverController1, 1);
	Button buttonB2 = new JoystickButton(xBoxCoDriverController1, 2);
	Button buttonX2 = new JoystickButton(xBoxCoDriverController1, 3);
	Button buttonY2 = new JoystickButton(xBoxCoDriverController1, 4);
	Button buttonLB2 = new JoystickButton(xBoxCoDriverController1, 5);
	Button buttonRB2 = new JoystickButton(xBoxCoDriverController1, 6);
	Button buttonBack2 = new JoystickButton(xBoxCoDriverController1, 7);
	Button buttonStart2 = new JoystickButton(xBoxCoDriverController1, 8);

	//Turn codriver triggers to buttons
	public class RightTrig2 extends Button {
		public boolean get() {
			return xBoxCoDriverController1.getRawAxis(3) > .5;
		}
	}
	RightTrig2 rightTrig2 = new RightTrig2();

	public class LeftTrig2 extends Button {
		public boolean get() {
			return xBoxCoDriverController1.getRawAxis(2) > .5;
		}
	}
	LeftTrig2 leftTrig2 = new LeftTrig2();
	
	//Turn Dpad directions to buttons for codriver
	public class CoDriverUpDPad extends Button {
		public boolean get() {
			return xBoxCoDriverController1.getPOV() >= 315
					|| (xBoxCoDriverController1.getPOV() > -1 && xBoxCoDriverController1
							.getPOV() <= 45);
		}
	}
	Button coDriverUpDPad = new CoDriverUpDPad();

	public class CoDriverDownDPad extends Button {
		public boolean get() {
			return xBoxCoDriverController1.getPOV() > 90
					&& xBoxCoDriverController1.getPOV() < 270;
		}
	}
	Button coDriverDownDPad = new CoDriverDownDPad();

	
	//Manual override board construction and button creation------------------------------------------------
	Joystick manualOveride = new Joystick(2);
	Button binGrabberLower = new JoystickButton(manualOveride,
			RobotMap.binGrabberLowerPort);
	Button binGrabberRaise = new JoystickButton(manualOveride,
			RobotMap.binGrabberRaisePort);
	Button fourBarArmDown = new JoystickButton(manualOveride,
			RobotMap.fourBarArmDownPort);
	Button fourBarArmUp = new JoystickButton(manualOveride,
			RobotMap.fourBarArmUpPort);
	Button fourBarClawClose = new JoystickButton(manualOveride,
			RobotMap.fourBarClawClosePort);
	Button fourBarClawOpen = new JoystickButton(manualOveride,
			RobotMap.fourBarClawOpenPort);
	Button stackerDown = new JoystickButton(manualOveride,
			RobotMap.stackerDownPort);
	Button stackerUp = new JoystickButton(manualOveride, RobotMap.stackerUpPort);

	/*
	 * Constructor for OI, contains connection of buttons to commands 
	 */
	public OI() {

		// ////////////
		// Driver //
		// ////////////

		// ////////Competition//////////
		
		buttonA1F.whenPressed(new StackerGoToPosition(RobotMap.StackerNeutralTote2Target, 2));
		buttonA1F.whenReleased(new ChangeButtonA1(true));
		buttonA1S.whenPressed(new StackerToMax());
		buttonA1S.whenReleased(new ChangeButtonA1(false));
		buttonB1.whenPressed(new CGSecureBottomTote());
		buttonStart1.whenPressed(new CGPrepToteStack());
		
		rightTrig1.whenPressed(new CGScoreTote());
		
		driverUpDPad.whenPressed(new StackerSafeUp());
		driverUpDPad.whenReleased(new MO_StackerStop());
		//driverUpDPad.whenReleased(new PrintCommand("Stacker Up Released"));
		driverDownDPad.whenPressed(new StackerSafeDown());
		driverDownDPad.whenReleased(new MO_StackerStop());
		//driverDownDPad.whenReleased(new PrintCommand("Stacker Down Released"));
		 
		// ////////Testing//////////
//		buttonX1.whenPressed(new DriveStraight(.4,210));
//		buttonY1.whenPressed(new DriveTurn(0, .75, 85));
/*
		buttonA1.whenPressed(new StackerToMax()); 
		buttonB1.whenPressed(new StackerToMin()); 
		buttonY1.whenPressed(new MO_StackerDown());
		buttonY1.whenReleased(new MO_StackerStop());
		buttonX1.whenPressed(new MO_StackerUp()); 
		buttonX1.whenReleased(new MO_StackerStop());
		buttonStart1.whenPressed(new StackerGoToPosition(100, 10));
*/		 
/*
		buttonA1.whenPressed(new StackerToMax());
		buttonB1.whenPressed(new StackerToMin());
		buttonY1.whenPressed(new StackerGoToPosition(400, 10));
		buttonLB1.whenPressed(new StackerGrabTote(2));
		buttonRB1.whenPressed(new StackerGoToNearestNeutralPosition(2));

		buttonStart1.whenPressed(new FourBarToMax());
		buttonBack1.whenPressed(new FourBarToMin());
		buttonX1.whenPressed(new FourBarGoToPosition(6, 1));

		buttonA2.whenPressed(new CGStackRaiseTote1());
		buttonB2.whenPressed(new CGLoadTote());
		buttonX2.whenPressed(new CGScoreTote());
*/
		// ///////////////
		//   Co-Driver  //
		// ///////////////

		// ////////Competition//////////
		
		buttonA2.whenPressed(new CGLoadTote());
		buttonB2.whenPressed(new CGSecureBottomTote());
		buttonStart2.whenPressed(new CGPrepToteStack());
		
		
		leftTrig2.whenPressed(new MO_FourBarClawOpen());
		rightTrig2.whenPressed(new MO_FourBarClawClose());
		
		coDriverUpDPad.whenPressed(new FourBarSafeUp());
		coDriverUpDPad.whenReleased(new MO_FourBarArmStop());
		//coDriverUpDPad.whenReleased(new PrintCommand("Four Bar Up Released"));
		coDriverDownDPad.whenPressed(new FourBarSafeDown());
		coDriverDownDPad.whenReleased(new MO_FourBarArmStop());
		//coDriverDownDPad.whenReleased(new PrintCommand("Four Bar Down Released"));
		
		///////////Testing//////////
		
		buttonX2.whenPressed(new BinGrabberGetBin());
		
		buttonRB2.whenPressed(new MO_BinGrabberDown());
		buttonRB2.whenReleased(new MO_BinGrabberStop());
		buttonLB2.whenPressed(new MO_BinGrabberUp());
		buttonLB2.whenReleased(new MO_BinGrabberStop());
		
		
		

		/////////////////////
		// Manual Override //
		/////////////////////

		binGrabberLower.whenPressed(new MO_BinGrabberDown());
		binGrabberLower.whenReleased(new MO_BinGrabberStop());
		binGrabberRaise.whenPressed(new MO_BinGrabberUp());
		binGrabberRaise.whenReleased(new MO_BinGrabberStop());
		
		fourBarArmDown.whenPressed(new MO_FourBarArmDown());
		fourBarArmDown.whenReleased(new MO_FourBarArmStop());
		fourBarArmUp.whenPressed(new MO_FourBarArmUp());
		fourBarArmUp.whenReleased(new MO_FourBarArmStop());
		fourBarClawClose.whenPressed(new MO_FourBarClawClose());
		fourBarClawOpen.whenPressed(new MO_FourBarClawOpen());
		stackerDown.whenPressed(new MO_StackerDown());
		stackerDown.whenReleased(new MO_StackerStop());
		stackerUp.whenPressed(new MO_StackerUp());
		stackerUp.whenReleased(new MO_StackerStop());

	}
	
	/*
	 * Accessor method to return the drive value forward or backward,
	 *  to be used to get values for the drive
	 */
	public double getDriveMove() {
		if(Math.abs(xBoxDriverController1.getRawAxis(1)) >.15 || Math.abs(xBoxDriverController1.getRawAxis(0)) >.15) {
			return -xBoxDriverController1.getRawAxis(1);
		}
		return -xBoxDriverController1.getRawAxis(5)*(.70);
	}
	
	/*
	 * Accessor method to return the drive value left or right,
	 *  to be used to get values for the drive
	 */
	public double getDriveRotate() {
		if(Math.abs(xBoxDriverController1.getRawAxis(0)) >.15 || Math.abs(xBoxDriverController1.getRawAxis(1)) >.15) {
			return -xBoxDriverController1.getRawAxis(0);
		}
		return -xBoxDriverController1.getRawAxis(4)*(.70);
	}
	
	/*
	 * Method to turn on the rumble for the driver controller
	 */
	public void driverRumbleOn(){
		xBoxDriverController1.setRumble(Joystick.RumbleType.kLeftRumble, 1);
		xBoxDriverController1.setRumble(Joystick.RumbleType.kRightRumble, 1);
	}

	/*
	 * Method to turn off the rumble for the driver controller
	 */
	public void driverRumbleOff(){
		xBoxDriverController1.setRumble(Joystick.RumbleType.kLeftRumble, 0);
		xBoxDriverController1.setRumble(Joystick.RumbleType.kRightRumble, 0);
	}
	
	/*
	 * Method to turn on the rumble for the codriver controller
	 */
	public void coDriverRumbleOn(){
		xBoxCoDriverController1.setRumble(Joystick.RumbleType.kLeftRumble, 1);
		xBoxCoDriverController1.setRumble(Joystick.RumbleType.kRightRumble, 1);
	}
	
	/*
	 * Method to turn off the rumble for the codriver controller
	 */
	public void coDriverRumbleOff(){
		xBoxCoDriverController1.setRumble(Joystick.RumbleType.kLeftRumble, 0);
		xBoxCoDriverController1.setRumble(Joystick.RumbleType.kRightRumble, 0);
	}
}
