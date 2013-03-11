package searchsortgraphics.Generators;

import java.util.Random;
import searchsortgraphics.Core;

/**
 * @brief generates random numbers from 1-1000
 */
public class GenerateRandom extends Generator {

    public GenerateRandom(Core i) {
        super(i);
    }

    public void generate() {
        this.numbers.clear();
        for (int i = 0; i != 139; i++) {
            this.numbers.add(this.main.getRand().nextInt(Core.MAXY-20));
        }
    }
}