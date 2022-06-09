import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class SlideShow extends JFrame {

	/**
	 * 
	 */
	// Added a serial version UID
	private static final long serialVersionUID = 1L;
	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		slidePane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		slidePane.setBackground(new Color(255, 255, 255));
		slidePane.setForeground(new Color(0, 0, 0));
		textPane = new JPanel();
		textPane.setBackground(new Color(255, 228, 196));
		textPane.setBounds(5, 470, 790, 50);
		buttonPane = new JPanel();
		// Created a border highlight around the panel
		buttonPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), null, new Color(255, 228, 196), null), null));
		// Changed color
		buttonPane.setBackground(new Color(30, 144, 255));
		btnPrev = new JButton();
		// Added an image to the Previous button
		btnPrev.setIcon(new ImageIcon(SlideShow.class.getResource("/resources/Hot_Springs.png")));
		btnNext = new JButton();
		// Added image to the Next button
		btnNext.setIcon(new ImageIcon(SlideShow.class.getResource("/resources/Flip_Flops.png")));
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Detox/Wellness Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	// Uploaded new images for the detox/wellness destination. 
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Wisconsin_1.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Florida_2.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Turks_Caicos_3.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Costa_Rica_4.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/California_5.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	// Commenting a description of the destination and crediting who provided the image. Font was re-sized to a font 5. 
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			text = "<html><body><font size='5'>#1 The Sand Valley Resort, Wisconsin.</font> <br>Leave the demands of daily life behind you and step into the world of rugged landscapes and views of wellness. (Photo Credit: San Valley Golf Resort)</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Carillon Miami Wellness Resort, Florida.</font> <br>All you have to do is get here to relax and unwind into eternity. (Photo Credit: Lenny Kagan)</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Amanyara, Turks and Caicos.</font> <br>A place of tranquility and self-reflection that awaits you. (Photo Credit: Marissa G. Muller)</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Nayara Springs, Costa Rica.</font> <br>Breathtaking views that's surrounded by a rain forest. A barefoot luxury vacation is only one click away! (Photo Credit: Miles Photography)</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Topanga, California.</font> <br>This Zen retreat has an endless view of the countryside desert located in California. (Photo Credit: Erika Owen) </body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}
