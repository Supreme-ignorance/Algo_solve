import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		int[] list = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			list[i] = arr[i] - '0';
		}
		
		br.close();
		
		QickSort qs = new QickSort();
		qs.qickSort(list, 0, list.length-1);
		
		for (int i = list.length - 1; i >= 0; i--) {
			bw.write(list[i] + "");
		}
		bw.flush();
		bw.close();
	}
}

class QickSort{
	
	void qickSort(int[] list, int start, int end) {
		if(start<end) {
			int p = partition(list, start, end);
			
			qickSort(list, start, p-1);
			qickSort(list, p+1, end);
		} else {
			return;
		}
	}

	void swap(int[] list, int o1, int o2){
		int temp;
		
		temp = list[o1];
		list[o1] = list[o2];
		list[o2] = temp;
	}
	
	int partition(int[] list, int start, int end) {
		int pivot = list[end];
		int low = start;
		int high = end;
		
		while(low < high) {
			while(list[low] < pivot && low < high) {
				low++;
			}
			while(list[high] >= pivot && low < high) {
				high--;
			}
			
			swap(list, low, high);
		}
		
		swap(list, end, high);
		
		return high;
	}
	
}