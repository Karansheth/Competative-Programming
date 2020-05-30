import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
/*
You are given n activities with their start and finish times. 
Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

Input
Activitiy arr[] = {{5, 9}, {1, 2}, {3, 4}, {0, 6}, {5, 7}, {8, 9}};
Output 
Following activities are selected 
(1, 2), (3, 4), (5, 7), (8, 9)                               
*/
public class ActivitiySelectionGreedyProblem {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int startend[][] = new int[n][2];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			startend[i][0] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			startend[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(startend, new Comparator<int []>() {
			public int compare(final int a[], final int b[]) {
				if(a[1]>b[1])
					return 1;
				else
					return -1;
			}
		});
		System.out.println("Activities Selected are: ");
		System.out.println(startend[0][0] + " " + startend[0][1]);
		int j=0;
		for(int i=1;i<n;i++)
		{
			if(startend[i][0] >= startend[j][1])
			{
				System.out.println(startend[i][0] + " " + startend[i][1]);
				j=i;
			}
		}
	}
	
}
