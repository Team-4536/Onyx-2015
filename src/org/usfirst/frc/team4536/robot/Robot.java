
package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team4536.robot.commands.ExampleCommand;
import org.usfirst.frc.team4536.robot.subsystems.*;
import org.usfirst.frc.team4536.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
    Command autonomousCommand;
    Command driveCommand;
    Command compressorCommand;
    Command autoIntakeCommand;
    Command runCameraCommand;
    Command accelCommand;
    Command runRadarCommand;
    Command setGimbleCommand;
    Command getDistanceCommand;
    Command getAngleCommand;
    

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
        // instantiate the command used for the autonomous period
		
        autonomousCommand = new ExampleCommand();
        driveCommand = new Drive(1);
        compressorCommand = new RunCompressor();
        autoIntakeCommand = new AutoIntake();
        runCameraCommand = new RunCamera();
        accelCommand = new Accel();
        runRadarCommand = new RunRadar();
        setGimbleCommand = new SetGimble();
        getDistanceCommand = new GetDistance();
        getAngleCommand = new GetAngle();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) 
        	//autonomousCommand.start();
        if(compressorCommand != null)
            compressorCommand.start();
        //if (runRadarCommand != null) {
        	//runRadarCommand.start();
        //}
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
        //if (runRadarCommand != null) {
        	//runRadarCommand.cancel();
        //}
        //if (runCameraCommand != null) {
        	//runCameraCommand.start();
        //}
        if (compressorCommand != null) {
        	compressorCommand.start();
        }
        //if (setGimbleCommand != null) {
        	//setGimbleCommand.start();
        //}
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	
    	if (driveCommand != null) 
        	driveCommand.cancel();
        if(compressorCommand != null)
            compressorCommand.cancel();
        if(getAngleCommand != null) {
        	getAngleCommand.cancel();
        }
        //if (setGimbleCommand != null) {
        	//setGimbleCommand.cancel();
        //}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if (driveCommand != null) {
        	driveCommand.start();
        }
        if (getAngleCommand != null) {
        	getAngleCommand.start();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
