package searchsortgraphics.GUI;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import searchsortgraphics.BaseGUI;
import searchsortgraphics.Generators.GenerateNeat;
import searchsortgraphics.Generators.GenerateRandom;
import searchsortgraphics.Generators.GenerateReverse;

/**
 * @brief the number generation panel
 * @author RoyZheng
 */
public class GenerateNumbers extends JPanel {

    SSGGenerateButton generate;///<generate random numbers
    SSGGenerateButton generatereverse;///<generate numbers in reverse
    SSGGenerateButton generateneat;///<generates neat shuffled numbers
    ActionListener listener;
    ButtonDisplay buttons;
    BaseGUI main;

    public GenerateNumbers(BaseGUI m, ActionListener al) {
        this.listener = al;
        this.main = m;
        this.create();
    }

    public void create() {
        this.buttons = new ButtonDisplay();
        this.generate = new SSGGenerateButton("Generate Random", new GenerateRandom(this.main));
        this.generate.addActionListener(this.listener);
        this.buttons.addButton(this.generate);
        this.generateneat = new SSGGenerateButton("Generate Random Neatly", new GenerateNeat(this.main));
        this.generateneat.addActionListener(this.listener);
        this.buttons.addButton(this.generateneat);
        this.generatereverse = new SSGGenerateButton("Generate Reverse", new GenerateReverse(this.main));
        this.generatereverse.addActionListener(this.listener);
        this.buttons.addButton(this.generatereverse);
        this.add(this.buttons);
    }
}
