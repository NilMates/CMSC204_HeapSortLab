import java.util.Arrays;

public class HeapSortLab {
	
    public static int[] createArray() {
        return new int[] {5, 22, 9, 76, 63, 81, 48, 92, 54, 28};
    }
 
    /** Converts the whole array into a max-heap (bottom-up build). */
    public static void buildMaxHeap(int[] list) {
        for (int index = list.length / 2 - 1; index >= 0; index--) {
            heapify(list, index, list.length);
        }
    }
 
    /** Sorts ascending: swap root with end of heap, shrink heap, re-heapify. */
    public static void heapSort(int[] list) {
        buildMaxHeap(list);
        System.out.println("Heap built      : " + Arrays.toString(list));
        for (int end = list.length - 1; end > 0; end--) {
            swap(list, 0, end);
            System.out.println("Swap [0] <-> [" + end + "]  : " + Arrays.toString(list));
            heapify(list, 0, end);
        }
    }
 
    /**
     * Sifts list[root] down so the subtree is a max-heap.
     * Only indices below 'size' are part of the heap.
     */
    private static void heapify(int[] list, int root, int size) {
        while (true) {
            int left = 2 * root + 1;
            int right = 2 * root + 2;
            if (left >= size) {
                return;                                   // root is a leaf
            }
            int largerIndex = left;
            if (right < size && list[right] > list[left]) {
                largerIndex = right;
            }
            if (list[root] >= list[largerIndex]) {
                return;                                   // already a heap
            }
            swap(list, root, largerIndex);
            System.out.println("  sift [" + root + "] <-> [" + largerIndex + "] : " + Arrays.toString(list));
            root = largerIndex;
        }
    }
 
    private static void swap(int[] list, int i, int j) {
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
 
    public static void main(String[] args) {
        int[] list = createArray();
        System.out.println("Original array  : " + Arrays.toString(list));
        heapSort(list);
        System.out.println("Sorted array    : " + Arrays.toString(list));
    }

}
