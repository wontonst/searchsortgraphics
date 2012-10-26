package searchsortgraphics;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class BaseGUI extends JFrame implements ActionListener {

    static final Integer MAXX = 1680;///<draw screen X size
    static final Integer MAXY = 1050;///< draw screen Y size
    static final Integer SELECTORMAXX = 200;///<selector screen X size
    Screen screen;///<where graphics get drawn onto
    JPanel selector;///<button controls
    ArrayList<Integer> numbers;///<numbers to display;
    Random rand;///<utility random number generator
    JTextField outputfilename;///<directory to place output files into
    Integer filenumber;///<output picture file number
    JButton generate;///<generate random numbers
    JButton generatereverse;///<generate numbers in reverse
    JButton generateneat;///<generates neat shuffled numbers
    JButton bubblesort;///<starts bubble sort rendering
    JButton cocktailsort;///<starts cocktail sort rendering
    JButton selectionsort;///<starts selection sort rendering
    JButton gnomesort;///<starts gnome sort rendering
    JButton gnomesortoptimized;///<start optimized gnome sort rendering
    JButton oddevensort;///<start odd-even sort rendering
    JButton combsort;///<start comb sort rendering
    JButton quicksort;///<start quicksort rendering
    JButton stoogesort;///<starts stoogesort rendering
    JButton bogosort;///<starts bogosort rendering
    JButton insertionsort;///<starts insertionsort rendering
    JButton exit;///<exits program

    /**
     * Sets up a nonresizeable JFrame size BaseGUI.MAXX by BaseGUI.MAXY.
     * Subpanels are also constructed. A welcoming background is presented in
     * the rendering screen Screen.
     *
     * @brief initializes the BaseGUI object and sets up all JPanels
     */
    BaseGUI() {
        this.filenumber = 0;
        this.rand = new Random();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.numbers = new ArrayList<Integer>();
        this.setLayout(new FlowLayout());
        this.screen = new Screen(this.numbers);
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
        this.selector = new JPanel();
        dim = new Dimension(BaseGUI.SELECTORMAXX, BaseGUI.MAXY);
        this.selector.setSize(dim);
        this.selector.setPreferredSize(dim);
        this.selector.setLayout(new GridLayout(0, 1));
        this.generate = new JButton("Generate Random");
        this.generate.addActionListener(this);
        this.selector.add(this.generate);
        this.generateneat = new JButton("Generate Random Neatly");
        this.generateneat.addActionListener(this);
        this.selector.add(this.generateneat);
        this.generatereverse = new JButton("Generate Reverse");
        this.generatereverse.addActionListener(this);
        this.selector.add(this.generatereverse);
        this.bubblesort = new JButton("Bubble Sort");
        this.bubblesort.addActionListener(this);
        this.selector.add(this.bubblesort);
        this.cocktailsort = new JButton("Cocktail Sort");
        this.cocktailsort.addActionListener(this);
        this.selector.add(this.cocktailsort);
        this.selectionsort = new JButton("Selection Sort");
        this.selectionsort.addActionListener(this);
        this.selector.add(this.selectionsort);
        this.gnomesort = new JButton("Gnome Sort");
        this.gnomesort.addActionListener(this);
        this.selector.add(this.gnomesort);
        this.gnomesortoptimized = new JButton("Gnome Sort (optimized)");
        this.gnomesortoptimized.addActionListener(this);
        this.selector.add(this.gnomesortoptimized);
        this.oddevensort = new JButton("Odd-Even Sort");
        this.oddevensort.addActionListener(this);
        this.selector.add(this.oddevensort);
        this.combsort = new JButton("Comb Sort");
        this.combsort.addActionListener(this);
        this.selector.add(this.combsort);
        this.quicksort = new JButton("Quick Sort");
        this.quicksort.addActionListener(this);
        this.selector.add(this.quicksort);
        this.stoogesort = new JButton ("Stooge Sort");
        this.stoogesort.addActionListener(this);
        this.selector.add(this.stoogesort);
        this.bogosort = new JButton("Bogo Sort");
        this.bogosort.addActionListener(this);
        this.selector.add(this.bogosort);
        this.insertionsort = new JButton("Insertion Sort");
        this.insertionsort.addActionListener(this);
        this.selector.add(this.insertionsort);

        this.outputfilename = new JTextField("outputfiledirectory");
        this.selector.add(this.outputfilename);
        this.exit = new JButton("Quit");
        this.exit.addActionListener(this);
        this.selector.add(this.exit);
        this.add(this.screen);
        this.add(this.selector);
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
        screen.paint(image.getGraphics());
        try {
            // write the image as a PNG
            ImageIO.write(
                image,
                "png",
                new File(this.outputfilename.getText() + "/" + this.filenumber + ".png"));
            this.filenumber++;
            System.out.println("Saving image " + this.outputfilename.getText() + "/" + this.filenumber + ".png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief generates random numbers from 1-1000
     */
    public void generate() {
        this.numbers.clear();
        for (int i = 0; i != 139; i++) {
            this.numbers.add(this.rand.nextInt(1000));
        }
        this.repaint();
    }

    /**
     * @brief shuffles the entire numbers array
     */
    public void shuffle() {
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        while (!this.numbers.isEmpty()) {
            Integer num;
            if (this.numbers.size() == 1) {
                num = 0;
            } else {
                num = this.rand.nextInt(this.numbers.size());
            }
            newlist.add(this.numbers.get(num));
            this.numbers.remove((int) num);
        }
        for (int i = 0; i != newlist.size(); i++) {
            this.numbers.add(newlist.get(i));
        }
        this.repaint();
    }

    /**
     * @brief neatly generates the numbers array, then shuffles it
     */
    public void generateNeat() {
        this.generateReverse();
        this.shuffle();
        this.repaint();
    }

    /**
     * @brief generates numbers in reverse number with equal spacing
     */
    public void generateReverse() {
        this.numbers.clear();
        for (int i = 139; i != 0; i--) {
            this.numbers.add(i * 1000 / 139);
        }
        this.repaint();
    }

    public void bubbleSort() {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();
        Boolean sorted = false;
        int iteration = 0;
        while (!sorted) {
            sorted = true;
            for (int i = 1; (i != this.numbers.size() - iteration); i++) {
                this.compare(i - 1, i);
                if (this.numbers.get(i - 1) > this.numbers.get(i)) {
                    this.swap(i - 1, i);
                    sorted = false;
                }
            }
            iteration++;
        }

        this.filenumber = 0;
    }

    public void cocktailSort() {

        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();

        Integer top = 0;
        Integer bot = 0;

        Boolean swapped = false;
        do {
            swapped = false;
            for (int i = 1 + bot; i != this.numbers.size() - top; i++) {
                this.compare(i - 1, i);
                if (this.numbers.get(i - 1) > this.numbers.get(i)) {
                    this.swap(i - 1, i);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            top++;
            swapped = false;
            for (int i = this.numbers.size() - 1 - top; i != bot; i--) {
                this.compare(i - 1, i);
                if (this.numbers.get(i - 1) > this.numbers.get(i)) {
                    this.swap(i - 1, i);
                    swapped = true;
                }
            }
            bot++;
        } while (swapped);

        this.filenumber = 0;
    }

    public void selectionSort() {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();
        for (int i = 0; i != this.numbers.size(); i++) {
            Integer min = i;
            this.setPersistentRed(min);
            this.saveScreen();
            for (int ii = i; ii != this.numbers.size(); ii++) {
                this.setBlue(ii);
                if (this.numbers.get(min) > this.numbers.get(ii)) {
                    this.screen.removePersistentRed(min);
                    min = ii;
                    this.setPersistentRed(min);
                }
            }
            this.swap(min, i);
            this.screen.clearPersistentRed();
        }
        System.out.println(numbers);
    }

    public void gnomeSort() {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();
        int index = 1;
        while (index < this.numbers.size()) {
            this.compare(index, index - 1);
            if (this.numbers.get(index) >= this.numbers.get(index - 1)) {
                index++;
            } else {
                this.swap(index, index - 1);
                if (index > 1) {
                    index--;
                } else {
                    index++;
                }
            }
        }
    }

    public void gnomeSortOptimized() {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();
        int pos = 1;
        int last = 0;
        while (pos < this.numbers.size()) {
            this.compare(pos, pos - 1);
            if (this.numbers.get(pos) >= this.numbers.get(pos - 1)) {
                if (last != 0) {
                    pos = last;
                    last = 0;
                }
                pos++;
            } else {
                this.swap(pos, pos - 1);
                if (pos > 1) {
                    if (last == 0) {
                        last = pos;
                    }
                    pos--;
                } else {
                    pos++;
                }
            }
        }
    }

    public void oddEvenSort() {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();
        Boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < this.numbers.size(); i += 2) {
                this.compare(i, i - 1);
                if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                    this.swap(i, i - 1);
                    sorted = false;
                }
            }
            for (int i = 2; i < this.numbers.size(); i += 2) {
                this.compare(i, i - 1);
                if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                    this.swap(i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    public void combSort() {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();
        Boolean swapped = false;
        Integer gap = this.numbers.size();
        while (gap > 1 || swapped) {
            gap = (int) (gap / 1.247330950103979);
            if (gap < 1) {
                gap = 1;
            }
            Integer i = 0;
            swapped = false;
            while ((i + gap) < this.numbers.size()) {
                compare(i, i + gap);
                if (this.numbers.get(i) > this.numbers.get(i + gap)) {
                    swapped = true;
                    swap(i, i + gap);
                    //System.out.println("swapping "+i+i+gap);
                }
                i++;
            }
        }
    }

    public void quickSort() {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.saveScreen();
        this.quickSort(this.numbers, 0, this.numbers.size() - 1);
        this.saveScreen();
    }

    public void quickSort(ArrayList<Integer> in, Integer l, Integer r) {
        Integer left = l, right = r;
        Integer pivot = this.numbers.get(l + (r - l) / 2);
        this.setYellow(l + (r - l) / 2);

        while (left <= right) {
            while (this.numbers.get(left) < pivot) {
                this.compare(left,l + (r - l) / 2);
                left++;
            }
            while (numbers.get(right) > pivot) {
                this.compare(right,l + (r - l) / 2);
                right--;
            }
            compare(left,right);
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        if (l < right) {
            this.quickSort(this.numbers, l, right);
        }
        if (left < r) {
            this.quickSort(this.numbers, left, r);
        }
    }
    public void stoogeSort()
    {
        if (this.numbers.isEmpty()) {
            return;
        }
        this.stoogeSort(0,this.numbers.size()-1);
    }
    public void stoogeSort(Integer i, Integer j)
    {
        //System.out.println("lolstoge");
        this.compare(i,j);
        if (this.numbers.get(j) < this.numbers.get(i)) {
            this.swap(i,j);
        }
        if ((j - i + 1) >= 3) {
            Integer t = (j - i + 1) / 3;
            this.stoogeSort(i  , j-t);
            this.stoogeSort(i+t, j  );
            this.stoogeSort(i  , j-t);
        }

    }
    public void bogoSort() {
        if (this.numbers.isEmpty()) {
            return;
        }
        while(!this.graphicalIsSorted())
        {
            this.shuffle();
            this.saveScreen();
        }
    }
    public void insertionSort()
    {
        if (this.numbers.isEmpty()) {
            return;
        }
        for (int i = 1; i != this.numbers.size(); i++)
        {
            this.setPersistentYellow(i);
            for(int ii = 0; ii != i; ii++)
            {
                compare(ii,i);
                if(this.numbers.get(ii) > this.numbers.get(i)) {
                    this.numbers.add(ii,this.numbers.get(i));
                    this.numbers.remove((int)i+1);
                    this.setRed(ii);
                }
            }
            this.screen.removePersistentYellow(i);
        }
    }
    /**
    @brief checks if the array is sorted
     */
    public Boolean isSorted()
    {
        for(int i = 1; i != this.numbers.size(); i++)
        {
            if(this.numbers.get(i) < this.numbers.get(i-1))
                return false;
        }
        return true;
    }
    /**
    @brief checks if the array is sorted and draws the necessary graphics to show comparisons made
     */
    public Boolean graphicalIsSorted()
    {
        for(int i = 1; i != this.numbers.size(); i++)
        {
            this.compare(i,i-1);
            if(this.numbers.get(i) < this.numbers.get(i-1))
                return false;
        }
        return true;
    }

    /**
     * @brief swaps the passed numbers and performs the correct image saves
     * @param i index A to swap with index B
     * @param j index B to swap with index A
     */
    private void swap(Integer i, Integer j) {
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

    private void compare(Integer i, Integer j) {
        this.screen.setCompare(i, j);
        this.saveScreen();
    }

    private void setBlue(Integer i) {
        this.screen.setBlue(i);
        this.saveScreen();
    }

    private void setYellow(Integer i) {
        this.screen.setYellow(i);
        this.saveScreen();
    }

    private void setRed(Integer i) {
        this.screen.setRed(i);
        this.saveScreen();
    }
    private void setPersistentYellow(Integer i)
    {
        this.screen.setPersistentYellow(i);
    }
    private void setPersistentBlue(Integer i) {
        this.screen.setPersistentBlue(i);
    }

    private void setPersistentRed(Integer i) {
        this.screen.setPersistentRed(i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.generate) {
            this.generate();
        } else if (e.getSource() == this.generateneat) {
            this.generateNeat();
        } else if (e.getSource() == this.generatereverse) {
            this.generateReverse();
        } else if (e.getSource() == this.bubblesort) {
            this.bubbleSort();
        } else if (e.getSource() == this.cocktailsort) {
            this.cocktailSort();
        } else if (e.getSource() == this.selectionsort) {
            this.selectionSort();
        } else if (e.getSource() == this.gnomesort) {
            this.gnomeSort();
        } else if (e.getSource() == this.gnomesortoptimized) {
            this.gnomeSortOptimized();
        } else if (e.getSource() == this.oddevensort) {
            this.oddEvenSort();
        } else if (e.getSource() == this.combsort) {
            this.combSort();
        } else if (e.getSource() == this.quicksort) {
            this.quickSort();
        } else if(e.getSource() == this.stoogesort) {
            this.stoogeSort();
        } else if(e.getSource() == this.bogosort) {
            this.bogoSort();
        } else if(e.getSource() == this.insertionsort) {
            this.insertionSort();
        } else if (e.getSource() == this.exit) {
            System.exit(0);
        }
        this.filenumber = 0;
    }

    public void debug() {
        for (int i = 0; i != this.numbers.size(); i++) {
            System.out.println(this.numbers.get(i));
        }
    }
}
