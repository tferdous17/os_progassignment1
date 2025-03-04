import java.util.Random;

public static void main(String[] args) {
    int PAGE_MAX = 100;
    int[] processes = new int[PAGE_MAX];
    userMemoryAllocation(processes);
}

public static void userMemoryAllocation(int[] processes) {
    Random rand = new Random();
    int currentAddress = 2000;

    for (int i = 0; i < processes.length; i++) {
        processes[i] = i;
        int randomNumber = rand.nextInt(1, 31);
        int processSize = randomNumber * 80;
        int numMemPages = (int) Math.ceil((double) processSize / 160);
        int unusedMemSpace = (numMemPages * 160) - processSize;

        System.out.printf("%-12s %-28s %-30s %-20s%n",
                "Process Id", "Starting Memory Address", "Size of the Process MB", "Unused Space MG");

        System.out.printf("%-12d %-28d %-30d %-20d%n",
                i, currentAddress, processSize, unusedMemSpace);

        currentAddress += (numMemPages * 160);
    }
}