/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchsortgraphics.GUI;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import searchsortgraphics.Core;

/** 
 * @brief the main user interface with all buttons, displays, etc.
 * @author RoyZheng
 */
public class GUI extends JPanel implements ActionListener {

    public static int MAXX = 800;
    public static int MAXY = 600;
    public static String SORT_CHOOSE = "0";
    public static String NUMBER_GENERATE = "1";
    SortChooser chooser;
    GenerateNumbers gen;
    CardLayout layout;
    Core main;///<reference to central control

    public GUI(Core in) {
        super();
        this.main = in;
        this.setup();
    }

    private void setup() {
        this.layout = new CardLayout();
        this.chooser = new SortChooser(this.main, this);
        this.gen = new GenerateNumbers(this.main, this);

        Dimension dim = new Dimension(GUI.MAXX, GUI.MAXY);
        this.setSize(dim);
        this.setPreferredSize(dim);

        this.setLayout(this.layout);
        this.add(this.gen, GUI.NUMBER_GENERATE);
        this.add(this.chooser, GUI.SORT_CHOOSE);
        this.displayNumberGenerate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof SSGButton) {
            SSGButton button = (SSGButton) e.getSource();
            switch (button.getType()) {
                case NUMBER_GENERATE:
                    this.displaySortChoose();
                    break;
                case SORT_CHOOSE:
                    break;
            }
            button.perform();
        }
    }

    /**
     * @brief displays the sort choose page
     */
    public void displaySortChoose() {
        this.layout.show(this, GUI.SORT_CHOOSE);
    }

    /**
     * @brief displays the number generation page
     */
    public void displayNumberGenerate() {
        this.layout.show(this, GUI.NUMBER_GENERATE);
    }
}
