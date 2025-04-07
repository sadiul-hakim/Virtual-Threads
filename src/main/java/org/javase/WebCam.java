//package org.javase;
//
//import org.bytedeco.javacpp.Loader;
//import org.bytedeco.opencv.opencv_java;
//import org.opencv.core.Mat;
//import org.opencv.highgui.HighGui;
//import org.opencv.videoio.VideoCapture;
//
//public class WebCam {
//    static {
//        Loader.load(opencv_java.class);
//    }
//
//    public static void main(String[] args) {
//        VideoCapture capture = new VideoCapture(0); // 0 for default camera
//        if (!capture.isOpened()) {
//            System.out.println("Cannot open webcam");
//            return;
//        }
//
//        Mat frame = new Mat();
//        while (true) {
//            if (capture.read(frame)) {
//                HighGui.imshow("Webcam Feed", frame);
//                if (HighGui.waitKey(1) == 27) break; // Press 'Esc' to exit
//            } else {
//                System.out.println("Failed to capture frame");
//                break;
//            }
//        }
//
//        capture.release();
//        HighGui.destroyAllWindows();
//    }
//}
