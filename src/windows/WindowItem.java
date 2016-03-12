package windows;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Main;

public abstract class WindowItem extends Main{
	public abstract void draw();
	public static Image loadImage(String path){
		Image img = null;
		try {
		    img = ImageIO.read(new File(path));
		} catch (IOException e){}		
		return img;
	}
}
