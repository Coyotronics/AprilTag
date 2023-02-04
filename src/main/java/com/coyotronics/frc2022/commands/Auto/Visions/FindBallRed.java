// package com.coyotronics.frc2022.commands.Auto.Visions;
// // package com.coyotronics.frc2022.commands.Auto.SubsytemInterfaces;
// // import edu.wpi.first.wpilibj2.command.CommandBase;
// // import com.coyotronics.frc2022.subsystems.DriveBaseSubsystem;


// import org.opencv.core.Rect;
// import org.opencv.imgproc.Imgproc;
// import edu.wpi.first.cscore.UsbCamera;
// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.DriverStation;
// import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.vision.VisionRunner;
// import edu.wpi.first.vision.VisionThread;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// import edu.wpi.first.cscore.CvSource;
// import org.opencv.core.Mat;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import org.opencv.core.MatOfPoint;
// import org.opencv.core.Scalar;
// import org.opencv.core.Mat;
// import org.opencv.core.MatOfPoint;
// import org.opencv.core.Scalar;
// import edu.wpi.first.cscore.CvSource;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


// public class FindBallRed extends CommandBase {
//       UsbCamera cam;
//     Object imgLock;
//     public FindBallRed(UsbCamera cam){
//       this.cam = cam;
//     }
//     public FindBallRed(){

//     }
//     public void initialize() {
//       imgLock = new Object();
//     }
//     public void execute() {
//         // CvSource output = CameraServer.putVideo("VisionOutput", 160, 120);
//         Mat res = new Mat();
//         System.out.println("STARTING 1");
//         VisionThread vision = new VisionThread(cam, new RedBallPipeline(), pipeline -> {
//           System.out.println("STARTING 2");
//             if(!pipeline.filterContoursOutput().isEmpty()) {
//               System.out.println("STARTING 3");
//               MatOfPoint largest = pipeline.filterContoursOutput().get(0);
//               int index = 0;
//               for(int i = 0; i < pipeline.filterContoursOutput().size(); ++i) {
//                 MatOfPoint contour = pipeline.filterContoursOutput().get(i);
//                 if(Imgproc.contourArea(contour) > Imgproc.contourArea(contour)) {
//                   largest = contour;
//                   index = i;
//                 }
//               }
//               Imgproc.drawContours(res, pipeline.filterContoursOutput(), index, new Scalar(255, 255, 255), -1);
//               synchronized (imgLock) {
//                 Rect boundRect = Imgproc.boundingRect(largest);
//                 double cX = boundRect.x + (boundRect.width / 2);
//                 double cY = boundRect.y + (boundRect.height / 2);
  
//                 SmartDashboard.putNumber("cX", cX);
//                 SmartDashboard.putNumber("cY", cY);
  
//                 // output.putFrame(res);
//               }
//             } else {
//               System.out.println("0 Contours");
//               SmartDashboard.putNumber("cX", -1);
//             }
//           });
//           vision.start();
//     }
//     public void end(boolean interrupted) {}
//      public boolean isFinished() {
//         return false;
//     }
// }
