package tool10.underdev.navigator;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class SimpleFrameDemo {
	 	 
	 void main() {
	         EventQueue.invokeLater(() -> {
	        	 SimpleFrame frame = new SimpleFrame();
	             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	             frame.setVisible(true);
	         });
	  }
	 
	  class SimpleFrame extends JFrame {
		  /**
		   * 
		   */
		  private static final long serialVersionUID = 1L;
		  private static final int DEFAULT_WIDTH = 300;
		  private static final int DEFAULT_HEIGHT = 200;
	 
		  public SimpleFrame() {
	         setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		  }
	  }
	  
}
