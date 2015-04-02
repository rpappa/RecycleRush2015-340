package org.usfirst.frc.team340.robot.commands;

/**
 *
 */
public class MO_FourBarClawClose extends CommandBase {

    public MO_FourBarClawClose() {
    	requires(fourBar);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	fourBar.closeClaw();
    	System.out.println("[MO_FourBarClawClose: initialize] Closed FourBar Claw");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fourBar.closeClaw();
    	System.out.println("[MO_FourBarClawClose: execute] Closed FourBar Claw");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_FourBarClawClose: end] called");
    }
    //James was here
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_FourBarClawClose: interrupted] called");
    }
}
