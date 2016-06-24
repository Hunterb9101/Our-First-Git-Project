package graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConstructorClass extends JApplet implements ActionListener, KeyListener, FocusListener, MouseListener {
	public static int fps = 200;
	private Timer timer; // The timer that drives the animation.
	private JPanel frame; // Where the frames are drawn.
	
	private boolean focused = false; // When applet is focused

	public ConstructorClass() { // Constructor
		frame = new JPanel() {
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				draw(g, width, height);
				
				// Draw Border //
				if(!focused){
					g.setColor(ConstructorClass.this.getForeground()); // Draw Text as well
					g.drawString("Paused", 10, height - 12);
					
					g.setColor(ConstructorClass.this.getBackground());
					
					g.drawRect(0, 0, width - 1, height - 1);
					g.drawRect(1, 1, width - 3, height - 3);
					g.drawRect(2, 2, width - 5, height - 5);
				}
			
			}
		};
		
		setContentPane(frame);
		setBackground(Color.red); // Color for border
		setForeground(Color.red); // Color for text
		
		frame.setFont(new Font("SanSerif", Font.BOLD, 30)); // Default font
		frame.addFocusListener(this);
		frame.addKeyListener(this);
		addMouseListener(this);
	}

	
	protected void init(int width, int height) {}
	public void init(){ init(getSize().width, getSize().height);}
	protected void draw(Graphics g, int width, int height) {}
	
	public void actionPerformed(ActionEvent evt) { frame.repaint();}

	public void start() {
		if (focused) {
			if (timer == null) {
				timer = new Timer((1000/fps), this);
				timer.start();
			} 
			else timer.restart();
		}
	}

	public void stop() {
		if (focused) {
			frame.repaint();
			timer.stop();
		}
	}

	public void focusGained(FocusEvent evt) {
		focused = true;
		start();
	}

	public void focusLost(FocusEvent evt) {
		focused = false;
		stop();
	}
	
	public void keyTyped(KeyEvent evt) {}
	public void keyPressed(KeyEvent evt) {}
	public void keyReleased(KeyEvent evt) {}
	
	public void mousePressed(MouseEvent evt) {frame.requestFocus();}
	public void mouseEntered(MouseEvent evt) {}
	public void mouseExited(MouseEvent evt) {} 
	public void mouseReleased(MouseEvent evt) {} 
	public void mouseClicked(MouseEvent evt) {}
}


