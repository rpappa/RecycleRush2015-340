package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.subsystems.Drive;

/**
 * Command which makes the robot move using the primary controller joystick
 * @author Kyle
 */
public class DriveWithJoysticks extends CommandBase {

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[DriveWithJoysticks: Initialize] ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	System.out.println("[DriveWithJoysticks: execute] Driving LeftDriveVal :"+ drive.leftMotorSpeed + ": RightDriveVal :"+ drive.rightMotorSpeed + ":");
//    	System.out.println("[DriveWithJoysticks: execute]"); //dont print here!!!1
//    	System.out.println("Encoders: " + String.valueOf(drive.getLeftEncoder()) + " , " + String.valueOf(drive.getRightEncoder()));
    	 drive.arcadeDrive(oi.getDriveMove(), oi.getDriveRotate());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[DriveWithJoysticks: end] ");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[DriveWithJoysticks: interrupted] ");
    }
}
