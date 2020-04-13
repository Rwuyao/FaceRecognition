package springboot.OpenCvNet.service;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class Facedetect {
	
	public static Mat facedetect(Mat image){
		//System.out.println("Running DetectFace ... ");  
        // 从配置文件lbpcascade_frontalface.xml中创建一个人脸识别器，该文件位于opencv安装目录中  
        CascadeClassifier faceDetector = new CascadeClassifier("D:\\Opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_alt.xml");             
        Mat frame_gray=new Mat();
        //转灰度图再进行直方图均匀化
        Imgproc.cvtColor(image, frame_gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(frame_gray, frame_gray);
        // 在图片中检测人脸  
        MatOfRect faceDetections = new MatOfRect();   
        faceDetector.detectMultiScale(frame_gray, faceDetections);    
       // System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));   
        Rect[] rects = faceDetections.toArray();        
        for (int i = 0; i < rects.length; i++){
        // 在每一个识别出来的人脸周围画出一个方框  
        Rect rect = rects[i];    
        Imgproc.rectangle(image, new Point(rect.x-2, rect.y-2),  
                          new Point(rect.x + rect.width, rect.y + rect.height),  
                          new Scalar(0, 255, 0));                    
        }  
        return image;
	}
	 
}
