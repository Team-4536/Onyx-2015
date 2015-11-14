package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class TurnCatch extends CommandBase {
	
	Timer time;
	
	double Time;
	
	double pos;
	double diff;
	double speed;
	
	public TurnCatch() {
		requires(gimble);
		requires(ultrasonic);
		requires(frontArm);
        requires(backArm);
        requires(driveTrain);
        requires(gyro);
	}
	
	protected void initialize() {
		time = new Timer();
		gimble.setLatPos(.2);
		gimble.setVertPos(.8);
		driveTrain.arcadeDrive(0, 0);
		gyro.reset();
    }
    
    protected void execute() {
    	gyro.reset();
    	time.reset();
    	time.start();
    	gimble.setLatPos(.2);
		gimble.setVertPos(.8);
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
		while (ultrasonic.returnValue() > 20) {
    	}
    	Time = time.get();
    	while (time.get() < Time + 2) {
			if (frontArm.isExtended() == false) {
			frontArm.extend();
			}
			frontArm.setThrottle(.5);
			if (backArm.isExtended() == true) {
			backArm.retract();
			}
			backArm.setThrottle(-.15);
		}
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
		Time = time.get();
		while (time.get() < Time + .5) {
			driveTrain.arcadeDrive(0, .5);
		}
		while ((gyro.getPos() <= 86 || gyro.getPos() >= 88) && gyro.getRate() > .1) {
			pos = gyro.getPos();
			diff = 90 - pos;
			speed = diff / 70;
			if (speed > .5) {
				speed = .5;
			}
			driveTrain.arcadeDrive(0, speed);
		}
		driveTrain.arcadeDrive(0, 0);
    	Time = time.get();
    	while (time.get() < Time + 2) {
    		frontArm.setThrottle(-.4);
    		backArm.setThrottle(.4);
    	}
    	end();
    }
    
    protected boolean isFinished() {
    	return false;
    }
    
    protected void end() {
    	frontArm.retract();
		frontArm.setThrottle(0);
		backArm.retract();
		backArm.setThrottle(0);
		time.reset();
    }
    
    protected void interrupted() {
    	end();
    }
	
}
