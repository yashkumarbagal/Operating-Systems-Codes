
//3.Write a program to stimulate CPU Sheduling Algorithms Round Robin (Preempitive)
//INPUT:
//package sayali;

import java.io.*;

class spos3_RR{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); int
                i, j, k, q, sum = 0;
        System.out.println("Enter number of processes:");
        int n = Integer.parseInt(br.readLine()); int bt[] = new
                int[n]; int wt[] = new int[n]; int tat[] = new
                int[n]; int a[] = new int[n];
        System.out.println("Enter burst Time:");
        for (i = 0; i < n; i++) {
            System.out.println("Enter burst Time for " + (i + 1)); bt[i]
                    = Integer.parseInt(br.readLine());
        }
        System.out.println("Enter Time quantum:");
        q = Integer.parseInt(br.readLine()); for (i =
                                                          0; i < n; i++)
            a[i] = bt[i]; for (i = 0;
                               i < n; i++)
            wt[i] = 0; do {
            for (i = 0; i < n; i++) { if
            (bt[i] > q) { bt[i]
                    -= q; for (j = 0; j < n;
                               j++) {
                if ((j != i) && (bt[j] != 0))
                    wt[j] += q;
            } } else { for
            (j = 0; j < n; j++) { if
            ((j != i) && (bt[j] != 0))
                wt[j] += bt[i];
            } bt[i]
                    = 0;
            }
            } sum
                    = 0; for (k =
                                      0; k < n; k++)
                sum = sum + bt[k]; } while
        (sum != 0);
        for (i = 0; i < n; i++)
            tat[i] = wt[i] + a[i];
        System.out.println("process\tBT\tWT\tTAT");
        for (i = 0; i < n; i++) {
            System.out.println("process " + (i + 1) + "\t" + a[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        float avg_wt = 0;
        float avg_tat = 0; for (j
                                        = 0; j < n; j++) {
            avg_wt += wt[j];
        } for (j = 0; j <
                n; j++) {
            avg_tat += tat[j]; }
        System.out.println("Average waiting time " + (avg_wt / n) + "\nAverage turnaround time "
                + (avg_tat / n));
    }
}

//OUTPUT:
//        Enter number of processes:
//        3
//        Enter burst Time:
//        Enter burst Time for 1
//        4
//        Enter burst Time for 2
//        5
//        Enter burst Time for 3 6
//        Enter Time quantum:
//        4
//        Process BT WT TAT process 1 4 0
//        4 process 2 5 8 13 process 3 6 9
//        15
//        Average waiting time 5.6666665
//        Average turnaround time 10.666667