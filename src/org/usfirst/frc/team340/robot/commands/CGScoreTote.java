package org.usfirst.frc.team340.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * A command group to score a tote stack automatically, at the push of a button.
 * @author Dayle
 */
public class CGScoreTote extends CommandGroup {
    
    public  CGScoreTote() {
    	addSequential(new StackerGoToPosition(10,5));
    	addSequential(new DriveSquareUp(),3.5);
    	addSequential(new StackerReleaseTote());
    	//addSequential(new StackerPush());
    	//addSequential(new StackerRetract());
    	addSequential(new DriveWithJoysticks());    	
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}