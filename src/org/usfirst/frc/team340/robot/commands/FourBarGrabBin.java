		package org.usfirst.frc.team340.robot.commands;

/**
 * 
 * @author Dayle 
 * @author Ryan
 */
public class FourBarGrabBin extends CommandBase {

    public FourBarGrabBin() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(fourBar);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[FourBarGrabBin: initialize] opens claw");
    	fourBar.openClaw();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[FourBarGrabBin: execute]");
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return fourBar.isClawClosedOnBin();
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[FourBarGrabBin: end] stop moving and close claw");
    	fourBar.stopMovement();
    	fourBar.closeClaw();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	fourBar.stopMovement();
    	System.out.println("[FourBarGrabBin: interrupted] stop moving");
    }
}
