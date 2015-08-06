package org.usfirst.frc.team4536.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team4536.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */



public class OI {
	
	public static Joystick mainStick;
	public static Joystick secondaryStick;
	public static Button frontArmToggleButton;
	public static Button backArmToggleButton;
	public static Button intakeButton;
	public static Button NeedsANameButton1;
	public static Button NeedsANameButton2;

	public OI(){
		mainStick = new Joystick(RobotMap.MAIN_STICK);
		secondaryStick = new Joystick(RobotMap.SECONDARY_STICK);
		
		/*-----------------------------------MainStick Buttons-------------------------------*/
		frontArmToggleButton = new JoystickButton(mainStick, 3);
		backArmToggleButton = new JoystickButton(mainStick, 2);
		intakeButton = new JoystickButton(mainStick, 1);
		
		frontArmToggleButton.whenPressed(new ToggleFrontArm());
		backArmToggleButton.whenPressed(new ToggleBackArm());
		intakeButton.whileHeld(new ArmOutIntake());
		
		/*--------------------------------SecondaryStick Buttons----------------------------*/
		NeedsANameButton1 = new JoystickButton(secondaryStick, 3);
		NeedsANameButton2 = new JoystickButton(secondaryStick, 2);
		
		NeedsANameButton1.whileHeld(new InsertNameHere(secondaryStick.getZ()));
		NeedsANameButton2.whileHeld(new InsertNameHere(-secondaryStick.getZ()));
	
	}
}
////CREATING BUTTONS
// One type of button is a joystick button which is any button on a joystick.
// You create one by telling it which joystick it's on and which button
// number it is.
// Joystick stick = new Joystick(port);
// Button button = new JoystickButton(stick, buttonNumber);

// There are a few additional built in buttons you can use. Additionally,
// by subclassing Button you can create custom triggers and bind those to
// commands the same as any other Button.

//// TRIGGERING COMMANDS WITH BUTTONS
// Once you have a button, it's trivial to bind it to a button in one of
// three ways:

// Start the command when the button is pressed and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenPressed(new ExampleCommand());

// Run the command while the button is being held down and interrupt it once
// the button is released.
// button.whileHeld(new ExampleCommand());

// Start the command when the button is released  and let it run the command
// until it is finished as determined by it's isFinished method.
// button.whenReleased(new ExampleCommand());

