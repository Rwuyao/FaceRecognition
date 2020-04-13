package springboot.OpenCvNet.controller;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homecontroller {	
		static{
			String path = "D:\\Opencv\\build\\java\\x64\\opencv_java320.dll";
			System.load(path); 
		}
	@RequestMapping(value="/home")
	public  String ResetData(){
		 Mat mat = Mat.eye(4,4,CvType.CV_8UC3);  
	      System.out.println(mat); 
		return "index";
	}
		
	@RequestMapping(value="/open")
	public String video(){		
		return "haardetect";
	}
	
}
