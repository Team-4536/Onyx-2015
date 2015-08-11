package org.usfirst.frc.team4536.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

public class Arm extends Subsystem {
	
	Talon roller;
	Solenoid leftSolenoid;
	Solenoid rightSolenoid;
    
	public Arm(int rollerSlot, int solenoidSlot1, int solenoidSlot2){
		roller = new Talon(rollerSlot);
        leftSolenoid = new Solenoid (solenoidSlot1);
        rightSolenoid = new Solenoid (solenoidSlot2);
        retract();
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	/**
	 * @author Stepan
	 */
	public void retract() {
		leftSolenoid.set(false);
		rightSolenoid.set(true);
	}
	
	public void setThrottle(double throttle){
		roller.set(throttle);	
	}
	
	/**
	 * @author Stepan
	 */
	public void extend() {
		leftSolenoid.set(true);
		rightSolenoid.set(false);
	}
	
	/**
	 * @author Stepan
	 * Sets the state of piston as the opposite of its current state
	 */
	public void flip() {
		leftSolenoid.set(!leftSolenoid.get());
		rightSolenoid.set(!rightSolenoid.get());
	}
	
	/**
	 * @author Stepan
	 */
	public boolean isExtended() {
		return leftSolenoid.get();
	}
}

