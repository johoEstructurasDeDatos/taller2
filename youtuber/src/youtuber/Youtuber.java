package youtuber;
import java.util.Scanner;
/**
 *
 * @author ElJoho
8
46 45 87 74 59 12 43 10 81 14 1 46 98 68 27 55 53 33 28 3 39 41 90 23 44 100 70 40 95 58 89 36 38 25 13 84 6 99 37 78 66 65 47 96 7 11 64 79
15 10 28 17 78 41 39 44 15 37 99 61 59 9 63 82 54 
21 19 1 16 19 100 15 90 9 20 40 30 26 86 50 31 60 67 20 15 100 17 99
3 1 3 100 1
5 2 19 12 3 4 17
5 3 23 45 11 77 18
5 4 0 0 0 0 0
5 0 23 45 11 77 18
 */
public class Youtuber{
    private static Scanner in=new Scanner(System.in);
    public static void main(String[] args){  
        try{
            short T=in.nextShort();
            if(T>=1&&T<=1000)execute(T);
        }catch(Exception e){
        }
            
    };
    
    public static void execute(int T){
        for(int i=0;i<T;i++){
            int N=in.nextInt();
            int K=in.nextInt();
            byte fans[]=new byte[N];
            if(N>=1&&N<=100000 && K>=0&&K<N)printAndDelete(deleteFans(fans(N),K));
        };
    };
    public static byte[] fans(int N){
        byte fans[]=new byte[N];
        for(int i=0;i<N;i++){
            byte popy=in.nextByte();
            if(popy>=0&&popy<=100)fans[i]=popy;
            else i=N;
        };
        return fans;
    };
    public static byte[] deleteFans(byte[] fans,int deletions){
        boolean delete=false, homogeneity=true;
         //System.out.println("-----------new "+fans.length);
        for(int i=1,j=0;i<fans.length && deletions!=0;i++){
            if(i<fans.length && fans[j]<fans[i] && fans[j]!=-1){
                fans[j]=-1;
                j=i;
                deletions--;
                delete=true;
                homogeneity=false;
                //System.out.println("delete");
            };
            
            if(fans[i]!=-1)
                if(fans[j]>=fans[i]|| fans[j]==-1)
                    j=i;
            
            if(homogeneity==true)
                if(fans[j]>fans[i]||fans[j]<fans[i])
                    homogeneity=false;
            
            if( i==fans.length-1 && deletions!=0 && delete==false){
                //System.out.println("jump1");
                for(int i1=fans.length-1 ;i1>-1; i1--){
                    if(fans[i1]!=-1){
                        fans[i1]=-1;
                        deletions--;
                        i1=-1;
                    };
                };
            };
        };
        
        if(deletions!=0 && homogeneity==true){
            for(int i1=fans.length-1;deletions>0;i1--){
                if(fans[i1]!=-1){
                    fans[i1]=-1;
                    deletions--;
                    //System.out.println("jump2");
                };
            };
        };
        if(deletions!=0)return deleteFans(fans,deletions);
        else return fans;
    };
    public static void printAndDelete(byte[] fans){
        for(int i=0;i<fans.length;i++){
            if(fans[i]!=-1)System.out.print(fans[i]+" ");
        };
        System.out.println("");
        fans=null;
        System.gc();
    };
};
