package com.coyotronics.frc2022.commands.VIsion;

public class VV { // VisionVariables
	public static class trackingtest {
		public static boolean targets = false; 	
		public static double theta = 0.0;
		public static double X = 0;
		public static double Y = 0;

		public static final double angleTolerance = 3.0;
		public static final double anglekP = 0.04;
		public static final double transkP = .2;
		public static int iterationsFromLastTarget = 100_00;
	}
}

