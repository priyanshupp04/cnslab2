import java.util.Arrays;
import java.util.Scanner ;

public class bellmanford {
    static Scanner sc = new Scanner(System.in) ;

    static void initialize(double [][]arr, int n) {
        for(int i = 1 ; i<=n ;i++) {
            for(int j=1;j<=n;j++) {
                arr[i][j] = sc.nextInt() ;
            }
        }
    }

    static void relaxation(double [][] arr,int n, double[] d ) {
        for(int i = 0 ; i< n-1 ; i++) {
            for(int j = 1; j<=n ; j++) {
                for(int k = 1 ; k<=n ; k++ ) {
                    if(arr[j][k] != 99 && i!=j) {
                        if(d[j]+arr[j][k]< d[k]) {
                            d[k] = d[j] + arr[j][k] ;
                        }
                    }
                }
            }
        }
    }

    static void print(double []d, int n) {
        for(int i = 1 ; i <= n ; i++) {
            System.out.println("Distance" + d[i]);
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt() ;
        double [][] array_2d =  new double[n+1][n+1] ;
        initialize(array_2d,n);
        double [] array_1d = new double[n+1] ;
        Arrays.fill(array_1d,99) ;
        int vertex = sc.nextInt() ;
        array_1d[vertex] = 0 ;
        relaxation(array_2d,n,array_1d) ;
        print(array_1d,n);
     }
    
}
