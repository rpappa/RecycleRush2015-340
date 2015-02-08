package org.usfirst.frc.team340.robot.commands;

/**
 *
 */
public class MO_BinGrabberContractGrabber extends CommandBase {

    public MO_BinGrabberContractGrabber() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(binGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    System.out.println("[MO_BinGrabberContractGrabber: initialize] Called");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	binGrabber.contractGrabber();
    	System.out.println("[MO_BinGrabberContractGrabber: execute] Contracted Grabber");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_BinGrabberContractGrabber: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_BinGrabberContractGrabber: interrupted] called");
    }
}
