
package org.usfirst.frc.team4536.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4536.robot.RobotMap;
import org.usfirst.frc.team4536.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * 
 *
 */

public abstract class CommandBase extends Command {
	
	public static DriveTrain driveTrain = new DriveTrain(RobotMap.LEFT_MOTOR, RobotMap.RIGHT_MOTOR);
	public static CompressorSubsystem compSub = new CompressorSubsystem();

	public static Arm frontArm = new Arm(RobotMap.FRONT_ROLLER_MOTOR, RobotMap.FRONT_ARM_LEFT_SOLENOID_CHANNEL, RobotMap.FRONT_ARM_RIGHT_SOLENOID_CHANNEL);
	public static Arm backArm = new Arm(RobotMap.BACK_ROLLER_MOTOR, RobotMap.BACK_ARM_LEFT_SOLENOID_CHANNEL, RobotMap.BACK_ARM_RIGHT_SOLENOID_CHANNEL);
	
	public static Ultrasonic ultrasonic = new Ultrasonic(RobotMap.ULTRA_CHANNEL);
	
	public static Accelerometer accelerometer = new Accelerometer(RobotMap.X_CHANNEL, RobotMap.Y_CHANNEL, RobotMap.Z_CHANNEL);
	
	public static Gimble gimble = new Gimble(4, 5);
	
	public static Camera camera = new Camera();
	
    public CommandBase() {
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
