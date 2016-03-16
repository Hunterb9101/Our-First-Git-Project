package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import main.Main;

public abstract class GraphicsObject{
	public static ArrayList<GraphicsObject> allObjects = new ArrayList<GraphicsObject>();
	
	//Basic reference for the interface//
	protected static int defaultWidth = 600;
	protected static int defaultHeight = 600;
	
	//Current Size of interface//
	public static int currWidth = defaultWidth;
	public static int currHeight = defaultHeight;
	
	//Current Scalar Values//
	protected static double xScalar = ((double)currWidth/(double)defaultWidth);
	protected static double yScalar = ((double)currHeight/(double)defaultHeight);
	
	//Positioning in reference to defaults//
	public int x = 0;
	public int y = 0;
	public int width = 0;
	public int height = 0;
	public Main.menuItem parentMenu;
	public boolean freeMotion = true; //Determines whether the object is scalable
	
	public GraphicsObject(int iX, int iY, int iWidth, int iHeight, Main.menuItem iParentMenu){
		x = iX;
		y = iY;
		width = iWidth;
		height = iHeight;
		parentMenu = iParentMenu;
		allObjects.add(this);
		
		System.out.println("SYSTEM: OBJECTS INITIALIZED: " + allObjects.size());
	}
	
	public abstract void drawObject();
	
	
	public abstract void onClick();
	public abstract void onHover();
	
	public static void setDimens(int cWidth, int cHeight){
		currWidth = cWidth;
		currHeight = cHeight;
		
		xScalar = ((double)currWidth/(double)defaultWidth);
		yScalar = ((double)currHeight/(double)defaultHeight);
	}
	
	public void setDefaultDimens(int defWidth, int defHeight){
		defaultWidth =  defWidth;
		defaultHeight = defHeight;
	}
	
	public static void checkOnClick(int x, int y){
		GraphicsObject obj;
		for(int i = 0; i<allObjects.size(); i++){
			obj = allObjects.get(i);
			if(obj.parentMenu.equals(Main.currMenu) || obj.parentMenu.equals(Main.menuItem.DEFAULT)){
				obj.onClick();
			}
		}
	}
	
	public static void checkOnHover(int x, int y){
		GraphicsObject obj;
		for(int i = 0; i < allObjects.size(); i++){
			obj = allObjects.get(i);
			if((x > obj.x*xScalar && x < (obj.width+obj.x)*xScalar) && (y > obj.y*yScalar && y < (obj.y+obj.height)*yScalar)){
				if(obj.parentMenu.equals(Main.currMenu) || obj.parentMenu.equals(Main.menuItem.DEFAULT)){
					obj.onHover();
				}
				
			}
		}
	}
}
