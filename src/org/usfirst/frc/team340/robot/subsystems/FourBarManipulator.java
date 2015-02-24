package org.usfirst.frc.team340.robot.subsystems;


import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The subsystem which contains all the methods that relate to the Four Bar mechanism. Manipulating bins primarily.
 * @author Kyle W.
 */
public class FourBarManipulator extends Subsystem {	
	//Motors
	private Victor leftMotor;
	private Victor rightMotor;
	
	//encoders
	private Encoder fourBarEncoder;
	private Potentiometer fourBarPot;
	
	//switches
	private DigitalInput topLimit;
	private DigitalInput bottomLimit;
	private DigitalInput clawSensor;
	
	//pneumatics 
	private DoubleSolenoid clawPneumatic;
	private Solenoid armBrake;
	
	// Constructing the inputs and motors
	public FourBarManipulator() {
		leftMotor = new Victor(RobotMap.FourBarLeftMove);
		rightMotor = new Victor(RobotMap.FourBarRightMove);
	
		fourBarEncoder = new Encoder(RobotMap.FourBarEncoder1,RobotMap.FourBarEncoder2);
		
		topLimit = new DigitalInput(RobotMap.FourBarTop);
		bottomLimit = new DigitalInput(RobotMap.FourBarBottom);
		clawSensor = new DigitalInput(RobotMap.FourBarClawSensor); /*hi*/
		
		clawPneumatic = new DoubleSolenoid(RobotMap.FourBarClawPortA, RobotMap.FourBarClawPortB);
		armBrake = new Solenoid(RobotMap.FourBarBrakePort);
	}
	
	protected void initDefaultCommand() {
		
	}
    private void driveBothMotors(double speed) {
    	leftMotor.set(-speed);
    	rightMotor.set(speed);
    }
    
    public void closeClaw() {
    	clawPneumatic.set(Value.kReverse);
    }
    
    public void openClaw() {
    	clawPneumatic.set(Value.kForward);
    }
    
    public boolean isClawClosedOnBin() {
    	return clawSensor.get();
    }
    
    public void moveUp() {
    	armBrake.set(true);
    	driveBothMotors(RobotMap.FourBarUpSpeed);
	}
    
    public void stopMovement() {
    	driveBothMotors(0);
    	armBrake.set(false);
	}
    
    public void moveDown(boolean safe) {
    	armBrake.set(true);
    	driveBothMotors(RobotMap.FourBarDownSpeed);
	}
    public int getPosition() {
    	//System.out.println(fourBarPot.get());
    	return this.fourBarEncoder.get();
    }
    
    public boolean isMax() {
    	return !this.topLimit.get();
    }
    
    public boolean isMin() {
    	if(!this.bottomLimit.get()) {
    		fourBarEncoder.reset();
    		System.out.println("reset 4bar encoder");
    		return true;
    	}
//    	Fix fix = new Fix(.75); 
    	return false;
    }
}	