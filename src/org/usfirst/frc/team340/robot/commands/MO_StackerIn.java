package org.usfirst.frc.team340.robot.commands;

/**
 * Manually runs stacker (intake?) in
 * @author Ryan
 */
public class MO_StackerIn extends CommandBase {

    public MO_StackerIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(stacker);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//stacker.stackerIn();
        System.out.println("deprecated. why is this being called???");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("deprecated. why is this being called???");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("deprecated. it's finally over");

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.println("deprecated. someone else stopped it");
    }
}
