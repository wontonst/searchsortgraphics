package searchsortgraphics.Generators;

import searchsortgraphics.BaseGUI;

/**
 * @brief neatly generates the numbers array, then shuffles it
 */
public class GenerateNeat extends Generator {

    public GenerateNeat(BaseGUI i) {
        super(i);
    }

    public void generate() {
        this.numbers.clear();
        for (int i = 0; i != 139; i++) {
            this.numbers.add(i * (BaseGUI.MAXY-20) / 139);
        }
        this.shuffle();
    }
}