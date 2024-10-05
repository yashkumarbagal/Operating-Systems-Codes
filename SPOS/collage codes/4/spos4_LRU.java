
//Write a program to stimulate page replacement algorithm. LRU page replacement
//INPUT:
//package LRU;

import java.io.*;
import java.util.*;

public class spos4_LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int frames, pointer = 0, hit = 0, fault = 0, ref_len;
        Boolean isFull = false;
        int buffer[];
        ArrayList<Integer> stack = new ArrayList<Integer>();
        int reference[];
        int mem_layout[][];
        System.out.println("Please enter the number of Frames: ");
        frames = Integer.parseInt(br.readLine());
        System.out.println("Please enter the length of the Reference string:");
        ref_len = Integer.parseInt(br.readLine());
        reference = new int[ref_len];
        mem_layout = new int[ref_len][frames];
        buffer = new int[frames];
        for (int j = 0; j < frames; j++)
            buffer[j] = -1;
        System.out.println("Please enter the reference string: ");
        for (int i = 0; i < ref_len; i++) {
            reference[i] = Integer.parseInt(br.readLine());
        }
        System.out.println();
        for (int i = 0; i < ref_len; i++) {
            if (stack.contains(reference[i])) {
                stack.remove(stack.indexOf(reference[i]));
            }
            stack.add(reference[i]);
            int search = -1;
            for (int j = 0; j < frames; j++) {
                if (buffer[j] == reference[i]) {
                    search = j;
                    hit++;
                    break;
                }
            }
            if (search == -1) {
                if (isFull) {
                    int min_loc = ref_len;
                    for (int j = 0; j < frames; j++) {
                        if (stack.contains(buffer[j])) {
                            int temp = stack.indexOf(buffer[j]);
                            if (temp < min_loc) {
                                min_loc = temp;
                                pointer = j;
                            }
                        }
                    }
                }
                buffer[pointer] = reference[i];
                fault++;
                pointer++;
                if (pointer == frames) {
                    pointer = 0;
                    isFull = true;
                }
            }
            for (int j = 0; j < frames; j++)
                mem_layout[i][j] = buffer[j];
        }
        for (int i = 0; i < frames; i++) {
            for (int j = 0; j < ref_len; j++)
                System.out.printf("%3d ", mem_layout[j][i]);
            System.out.println();
        }
        System.out.println("The number of Hits: " + hit);
        System.out.println("Hit Ratio: " + (float) ((float) hit / ref_len));
        System.out.println("The number of Faults: " + fault);
    }
}

// OUTPUT:
// Please enter the number of Frames:
// 3
// Please enter the length of the Reference string:
// 12
// Please enter the reference string:
// 6
// 7
// 0
// 9
// 4
// 6
// 7
// 2
// 4
// 3
// 5
// 6
// 6 6 6 9 9 9 7 7 7 3 3 3
// -1 7 7 7 4 4 4 2 2 2 5 5
// -1 -1 0 0 0 6 6 6 4 4 4 6
// The number of Hits: 0
// Hit Ratio: 0.0
// The number of Faults: 12
