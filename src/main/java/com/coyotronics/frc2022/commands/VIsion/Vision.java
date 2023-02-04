package com.coyotronics.frc2022.commands.VIsion;

import java.lang.annotation.Target;

import org.opencv.photo.Photo;
import org.photonvision.PhotonCamera;

import com.coyotronics.frc2022.Constants;
import com.coyotronics.frc2022.Robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;import org.photonvision.targeting.PhotonTrackedTarget;

import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;
import com.coyotronics.frc2022.subsystems.VisionSubsystem;
import com.coyotronics.frc2022.RobotContainer;

import edu.wpi.first.math.geometry.*;

public class Vision extends CommandBase {
    PhotonCamera camera;
	DriveBaseSubsystem db;
	final double CAMERA_HEIGHT_METERS = 0.175;
	final double TARGET_HEIGHT_METERS = 0.185;
	final double CAMERA_PITCH_RADIANS = 0.0;

	boolean foundTag = false;
	JoystickButton align;

    public Vision(VisionSubsystem ph, PhotonCamera cam, DriveBaseSubsystem db) {
        this.camera = cam;
		align = new JoystickButton(RobotContainer.controller, 1);
		this.db = db;
		addRequirements(ph);
    }
	public double degreesToRadians(double degrees) {
		return degrees / 180.0 * 3.141593;
	}
	public double radToDeg(double radians) {
		return radians * 180.0 / 3.141593;
	}

	@Override
	public void initialize() {
		this.align.whileTrue(new FindAndPursueAT(this.db, 0.3));
	}

	@Override
	public void execute() {
		executeAprilTagPipeline();
	}

	public void executeAprilTagPipeline() {
		PhotonTrackedTarget target = getAprilTags();
		this.setVVData(target);
	}
	public void setVVData(PhotonTrackedTarget t) {
		VV.trackingtest.targets = (t == null) ? false : true;
		VV.trackingtest.X = (t == null) ? 0 : t.getBestCameraToTarget().getX();
		VV.trackingtest.Y = (t == null) ? 0 : t.getBestCameraToTarget().getY();
		VV.trackingtest.theta = (t == null) ? 0 : t.getYaw();
	}


	public PhotonTrackedTarget getAprilTags() {
		var result = camera.getLatestResult();
		foundTag = result.hasTargets();
		SmartDashboard.putBoolean("Targests?", foundTag);
		SmartDashboard.putNumber("Latency", result.getLatencyMillis());
		if(foundTag) {
			putData(result.getBestTarget());
			SmartDashboard.putNumber("Targets", result.getTargets().size());
			return result.getBestTarget();
		} 
		return null;
	}

	public void putData(PhotonTrackedTarget target) {
		Transform3d bestresult = target.getBestCameraToTarget();

		double X = bestresult.getX();
		double Y = bestresult.getY();
		double Z = bestresult.getZ();
		double XYdistance = Math.sqrt(X * X + Y * Y);
		double ambiguity = target.getPoseAmbiguity();
		double yaw = target.getYaw();
		double id = target.getFiducialId();
		double pitch = target.getPitch();
		Rotation3d rotation = target.getBestCameraToTarget().getRotation();
		double angle = radToDeg(rotation.getAngle());
		double XAngle = radToDeg(rotation.getX());
		double YAngle = radToDeg(rotation.getY());
		double ZAngle = radToDeg(rotation.getZ());

		SmartDashboard.putNumber("X Translation", X);
		SmartDashboard.putNumber("Y Translation", Y);
		SmartDashboard.putNumber("Z Translation", Z);
		SmartDashboard.putNumber("XY Distance", XYdistance);

		// SmartDashboard.putNumber("Rotation Angle", angle);
		// SmartDashboard.putNumber("X Angle", XAngle);
		// SmartDashboard.putNumber("Y Angle", YAngle);
		// SmartDashboard.putNumber("Z Angle", ZAngle);

		// SmartDashboard.putNumber("Pitch", pitch);
		SmartDashboard.putNumber("Yaw", yaw);
		SmartDashboard.putNumber("ID", id);
		SmartDashboard.putNumber("Ambiguity", ambiguity);
	}

}
