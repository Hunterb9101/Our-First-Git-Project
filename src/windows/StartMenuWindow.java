package windows;
 
 import java.awt.Color;
 
 import graphics.GraphicsImage;
 import main.Main;
 import main.Registry;
 import main.Main.menuItem;
 
 public class StartMenuWindow extends WindowItem {
	 private static menuItem thisMenu = menuItem.START;
 	GraphicsImage title = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),100,0,400,100, thisMenu);
 	
 	// GraphicsImage(Image source, Int X, Int Y, Int Width, Int Height);
 
 	GraphicsImage loadGame = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,175,200,50, thisMenu){
 			@Override
 			public void onClick(){
 				Main.currMenu = menuItem.NONE; //Use this syntax to change the window
 			}
 	};
 
 	GraphicsImage newGame = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,250,200,50, thisMenu){
 			@Override
 			public void onClick(){
 				Main.currMenu = menuItem.NONE; //Use this syntax to change the window
 			}
 	};
 
 	GraphicsImage credits = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,325,200,50, thisMenu){ 
 		@Override
 		public void onClick(){
 			Main.currMenu = menuItem.NONE; //Use this syntax to change the window
 		}
 	};
 	
 	GraphicsImage exit = new GraphicsImage(Registry.imgRes.get("InventoryMenu"),200,400,200,50, thisMenu){
 	};
 	
 	@Override
 	public void draw() {
 		title.drawObject();
 		loadGame.drawObject();
 		newGame.drawObject();
 		credits.drawObject();
 		exit.drawObject();
 		// TODO Auto-generated method stub
 		
 	}
 }