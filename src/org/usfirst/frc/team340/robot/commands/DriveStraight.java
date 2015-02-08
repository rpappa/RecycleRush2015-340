package org.usfirst.frc.team340.robot.commands;

/**
 * Command which will have the robot drive straight for a given distance at a given speed.
 * @author Jakob W.
 */
public class DriveStraight extends CommandBase {

    private double speed;
	private double distance;

	public DriveStraight(double speed, double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	this.speed = speed;
    	this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[DriveStraight: initialize] reset drive encoder");
    	//why do we reset here?
    	//XXJPLXX lets try to avoid this. Store an intial state and then compare to that. -JPL
    	drive.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[DriveStraight: execute] driving left and right motors at equal speed");
    	drive.setLeftRightMotorOutputs(speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// XXJPLXX this will not work for going backwards. Lets try to do something like this math.abs(delta) = curr-init; t
        return ((drive.leftEncoderDistance() >= distance) || (drive.rightEncoderDistance() >= distance));
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[DriveStraight: end] stop moving");
    	drive.setLeftRightMotorOutputs(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[DriveStraight: interrupted] stop moving");
    	drive.setLeftRightMotorOutputs(0.0, 0.0);
    }
}