package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Lifts the bottom tote to the third position for use at the human player station.
 */
public class CGLoadTote extends CommandGroup {
    
    public  CGLoadTote() {
    	addSequential(new StackerGoToPosition(RobotMap.StackerNeutralTote2Target, 2), 10.0);
    	addSequential(new WaitCommand(.5));
    	addSequential(new StackerToMax(), 10.0);
    }
}
