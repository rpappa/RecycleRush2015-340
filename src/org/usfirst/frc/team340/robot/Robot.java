
package org.usfirst.frc.team340.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc.team340.robot.commands.Auto4BarBinDrive;
import org.usfirst.frc.team340.robot.commands.Auto4BarStillBinGrab;
import org.usfirst.frc.team340.robot.commands.AutoGetBins;
import org.usfirst.frc.team340.robot.commands.AutoMobility;
import org.usfirst.frc.team340.robot.commands.AutoMobilityLonger;
import org.usfirst.frc.team340.robot.commands.BinarySwitchesRunAuto;
import org.usfirst.frc.team340.robot.commands.CommandBase;
//import org.usfirst.frc.team340.robot.subsystems.BinaryAutoSwitches;

import edu.wpi.first.wpilibj.CameraServer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    CameraServer camera;
    Command auto1;
    Command auto2;
    Command auto3;
    Command auto4;
    Command binarySwitchChoose;
    int autoMode = 0;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
//        autonomousCommand = new ExampleCommand();
        System.out.println("Default IterativeRobot.robotInit() method... We Are Running!");
        CommandBase.init();
        System.out.println("Command base init good");
        auto1 = new AutoMobility();
        auto2 = new AutoMobilityLonger();
        auto3 = new AutoGetBins();
        auto4 = new Auto4BarStillBinGrab();
        binarySwitchChoose = new BinarySwitchesRunAuto();
        
        try{
        	camera = CameraServer.getInstance();
        	camera.setQuality(50);
        	camera.startAutomaticCapture("cam0");
        	System.out.println("Camera init good");
        }
        catch(Exception e){
        	System.err.println("Camera init bad");
        }
    }
	
	

    public void autonomousInit() {
        // schedule the autonomous command (example)
//        if (autonomousCommand != null) autonomousCommand.start();
    	try{
//    		int[] death;
//    		death = new int[2];
//    		System.out.println(death[3]);
    		this.autoMode = (int) SmartDashboard.getNumber("autoMode");
//    		System.out.println(BinaryAutoSwitches.getMode());
    	}
    	catch(Exception e){
    		System.out.println(e);
    		SmartDashboard.putBoolean("autoException", true);
//    		SmartDashboard.putString("Exception", e.getMessage());
		}
    	binarySwitchChoose.start();
		switch (autoMode) {
			case 0:
				break;
			case 1:
				auto1.start();
				SmartDashboard.putNumber("auto", 1);
				break;
			case 2:
				auto2.start();
				SmartDashboard.putNumber("auto", 2);
				break;
			case 3:
				auto3.start();
				SmartDashboard.putNumber("auto", 3);
				break;
			case 4:
				auto4.start();
				SmartDashboard.putNumber("auto", 4);
				break;
		}
	}

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        auto1.cancel();
    	auto2.cancel();
    	auto3.cancel();
    	auto4.cancel();
    	SmartDashboard.putBoolean("cameraOn", true);;
    }
    
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
//    	if (autonomousCommand != null) autonomousCommand.cancel();
    	auto1.cancel();
    	auto2.cancel();
    	auto3.cancel();
    	auto4.cancel();
    }
    
    
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
		auto1.cancel();
    	auto2.cancel();
    	auto3.cancel();
    	auto4.cancel();
    	try{
    		this.autoMode = (int) SmartDashboard.getNumber("autoMode");
    	}
    	catch(Exception e){
    	}
    	SmartDashboard.putNumber("auto", autoMode);
	}
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
