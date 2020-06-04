import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;


public class policecatchthievesgreedyalgorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> police = new ArrayList<>();
		ArrayList<Integer> thieves = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			char c = st.nextToken().charAt(0);
			if(c=='P')
				police.add(i);
			else if(c=='T')
				thieves.add(i);
		}
		int p=0;
		int t=0;
		int count=0;
		while(p<police.size() && t<thieves.size())
		{
			if(Math.abs(police.get(p) - thieves.get(t)) <= k)
			{
				count++;
				p++;
				t++;
			}
			else if(police.get(p) < thieves.get(t))
				p++;
			else
				t++;
		}
		System.out.println(count);
		
	}
	
}