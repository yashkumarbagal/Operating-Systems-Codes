
//2.Write a program to stimulate CPU Sheduling Algorithms SJF
//package SJF;
import java.util.Scanner;
public class spos3_SJF {
    public static void main(String args[])
    {
        int burst_time[],process[],waiting_time[],tat[],arr_time[],completion_time[],i,j,n,total=0,total_comp =0,pos,temp;
        float wait_avg,TAT_avg;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of process: ");
        n = s.nextInt();
        process = new int[n];
        burst_time = new int[n];
        waiting_time = new int[n];
        arr_time=new int[n];
        tat = new int[n];
        completion_time=new int[n];
//burst time
        System.out.println("\nEnter Burst time:"); for(i=0;i<n;i++)
    {
        System.out.print("\nProcess["+(i+1)+"]: ");
        burst_time[i] = s.nextInt();; process[i]=i+1;
//Process Number
    }
//arrival time
        System.out.println("\nEnter arrival time:");
        for(i=0;i<n;i++)
    {
        System.out.print("\nProcess["+(i+1)+"]: ");
        arr_time[i] = s.nextInt();; process[i]=i+1;
//Process Number
    } //Sorting
        for(i=0;i<n;i++)
        { pos=i;
            for(j=i+1;j<n;j++)
            {
                if(burst_time[j]<burst_time[pos]) pos=j;}
            temp=burst_time[i];
            burst_time[i]=burst_time[pos];
            burst_time[pos]=temp; temp=process[i];
            process[i]=process[pos];
            process[pos]=temp;
            System.out.println("process"+process[i]);
        }
//completion time new
        for(i=1;i<n;i++)
        {
            completion_time[i]=0; for(j=0;j<i;j++)
            completion_time[i]+=burst_time[j];
            total_comp+=completion_time[i];
        }
//First process has 0 waiting time
        waiting_time[0]=0; //calculate waiting time
        for(i=1;i<n;i++)
    { waiting_time[i]=0;
        for(j=0;j<i;j++)
            waiting_time[i]+=burst_time[j]; total+=waiting_time[i];
    }
//Calculating Average waiting time
        wait_avg=(float)total/n; total=0;
        System.out.println("\nPro_number\t Burst Time \tcompletion_time\tWaiting Time\tTurnaround Time");
        for(i=0;i<n;i++)
        { tat[i]=burst_time[i]+waiting_time[i];
//Calculating Turnaround Time
            total+=tat[i];
            System.out.println("\n"+process[i]+"\t\t "+burst_time[i]+"\t\t"+completion_time[i]+"\t\t"+waiting_time[i]+"\t\t "+tat[i]); }
//Calculation of Average Turnaround Time
                    TAT_avg=(float)total/n;
            System.out.println("\n\nAWT: "+wait_avg);
            System.out.println("\nATAT: "+TAT_avg);

        }
    }
//
//    OUTPUT:
//    Enter number of process: 5 Enter
//    Burst time:
//    Process[1]: 20
//    Process[2]: 16
//    Process[3]: 18
//    Process[4]: 14
//    Process[5]: 12
//    Enter arrival time:
//    Process[1]: 10
//    Process[2]: 8
//    Process[3]: 15
//    Process[4]: 17
//    Process[5]: 18
//    process5 process4
//    process2 process3
//    process1
//    Pro_number Burst Time completion_time Waiting Time Turnaround Time
//5 12 0 0 12
//        4 14 12 12 26
//        2 16 26 26 42
//        3 18 42 42 60
//        1 20 60 60 80
//    AWT: 28.0
//    ATAT: 44.0