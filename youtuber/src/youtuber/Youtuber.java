package youtuber;
import java.util.Scanner;
/**
 *
 * @author ElJoho
 */
public class Youtuber{
    private static Scanner in=new Scanner(System.in);
    public static void main(String[] args){
        
        short T=in.nextShort();
        try{
            if(T>=1&&T<=1000)execute(T);
        }catch(Exception e){
            /* 
            List fans=new List();
            fans.add((byte)5);
            fans.add((byte)4);
            fans.add((byte)3);
            fans.add((byte)2);
            fans.add((byte)1);
            fans.remove(1);
            fans.get(1);
            fans.getList();
            fans.reset();
            fans.getList();
            System.out.println(fans.size());
            */
        };
    };
    
    public static void execute(int T){
        int N;
        int K;
        for(int i=0;i<T;i++){
            N=in.nextInt();
            K=in.nextInt();
            if(N>=1&&N<=100000 && K>=0&&K<N)deleteFans(fans(N),K).getListAndReset();
        };
    };
    public static List fans(int N){
        List fans=new List();
        for(int i=0;i<N;i++){
            byte popy=in.nextByte();
            if(popy>=0&&popy<=100)fans.add(popy);
            else i=N;
        };
        return fans;
    };
    public static List deleteFans(List fans,int deletions){
        boolean removal=false;
        boolean homogeneity=false;
        for(int i=1;i<=fans.size() && deletions!=0;i++){
            if(i!=fans.size() && (fans.get(i)<fans.get(i+1)) ){
                fans.remove(i);
                deletions--;
                removal=true;
            };
            if(i==fans.size() && (deletions!=0&&removal!=true)){
                fans.remove(fans.size());
                deletions--;
                homogeneity=true;
                System.out.println(homogeneity);
            };
        };
        if(homogeneity){
            for(int i=0;i<deletions;i++){
                fans.remove(fans.size());
            };
        };
        if(deletions!=0)return deleteFans(fans,deletions);
        else return fans;
    };
};

class List{
    private Node head;
    private Node butt;
    private int size;
    
    public List(){
        this.head=null;
        this.butt=null;
        this.size=0;
    };
    public void add(byte item){
        Node newItem=new Node(item);
        
        if(this.head==null){
            this.head=newItem;
            this.butt=this.head;
            this.head.setNext(butt);
        }else{
            this.butt.setNext(newItem);
            newItem.setNext(this.head);
            this.butt=newItem;
        };
        this.size++;
    };
    
    //Metodos  de Busquedas
    public void search(byte item){
        Node present=this.head;
        for(int i=1;i<=this.size;i++){
            if(present.getItem()==item){
                System.out.println(present.getItem());
                i=this.size;
            }else present=present.getNext();
        };
    };
    public byte get(int position){
        Node present=this.head;
        for(int i=1;position<=this.size && i<=position;i++){
            if(i==position)i=position;//System.out.println(present.getItem());
            else present=present.getNext();
        };
        return present.getItem();
    };
    public void getList(){
        Node present=this.head;
        for(int i=0;i<this.size;i++){
            System.out.print(present.getItem()+" ");
            present=present.getNext();
        };
        System.out.println("");
    };
    public void getListAndReset(){
        getList();
        reset();
    };   
    //Metodos de Modificaciones
    public void set(int position,byte item){
        Node present=this.head;
        for(int i=1;position<=this.size && i<=position;i++){
            if(i==position)present.setItem(item);
            else present=present.getNext();
        };
    };
    public void remove(int position){
        Node present=this.head;
        Node before=this.butt;
        for(int i=1;i<=position && position<=this.size;i++){
            if(i==position){
                if(present==this.head){
                    this.head=this.head.getNext();
                    this.butt.setNext(this.head);
                }else if(present==this.butt){
                    before.setNext(this.butt.getNext());
                    this.butt=before;
                }else{
                    before.setNext(present.getNext());
                };                
            };
            before=present;
            present=present.getNext();
        };
        size--;
    };
    public void reset(){
        this.head=null;
        size=0;
    };
    //Acceder a caracterisiticas
    public int size(){
        return this.size;
    };
    public Node head(){
        return this.head;
    };
    public Node butt(){
        return this.butt;
    };
};

class Node{
    private byte item;
    private Node next;

    public Node(){
    };
    public Node(byte value){
        this.item=value;
    };
    public void setItem(byte newItem){
        this.item=newItem;
    };
    public byte getItem(){
        return this.item;  
    };
    public void setNext(Node next){
        this.next=next;  
    };
    public Node getNext(){
        return this.next;
    };
    
};
