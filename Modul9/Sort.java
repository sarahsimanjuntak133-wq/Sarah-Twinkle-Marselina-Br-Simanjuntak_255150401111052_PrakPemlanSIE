import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Sort{

    public static int[] bubble(int[] list) {
        int tukarAtauGeser = 0;

        for (int i = 0; i < list.length - 1; i++) {
            for (int k = i + 1; k < list.length; k++) {
                System.out.printf("%d:%d\n", list[k], list[i]);

                if (list[k] > list[i]) {
                    int t = list[i];
                    list[i] = list[k];
                    list[k] = t;

                    tukarAtauGeser++;
                }
            }
        }
        System.out.println("Jumlah swap Bubble: " + tukarAtauGeser);
        return list;
    }

    public static int[] insertion(int[] list) {
        int tukarAtauGeser = 0;
        for (int i = 1; i < list.length; ++i) {
            int key = list[i];
            int k = i - 1;

            while (k >= 0 && list[k] < key) {
                list[k + 1] = list[k];
                k = k - 1;

                tukarAtauGeser++;
            }

            list[k + 1] = key;
        }

        System.out.println("Jumlah geser Insertion: " + tukarAtauGeser);
        return list;
    }

    public static int[] selection(int[] list) {
         int tukarAtauGeser = 0;
        for (int i = 0; i < list.length - 1; i++) {

            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] > list[minIndex]) {
                    minIndex = k;
                }
            }
            int t = list[minIndex];
            list[minIndex] = list[i];
            list[i] = t;

            tukarAtauGeser++;
        }

        System.out.println("Jumlah swap Selection: " + tukarAtauGeser);
        return list;
    }

    public static void main(String[] args) {

    Set<Integer> set = new HashSet<>();
    Random rand = new Random();

    while (set.size() < 30) {
        set.add(rand.nextInt(100) + 1);
    }

    int[] arr = new int[30];
    int i = 0;
    for (int num : set) {
        arr[i++] = num;
    }

    System.out.println("Data awal:");
    System.out.println(Arrays.toString(arr));

    int[] arr2 = Arrays.copyOf(arr, arr.length);
    int[] arr3 = Arrays.copyOf(arr, arr.length);

    int[] hasilBubble = bubble(arr);
    int[] hasilInsertion = insertion(arr2);
    int[] hasilSelection = selection(arr3);

    System.out.println("\nHasil Sorting:");
    System.out.println("Bubble   : " + Arrays.toString(hasilBubble));
    System.out.println("Insertion: " + Arrays.toString(hasilInsertion));
    System.out.println("Selection: " + Arrays.toString(hasilSelection));
    }
}
