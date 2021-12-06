package lb;
import java.util.*;
public class Lb{
public static void main(String[] args) {
System.out.println("enter the number of time intervals");
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int t[]=new int[n];
System.out.println("enter the time intervals");
for(int i=0;i<n;i++)
t[i]=sc.nextInt();
System.out.println("enter i and l");
int i=sc.nextInt();
int l=sc.nextInt();
int lct=t[0];
int x=0,y=0;
for(int j=0;j<n;j++)
{
y=x-(t[j]-lct);
if(y>l)
{
System.out.println("nonconforming packet"+t[j]);
}
else
x=y+i;
lct=t[j];
System.out.println("conforming packet"+t[j]);
}
}
}
/*
OUTPUT
enter the number of time intervals
11
enter the time intervals
1 2 3 5 6 8 11 12 13 15 19
enter i and l
4
4
conforming packet1
conforming packet2
nonconforming packet3
conforming packet3
nonconforming packet5
conforming packet5
nonconforming packet6
conforming packet6
nonconforming packet8
conforming packet8
conforming packet11
nonconforming packet12
conforming packet12
nonconforming packet13
conforming packet13
nonconforming packet15
conforming packet15
conforming packet19
*/
