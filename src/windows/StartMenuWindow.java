package windows;
 
 import java.awt.Color;
 
 import graphics.GraphicsImage;
import graphics.GraphicsPrimitives;
import main.Main;
 import main.Registry;
 import main.Main.menuItem;
 
 public class StartMenuWindow extends WindowItem {
	 private static menuItem thisMenu = menuItem.START;
 	GraphicsImage title = new GraphicsImage(Registry.imgRes.get("titleArt"),0,0,600,200, thisMenu);
 	GraphicsPrimitives titleLineTop    = new GraphicsPrimitives(new Color(234,208,0),0,198,600,2,thisMenu);
 	GraphicsPrimitives titleLineBottom = new GraphicsPrimitives(new Color(234,208,0),0,0,600, 2, thisMenu);
 	GraphicsPrimitives titleLineLeft   = new GraphicsPrimitives(new Color(234,208,0),0,0,2,200,thisMenu);
 	GraphicsPrimitives titleLineRight  = new GraphicsPrimitives(new Color(234,208,0),598,0,2,200,thisMenu);
 	// GraphicsImage(Image source, Int X, Int Y, Int Width, Int Height);
 
 	GraphicsImage loadGame = new GraphicsImage(Registry.imgRes.get("loadGameButton"),200,225,200,50, thisMenu){
 			@Override
 			public void onClick(){
 				Main.currMenu = menuItem.MAIN; //Use this syntax to change the window
 			}
 	};
 
 	GraphicsImage newGame = new GraphicsImage(Registry.imgRes.get("newGameButton"),200,300,200,50, thisMenu){
 			@Override
 			public void onClick(){
 				Main.currMenu = menuItem.MAIN; //Use this syntax to change the window
 			}
 	};
 
 	GraphicsImage credits = new GraphicsImage(Registry.imgRes.get("creditButton"),200,375,200,50, thisMenu){ 
 		@Override
 		public void onClick(){
 			Main.currMenu = menuItem.MAIN; //Use this syntax to change the window
 		}
 	};
 	
 	GraphicsImage exit = new GraphicsImage(Registry.imgRes.get("exitButton"),200,450,200,50, thisMenu){
 	};
 	
 	@Override
 	public void draw() {
 		title.drawObject();
 		titleLineTop.drawObject();
 		titleLineBottom.drawObject();
 		titleLineLeft.drawObject();
 		titleLineRight.drawObject();
 		
 		loadGame.drawObject();
 		newGame.drawObject();
 		credits.drawObject();
 		exit.drawObject();
 		// TODO Auto-generated method stub
 		
 	}
 }