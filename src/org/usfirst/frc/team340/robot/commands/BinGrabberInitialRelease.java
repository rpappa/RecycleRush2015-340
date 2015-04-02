package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BinGrabberInitialRelease extends CommandBase {

	private double time = .25;
    public BinGrabberInitialRelease(Double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(binGrabber);
    	this.time = time;
    }
    Timer timer = new Timer();
    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	binGrabber.raiseHook();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	binGrabber.raiseHook();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get()>=time;
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
