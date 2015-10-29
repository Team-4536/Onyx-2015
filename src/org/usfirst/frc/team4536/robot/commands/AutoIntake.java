package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;

public class AutoIntake extends CommandBase {
	
	boolean running;
	
	public AutoIntake() {
		requires(ultrasonic);
		requires(frontArm);
        requires(backArm);
	}
	
	protected void initialize() {
    }
	
    protected void execute() {
    	if (OI.frontOuttake.get() == false) {
    		if (ultrasonic.returnValue() <= 2) {
    			if (frontArm.isExtended() == false) {
    				frontArm.extend();
    			}
    			frontArm.setThrottle(.5);
    			if (backArm.isExtended() == true) {
    				backArm.retract();
    			}
    			backArm.setThrottle(-.15);
    			running = true;
    		}
    		else if (ultrasonic.returnValue() > 2 && running == true) {
    			frontArm.retract();
    			frontArm.setThrottle(0);
    			backArm.retract();
    			backArm.setThrottle(0);
    			running = false;
    		}
    	}
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    	end();
    }
	
}
