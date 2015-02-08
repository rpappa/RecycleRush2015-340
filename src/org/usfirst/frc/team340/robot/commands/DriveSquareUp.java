package org.usfirst.frc.team340.robot.commands;

/**
 * Has the robot use the two Drive sensors to align itself with the scoring platform
 * @author Dayle 
 */
public class DriveSquareUp extends CommandBase {

    public DriveSquareUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("[DriveSquareUp: initialize] ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("[DriveSquareUp: execute] squaring up to bump");
    	if(drive.isLeftBump() && drive.isRightBump()){
    		System.out.println("[DriveSquareUp: execute] both banners tripped");
    	}
    	else if(!drive.isLeftBump() && !drive.isRightBump()) {
    		System.out.println("[DriveSquareUp: execute] no banner values, continue to drive");
    		drive.setLeftRightMotorOutputs(.5, .5);
    	} else if(drive.isLeftBump()) {
    		System.out.println("[DriveSquareUp: execute] left banner tripped, continue to drive right");
    		drive.setLeftDrive(0);
    		drive.setRightDrive(.25);
    	} else if (drive.isRightBump()) {
    		System.out.println("[DriveSquareUp: execute] right banner tripped, continue to drive left");
    		drive.setRightDrive(0);
    		drive.setLeftDrive(.25);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return drive.isLeftBump() && drive.isRightBump();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[DriveSquareUp: end] stops driving");
    	drive.setLeftRightMotorOutputs(0, 0);
    	/*Command driveWithJoysticks = new DriveWithJoysticks();
//    	driveWithJoysticks.start();*/
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[DriveSquareUp: interrupted] stops motors");
    	drive.setLeftRightMotorOutputs(0, 0);
    }
}
