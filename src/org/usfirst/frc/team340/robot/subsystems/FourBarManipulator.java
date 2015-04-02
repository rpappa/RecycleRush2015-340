package org.usfirst.frc.team340.robot.subsystems;


import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

/**
 * The subsystem which contains all the methods that relate to the Four Bar mechanism. Manipulating bins primarily.
 * @author Kyle W.
 */
public class FourBarManipulator extends Subsystem {	
	//Motors
	private Victor leftMotor;
	private Victor rightMotor;
	
	//encoders
//	private Encoder fourBarEncoderLeft;
//	private Encoder fourBarEncoderRight;
	
	//switches
	private DigitalInput bottomLimitLeftA;
	private DigitalInput bottomLimitLeftB;
	private DigitalInput bottomLimitRightA;
	private DigitalInput bottomLimitRightB;
	
	private DigitalInput topLimit;
	
	private DigitalInput clawSensor;
	
	//analog potentiometer
	private AnalogPotentiometer fourBarLeftPot;
	private AnalogPotentiometer fourBarRightPot;
	//Pot offsets
	private double leftPotOffset = 0;
	private double rightPotOffset = 0;
	
	@SuppressWarnings("unused")
	private PowerDistributionPanel PDP;
	
	//Testing variables, for protecting the 4Bar from poor driving
//	private double prevLeftPosition = 0;
//	private double prevRightPosition = 0;
//	private boolean testedBefore = false;
//	private boolean isPotsFunctional = true;
	
	//pneumatics 
	private DoubleSolenoid clawPneumatic;
	private Solenoid armBrake;
	
	// Constructing the inputs and motors
	public FourBarManipulator() {
		leftMotor = new Victor(RobotMap.FourBarLeftMove);
		rightMotor = new Victor(RobotMap.FourBarRightMove);
	
//		fourBarEncoderLeft = new Encoder(RobotMap.FourBarEncoderLeft1,RobotMap.FourBarEncoderLeft2);
//		fourBarEncoderRight = new Encoder(RobotMap.FourBarEncoderRight1,RobotMap.FourBarEncoderRight2);
		
		PDP = new PowerDistributionPanel();
		
		fourBarLeftPot = new AnalogPotentiometer(RobotMap.FourBarLeftPot,1000,0);
		fourBarRightPot = new AnalogPotentiometer(RobotMap.FourBarRightPot,1000,0);
		
		bottomLimitLeftA = new DigitalInput(RobotMap.FourBarBottomLeftA);
		bottomLimitLeftB = new DigitalInput(RobotMap.FourBarBottomLeftB);
		bottomLimitRightA = new DigitalInput(RobotMap.FourBarBottomRightA);
		bottomLimitRightB = new DigitalInput(RobotMap.FourBarBottomRightB);
		
		topLimit = new DigitalInput(RobotMap.FourBarTopLimit);
		
		clawSensor = new DigitalInput(RobotMap.FourBarClawSensor);
	
		clawPneumatic = new DoubleSolenoid(RobotMap.FourBarClawPortA, RobotMap.FourBarClawPortB);
		armBrake = new Solenoid(RobotMap.FourBarBrakePort);
	}

	protected void initDefaultCommand() {
		
	}
	
	/**
	 * Allows bypass of sensors
	 * @param speed
	 */
	private void driveLeftMotorUnsafe(double speed){
		leftMotor.set(speed);
	}
	
	/**
	 * Allows bypass of sensors
	 * @param speed
	 */
	private void driveRightMotorUnsafe(double speed){
		rightMotor.set(speed);
	}
	/**
	 * This is the method the drives the left side of the 
	 *  4bar. it has limit switch and current safeties. Current
	 *  safety will cause the 4bar to jerk briefly in a 
	 *  direction, before it stops. This allows the 4bar to be 
	 *  moved anyways in pulses.
	 *  @param speed
	 */
	public void driveLeftMotor(double speed){
		//limit switches are used here so that the two sides will sync back up, if slightly out of phase
//		if(rightMotor.get() != 0 && PDP.getCurrent(RobotMap.RightFourBarCurrentChannel) < 3.5){
//			//this disables the left side if the right side draw no current, i.e. is unplugged
//			driveLeftMotorUnsafe(0);
//		}
//		else
		if ( speed < 0 && isLeftDown() ){
			//has hit the bottom limit switch, stop this side only going down
			driveLeftMotorUnsafe(0);
		}
//		else if( speed > 0 && !topLimitLeft.get() ){
//			//has hit the top limit switch, stop this side only going up
//			driveLeftMotorUnsafe(0);
//		}
		else{
			driveLeftMotorUnsafe(speed);
		}
	}
	
