package graphics;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConstructorClass extends JApplet implements ActionListener, KeyListener, FocusListener, MouseListener {
	
	protected void doInitialization(int width, int height) {
		// This routine is called once when the applet is first created.
		// You can override it to do initialization of your instance
		// variables. It's also a good place to call setFrameCount()
		// and setMillisecondsPerFrame(), if you want to customize these
		// values. The parameters tell the size of the drawing area
		// at the time the applet is created.
	}

	protected void drawFrame(Graphics g, int width, int height) {
		//this.setSize(600,600);
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		g.drawString("Elapsed Time:  " + (getElapsedTime() / 1000), 10, 20);
		g.drawString("Frame Number:  " + (getFrameNumber()), 10, 35);
	}

	public void keyTyped(KeyEvent evt) {
		// Method to respond when the user types a character. Use
		// char key = evt.getKeyChar() to find out which character
		// was typed. Note that this method is part of the
		// KeyListener interface.
	}

	public void keyPressed(KeyEvent evt) {
	}

	public void keyReleased(KeyEvent evt) {
		// Method to respond when the user releases a key. Use evt.getKeyCode()
		// to get the code number of the key that was released. Override this
		// method if you want to respond when the user releases a key. This
		// method
		// is part of the KeyListener interface.
	}

	public int getFrameNumber() {
		return frameNumber;
	}

	public void setFrameNumber(int frameNumber) {
		// Set the current frame number. This is the value returned by
		// getFrameNumber().
		if (frameNumber < 0)
			this.frameNumber = 0;
		else
			this.frameNumber = frameNumber;
	}

	public long getElapsedTime() {
		// return the total number of milliseconds that the animation has been
		// running (not including the time when the applet is suspended by
		// the system or when the applet does not have the keyboard focus).
		return elapsedTime;
	}

	public void setFrameCount(int max) {
		// If you want your animation to loop through a set of frames over
		// and over, you should call this routine to set the frameCount to
		// the number of frames in the animation. Frames will be numbered
		// from 0 to frameCount - 1. If you specify a value <= 0, the
		// frameNumber will increase indefinitely without ever returning
		// to zero. The default value of frameCount is -1, meaning that
		// by default frameNumber does NOT loop.
		if (max <= 0)
			this.frameCount = -1;
		else
			frameCount = max;
	}

	public void setMillisecondsPerFrame(int time) {
		// Set the approximate number of milliseconds to be used for each frame.
		// For example, set time = 1000 if you want each frame to be displayed
		// for
		// about a second. The time is only approximate, and the actual display
		// time will probably be a bit longer. The default value of 40 is
		// probably OK for a game.
		millisecondsPerFrame = time;
		if (timer != null)
			timer.setDelay(millisecondsPerFrame);
	}

	public void setFocusBorderColor(Color c) {
		focusBorderColor = c;
	}


	private int frameNumber = 0; // Current frame number.
	private int frameCount = -1; // If > 0, frame number loops from
									// frameNumber-1 back to 0.
	private int millisecondsPerFrame = 40; // Approximate time between frames.

	private long startTime; // Time since animation was started or restarted.
	private long oldElapsedTime; // Holds time the animation had been running
									// before
									// it was most recently restarted.
	private long elapsedTime; // Time animation has been running. This is set
								// just before each frame is drawn.

	private Timer timer; // The timer that drives the animation.

	private JPanel frame; // Where the frames are drawn. This panel fills the
							// applet.

	private boolean focussed = false; // set to true when the applet has the
										// keyboard focus

	Color focusBorderColor = Color.black; // Color of border when applet has the
											// focus.

	public ConstructorClass() { // Constructor
		frame = new JPanel() {
			public void paintComponent(Graphics g) {
				int width = getWidth();
				int height = getHeight();
				drawFrame(g, width, height);
				if (focussed) // Draw a 3-pixel border. If the applet has the
					g.setColor(focusBorderColor); // focus, draw it in
													// focusBorderColor;
													// otherwise,
				else
					// draw it in the background color.
					g.setColor(ConstructorClass.this.getBackground());
				g.drawRect(0, 0, width - 1, height - 1);
				g.drawRect(1, 1, width - 3, height - 3);
				g.drawRect(2, 2, width - 5, height - 5);
				if (!focussed) { // If the applet does not have the focus,
									// print a message for the user.
					g.setColor(ConstructorClass.this.getForeground());
					g.drawString("Paused", 10, height - 12);
				}
			}
		};
		setContentPane(frame);
		setBackground(Color.red); // Color used for border when applet doesn't
									// have focus.
		setForeground(Color.red);
		frame.setFont(new Font("SanSerif", Font.BOLD, 30));
		frame.addFocusListener(this);
		frame.addKeyListener(this);
		addMouseListener(this);
	}

	public void init() {
		// Just call do initialization. (This is in init() instead of in
		// the constructor since the size of the applet is not known in the
		// constructor.)
		doInitialization(getSize().width, getSize().height);
	}

	public void actionPerformed(ActionEvent evt) {
		// Called by the timer when it's time to draw a new frame.
		frameNumber++;
		if (frameCount > 0 && frameNumber >= frameCount)
			frameNumber = 0;
		elapsedTime = oldElapsedTime + (System.currentTimeMillis() - startTime);
		frame.repaint();
	}

	private void startAnimation() {
		// Start or restart the animation, but only if the applet has focus.
		if (focussed) {
			if (timer == null) {
				timer = new Timer(millisecondsPerFrame, this);
				timer.start();
			} else
				timer.restart();
			startTime = System.currentTimeMillis();
		}
	}

	private void stopAnimation() {
		// Start the animation, if it's running, i.e. if the applet has focus.
		if (focussed) {
			oldElapsedTime += (System.currentTimeMillis() - startTime);
			elapsedTime = oldElapsedTime;
			frame.repaint();
			timer.stop();
		}
	}

	public void start() {
		// Called by the system when the applet is first started
		// or restarted after being stopped. (Probably this has
		// no effect, since we shouldn't get forcus events before
		// the applet is started.)
		startAnimation();
	}

	public void stop() {
		// Called by the system to suspend the applet.
		stopAnimation();
	}

	public void focusGained(FocusEvent evt) {
		// The applet now has the input focus. Set focussed = true
		// start the animation.
		focussed = true;
		startAnimation();
	}

	public void focusLost(FocusEvent evt) {
		// The applet has lost the input focus. Set focussed = false
		// and stop the animation.
		stopAnimation();
		focussed = false;
	}

	public void mousePressed(MouseEvent evt) {
		// Request the input focus when the user clicks on
		// the applet.
		frame.requestFocus();
	}

	public void mouseEntered(MouseEvent evt) {
	} // Required by the

	public void mouseExited(MouseEvent evt) {
	} // MouseListener

	public void mouseReleased(MouseEvent evt) {
	} // interface.

	public void mouseClicked(MouseEvent evt) {
	}

} // end class KeyboardAnimationApplet2


