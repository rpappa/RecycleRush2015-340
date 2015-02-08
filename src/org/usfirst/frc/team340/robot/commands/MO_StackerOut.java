package org.usfirst.frc.team340.robot.commands;

/**
 * Manually moves the stacker (intake?) out
 * @author Ryan
 */
public class MO_StackerOut extends CommandBase {

    public MO_StackerOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stacker.stackerOut();
        System.out.println("[MO_StackerOut: initalize] Makes stacker eject the bins");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("[MO_StackerOut: execute] called");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("[MO_StackerOut: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("[MO_StackerOut: end] called");

    }
}
