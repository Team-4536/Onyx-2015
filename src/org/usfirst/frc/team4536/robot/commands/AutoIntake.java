package org.usfirst.frc.team4536.robot.commands;

import org.usfirst.frc.team4536.robot.OI;
import edu.wpi.first.wpilibj.Timer;

public class AutoIntake extends CommandBase {
	
	boolean running;
	Timer time;
	
	public AutoIntake() {
		requires(ultrasonic);
		requires(frontArm);
        requires(backArm);
	}
	
	protected void initialize() {
		time = new Timer();
		time.start();
		running = false;
    }
	
    protected void execute() {
    	System.out.println(OI.frontOuttake.get());
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
    		else {
    			running = false;
    		}
    	}
    }
    
    protected boolean isFinished() {
    	if (time.get() > 10) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    protected void end() {
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
		running = false;
    }
    
    protected void interrupted() {
    	end();
    }
	
}
