package region;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class RegionUtils {
	/* Some Colors */
	static final Color brown = new Color(96,54,0);
	static final Color darkGreen = new Color(0,70,0);
	static final Color medGreen = new Color(0,128,0);
	
	static String imgLoadError = "Error loading image: ";
	
	public static List<String> ReadFile(File filePath){ //This is still in it's primitive form, and ReadFile should be used instead
		String fLine = "";
		List<String> fDataRaw = new ArrayList<String>(); //All Data in a file
		
		if (filePath.exists()){
			try {
				Scanner scan = new Scanner(filePath);
				while (scan.hasNext()) {
					fLine = scan.nextLine(); // This records every line
					fDataRaw.add(fLine); // this adds the string into the entire database
					fLine = "";//resets the line variable so the string doesn't keep concatenating the lines before it.
				}
				scan.close();
			}
			catch (FileNotFoundException ignored) {}
		}
		
		else{
			System.out.println("ERROR: FileOps can't find the file!");
		}
		return fDataRaw;	
	}
	
	public static Image loadImage(String path){
		Image img = null;
		try {
		    img = ImageIO.read(new File(path));
		    if(img == null){
		    	System.out.println(imgLoadError + path);
		    }
		} 
		catch (IOException e){ System.out.println(imgLoadError + path);} 
		catch(NullPointerException e){System.out.println(imgLoadError + path);}
		
		return img;
	}
	
	public static int[] addToArray(int[] baseArr, int add){
		for(int i = 0; i<baseArr.length;i++){
			baseArr[i] += add;
		}
		return baseArr;
	}
	
	public static boolean contains(Point test, int[] xPoints, int[] yPoints) {
	      int i;
	      int j;
	      boolean result = false;
	      for (i = 0, j = xPoints.length - 1; i < xPoints.length; j = i++) {
	        if (((yPoints[i] > test.y) != yPoints[j] > test.y) &&
	            (test.x < ((xPoints[j] - xPoints[i]) * (test.y - yPoints[i]) / (yPoints[j]-yPoints[i]) + xPoints[i]))) {
	          result = !result;
	         }
	      }
	      return result;
	 }
}

