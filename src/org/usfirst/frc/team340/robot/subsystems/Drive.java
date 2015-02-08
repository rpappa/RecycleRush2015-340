package org.usfirst.frc.team340.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team340.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team340.robot.RobotMap;

/**
 * The subsystem which contains all the methods that relate to the Drive mechanism. It drives the robot around.
 * @author Dayle
 * @author Ryan
 * @author Kyle W.
 */
public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
	// Drive motors
	private Talon leftDriveA;
	private Talon leftDriveB;
	private Talon rightDriveA;
	private Talon rightDriveB;
	
	// Left and right banner sensors
	private DigitalInput leftBanner;
	private DigitalInput rightBanner;
	
	// Encoders on motors
	private Encoder leftDriveEncoder;
	private Encoder rightDriveEncoder;
	
	// Drive speed variables
	public double leftMotorSpeed;
	public double rightMotorSpeed;
	//TODO set distancePerPulse
	public double distancePerPulse = 0;
	
	// PID controllers
	private PIDController leftController;
	private PIDController rightController;
	private final double K_PROP = 1;
	private final double K_INT = 0;
	private final double K_DIFF = 0;
    private PIDOutput leftPIDOutput = new PIDOutput() {

        public void pidWrite(double output) {
            setLeftDrive(output);
        }
    };
    private PIDOutput rightPIDOutput = new PIDOutput() {

        public void pidWrite(double output) {
            setRightDrive(output);
        }
    };
	// Constructing the inputs and motors
	public Drive() {
		leftDriveA = new Talon(RobotMap.DriveLeftA);
		leftDriveB = new Talon(RobotMap.DriveLeftB);
		rightDriveA = new Talon(RobotMap.DriveRightA);
		rightDriveB = new Talon(RobotMap.DriveRightB);
		
		leftBanner = new DigitalInput(RobotMap.DriveLeftBannerPort);
		rightBanner = new DigitalInput(RobotMap.DriveRightBannerPort);
		
		leftDriveEncoder = new Encoder(RobotMap.DriveLeftEncoder1,RobotMap.DriveLeftEncoder2);
		rightDriveEncoder = new Encoder(RobotMap.DriveRightEncoder1,RobotMap.DriveRightEncoder2);
		leftDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
		rightDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
//		leftDriveEncoder.setDistancePerPulse(distancePerPulse);
//		rightDriveEncoder.setDistancePerPulse(distancePerPulse);
		leftController = new PIDController(K_PROP, K_INT, K_DIFF, leftDriveEncoder, leftPIDOutput);
		rightController = new PIDController(K_PROP, K_INT, K_DIFF, rightDriveEncoder, rightPIDOutput);
	}	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void setSetpoints(double leftSetpoint, double rightSetpoint) {
    	leftController.setSetpoint(leftSetpoint);
    	rightController.setSetpoint(rightSetpoint);
    }
    
    public void resetEncoder(){
    	leftDriveEncoder.reset();
    	rightDriveEncoder.reset();
    	
    }
    
    public void enablePID() {
    	leftController.enable();
    	rightController.enable();
    }
    
    public void disablePID() {
    	leftController.disable();
    	rightController.disable();
    }
    
    public void setLeftDrive(double speed) {
    	if(speed > 1) {
    		speed = 1;
    	} else if(speed < -1) {
    		speed = -1;
    	}
    	leftDriveA.set(speed);
    	leftDriveB.set(speed);
    }
    
    public void setRightDrive(double speed) {
    	if(speed > 1) {
    		speed = 1;
    	} else if(speed < -1) {
    		speed = -1;
    	}
    	rightDriveA.set(speed);
    	rightDriveB.set(speed);
    }
    /**
     * Sets the motors all at once!
     * @param leftOutput	Left motor speed
     * @param rightOutput	Right motor speed
     */
    public void setLeftRightMotorOutputs(double leftOutput, double rightOutput){
    	setLeftDrive(leftOutput);
    	setRightDrive(-rightOutput);
    }
    
    
    public void arcadeDrive(double moveValue, double rotateValue){
    	if (moveValue >= 0.0){
    		moveValue = (moveValue * moveValue);	
   		} else {
   			moveValue = -(moveValue * moveValue);
   			
   		}
    	if (rotateValue >= 0.0){
    		rotateValue = (rotateValue * rotateValue);
    	} else {
    		rotateValue = -(rotateValue *rotateValue);
    	}
    	if (moveValue > 0.0) 
        {
        
            if (rotateValue > 0.0) 
            {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = Math.max(moveValue, rotateValue);
            } 
        
            else 
            {
                leftMotorSpeed = Math.max(moveValue, -rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
        }
        
        else 
        {
            if (rotateValue > 0.0) 
            {
                leftMotorSpeed = -Math.max(-moveValue, rotateValue);
                rightMotorSpeed = moveValue + rotateValue;
            }
            else {
                leftMotorSpeed = moveValue - rotateValue;
                rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
            }
        }
    	setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
   	}
    
    
    /**
     * Gets left sensor for detecting scoring bump
     * @return Boolean is left sensor detecting bump
     */
    public boolean isLeftBump(){
    	return leftBanner.get();
    }
    /**
     * Gets right sensor for detecting scoring bump
     * @return Boolean is right sensor detecting bump
     */
    public boolean isRightBump(){
    	return rightBanner.get();
    }
    
    public double leftEncoderDistance(){
    	return leftDriveEncoder.getDistance();
    }
    
    public double rightEncoderDistance(){
    	return rightDriveEncoder.getDistance();
    }
}