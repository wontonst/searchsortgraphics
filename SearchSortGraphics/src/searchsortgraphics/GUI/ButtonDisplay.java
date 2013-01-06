package searchsortgraphics.GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @brief a generic button displayer
 * @author RoyZheng
 */
public class ButtonDisplay extends JPanel {

    int columns;
    int rows;
    int currx;
    int curry;

    public ButtonDisplay() {
        super();
        this.columns = 3;
        this.rows = 4;
        this.setup();
    }

    public ButtonDisplay(int x, int y) {
        this.columns = x;
        this.rows = y;
    }

    private void setup() {
        this.currx = 0;
        this.curry = 0;
        this.setLayout(new GridBagLayout());
    }

    public void addButton(JButton in) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = this.currx;
        c.gridy = this.curry;
        c.insets = new Insets(2, 2, 2, 2);
        c.fill = GridBagConstraints.BOTH;
        c.ipady = 18;
        c.ipadx = 75;
        c.weighty = 0.75;
        c.weightx = .75;
        this.currx++;
        if (this.currx == this.columns) {
            this.currx = 0;
            this.curry++;
        }
        this.add(in, c);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 400);
        f.setVisible(true);
        ButtonDisplay p = new ButtonDisplay();
        for (int i = 0; i != 20; i++) {
            p.addButton(new JButton("Hey"));
        }
        f.add(p);
    }
}