package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class ToggleBackArm extends CommandBase {

	boolean prevArmValue;
	boolean armValue;
	
    public ToggleBackArm() {
        // Use requires() here to declare subsystem dependencies
        requires(backArm);    
        }

    // Called just before this Command runs the first time
    protected void initialize() {
    	prevArmValue = backArm.isExtended();
    	backArm.flip();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	armValue = backArm.isExtended();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (armValue != prevArmValue){
        	return true;
        	}
        else
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
