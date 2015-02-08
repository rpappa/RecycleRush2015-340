package org.usfirst.frc.team340.robot.subsystems;


import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The subsystem which contains all the methods that relate to the Four Bar mechanism. Manipulating bins primarily.
 * @author Kyle W.
 */
public class FourBarManipulator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	//Motors
	private Victor leftMotor;
	private Victor rightMotor;
	
	//encoders
	private Encoder fourBarEncoder;
//	private Encoder rightFourBarEncoder;
	
	//switches
	private DigitalInput bottomLeftLimit;
	private DigitalInput bottomRightLimit;
	
	//pneumatics 
	private Solenoid rotatorPneumatic;
	private Solenoid clawPneumatic;
	
	// Constructing the inputs and motors
	public FourBarManipulator() {
		leftMotor = new Victor(RobotMap.FourBarLeftMove);
		rightMotor = new Victor(RobotMap.FourBarRightMove);
	
		fourBarEncoder = new Encoder(RobotMap.FourBarEncoder1,RobotMap.FourBarEncoder2);
//		rightFourBarEncoder = new Encoder(RobotMap.FourBarRightEncoder1,RobotMap.FourBarRightEncoder2);
		
		bottomLeftLimit = new DigitalInput(RobotMap.FourBarBottomLeft);
		bottomRightLimit = new DigitalInput(RobotMap.FourBarBottomRight);
		
		rotatorPneumatic = new Solenoid(RobotMap.FourBarRotatorPort);
		clawPneumatic = new Solenoid(RobotMap.FourBarClawPort);
	}
	
	protected void initDefaultCommand() {
		
	}
	
	private boolean isAtBottom(){
		if(bottomLeftLimit.get() && bottomRightLimit.get()){
			fourBarEncoder.reset();
			driveBothMotors(0);
			return true;
		} else if (bottomLeftLimit.get()) {
			driveLeftMotor(0);
		} else if (bottomRightLimit.get()) {
			driveRightMotor(0);
		}
		return false;
	}
	/*private boolean isAtBottomRight(){
		if(bottomRightLimit.get()){
//			rightFourBarEncoder.reset();
			return true;
		}
		return false;
	}*/
	private void driveLeftMotor(double speed){
    	leftMotor.set(speed);
    }
    private void driveRightMotor(double speed){
    	rightMotor.set(speed);
    }
    private void driveBothMotors(double speed) {
    	leftMotor.set(speed);
    	rightMotor.set(speed);
    }
    
    public void closeClaw() {
    	clawPneumatic.set(false);
    }
    
    public void openClaw() {
    	clawPneumatic.set(true);
    }
    
    public void moveUp() {
    	driveBothMotors(RobotMap.FourBarUpSpeed);
	}
    
    public void stopMovement() {
    	driveBothMotors(0);
	}
    
    public void moveDown() {
    	driveBothMotors(RobotMap.FourBarDownSpeed);
	}
    public void rotateClawDown() {
    	rotatorPneumatic.set(true);
    }
    public void rotateClawUp() {
    	rotatorPneumatic.set(false);
    }
    public int getPosition() {
    	return this.fourBarEncoder.get();
    }
    
    public boolean isMax() {
    	return this.fourBarEncoder.get() > RobotMap.fourBarArmMaxEncoderValue;
	}
    
    public boolean isMin() {
    	return this.bottomLeftLimit.get() && this.bottomRightLimit.get();
    }
}
