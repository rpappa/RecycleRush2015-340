package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
//import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CGPrepToteStack extends CommandGroup {
    
    public  CGPrepToteStack() {

    	addSequential(new StackerGoToPosition(RobotMap.StackerGrabTote1Target, 2));
    	addSequential(new StackerToMin());
    	addSequential(new StackerGoToPosition(RobotMap.StackerNeutralTote3Target, 2));
    }
}