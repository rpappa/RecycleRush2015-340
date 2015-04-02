package org.usfirst.frc.team340.robot.commands;

//import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Lifts the bottom tote to the third position for use at the human player station.
 * Also for stacking or putting our totes on an existing stack.
 */
public class CGStackRaiseTote1 extends CommandGroup {
    
    public  CGStackRaiseTote1() {
    	addSequential(new StackerToMin());
    	addSequential(new StackerToMax(), 15.0);
    }
}