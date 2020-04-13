package springboot.OpenCvNet.service;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

public class bytetomat {

	public Mat convert(byte[] data){
		MatOfByte Mob = new MatOfByte(data);
   	 	Mat result = Imgcodecs.imdecode(Mob, Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
		return result;		 
	}
	
	public  byte[] rconvert(Mat data){    
        MatOfByte mob = new MatOfByte();
		Imgcodecs.imencode(".jpg",data,mob);
        byte[] byteArray = mob.toArray();
        return byteArray;	 
	}		 
}
