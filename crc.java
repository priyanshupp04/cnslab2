import java.util.Scanner;

public class Main {
    
       static int[] divide(int div[],int divisor[], int rem[])
        {
            int cur=0;
            while(true)
                    {
                    for(int i=0;i<divisor.length;i++)
                      rem[cur+i]=(rem[cur+i]^divisor[i]);
                      
                    while(rem[cur]==0 && cur!=rem.length-1)
                         cur++;
                         
                    if((rem.length-cur)<divisor.length)
                        break;
                    }
                return rem;
        }
    public static void main(String[] args) {
        int[] data;
        int[] div;
        int[] divisor;
        int[] rem;
        int[] crc;
        int data_bits,divisor_bits,tot_length;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("enter the number of data_bits");
        data_bits=sc.nextInt();
        data = new int[data_bits];
        System.out.println("Enter the data bits:");
        for(int i=0;i<data_bits;i++)
            data[i]=sc.nextInt();
        
        System.out.println("Enter the number of divisor_bits:");
        divisor_bits=sc.nextInt();
        divisor = new int[divisor_bits];
        System.out.println("Enter the divisor_bits:");
        for(int i=0; i<divisor.length;i++)
            divisor[i] = sc.nextInt();
            
        tot_length=data_bits+divisor_bits-1 ;
        
        div=new int[tot_length];
        rem=new int[tot_length];
        crc=new int[tot_length];
        
        // crc generation
        for(int i=0;i<data.length;i++)
            div[i]=data[i];
        
        System.out.println("dividend after appending 0's are :");
        for(int i=0;i<div.length;i++)
            System.out.print(div[i]);
        System.out.println();
            
        for(int j=0;j<div.length;j++) {
            rem[j]=div[j];
        }
        rem=divide(div,divisor,rem);
        
        for(int i=0;i<div.length;i++)
        {
            crc[i]=div[i]^rem[i];
        }
        System.out.println();
        System.out.println("Enter crc code:");
        for(int i=0;i<crc.length;i++)
            System.out.println(crc[i]);
        
        //Error detection
        System.out.println("Enter crc code:");
        for(int i=0;i<crc.length;i++)
            crc[i]=sc.nextInt();
            
        for(int j=0;j<crc.length;j++)
           { rem[j]=crc[j]; }
        rem=divide(crc,divisor,rem);
        
        for(int i=0;i<rem.length;i++)
        {
            if(rem[i]!=0) {
                System.out.println("Error");
                break;
            }
            if(i==rem.length-1){
                System.out.println("No error");
                }
        }
    }
     
}

