package org.usfirst.frc.team340.robot.commands;

import org.usfirst.frc.team340.robot.subsystems.*;
import org.usfirst.frc.team340.robot.OI;
import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The file in which all Subsystems are instantiated for commands, and all commands should extend it. If requiring Subsystems is throwing errors, make sure that your code is extending CommandBase and not just Command.
 * @author Jakob W.
 */	
//@SuppressWarnings("unused")
public abstract class CommandBase extends Command {
	
	public static OI oi;
	//create a single static instance of all of your subsystems
	public static Stacker stacker;
	public static Drive drive;
	public static BinGrabber binGrabber;
	public static FourBarManipulator fourBar;
	public static LevelManager levelManager;
	public static NoSub noSub;
    
	public static void init() {
		System.out.println("Initiating Stacker");
		stacker = new Stacker();
		System.out.println("Initiating Drive");
		drive = new Drive();
		System.out.println("Initiating Bin");
		binGrabber = new BinGrabber();
		System.out.println("Initiating Four");
		fourBar = new FourBarManipulator();
		levelManager = new LevelManager();
		noSub = new NoSub();
		
    	// This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
		System.out.println("Initiating OI");
        oi = new OI();
        System.out.println("OI init done!");
    }
    
    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
