package New;
import java.util.Scanner;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class Helper {
	private long startTime;
	private long elapsedTime;
	
	public Helper(){
		startTime = System.currentTimeMillis(); //starts the timer
	}
	
	public void start(){
		startTime = System.currentTimeMillis();
	}
	
	public long getElapsedTime(){
		elapsedTime = System.currentTimeMillis() - startTime;
		return elapsedTime;
	}
	
	public static void printlnTextSlowly(String text){
		try{
			for(int i = 0; i<text.length(); i++){
				System.out.print(text.substring(i,i+1));
				Thread.sleep(250);
			}
			System.out.println();
		}
		catch(InterruptedException e){
		}
	}
	
	public static void printlnTextSlowly(String text, int time){
		try{
			for(int i = 0; i<text.length(); i++){
				System.out.print(text.substring(i,i+1));
				Thread.sleep(time);
			}
			System.out.println();
		}
		catch(InterruptedException e){
		}
	}
	
	public void tone(int hz, int msecs) throws LineUnavailableException {
	     tone(hz, msecs);
	}
	
	public void tone(int hz, int msecs, double vol) throws LineUnavailableException {
	    byte[] buf = new byte[1];
	    float SAMPLE_RATE = 8000f;
	    AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false); // sampleRate, sampleSizeInBits, channels, signed, bigEndian
	    SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
	    sdl.open(af);
	    sdl.start();
	    for (int i=0; i < msecs*8; i++) {
	      double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
	      buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
	      sdl.write(buf,0,1);
	    }
	    sdl.drain();
	    sdl.stop();
	    sdl.close();
	}
	
	public boolean isAgreement(String responce){
		String[] consent = {"Yes", "Yeah", "Ya", "Ye", "Sure", "Yup", "Sounds good"};
		for (int i = 0; i < consent.length; i++) {
			if(consent[i].equalsIgnoreCase(responce)){
				return true;
			}
		}
		if(responce.startsWith("ye")){
			responce = readString("Please answer with just yes or no");
			isAgreement(responce);
		}
		return false;
	}
	
	public void playSound(String file) {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public String readString(){
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public String readString(String text){
		System.out.println(text);
		return readString();
	}
	
	public int readInt(){
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	public int readInt(String text){
		System.out.println(text);
		return readInt();
	}
	
	public double readDouble(){
		Scanner scan = new Scanner(System.in);
		return scan.nextDouble();
	}
	
	public double readDouble(String text){
		System.out.println(text);
		return readInt();
	}
	
	public void printBox(String text){
		JOptionPane.showMessageDialog(null, text); //Simple JOption pane dialog box
	}
	
	public String inputBox(String text){
		return JOptionPane.showInputDialog(text); //Simple JOption pane input box
	}
	
	public int yesNoBox(String text){
		return JOptionPane.showConfirmDialog(null, text);//Simple JOption pane confirm box
	}
	
	public int rand(int start, int end){
		Random a = new Random();
		return (a.nextInt(end) + start);
	}
	
	public String[][] parcer(String base, String div1, String div2){
		String[] d1 = base.split(div1); //divides the base string
		String[] d2;
		String[][] endP = null;
		String curr;
		for(int i = 0; i < d1.length; i++){
			curr = d1[i];
			d2 = curr.split(div2); //divides stuff within 1st division
			for(int j = 0; j < d2.length; j++){
				endP[i][j] = d2[j];//puts it in double array
			}
		}
		return endP;
	}
	
	public int[] sort(int[] x, boolean LeastToGreatest){
		int[] endP = null;
		if(LeastToGreatest){
			int lowest = Integer.MAX_VALUE; //sets lowest to highest possible, so everything is lower than it
			int index = 0;
			for(int i = 0; i < x.length; i++){
				for(int j = 0; j < x.length; j++){
					if(x[j] < lowest){
						lowest = x[j]; // if current spot is < lowest set it to lowest
						index = j;
					}
				}
				endP[i] = lowest;
				x[index] = Integer.MAX_VALUE; //sets it to really big so it is not picked again
			}
		}
		else{
			int greatest = Integer.MIN_VALUE;//sets greatest to lowest possible, so everything is greater than it
			int index = 0;
			for(int i = 0; i < x.length; i++){
				for(int j = 0; j < x.length; j++){
					if(x[j] > greatest){
						greatest = x[j]; // if current spot > greatest set it to the greatest
						index = j;
					}
				}
				endP[i] = greatest;
				x[index] = Integer.MIN_VALUE;//sets it to really little, so it is not picked again
			}
		}
		return endP;
	}
	
	public void nap(int time){
		try { //try's and catches Thread.sleep
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.getCause();
			e.printStackTrace();
		}
	}
	
	public void snooze(Long time){
		try {
			wait(time);//same as nap, but with wait, in case not thread bound
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
