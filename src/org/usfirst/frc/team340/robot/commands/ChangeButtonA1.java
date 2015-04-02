package org.usfirst.frc.team340.robot.commands;



/**
 *
 */
public class ChangeButtonA1 extends CommandBase {
	
	private boolean state;

    public ChangeButtonA1(boolean state) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.state = state;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	oi.buttonA1Pressed = state;
    	this.setTimeout(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(state){
    		oi.driverRumbleOn();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	oi.driverRumbleOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	oi.driverRumbleOff();
    }
}
