import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		heapSort(list);
		
		for (int i = 0; i < n; i++) {
			bw.write(list[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void heapSort(int[] list) {
		heapSort(list, list.length);
	}
	
	static void heapSort(int[] list, int size) {

		if (size < 2) {
			return;
		}

		int parentidx = getParent(size - 1);

		for (int i = parentidx; i >= 0; i--) {
			heapify(list, i, size-1);
		}

		for (int i = size - 1; i > 0; i--) {
			swap(list, 0, i);
			heapify(list, 0, i-1);
		}
	}
	
	static int getParent(int child) {
		return ((child -1) /2);
	}
	
	static void swap (int[] list, int o1, int o2) {
		int temp = list[o1];
		list[o1] = list[o2];
		list[o2] = temp;
	}
	
	static void heapify(int[] list, int parentidx, int lastidx) {
		
		while (2 * parentidx + 1 <= lastidx) {
			int largestidx = parentidx;
			int leftChildidx = 2 * parentidx + 1;
			int rightChildidx = 2 * parentidx + 2;
			
			if (leftChildidx <= lastidx && list[leftChildidx] > list[largestidx]) {
				largestidx = leftChildidx;
			}
			
			if (rightChildidx <= lastidx && list[rightChildidx] > list[largestidx]) {
				largestidx = rightChildidx;
			}
			
			if (largestidx != parentidx) {
				swap(list, largestidx, parentidx);
				parentidx = largestidx;
			} else {
				return;
			}
		}
	}
}
