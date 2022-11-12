import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			
			int[] preorder = new int[n];
			int[] inorder = new int[n];
			
			for(int i = 0; i < n; i++) {
				preorder[i] = sc.nextInt();
			}
			for(int i = 0; i < n; i++) {
				inorder[i] = sc.nextInt();
			}
			
			postOrder(preorder, inorder);
			System.out.println();
		}
	}
	
	static void postOrder(int[] preorder, int[] inorder) {
		if (preorder.length == 1) {
			System.out.print(preorder[0] + " ");
			return;
		}
		int root = preorder[0];
		
		//find
		int rootidx = -1;
		
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == root) {
				rootidx = i;
				break;
			}
		}
		
		int[] rightinorder = cutinorder(inorder, rootidx, true);
		int[] leftinorder = cutinorder(inorder, rootidx, false);
		int[] rightpreorder = cutpreorder(preorder, rootidx, true);
		int[] leftpreorder = cutpreorder(preorder, rootidx, false);
		if(leftpreorder.length != 0) postOrder(leftpreorder, leftinorder);
		if(rightpreorder.length != 0) postOrder(rightpreorder, rightinorder);
		
		System.out.print(preorder[0] + " ");
	}
	
	static int[] cutinorder(int[] array, int cutidx, boolean right) {
		int[] temp;
		
		if(right) {
			int n = array.length-cutidx-1;
			temp = new int[n];
			for(int i = cutidx+1; i < array.length; i++) {
				temp[i-cutidx-1] = array[i];
			}
		} else {
			int n = cutidx;
			temp = new int[n];
			for(int i = 0; i < n; i++) {
				temp[i] = array[i];
			}
		}
		
		return temp;
	}
	
	static int[] cutpreorder(int[] array, int cutidx, boolean right) {
		int[] temp;
		
		if(right) {
			int n = cutidx;
			temp = new int[array.length-n-1];
			int j = 0;
			for(int i = n+1; i < array.length; i++) {
				temp[j++] = array[i];
			}
			
		} else {
			int n = cutidx;
			temp = new int[n];
			int j = 0;
			for(int i = 1; i < n+1; i++) {
				temp[j++] = array[i];
			}
		}
		
		return temp;
	}
}