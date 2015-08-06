package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Outtake extends CommandBase {
	
	public double throttle;

    public Outtake(double throttle) {
        // Use requires() here to declare subsystem dependencies
        requires(backArm);
        requires(frontArm);
        this.throttle = throttle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	backArm.setThrottle(throttle);
    	frontArm.setThrottle(-throttle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	frontArm.setThrottle(0);
    	backArm.setThrottle(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
