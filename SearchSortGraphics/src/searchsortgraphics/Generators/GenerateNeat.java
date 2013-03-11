package searchsortgraphics.Generators;

import searchsortgraphics.Core;

/**
 * @brief neatly generates the numbers array, then shuffles it
 */
public class GenerateNeat extends Generator {

    public GenerateNeat(Core i) {
        super(i);
    }

    public void generate() {
        this.numbers.clear();
        for (int i = 0; i != 139; i++) {
            this.numbers.add(i * (Core.MAXY-20) / 139);
        }
        this.shuffle();
    }
}