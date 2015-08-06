package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmOutIntake extends CommandBase {
	
	public double throttle;

    public ArmOutIntake() {
        // Use requires() here to declare subsystem dependencies
        requires(frontArm);
        requires(backArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(frontArm.isExtended()){
    		frontArm.setThrottle(1.0);
    	}
    	if(backArm.isExtended()){
    		backArm.setThrottle(1.0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
