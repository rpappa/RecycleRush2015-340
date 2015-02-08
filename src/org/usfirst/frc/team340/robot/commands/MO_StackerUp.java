package org.usfirst.frc.team340.robot.commands;

/**
 * Manually moves the stacker up
 * @author Tai
 */
public class MO_StackerUp extends CommandBase {

    public MO_StackerUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stacker.stackerMoveUp(.75);
        System.out.println("[MO_StackerUp: initalize] Called :" + stacker.getStackerPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("[MO_StackerUp: execute] Called :" + stacker.getStackerPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("[MO_StackerUp: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("[MO_StackerUp: interrupted] called");
    }
}
