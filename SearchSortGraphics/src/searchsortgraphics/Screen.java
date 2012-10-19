package searchsortgraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

class Screen extends JPanel {

    ArrayList<Integer> numbers;///<reference to the numbers list from BaseGUI
    ImageIcon bg;///<default background
    ArrayList<Integer> compare;///<numbers being compared, this is blue
    ArrayList<Integer> swap;///<numbers being swapped, this is red
    ArrayList<Integer> blue;///<persistent blue bars
    ArrayList<Integer> red;///<persistent red bars

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
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

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
            if (this.compare.contains(i)) {
                g2.setColor(Color.BLUE);
            }
            if (this.swap.contains(i)) {
                g2.setColor(Color.RED);
            }
            g2.fillRect(loc, BaseGUI.MAXY - 10 - this.numbers.get(i), 10, this.numbers.get(i));
            loc += 12;
        }
        this.compare.clear();
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

    public void setPersistentBlue(Integer i) {
        this.blue.add(i);
    }

    public void setPersistentRed(Integer i) {
        this.red.add(i);
    }
    public void removePersistentBlue(Integer i)
    {
        this.blue.remove((Integer)i);
    }
    public void removePersistentRed(Integer i)
    {
        this.red.remove((Integer)i);
    }
    public void clearPersistentBlue()
    {
        this.blue.clear();
    }
    public void clearPersistentRed()
    {
        this.red.clear();
    }
}
