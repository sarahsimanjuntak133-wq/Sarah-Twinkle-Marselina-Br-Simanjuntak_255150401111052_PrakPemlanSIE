import java.util.*;

public class Search {

    public static int linearSearch(int[] arr, int search) {
    int check = 0;

    for (int i = 0; i < arr.length; i++) {
        check++;
        if (arr[i] == search) {
            System.out.println("Linear Search check: " + check);
            return i;
        }
    }

    System.out.println("Linear Search check: " + check);
    return -1;
}

    public static int binarySearch(int[] arr, int search) {
    int low = 0, high = arr.length - 1;
    int check = 0;

    while (low <= high) {
        check++;
        int mid = low + (high - low) / 2;

        if (arr[mid] == search) {
            System.out.println("Binary Search check: " + check);
            return mid;
        }

        if (arr[mid] < search) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    System.out.println("Binary Search check: " + check);
    return -1;
}

     public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();

        set.add(88);

        while (set.size() < 30) {
            int angka = rand.nextInt(100) + 1;
            set.add(angka);
        }

        int[] arr = new int[30];
        int i = 0;
        for (int num : set) {
            arr[i++] = num;
        }

        Arrays.sort(arr);

        System.out.println("Array (ascending):");
        System.out.println(Arrays.toString(arr));
    

        int hasilLinear = linearSearch(arr, 200);
        int hasilBinary = binarySearch(arr, 200);

        System.out.println("\nHasil Pencarian:");
        System.out.println("Linear Search index: " + hasilLinear);
        System.out.println("Binary Search index: " + hasilBinary);
    }
}
