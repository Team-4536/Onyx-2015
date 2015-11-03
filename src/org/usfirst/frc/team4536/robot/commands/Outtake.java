package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Outtake extends CommandBase {
	
	double throttle;
	double Direction;

    public Outtake(int direction) {
        // Use requires() here to declare subsystem dependencies
        requires(backArm);
        requires(frontArm);
        Direction = direction;
        // A positive direction makes it outtake forward, negative makes it outtake backward
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	throttle = (-0.5 * OI.secondaryStick.getZ()) + 0.5;
    	backArm.setThrottle(Direction*throttle);
    	frontArm.setThrottle(-Direction*throttle);
    	System.out.println(throttle);
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
