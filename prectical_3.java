class prectical_3 {
    public static void main(String[] args) {
        System.out.println("202202100410040");
        int processes[] = new int[] { 1, 2, 4 };
        int priority[] = new int[] { 3, 4, 1 };
        int arrival[] = new int[] { 4, 2, 0 };
        int burst[] = new int[] { 15, 12, 5 };
        int ct[] = new int[] { 0, 0, 0 };
        int i = 0;
        int tat;
        int atat[] = new int[3];
        int wt;
        int awt[] = new int[3];
        int ct2 = 0;
        int sum_tat = 0;
        int sum_wt = 0;
        int l = 0;
        l = processes.length;
        int temppro;
        int temppri;
        int tempb;
        int tempa;
        for (i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                if (priority[i] > priority[j]) {
                    temppri = priority[i];
                    priority[i] = priority[j];
                    priority[j] = temppri;
                    temppro = processes[i];
                    processes[i] = processes[j];
                    processes[j] = temppro;
                    tempb = burst[i];
                    burst[i] = burst[j];
                    burst[j] = tempb;
                    tempa = arrival[i];
                    arrival[i] = arrival[j];
                    arrival[j] = tempa;
                }
            }
        }
        for (i = 0; i < l; i++) {
            ct[i] += burst[i];
            ct2 += ct[i];
            ct[i] = ct2;
            tat = ct2 - arrival[i];
            atat[i] = tat;
            sum_tat += tat;
            wt = tat - burst[i];
            awt[i] = wt;
            sum_wt += wt;
        }
        System.out.print("processes" + "priority" + "Burst time" + "Arrival time" + "Waiting time" + "time around time"
                + "completion time\n");
        for (i = 0; i < l; i++) {
            System.out.println(processes[i] + "\t" + priority[i] + "\t" + burst[i] + "\t\t" + arrival[i] + "\t" + awt[i]
                    + "\t\t" + atat[i] + "\t\t" + ct[i]);
        }
        System.out.print("Average waiting time= " + (float) sum_wt / (float) processes[i - 1]);
        System.out.print("\n Average turm around time= " + (float) sum_tat / (float) processes[i - 1]);

    }
}