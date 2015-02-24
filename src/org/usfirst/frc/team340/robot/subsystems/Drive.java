package org.usfirst.frc.team340.robot.subsystems;

import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.AnalogInput;
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
//	private Talon leftDriveB;
	private Talon rightDriveA;
//	private Talon rightDriveB;
	
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
	private final double KP_LEFT = 1;
	private final double KI_LEFT = 0;
	private final double KD_LEFT = 0;
	private final double KP_RIGHT = 1;
	private final double KI_RIGHT = 0;
	private final double KD_RIGHT = 0;
	private double fixOutput(double output, boolean right) {
		double deadBand;
		if(right) {
			deadBand = RobotMap.DriveRightDeadBand;
		} else {
			deadBand = RobotMap.DriveLeftDeadBand;
		}
		if(output<deadBand && output>0) {
    		output+=deadBand;
    	} else if(output<0 && output>-1*deadBand) {
    		output-=deadBand;
    	}
    	output = Math.min(output, 1);
    	output = Math.max(output, -1);
    	return output;
	}
    private PIDOutput leftPIDOutput = new PIDOutput() {

        public void pidWrite(double output) {
        	output = fixOutput(output, false);
        	setLeftDrive(output);
        }
    };
    private PIDOutput rightPIDOutput = new PIDOutput() {

        public void pidWrite(double output) {
        	output = fixOutput(output, false);
        	if(output<.1 && output>0) {
        		output+=.1;
        	} else if(output<0 && output>-.1) {
        		output-=.1;
        	}
        	output = Math.min(output, 1);
        	output = Math.max(output, -1);
        	setRightDrive(output);
        }
    };
	// Constructing the inputs and motors
	public Drive() {
		leftDriveA = new Talon(RobotMap.DriveLeftA);
//		leftDriveB = new Talon(RobotMap.DriveLeftB);
		rightDriveA = new Talon(RobotMap.DriveRightA);
//		rightDriveB = new Talon(RobotMap.DriveRightB);
		
		leftDriveEncoder = new Encoder(RobotMap.DriveLeftEncoder1,RobotMap.DriveLeftEncoder2);
		rightDriveEncoder = new Encoder(RobotMap.DriveRightEncoder1,RobotMap.DriveRightEncoder2);
		leftDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
		rightDriveEncoder.setPIDSourceParameter(PIDSourceParameter.kDistance);
//		leftDriveEncoder.setDistancePerPulse(distancePerPulse);
//		rightDriveEncoder.setDistancePerPulse(distancePerPulse);
		leftController = new PIDController(KP_LEFT, KI_LEFT, KD_LEFT, leftDriveEncoder, leftPIDOutput);
		rightController = new PIDController(KP_RIGHT, KI_RIGHT, KD_RIGHT, rightDriveEncoder, rightPIDOutput);
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
//    	leftDriveB.set(speed);
    }
    
    public void setRightDrive(double speed) {
    	if(speed > 1) {
    		speed = 1;
    	} else if(speed < -1) {
    		speed = -1;
    	}
    	rightDriveA.set(speed);
//    	rightDriveB.set(speed);
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
    
    
    public double getLeftEncoder(){
    	return leftDriveEncoder.get();
    }
    
    public double getRightEncoder(){
    	return rightDriveEncoder.get();
    }
}