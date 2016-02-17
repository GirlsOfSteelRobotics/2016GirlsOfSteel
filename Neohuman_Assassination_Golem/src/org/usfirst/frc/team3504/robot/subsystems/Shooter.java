package org.usfirst.frc.team3504.robot.subsystems;

import org.usfirst.frc.team3504.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private CANTalon shooterMotor1;
	private CANTalon shooterMotor2;
	
	public Shooter() {
		//shooterMotor1 = null;
		//shooterMotor2 = null;
		
		shooterMotor1 = new CANTalon(RobotMap.SHOOTER_MOTOR_A);
		shooterMotor1.changeControlMode(TalonControlMode.PercentVbus);
		shooterMotor2 = new CANTalon(RobotMap.SHOOTER_MOTOR_B);
		shooterMotor2.changeControlMode(TalonControlMode.PercentVbus);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void spinWheels() {
    	shooterMotor1.set(0.8);
    	shooterMotor2.set(-0.8);
    }
    
    public void collectWheels() {
    	shooterMotor1.set(-0.8);
    	shooterMotor2.set(0.8);
    }
    
    public void stop() {
    	shooterMotor1.set(0.0);
    	shooterMotor2.set(0.0);
    }
}

