// package com.coyotronics.frc2022.commands.Auto.Visions;

// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.HashMap;

// import edu.wpi.first.cscore.UsbCamera;
// import edu.wpi.first.wpilibj.vision.VisionPipeline;

// import org.opencv.core.*;
// import org.opencv.core.Core.*;
// import org.opencv.features2d.FastFeatureDetector;
// import org.opencv.imgcodecs.Imgcodecs;
// import org.opencv.imgproc.*;
// import org.opencv.objdetect.*;

// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.cscore.CvSink;
// import edu.wpi.first.cscore.CvSource;
// import edu.wpi.first.cscore.UsbCamera;
// import edu.wpi.first.wpilibj.TimedRobot;
// import org.opencv.core.Mat;
// import org.opencv.core.Point;
// import org.opencv.core.Scalar;
// import org.opencv.imgproc.Imgproc;


// public class BlueVisionPipeline {
//     Mat mat;
//     public BlueVisionPipeline(Mat mat) {
//         Core.inRange(mat, new Scalar(1,1,1), new Scalar(1,1,1), mat);
//         Imgproc.blur(mat, mat, new Size(3, 3), new Point(-1, -1));
//         // Imgproc.erode(mat, mat, kernel)
//         ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
//         Mat heir = new Mat();
//         Imgproc.findContours(mat, contours, heir, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_NONE);
//         Mat res = new Mat();
//         mat.copySize(res);
//         mat.copyTo(res);
//        for(int i = 0; i < contours.size(); ++i) {
//             MatOfPoint contour = contours.get(i);
//             // if(Imgproc.isContourConvex(contour)) {

//                 Imgproc.drawContours(res, contours, i, new Scalar(255, 255, 255), -1);
                
//                 Rect boundRect = Imgproc.boundingRect(contour);
//                 double centerX = boundRect.x + (boundRect.width / 2);
//                 double centerY = boundRect.y + (boundRect.height / 2);
//             // }
//         }
//         CvSource outputStream = CameraServer.putVideo("Blur", 640, 480);
//         outputStream.putFrame(res);

//     }
//     // public BlueVisionPipeline()
// }