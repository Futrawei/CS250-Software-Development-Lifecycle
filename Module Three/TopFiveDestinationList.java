import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame tpdstntnlstfrmTopDestinations = new TopDestinationListFrame();
            	tpdstntnlstfrmTopDestinations.setAlwaysOnTop(true);
            	tpdstntnlstfrmTopDestinations.getContentPane().setFont(new Font("Mukta Mahee", Font.PLAIN, 13));
            	tpdstntnlstfrmTopDestinations.getContentPane().setForeground(new Color(100, 149, 237));
            	tpdstntnlstfrmTopDestinations.getContentPane().setBackground(new Color(138, 43, 226));
            	tpdstntnlstfrmTopDestinations.setForeground(new Color(255, 255, 255));
            	tpdstntnlstfrmTopDestinations.setFont(new Font("Mukta Mahee", Font.BOLD, 13)); // Font changed. 
            	tpdstntnlstfrmTopDestinations.setBackground(new Color(255, 255, 255)); // Changed "Top 5 Destination List" background color.
                tpdstntnlstfrmTopDestinations.setTitle("Top 5 Destinations List");
                
                JLabel nameLabel = new JLabel("Developer: Travis Barbur"); // Label and name was added and placed at the bottom.
                nameLabel.setIcon(null);
                nameLabel.setFont(new Font("Mukta Mahee", Font.PLAIN, 13));
                nameLabel.setVerticalAlignment(SwingConstants.BOTTOM); // Text set to BOTTOM.
                nameLabel.setHorizontalAlignment(SwingConstants.CENTER); // Text set to CENTER.
                nameLabel.setForeground(new Color(255, 255, 255)); // Font text set to white.
                nameLabel.setBackground(new Color(245, 255, 250)); // Background set to a purple color.
                tpdstntnlstfrmTopDestinations.getContentPane().add(nameLabel, BorderLayout.SOUTH);
                
             
                JLabel nameLabel_1 = new JLabel("SNHU Top 5 Travel Destinations"); // Added a new label at the top of the page.
                
                // Added a Beach Umbrella image at the top of the page. 
                nameLabel_1.setIcon(new ImageIcon(TopFiveDestinationList.class.getResource("/resources/BeachUmbrella.png")));
                nameLabel_1.setFont(new Font("Mukta Mahee", Font.PLAIN, 20)); // Font changed. 
                nameLabel_1.setHorizontalAlignment(SwingConstants.CENTER); // Centered the label. 
                nameLabel_1.setForeground(Color.WHITE); // Text is white. 
                tpdstntnlstfrmTopDestinations.getContentPane().add(nameLabel_1, BorderLayout.NORTH); // Label set NORTH (top).  
                
                

                tpdstntnlstfrmTopDestinations.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<TextAndIcon> listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel<TextAndIcon>();


        // Make updates to your top 5 list below. Import the new image files to resources directory.
        // All images were gathered from WikiMedia Commons and credit by the Authors at the end of the description. 
        // Added a description for each destination.
        // All images were reformatted and sized appropriately. 
        // All images were named accordingly and placed into the resources directory. 
        // All images were linked in the project by resources > New > File > Advanced > 
        // link to file in the file system > Browse > image linked to resources. 
        // Refreshed the resources directory. 
        addDestinationNameAndPicture("1. Montreal, Canada: This is one of the most popular places to visit due to its historical landmarks and great cuisine. (Photo Credit: Tourismemontreal)", new ImageIcon(getClass().getResource("/resources/MontrealCanada.jpg")));
        addDestinationNameAndPicture("2. Grand Canyon, Arizona: If you're looking for beautiful sunrises and sunsets, look no further because the natural scenery will blow you away! (Photo Credit: Luca Galuzzi)", new ImageIcon(getClass().getResource("/resources/GrandCanyon.jpg")));
        addDestinationNameAndPicture("3. London, England: A city that speaks more than 300 languages, great food and a steep history filled with architecture, attractions and much more. (Photo Credit: Rodrigo Silva)", new ImageIcon(getClass().getResource("/resources/LondonEngland.jpg")));
        addDestinationNameAndPicture("4. Instanbul, Turkey: If shopping is one of the highlights on your trip then don't miss the Grand Bazaar which is one of the largest and oldest markets in the world! (Photo Credit: Mostafameraji)", new ImageIcon(getClass().getResource("/resources/Instanbul.jpg")));
        addDestinationNameAndPicture("5. Rome, Italy: The one destination that has architecture, great food, piazzas, museums and historical neighborhoods. (Photo Credit: Henriette Gerzee)", new ImageIcon(getClass().getResource("/resources/Rome.jpg")));
        
        
        JList<TextAndIcon> list = new JList<TextAndIcon>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);
        
        
        
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer<Object> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList<?> list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}
