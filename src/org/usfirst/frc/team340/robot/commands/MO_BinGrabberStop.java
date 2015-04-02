package org.usfirst.frc.team340.robot.commands;

/**
 *@author Dayle
 */
public class MO_BinGrabberStop extends CommandBase {

    public MO_BinGrabberStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(binGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[MO_BinGrabberStop: initialize] Called");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	binGrabber.raiseGrabber();
    	binGrabber.stopMoving();
    	System.out.println("[MO_BinGrabberStop: initialize] Raised Grabber at speed specified in RobotMap");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_BinGrabberStop: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_BinGrabberStop: interrupted] called");
    }
}