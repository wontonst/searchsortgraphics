package searchsortgraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @deprecated 
 * @brief integer array graphical display
 * Graphically displays the contents of an integer array
 * This class has been replaced by searchsortgraphics.DynamicScreen
 * @author RoyZheng
 */
public class Screen extends JPanel{

  volatile  ArrayList<Integer> numbers;///<reference to the numbers list from BaseGUI
    ImageIcon bg;///<default background
    ArrayList<Integer> compare;///<numbers being compared, this is blue
    ArrayList<Integer> swap;///<numbers being swapped, this is red
    ArrayList<Integer> blue;///<persistent blue bars
    ArrayList<Integer> red;///<persistent red bars
    ArrayList<Integer> yellowtemp;///<temporary yellow, used for pivot
    ArrayList<Integer> yellow;///<persistent yellow bars

    private Screen() {
    }

    public Screen(ArrayList<Integer> in) {
        if (in == null) {
            System.out.println("ERROR: Screen initialized with a null ArrayList<Integer>!");
        }
        this.bg = new ImageIcon("bg.png");
        this.numbers = in;
        this.compare = new ArrayList<Integer>();
        this.swap = new ArrayList<Integer>();
        this.blue = new ArrayList<Integer>();
        this.red = new ArrayList<Integer>();
        this.yellowtemp = new ArrayList<Integer>();
        this.yellow = new ArrayList<Integer>();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //g2.setColor(Color.WHITE);
        //g2.drawRect(0,0,BaseGUI.MAXX,BaseGUI.MAXY);
        
        if (this.numbers.size() == 0) {
            this.bg.paintIcon(this, g2, 0, 0);
        }
        int loc = 5;
        for (int i = 0; i != this.numbers.size(); i++) {
            g2.setColor(Color.BLACK);
            if (this.blue.contains(i)) {
                g2.setColor(Color.BLUE);
            }
            if (this.red.contains(i)) {
                g2.setColor(Color.RED);
            }
            if(this.yellow.contains(i))
            {
                g2.setColor(Color.YELLOW);
            }
            if (this.compare.contains(i)) {
                g2.setColor(Color.BLUE);
            }
            if (this.swap.contains(i)) {
                g2.setColor(Color.RED);
            }
            if (this.yellowtemp.contains(i)) {
                g2.setColor(Color.YELLOW);
            }
            g2.fillRect(loc, Core.MAXY - 10 - this.numbers.get(i), 10, this.numbers.get(i));
            loc += ((Core.MAXX-10)/139);
        }
        this.compare.clear();
        this.yellowtemp.clear();
        this.swap.clear();
    }

    public void setCompare(Integer i, Integer j) {
        this.compare.add(i);
        this.compare.add(j);
    }

    public void setSwap(Integer i, Integer j) {
        this.swap.add(i);
        this.swap.add(j);
    }

    public void setBlue(Integer i) {
        this.compare.add(i);
    }

    public void setRed(Integer i) {
        this.swap.add(i);
    }

    public void setYellow(Integer i) {
        this.yellowtemp.add(i);
    }

    public void setPersistentBlue(Integer i) {
        this.blue.add(i);
    }

    public void setPersistentYellow(Integer i) {
        this.yellow.add(i);
    }

    public void setPersistentRed(Integer i) {
        this.red.add(i);
    }

    public void removePersistentBlue(Integer i) {
        this.blue.remove((Integer) i);
    }

    public void removePersistentYellow(Integer i) {
        this.yellow.remove((Integer) i);
    }

    public void removePersistentRed(Integer i) {
        this.red.remove((Integer) i);
    }

    public void clearPersistentBlue() {
        this.blue.clear();
    }
    public void clearPersistentYellow()
    {
        this.yellow.clear();
    }
    public void clearPersistentRed() {
        this.red.clear();
    }
}
