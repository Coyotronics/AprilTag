// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package com.coyotronics.frc2022;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    private Constants() {
        /* disallow construction of this class */
        throw new UnsupportedOperationException("don't try to construct an instance of Constants ok bro");
    }

    /**
     * When competition mode is enabled, most throwable errors are disregarded.
     * Classes in the project should use the competition mode variable in order to
     * decide what their failure behavior should be.
     */
    public static final boolean kCompetitionMode = false;
    public static final boolean ksafetyMode = true; 
    public static final double kSafetyMultiplier = 0.25; //MAKE SURE BETWEEN 0 AND 1
    
    public static class Controller {
        public static final int LEFT_STICK_X = 0; // foward
	    public static final int LEFT_STICK_Y = 1; // backward
	    public static final int RIGHT_STICK_X = 4; //right
	    public static final int RIGHT_STICK_Y = 5; //left

        public static final int LEFT_TRIGGER = 2; //left
        public static final int RIGHT_TRIGGER = 3; //left

        public static final int RIGHT_BUMPER = 6; //switch drive type
        public static final int LEFT_BUMPER = 5; 

        public static final int A = 1;
	    public static final int B = 2;
	    public static final int X = 3;
	    public static final int Y = 4;

        public static final int BACK = 7;
        public static final int START = 8;
        public static final int RIGHT = 9;
        public static final int LEFT = 10;
    }
    public static class Common {
        public static final int kController = 0;
    }

    public static class Auto {
        
    }
    public static class Intake {
        public static final int kIntakeMotor = 18;
        public static final double kIntakeSpeed = 0.5;
    }
    public static class Shooter {
        public static final int kStorageMotor = 20; //now climb
        public static final int kTransportMotor = 21;
        public static final int kDischargeMotor = 19;
        public static final double kReductionMultiplier = 0.3;
        public static final double kTransportSpeed = 0.4;
        public static final double kDischargeSpeedLowHub = 0.4;
        public static final double kDischargeSpeedHighHub = 0.77;

        public enum ShootType {
            HIGH, LOW;
        }
    }
    public static class Drive {
        public static final int kRightFrontMotor = 3;
        public static final int kRightBackMotor = 2;
        public static final int kLeftFrontMotor = 4;
        public static final int kLeftBackMotor = 1;

        public enum DriveType {
            ARCADE, TANK;
        }
    }

    public static class Vars {
        public static Drive.DriveType cDriveType = Drive.DriveType.ARCADE;
        public static int cam = 0; //0 = field, 1 = intake

    }
}
