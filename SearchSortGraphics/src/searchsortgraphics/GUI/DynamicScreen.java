/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @brief advanced numbers array displayer.
 *
 * The DynamicScreen class replaces the deprecated Screen class. Major
 * improvements have been made. The DynamicScreen automatically adjusts bar size
 * according to the size requested by the user during construction. Spacing,
 * vertical scaling, and width are all dynamically generated. Furthermore,
 * significant performance advancements have been made to displaying color.
 * There are now only two arraylists that holds any type of color, versus the
 * old system of having an arraylist for each color.
 * @author RoyZheng
 */
public class DynamicScreen extends JPanel {

    public boolean debug = false;
    public static final int SPACING_INCREMENTATION_FACTOR = 10;
    public static final Color DEFAULT_COLOR = Color.BLACK;
    volatile ArrayList<Integer> numbers;///<reference to the numbers list from BaseGUI
    ArrayList<Color> single;///<single time custom color
    ArrayList<Color> extended;///<extended custom color
    Integer x;///<panel x-dimension
    Integer y;///<panel y-dimension
    Double scale;///<constant factor to multiply number by to fit in screen
    Integer width;///<width of each bar
    Integer spacing;///<width of spacing

    private DynamicScreen() {
    }

    /**
     * @brief initializes the screen
     * @param in arraylist of numbers to build off of
     * @param x x-dimension requested
     * @param y y-dimension requested
     */
    public DynamicScreen(ArrayList<Integer> in, Integer x, Integer y) {
        if (in == null) {
            System.out.println("DynamicScreen: Screen initialized with a null ArrayList<Integer>!");
        }
        this.numbers = in;
        this.x = x;
        this.y = y;
        this.single = new ArrayList<Color>();
        this.extended = new ArrayList<Color>();
    }

    /**
     * @brief rebuilds the auxiliary arrays to compensate for changes in numbers
     * array
     */
    public void rebuild() {
        this.single.clear();
        this.extended.clear();
        if (this.numbers.size() == 0) {
            return;
        }
        for (int i = 0; i != this.numbers.size(); i++) {
            this.single.add(null);
            this.extended.add(DynamicScreen.DEFAULT_COLOR);
        }
        this.scale = (double) (this.y - 8) / Collections.max(this.numbers);
        this.width = ((this.x - 10) / this.numbers.size()) - 1;
        this.spacing = 1;

        int offset = (int) Math.floor((double) (this.width / DynamicScreen.SPACING_INCREMENTATION_FACTOR));
        this.width += offset;
        this.spacing += offset;

        if (this.width == 1) {
            this.spacing = 0;
        }
        if (this.debug) {
            System.out.println("Scale; " + this.scale);
            System.out.println("Width: " + this.width);
            System.out.println("Spacing: " + this.spacing);
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int loc = 5;
        for (int i = 0; i != this.numbers.size(); i++) {
            g2.setColor((this.single.get(i) == null) ? this.extended.get(i) : this.single.get(i));
            this.single.set(i, DynamicScreen.DEFAULT_COLOR);
            g2.fillRect(loc, (int) (this.y - 4 - this.scale * this.numbers.get(i)), width, (int) (this.scale * this.numbers.get(i)));
            loc += this.width + this.spacing;
            //System.out.println(loc);
            //System.out.println((int) (this.y - 4 - this.scale * this.numbers.get(i)));
        }
    }

    public void setCompare(Integer i, Integer j) {
        this.single.set(i, Color.BLUE);
        this.single.set(j, Color.BLUE);
    }

    public void setSwap(Integer i, Integer j) {
        this.single.set(i, Color.RED);
        this.single.set(j, Color.RED);
    }

    public void setSingleColor(Integer i, Color b) {
        this.single.set(i, b);
    }

    public void setPersistentColor(Integer i, Color b) {
        this.extended.set(i, b);
    }

    public void setBlue(Integer i) {
        this.setSingleColor(i, Color.blue);
    }

    public void setRed(Integer i) {
        this.setSingleColor(i, Color.red);
    }

    public void setYellow(Integer i) {
        this.setSingleColor(i, Color.yellow);
    }

    public void setPersistentBlue(Integer i) {
        this.extended.set(i, Color.BLUE);
    }

    public void setPersistentYellow(Integer i) {
        this.extended.set(i, Color.YELLOW);
    }

    public void setPersistentRed(Integer i) {
       // System.out.println(this.extended.size() + " ," + this.single.size() + "," + this.numbers.size());
        this.extended.set(i, Color.RED);
    }

    public void removePersistent(Integer i) {
        this.extended.set(i, DEFAULT_COLOR);
    }

    public void clearPersistent() {
        this.extended.clear();
        for (int i = 0; i != this.extended.size(); i++) {
            this.extended.add(DynamicScreen.DEFAULT_COLOR);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(400, 400);
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i != 10; i++) {
            num.add(i);
        }
        DynamicScreen scrn = new DynamicScreen(num, 400, 400);
        f.add(scrn);
        scrn.setVisible(true);
        f.repaint();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
