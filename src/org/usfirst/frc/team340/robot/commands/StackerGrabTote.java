package org.usfirst.frc.team340.robot.commands;

/**
 * Command the stacker to move up until it either grabs a tote or reaches the top of its motion.
 * @author Jakob W.
 */
public class StackerGrabTote extends CommandBase {

    public StackerGrabTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[StackerGrabTote: initialize] ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// XXTHHXX Lets not use magic numbers
    	System.out.println("[StackerGrabTote: execute] moves up if we dont have a tote and were not at max");
    	if (!stacker.isToteInHand() && !stacker.isStackerMax()) {
    		System.out.println("[StackerGrabTote: execute] moves up");
    		stacker.stackerMoveUp(.5);
    	}
    	else {
    		System.out.println("[StackerGrabTote: execute] stop moving");
    		stacker.stackerStopVertical();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (stacker.isToteInHand() || stacker.isStackerMax());
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[StackerGrabTote: end] stop moving");
    	stacker.stackerStopVertical();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[StackerGrabTote: interrupted] stop moving");
    	stacker.stackerStopVertical();
    }
}