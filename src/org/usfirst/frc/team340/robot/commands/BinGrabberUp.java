package org.usfirst.frc.team340.robot.commands;

//import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BinGrabberUp extends CommandBase {

    public BinGrabberUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(binGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	binGrabber.raiseHook();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	binGrabber.raiseHook();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	binGrabber.stopMoving();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	binGrabber.stopMoving();
    }
}
