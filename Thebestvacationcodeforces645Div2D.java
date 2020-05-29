/*
You've been in love with Coronavirus-chan for a long time, but you didn't know where she lived until now. And just now you found out that she lives in a faraway place called Naha.

You immediately decided to take a vacation and visit Coronavirus-chan. Your vacation lasts exactly x
days and that's the exact number of days you will spend visiting your friend. You will spend exactly x consecutive (successive) days visiting Coronavirus-chan.

They use a very unusual calendar in Naha: there are n months in a year, i-th month lasts exactly di days.
Days in the i-th month are numbered from 1 to di.
There are no leap years in Naha.

The mood of Coronavirus-chan (and, accordingly, her desire to hug you) depends on the number of the day in a month. In particular, you get j
hugs if you visit Coronavirus-chan on the j-th day of the month.

You know about this feature of your friend and want to plan your trip to get as many hugs as possible (and then maybe you can win the heart of Coronavirus-chan).

Please note that your trip should not necessarily begin and end in the same year.
Input

The first line of input contains two integers n
and x (1≤n≤2⋅105) — the number of months in the year and the number of days you can spend with your friend.

The second line contains n
integers d1,d2,…,dn, di is the number of days in the i-th month (1≤di≤106).

It is guaranteed that 1≤x≤d1+d2+…+dn

.
Output

Print one integer — the maximum number of hugs that you can get from Coronavirus-chan during the best vacation in your life.

Input
3 2
1 3 1
Output
5

Input
3 6
3 3 3
Output
12

Input
5 6
4 2 3 1 3
Output
15

*/
import java.io.*;
import java.util.*;
import java.lang.*;

public class Thebestvacationcodeforces645Div2D{
	
	static long hugss(long x) {
		return (x*(x+1))/2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Long.parseLong(st.nextToken());
		int d[] = new int[2*n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			d[i] = Integer.parseInt(st.nextToken());
			d[i+n] = d[i];
		}
		long res=0;
		long days=0;
		long hugs=0;
		long right=0;
		int i=0;
		int j=0;
		while(i<n)
		{
			days += d[j];
			hugs += hugss(d[j]);
			if(days >= x)
			{
				while(i<n && days-d[i]>=x)
				{
					days-=d[i];
					hugs-=hugss(d[i]);
					i++;
				}
				long diff = days - x;
				res = Math.max(res, hugs - hugss(diff));
			}
			j=(j+1)%n;
		}
		System.out.println(res);
		
	}
}
