package searchsortgraphics;

import searchsortgraphics.GUI.DynamicScreen;
import searchsortgraphics.GUI.LoadingBar;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JTextField;
import searchsortgraphics.GUI.GUI;

/**
 * @brief God object anti-pattern that controls most of the operations of this
 * application. Will be broken up eventually.
 * @author RoyZheng
 */
public class Core extends JFrame {

    public static final Integer MAXX = 1680;///<draw screen X size
    public static final Integer MAXY = 1050;///< draw screen Y size
    public static final Integer PREVIEWX = 600;
    public static final Integer PREVIEWY = 500;
    public static final Integer SELECTORMAXX = 200;///<selector screen X size
    LoadingBar bar;///<loading bar frame
    ImageSaverExecutor saver;///<executorservice used to save frames
    DynamicScreen screen;///<where graphics get drawn onto
    volatile ArrayList<Integer> numbers;///<numbers to display;
    GUI gui;///<all gui
    JTextField outputfilename;///<directory to place output files into
    Integer filenumber;///<output picture file number
    Random rand;
    DynamicScreen preview;

    /**
     * Sets up a nonresizeable JFrame size BaseGUI.MAXX by BaseGUI.MAXY.
     * Subpanels are also constructed. A welcoming background is presented in
     * the rendering screen Screen.
     *
     * @brief initializes the BaseGUI object and sets up all JPanels
     */
    Core() {
        this.saver = new ImageSaverExecutor(this);
        this.filenumber = 0;
        this.rand = new Random();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.numbers = new ArrayList<Integer>();
        this.setLayout(new FlowLayout());
        this.screen = new DynamicScreen(this.numbers, Core.MAXX, Core.MAXY);
        this.preview = new DynamicScreen(this.numbers, PREVIEWX, PREVIEWY);
        //	(new Thread(this.screen)).start();
        this.makePanels();
        this.setResizable(false);
        this.pack();
        //this.setSize(BaseGUI.MAXX + BaseGUI.SELECTORMAXX, BaseGUI.MAXY);
        this.setVisible(true);
    }

    public void displayPreview() {

        JFrame f = new JFrame();
        f.setSize(PREVIEWX + 10, PREVIEWY + 10);
        f.add(this.preview);
        f.setVisible(true);
    }

    public DynamicScreen getPreview() {
        return this.preview;
    }

    public DynamicScreen getScreen() {
        return this.screen;
    }

    /**
     * @brief makes the left menu with all the buttons
     */
    private void makePanels() {
        Dimension dim = new Dimension(Core.MAXX, Core.MAXY);
        this.screen.setSize(dim);
        this.screen.setPreferredSize(dim);

        this.gui = new GUI(this);
        this.add(this.gui);
        this.outputfilename = new JTextField("outputfiledirectory");
    }

    /**
     * @brief places an image to be rendered by the ImageSaverExecuter image
     * rendering threadpool.
     */
    public void saveScreen() {
        this.preview.repaint();
        File f = new File("./" + this.outputfilename.getText());
        if (!f.exists()) {
            f.mkdir();
        }
        BufferedImage image = new BufferedImage(
                Core.MAXX,
                Core.MAXY,
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

    public Random getRand() {
        return this.rand;
    }
}
