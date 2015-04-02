package org.usfirst.frc.team340.robot.commands;

/**
 *
 */
public class MO_FourBarArmStop extends CommandBase {

    public MO_FourBarArmStop() {
    	requires(fourBar);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	fourBar.stopMovement();
    	System.out.println("[MO_FourBarArmStop: initialize] Stopped Robot Arm From Moving");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	fourBar.stopMovement();
//    	System.out.println("[MO_FourBarArmStop: execute] Stopped Robot Arm From Moving");
    	System.out.println("[MO_FourBarArmStop: execute] Current position Left: " + fourBar.getPositionLeft() +
  			"Current position Right: " + fourBar.getPositionRight() + 
  			"    Is min: " + fourBar.isMin() + 
  			"    Is max: " + fourBar.isMax());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("[MO_FourBarArmStop: end] called");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("[MO_FourBarArmStop: interrupted] called");
    }
}
