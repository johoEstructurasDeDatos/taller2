package youtuber;
import java.util.Scanner;
/**
 *
 * @author ElJoho
 */
public class Youtuber{
    private static Scanner in=new Scanner(System.in);
    public static void main(String[] args){
        int T=in.nextInt();
        try{
            if(T>=1&&T<=1000)execute(T);
        }catch(Exception e){
        };
            /*
            List fans=new List();
            fans.add((byte)5);
            fans.add((byte)4);
            fans.add((byte)3);
            fans.add((byte)2);
            fans.add((byte)1);
            fans.get(5);
            System.out.println("Aca obtine 5: ");
            fans.get(1);
            System.out.println("Aca obtiene la list");
            fans.getList();
            fans.reset();
            System.out.println("Aca no obtine nada");
            fans.getList();
            System.out.println("Aca obtiene 0: "+fans.size());
        */
    };
    
    public static void execute(int T){
        int N;
        int K;
        for(int i=0;i<T;i++){
            N=in.nextInt();
            K=in.nextInt();
            if(N>=1&&N<=100000 && K>=0&&K<N)deleteFans(fans(N),K).printAndReset();
            System.gc();
        };
    };
    public static List fans(int N){
        List fans=new List();
        for(int i=0;i<N;i++){
            byte popy=in.nextByte();
            if(popy>=0&&popy<=100)fans.add(popy);
            else i=N;
        };
        System.out.println("imprime fans: \n");
        fans.getList();
        return fans;
    };
    public static List deleteFans(List fans,int deletions){
        boolean removal=false;
        for(int i=1;i<=fans.size();i++){
            if(i!=fans.size() && (fans.get(i)<fans.get(i+1)) ){
                fans.remove(i);
                System.gc();
                deletions--;
                removal=true;
            };
            if(i==fans.size() && (deletions!=0&&removal!=true)){
                fans.remove(fans.size());
                System.gc();
                deletions--;
            };
        };
        if(deletions!=0)return deleteFans(fans,deletions);
        else return fans;
    };
};



class List{
    
    private Node head;
    private int size;
    
    public List(){
        this.head=null;
        this.size=0;
    };
    //Añadir 
    public void add(byte item){
        if(this.head==null)this.head=new Node(item);
        else{
            Node temporal=this.head;
            Node incoming=new Node(item);
            incoming.setNext(temporal);
            this.head=incoming;
        };
        this.size++;
    };
    
    //Obtener
    public int size(){
        return this.size;
    };
    public byte head(){
        return get(0);
    };
    public byte get(int index){
        Node temporal=this.head;
        for(int i=1;i<index;i++){
            temporal=temporal.getNext();
        };
        //System.out.println(temporal.getItem());
        return temporal.getItem();
    };
    public void getList(){
        Node present=this.head;
        for(int i=0;i<this.size;i++){
            System.out.print(present.getItem()+" ");
            present=present.getNext();
        };
        System.out.println("");
    };
    public boolean voidList(){
        return(this.head==null)?true:false;
    };
    
    //Modificar
    public void remove(int index){
        if(index==0)this.head=this.head.getNext();
        else{
            Node temporal=this.head;
            for(int i=1;i<index;i++){
                temporal=temporal.getNext();
            };
            temporal.setNext(
                temporal.getNext().getNext()
            );    
        };
        size--;
        System.gc();
    };
    public void reset(){
        this.head=null;
        this.size=0;
    };
    public void printAndReset(){
        getList();
        reset();
        System.gc();
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