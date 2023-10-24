import java.util.ArrayList;
import java.util.Random;

public class Merge {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 20; i++) {
            arr.add(rand.nextInt(100));
        }

        System.out.println("Original array: " + arr);

        ArrayList<Integer> bubbleSorted = new ArrayList<>(arr);
        bubbleSort(bubbleSorted);
        System.out.println("Bubble sorted: " + bubbleSorted);

        ArrayList<Integer> mergeSorted = mergeSort(arr);
        System.out.println("Merge sorted: " + mergeSorted);
    }

    public static void bubbleSort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        int mid = arr.size() / 2;
        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, mid));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(mid, arr.size()));

        return merge(mergeSort(left), mergeSort(right));
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}