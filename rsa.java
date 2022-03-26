import java.util.Scanner ;
import java.math.BigInteger;
import java.security.SecureRandom;

public class rsa {
    static BigInteger p,q,n,phi,e,d ;
    static SecureRandom r;
    static int bitLength = 64;

    static String encrypt (String msg) {
        return new BigInteger(msg.getBytes()).modPow(e,n).toString() ;
    }

    static String decrypt(String encryptedmsg) {
       BigInteger bi=new BigInteger(encryptedmsg).modPow(d,n) ;
       return new String(bi.toByteArray()) ;
       


    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in) ;
        r = new SecureRandom() ;

        p=BigInteger.probablePrime(bitLength, r) ;
        q=BigInteger.probablePrime(bitLength, r) ;
        n=p.multiply(q) ;
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)) ;
        e = BigInteger.probablePrime(bitLength, r) ;
        while(e.gcd(phi).compareTo(BigInteger.ONE)!=0 && e.compareTo(phi)< 0 ) {
            e = e.add(BigInteger.ONE) ;
        }  
        d = e.modInverse(phi) ;

        System.out.println("P :"  + p);
        System.out.println("Q :" + q);
        System.out.println("N :" + n);
        System.out.println("phi :" + phi);

        System.out.println("Enter the message\n");
        String msg = sc.nextLine() ;

        String encryptedmsg = encrypt(msg) ;
        System.out.println("Encrypted msg" + encryptedmsg);

        String decryptedmsg = decrypt(encryptedmsg);
        System.out.println("Decrypted msg :" + decryptedmsg);
        sc.close() ;
    }
    
}

    

