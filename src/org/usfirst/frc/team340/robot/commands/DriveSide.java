package org.usfirst.frc.team340.robot.commands;

//import edu.wpi.first.wpilibj.command.Command;

/**
 * Drives one side of robot
 */
public class DriveSide extends CommandBase {

	/**
	 * Drives one side of robot
	 * @param rightSide Drive right side? Otherwise drives left side
	 * @param speed -1 to 1
	 */
	boolean rightSide;
	double speed;
	
    public DriveSide(boolean rightSide, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    	this.rightSide = rightSide;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(rightSide) {
    		drive.setRightDrive(speed);
    	} else {
    		drive.setLeftDrive(speed);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(rightSide) {
    		drive.setRightDrive(speed);
    	} else {
    		drive.setLeftDrive(speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	drive.setLeftRightMotorOutputs(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	drive.setLeftRightMotorOutputs(0, 0);
    }
}
