public class prectical_2

{
    static void FindWatingTime(int processes[], int n, int bt[], int wt[], int at[]) {
        System.out.println("202202100410010");
        int service_time[] = new int[n];
        service_time[0] = at[0];
        wt[0] = 0;
        for (int i = 1; i < n; i++) {
            int wasted = 0;
            service_time[i] = service_time[i - 1] + bt[i - 1];
            wt[i] = service_time[i] - at[i];
            if (wt[0] < 0) {
                wasted = Math.abs(wt[i]);
                wt[i] = 0;
            }
            service_time[i] = service_time[i] + wasted;
        }
    }

    static void FindTurnaroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++)
            tat[i] = bt[i] + wt[i];
    }

    static void FindAvgTime(int processes[], int n, int bt[], int at[]) {
        int wt[] = new int[n], tat[] = new int[n];
        FindWatingTime(processes, n, bt, wt, at);
        FindTurnaroundTime(processes, n, bt, wt, tat);
        System.out.println("Processes\t" + "BrustTime\t" + "ArrivalTime\t" + "WatingTime\t" + "TurnaroundTime\t"
                + "CompletionTime\t");
        int total_wt = 0, total_tat = 0;
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wt[i];
            total_tat = total_tat + tat[i];
            int compl_time = tat[i] + at[i];
            System.out.println(
                    i + 1 + "\t\t" + bt[i] + "\t\t" + at[i] + "\t\t" + wt[i] + "\t\t" + tat[i] + "\t\t" + compl_time);
        }
        System.out.print("Average wating time=" + (float) total_wt / (float) n);
        System.out.print("\nAverage Turn around time time=" + (float) total_tat / (float) n);
    }

    public static void main(String args[]) {
        int processes[] = { 1, 2, 3 };
        int n = processes.length;
        int burst_time[] = { 5, 9, 6 };
        int arrival_time[] = { 0, 3, 6 };
        FindAvgTime(processes, n, burst_time, arrival_time);
    }
}