	/**
	 * This is the method the drives the right side of the 
	 *  4bar. it has limit switch and current safeties. Current
	 *  safety will cause the 4bar to jerk briefly in a 
	 *  direction, before it stops. This allows the 4bar to be 
	 *  moved anyways in pulses.
	 *  @param
	 */	
	public void driveRightMotor(double speed){
		//limit switches are used here so that the two sides will sync back up, if slightly out of phase
//		if(leftMotor.get()!= 0 && PDP.getCurrent(RobotMap.LeftFourBarCurrentChannel) < 3.5){
//			//this disables the right side if the right side draw no current, i.e. is unplugged
//			driveRightMotorUnsafe(0);
//		}
//		else 
		if (speed < 0 && isRightDown()){
//		if (speed < 0 && !bottomLimitRight.get() ){
			//has hit the bottom limit switch, stop this side only going down
			driveRightMotorUnsafe(0);
		}
//		else if( speed > 0 && !topLimitRight.get() ){
//			//has hit the top limit switch, stop this side only going up
//			driveRightMotorUnsafe(0);
//		}
		else{
			driveRightMotorUnsafe(speed);
		}
	}
	
	/**
	 * This is the internal method to drive the four bar.
	 *  Both motors must be activated together. Only this
	 *  method should call driveRightMotor or driveLeftMotor.
	 *  Here directionality is corrected, and the argument 
	 *  speed tells how fast to drive the motors
	 *  If motors are out of sync, this attempts to correct 
	 *  the issue but won't both if the pots are deemed non-
	 *  functional by isFailedTest().
	 *  @param speed 
	 */
    private void driveBothMotors(double speed) {
    	//the following will do Syncing between 4Bar arms
//    	if(speed < 0 && this.isPotsFunctional){
//    		if(this.getPositionRight()-this.getPositionLeft() <-20 ){
//    	    	//right is lower than left
//    			this.driveLeftMotor(speed);
//    	    	this.driveRightMotor(0);
//    		}else if(this.getPositionLeft()-this.getPositionRight() <-20 ){
//    	    	//left is lower than right
//    			this.driveLeftMotor(0);
//    	    	this.driveRightMotor(speed);
//    		}else{
//    			//darts are in sync
//    	    	this.driveLeftMotor(speed);
//    	    	this.driveRightMotor(speed);
//    		}
//    	}else if(speed > 0 && this.isPotsFunctional){
//    		if(this.getPositionRight()-this.getPositionLeft() > 20 ){
//    			//the right is higher than the left
//    	    	this.driveLeftMotor(speed);
//    	    	this.driveRightMotor(0);
//    		}else if(this.getPositionLeft()-this.getPositionRight() > 20 ){
//    			//the left is higher than the right
//    	    	this.driveLeftMotor(0);
//    	    	this.driveRightMotor(speed);
//    		}else{
//    			//darts are in sync
//    	    	this.driveLeftMotor(speed);
//    	    	this.driveRightMotor(speed);
//    		}
//    	}else{
    		//runs if pots are deemed not functional, or speed is set to 0.
        	this.driveLeftMotor(speed);
        	this.driveRightMotor(speed);
//    	}
    }
    
    /**
     * This tests two key conditions that could happen with the
     *  4bar. The first is if the motors are set to move but one
     *  of them is not drawing current, implying it is unplugged.
     *  The second is the case where the motor is set to move but
     *  the potentiometer is not showing movement. The latter is 
     *  a case where it could just be that the potentiometer is 
     *  not functional. But if that is the case the user should 
     *  just keep using the 4bar, but it could mean that the dart 
     *  is stuck on one side. This case also disables syncing 
     *  functions, so that the 4bar will not attempt to get back 
     *  in sync with bad data. 
     */
    public boolean isFailedTest(){
    	boolean isFailed = false;
//    	if(leftMotor.get() != 0){//FIX ME this should notbe like this doubles should not be compared for equivelency -JPL
//    		//tests for cases when left motor is supposed to be moving
//    		if(PDP.getCurrent(RobotMap.LeftFourBarCurrentChannel) < 3.5){
//    			isFailed = true;
//    			SmartDashboard.putString("4BarError", "No Current in Left 4Bar Motor, check electrical connection.");
//    		}else if(testedBefore && this.getPositionLeft()==prevLeftPosition){ //dont compare doubles for == 
//    			isFailed = true;
//    			SmartDashboard.putString("4BarError", "No movement in Left 4Bar Motor, check potentiometer. 4Bar Sync Disabled till restart");
//    			isPotsFunctional = false;
//    		}
//    	}
//    	if(rightMotor.get() != 0 ){ // this should not be in an else block never will be reached leading to red herrings in debugging
//    		//tests for cases when right motor is supposed to be moving
//    		if(PDP.getCurrent(RobotMap.RightFourBarCurrentChannel) < 3.5){
//    			isFailed = true;
//    			SmartDashboard.putString("4BarError", "No Current in Right 4Bar Motor, check electrical connection.");
//    		}else if(testedBefore && this.getPositionRight()==prevRightPosition){
//    			isFailed = true;
//    			SmartDashboard.putString("4BarError", "No movement in Right 4Bar Motor, check potentiometer. 4Bar Sync Disabled till restart");
//    			isPotsFunctional = false;
//    		}
//    	}//isPotsFunctionalis never set back to true -JPL
//    	prevLeftPosition = this.getPositionLeft();
//    	prevRightPosition = this.getPositionRight();
//    	testedBefore = true;
    	return isFailed;
    }
    
