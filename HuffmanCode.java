import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

class TreeNode{
	int val;
	char c;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val){
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class HuffmanCode {
	
	public static void assigncode(TreeNode root, String s) {
		
		if(root.left == null && root.right == null && Character.isLetter(root.c))
		{
			System.out.println(root.c + ": " + s);
			return;
		}
		assigncode(root.left, s + "0");
		assigncode(root.right, s + "1");
	}
	
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		int n = 6;
		char ch[] = {'c', 'f', 'a', 'd', 'e', 'b'};
		int chf[] = {12, 45, 5, 13, 16, 9};
		PriorityQueue<TreeNode> q = new PriorityQueue<>(n, new Comparator<TreeNode>() {
			public int compare(TreeNode x, TreeNode y) {
				return x.val - y.val;
			}
		});
		for(int i=0;i<n;i++)
		{
			TreeNode t = new TreeNode();
			t.c = ch[i];
			t.val = chf[i];
			t.left = null;
			t.right = null;
			q.add(t);
		}
		TreeNode root = null;
		while(q.size()>1)
		{
			TreeNode x = q.peek();
			q.poll();
			TreeNode y = q.peek();
			q.poll();
			
			TreeNode f = new TreeNode();
			
			f.val = x.val + y.val;
			f.c = '-';
			f.left = x;
			f.right = y;
			root = f;
			q.add(f);
		}
		assigncode(root, "");
		
	}
	
}