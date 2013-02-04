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
            gap = (int) (gap / 1.247330950103979);
            if (gap < 1) {
                gap = 1;
            }
            Integer i = 0;
            swapped = false;
            while ((i + gap) < this.numbers.size()) {
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
        this.quickSort(this.numbers, 0, this.numbers.size() - 1);
    }

    public void quickSort(ArrayList<Integer> in, Integer l, Integer r) {
        Integer left = l, right = r;
        Integer pivot = this.numbers.get(l + (r - l) / 2);

        while (left <= right) {
            while (this.numbers.get(left) < pivot) {
                left++;
            }
            while (numbers.get(right) > pivot) {
                right--;
            }
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
        this.stoogeSort(0,this.numbers.size()-1);
    }
    public void stoogeSort(Integer i, Integer j)
    {
        //System.out.println("lolstoge");
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

        while(!this.isSorted())
        {
            System.out.println(this.numbers);
            this.shuffle();
        }
    }
    public void insertionSort()
    {
        for (int i = 1; i != this.numbers.size(); i++)
        {
            for(int ii = 0; ii != i; ii++)
            {
                if(this.numbers.get(ii) > this.numbers.get(i)) {
                    this.numbers.add(ii,this.numbers.get(i));
                    this.numbers.remove((int)i+1);
                }
            }
        }
    }
    public void shuffle()
    {
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
    }
    public void shellSort()
    {
        ArrayList<Integer> gaps = new ArrayList<Integer>();
        gaps.add(701);
        gaps.add(301);
        gaps.add(132);
        gaps.add(57);
        gaps.add(23);
        gaps.add(10);
        gaps.add(4);
        gaps.add(1);

        for(int b = 0; b != gaps.size(); b++) {
            int gap = (int)gaps.get(b);
            for (int i = gap; i < this.numbers.size(); i++) {
                Integer temp = this.numbers.get(i);
                int j = i;
                for (; j >= gap && this.numbers.get(j - gap) > temp; j -= gap) {
                    this.numbers.set(j,this.numbers.get(j - gap));
                }
                this.numbers.set(j,temp);
            }
        }
    }
    public Boolean isSorted()
    {
        for(int i = 1; i != this.numbers.size(); i++)
        {
            if(this.numbers.get(i) < this.numbers.get(i-1))
                return false;
        }
        return true;
    }
    public void swap(Integer i, Integer j) {
        Integer temp = this.numbers.get(i);//swapping
        this.numbers.set(i, this.numbers.get(j));
        this.numbers.set(j, temp);
    }

    public ArrayList<Integer> getArray() {
        return this.numbers;
    }

    public Integer max()
    {
	Integer max = this.numbers.get(0);
	for(int i = 0; i != this.numbers.size(); i++)
	    if(this.numbers.get(i) > max)
		max=this.numbers.get(i);
	return max;
    }
    public void radixSort()
    {
 
    buckets_type buckets(10); // allocate buckets
    // for sorting decimal numbers
 
    int pow10 = 1; // pow10 holds powers of 10 (1, 10, 100, ...)
 
    int max = this.max();
 
    //begin radix sort
    for(; max != 0 ; max/=10, pow10*=10)
    {
        // 1. determine which bucket each element should enter
        // for each element in 'x':
        for(input_type::const_iterator elem = x.begin(); elem != x.end(); ++elem)
        {
                // calculate the bucket number:
                size_t const bucket_num = ( *elem / pow10 ) % 10;
                // add the element to the list in the bucket:
                buckets[ bucket_num ].push_back( *elem );
        }
 
        // 2. transfer results of buckets back into main array
        input_type::iterator store_pos = x.begin();
        // for each bucket:
        for(buckets_type::iterator bucket = buckets.begin(); bucket != buckets.end(); ++bucket)
        {
                // for each element in the bucket:
                for(buckets_type::value_type::const_iterator bucket_elem = bucket->begin();
                        bucket_elem != bucket->end(); ++bucket_elem)
                {
                        // copy the element into next position in the main array
                        *store_pos++ = *bucket_elem;
                }
                bucket->clear(); // forget the current bucket's list
        }
    }
}
    }

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.getArray());
        t.shellSort();
        System.out.println(t.getArray());
    }
}