package org.usfirst.frc.team340.robot.commands;

/**
 * Stops the stacker from moving up or down
 * @author Tai
 */
public class MO_StackerStop extends CommandBase {

    public MO_StackerStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	stacker.stackerStopVertical();
        System.out.println("[MO_StopStacker: initialize] Called :" + stacker.getStackerPosition());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("[MO_StopStacker: execute] Called :" + stacker.getStackerPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("[MO_StopStacker: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("[MO_StopStacker: interrupted] called");
    }
}