    /**
     * The method to close the claw at the end of the four bar.
     */
    public void closeClaw() {
    	clawPneumatic.set(Value.kReverse);
    }
    
    /**
     * The method to open the claw at the end of the four bar
     */
    public void openClaw() {
    	clawPneumatic.set(Value.kForward);
    }
    
    /**
     * Utilizing the optical sensor in the claw, this accessor
     *  method will return true when the optical beam is broken.
     */
    public boolean isClawClosedOnBin() {
    	return clawSensor.get();
    }
    
    /**
     * The public method to move the four bar up at the allowed 
     *  speed. It also disengages the brake, though this is not
     *  connected to the physical robot at this time.
     */
    public void moveUp(boolean safe) {
    	armBrake.set(true);
    	if(!safe){
    		driveLeftMotorUnsafe(RobotMap.FourBarUpSpeed);
    		driveRightMotorUnsafe(RobotMap.FourBarUpSpeed);
    	}
    	else{
    		driveBothMotors(RobotMap.FourBarUpSpeed);
    	}
	}
    
    /**
     * The public method to stop the motion of the four bar. 
     *  This will also engage the arm's brake though it is not
     *  connected to the physical robot at this time.
     */
    public void stopMovement() {
    	driveBothMotors(0);
    	armBrake.set(false);
	}
    
    /**
     * The public method to move the four bar down at the allowed 
     *  speed. It also disengages the brake, though this is not
     *  connected to the physical robot at this time.
     */
    public void moveDown(boolean safe) {
    	armBrake.set(true);
    	if(!safe){
    		driveLeftMotorUnsafe(RobotMap.FourBarDownSpeed);
    		driveRightMotorUnsafe(RobotMap.FourBarDownSpeed);
    	}
    	else{
    		driveBothMotors(RobotMap.FourBarDownSpeed);
    	}
	}
    
    /**
     * This accessor method polls both left and right potentiometers,
     *  averages them, and force casts the result as an int for easier
     *  use.
     * @return int 
     */
    public int getPosition(){
    	return (int)((getPositionLeft() + getPositionRight()) /2);
    }
    
    /**
     * Returns the corrected position, i.e. the current potentiometer
     * reading minus the offset, for the left side of the four bar.
     */
    public int getPositionLeft() {
    	SmartDashboard.putNumber("Left4BarPosition",fourBarLeftPot.get()-leftPotOffset);
    	//System.out.println(fourBarPot.get());
//    	return this.fourBarEncoderLeft.get();
    	return (int) Math.round(fourBarLeftPot.get()-leftPotOffset);
    }

    /**
     * Returns the corrected position, i.e. the current potentiometer
     * reading minus the offset, for the right side of the four bar.
     */
    public int getPositionRight() {
    	SmartDashboard.putNumber("Right4BarPosition",fourBarRightPot.get()-rightPotOffset);
//    	System.out.println(fourBarPot.get());
//    	return this.fourBarEncoderRight.get();
    	return (int) Math.round(fourBarRightPot.get()-rightPotOffset);
    }
    
    /**
     * This accessor method checks the upper limits, if hit each limit will
     *  stop their own side,(seen else where in code) but unless both are 
     *  pressed, this method is not true. This allows the sides to get caught up.
     */
    public boolean isMax() {
//    	System.out.println("LeftMax"+this.topLimitLeft+"RightMax"+this.topLimitRight);
//    	SmartDashboard.putBoolean("isMax",getPosition()>RobotMap.FourBarArmMaxPotValue);
    	SmartDashboard.putBoolean("isMax",!topLimit.get());
//    	return (getPosition()>RobotMap.FourBarArmMaxPotValue);
    	return !topLimit.get();
    	
    }
    
    /**
     * This accessor method checks both lower limits and will return true
     *  when both limits are hit. Additionally when this returns true, it
     *  will use the current value of the potentiometer as the offset
     *  value, essentially reseting the bottom of the four bar.
     * 
     *  @return boolean
     */
    public boolean isMin() {
//    	System.out.println("LeftMin"+this.bottomLimitLeft+"RightMin"+this.bottomLimitRight);
//    	if(isLeftDown() || isRightDown()/* && this.bottomLimitRight.get()*/) {
//    		fourBarEncoderLeft.reset();
//    		fourBarEncoderRight.reset();
//    		leftPotOffset = fourBarLeftPot.get();
//    		rightPotOffset = fourBarRightPot.get();
//    		SmartDashboard.putNumber("Right4BarOffset", leftPotOffset);
//    		SmartDashboard.putNumber("Left4BarOffset", rightPotOffset);
//    		System.out.println("reset 4bar encoders");
//    		return true;
//    	}
//    	return false;
    	return isLeftDown() || isRightDown();
    }
    /**
     * Is left side down?
     */
    public boolean isLeftDown() {
    	return !bottomLimitLeftA.get() || !bottomLimitLeftB.get();
    }
    public boolean isRightDown() {
    	return !bottomLimitRightA.get() || !bottomLimitRightB.get();
    }
}	