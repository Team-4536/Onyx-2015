package org.usfirst.frc.team4536.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/*-------------------------------------Motor Channels------------------------------------*/	
    public static final int LEFT_MOTOR = 1;
    public static final int RIGHT_MOTOR = 0;
    public static final int FRONT_ROLLER_MOTOR = 3;
    public static final int BACK_ROLLER_MOTOR = 2;
    
    /*-------------------------------------Joystick Ports---------------------------------*/
    public static final int MAIN_STICK = 0; // (Also the left stick for tank drive)
    public static final int SECONDARY_STICK = 1; // (Also the right stick for tank drive)
    
    /*-------------------------------------Solenoid Channels------------------------------------*/	
    public static final int FRONT_ARM_RIGHT_SOLENOID_CHANNEL = 4;
	public static final int FRONT_ARM_LEFT_SOLENOID_CHANNEL = 6;
	public static final int BACK_ARM_RIGHT_SOLENOID_CHANNEL = 5;
	public static final int BACK_ARM_LEFT_SOLENOID_CHANNEL = 7;
}

