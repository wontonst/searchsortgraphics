package searchsortgraphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
import searchsortgraphics.GUI.MainDisplay;

/**
 * @brief God object anti-pattern that controls most of the operations of this
 * application.
 * @author RoyZheng
 */
public class BaseGUI extends JFrame {

    public static final Integer MAXX = 1680;///<draw screen X size
    public static final Integer MAXY = 1050;///< draw screen Y size
    public static final Integer SELECTORMAXX = 200;///<selector screen X size
    LoadingBar bar;///<loading bar frame
    ImageSaverExecutor saver;///<executorservice used to save frames
    DynamicScreen screen;///<where graphics get drawn onto
    volatile ArrayList<Integer> numbers;///<numbers to display;
    MainDisplay gui;///<all gui
    JTextField outputfilename;///<directory to place output files into
    Integer filenumber;///<output picture file number
    Random rand;

    /**
     * Sets up a nonresizeable JFrame size BaseGUI.MAXX by BaseGUI.MAXY.
     * Subpanels are also constructed. A welcoming background is presented in
     * the rendering screen Screen.
     *
     * @brief initializes the BaseGUI object and sets up all JPanels
     */
    BaseGUI() {
        this.saver = new ImageSaverExecutor(this);
        this.filenumber = 0;
        this.rand = new Random();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.numbers = new ArrayList<Integer>();
        this.setLayout(new FlowLayout());
        this.screen = new DynamicScreen(this.numbers,BaseGUI.MAXX,BaseGUI.MAXY);
        //	(new Thread(this.screen)).start();
        this.makePanels();
        this.setResizable(false);
        this.pack();
        //this.setSize(BaseGUI.MAXX + BaseGUI.SELECTORMAXX, BaseGUI.MAXY);
        this.setVisible(true);
    }

    /**
     * @brief makes the left menu with all the buttons
     */
    private void makePanels() {
        Dimension dim = new Dimension(BaseGUI.MAXX, BaseGUI.MAXY);
        this.screen.setSize(dim);
        this.screen.setPreferredSize(dim);

        this.gui = new MainDisplay(this);
        this.add(this.gui);
        this.outputfilename = new JTextField("outputfiledirectory");
    }

    /**
     * @brief saves graphics on the Screen into the user specified directory
     */
    public void saveScreen() {
        File f = new File("./" + this.outputfilename.getText());
        if (!f.exists()) {
            f.mkdir();
        }
        BufferedImage image = new BufferedImage(
                BaseGUI.MAXX,
                BaseGUI.MAXY,
                BufferedImage.TYPE_INT_RGB);
        screen.printAll(image.getGraphics());
        this.saver.addRender(image, this.getFilename(), this.bar);
    }

    public String getFilename() {
        String t = this.outputfilename.getText() + "/" + this.filenumber + ".png";
        this.filenumber++;
        return t;
    }

    /**
     * @brief checks if the array is sorted
     */
    public Boolean isSorted() {
        for (int i = 1; i != this.numbers.size(); i++) {
            if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @brief checks if the array is sorted and draws the necessary graphics to
     * show comparisons made
     */
    public Boolean graphicalIsSorted() {
        for (int i = 1; i != this.numbers.size(); i++) {
            this.compare(i, i - 1);
            if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @brief swaps the passed numbers and performs the correct image saves
     * @param i index A to swap with index B
     * @param j index B to swap with index A
     */
    public void swap(Integer i, Integer j) {
        this.screen.setSwap(i, j);
        //this.repaint();
        this.saveScreen();
        Integer temp = this.numbers.get(i);

        this.numbers.set(i, this.numbers.get(j));
        this.numbers.set(j, temp);
        this.screen.setSwap(i, j);
        //this.repaint();
        this.saveScreen();
    }

    public void compare(Integer i, Integer j) {
        this.screen.setCompare(i, j);
        this.saveScreen();
    }

    public void setBlue(Integer i) {
        this.screen.setBlue(i);
        this.saveScreen();
    }

    public void setYellow(Integer i) {
        this.screen.setYellow(i);
        this.saveScreen();
    }

    public void setRed(Integer i) {
        this.screen.setRed(i);
        this.saveScreen();
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public LoadingBar getLoadingBar() {
        return this.bar;
    }

    public void setLoadingBar(LoadingBar in) {
        this.bar = in;
    }

    public void resetFileNumber() {
        this.filenumber = 0;
    }

    public DynamicScreen getScreen() {
        return this.screen;
    }

    public void debug() {
        for (int i = 0; i != this.numbers.size(); i++) {
            System.out.println(this.numbers.get(i));
        }
    }

    public void finishRender() {
        this.bar.close();
        this.resetFileNumber();
        this.gui.displayNumberGenerate();
    }
    

    public Random getRand()
    {
    return this.rand;
    }
}
