package Main;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import Main.ObjectAndLocation.ObjectType;

public class Main {
	static ArrayList<ObjectAndLocation> list = new ArrayList<ObjectAndLocation>();
	public static void main(String[] args) {
	      System.loadLibrary(Core.NATIVE_LIBRARY_NAME );
	    //DataSet
		list.add(new ObjectAndLocation(ObjectType.cone, 2165,1640,"FILEPATH4.jpg"));
		list.add(new ObjectAndLocation(ObjectType.cone, 969,589,"FILEPATH5.jpg"));
		list.add(new ObjectAndLocation(ObjectType.cone, 2150,1500,"FILEPATH6.jpg"));
		list.add(new ObjectAndLocation(ObjectType.cone, 2200,858,"FILEPATH3.jpg"));
		BufferedImage tempImg = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
		Window w = new Window(tempImg);
		while(true) {
		try {
		      VideoCapture capture = new VideoCapture(0);
		      
		      Mat matrix = new Mat();
		      capture.read(matrix);
		      //Is Camera Opened?
		      if(capture.isOpened()) {
		    	  //If we can read the Camera
		         if (capture.read(matrix)) {
		        	//Convert Mat from OpenCV to BufferedImage
		        	BufferedImage img = Util.Mat2BufferedImage(matrix);
		        	//Search for cone
		        	LocationAndConfidence result = searching.getLocCone(img, list,1);

		        	//Draw Locator
		 			img = Util.drawCircle(img, result.getX(), result.getY());
		 			//Refresh Image
		     		w.updateImg(img, result.getConfidence());
		         }
		      }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
