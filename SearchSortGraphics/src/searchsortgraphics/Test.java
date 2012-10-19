//package searchsortgraphics;

import java.util.Random;
import java.util.ArrayList;

class Test {

    ArrayList<Integer> numbers;
    Random rand;

    public Test() {
        this.rand = new Random();
        this.numbers = new ArrayList<Integer>();
        this.generate();
    }

    public void generate() {
        for (int i = 0; i != 139; i++) {
            this.numbers.add(rand.nextInt(1000));
        }
    }

    public void gnomeSort() {
        int index = 1;
        while (index < this.numbers.size()) {
            if (this.numbers.get(index) >= this.numbers.get(index - 1)) {
                index++;
            } else {
                Integer temp = this.numbers.get(index);//swapping
                this.numbers.set(index, this.numbers.get(index - 1));
                this.numbers.set(index - 1, temp);
                if (index > 1) {
                    index--;
                } else {
                    index++;
                }
            }
        }
    }

    public void optimizedGnomeSort() {
        int pos = 1;
        int last = 0;
        while (pos < this.numbers.size()) {

            if (this.numbers.get(pos) >= this.numbers.get(pos - 1)) {
                if (last != 0) {
                    pos = last;
                    last = 0;
                }

                pos++;
            } else {
                Integer temp = this.numbers.get(pos);//swapping
                this.numbers.set(pos, this.numbers.get(pos - 1));
                this.numbers.set(pos - 1, temp);
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
        Boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < this.numbers.size(); i += 2) {
                if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                    swap(i, i - 1);
                    sorted = false;
                }
            }
            for (int i = 2; i < this.numbers.size(); i += 2) {
                if (this.numbers.get(i) < this.numbers.get(i - 1)) {
                    swap(i, i - 1);
                    sorted = false;
                }
            }
        }
    }

    public void combSort() {

        Boolean swapped = false;
        Integer gap = this.numbers.size();
        while (gap > 1 || swapped) {
            gap = (int)(gap / 1.247330950103979);
            if (gap < 1) {
                gap = 1;
            }
            Integer i = 0;
            swapped = false;
            while ((i + gap) < this.numbers.size()) {
                if (this.numbers.get(i) > this.numbers.get(i + gap))
                {
                swapped = true;
                swap(i,i+gap);
                //System.out.println("swapping "+i+i+gap);
                }
                i++;
            }
        }
    }

    public void swap(Integer i, Integer j) {
        Integer temp = this.numbers.get(i);//swapping
        this.numbers.set(i, this.numbers.get(j));
        this.numbers.set(j, temp);
    }

    public ArrayList<Integer> getArray() {
        return this.numbers;
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.getArray());
        t.combSort();
        System.out.println(t.getArray());
    }
}