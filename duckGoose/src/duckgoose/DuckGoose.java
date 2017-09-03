package duckgoose;
import java.util.Scanner;

public class DuckGoose{
    
    private static Scanner in=new Scanner(System.in);
        public static void main(String args[])throws Exception{
            execute(in.nextInt());
        };
    
    static void execute(int T){
        if(T>=1&&T<=50){
            for(int i=0;i<T;i++){
                int N=in.nextInt();
                duckGoose(N);       
            };  
        };
    };
    static void duckGoose(int N){
        LinkedList students=new LinkedList();
        students=makeList(N);
        if(N>=1&&N<=10000){
            for(int i=0;i<N;i++){
                int K=in.nextInt();
                if(K>=0&&K<=1000000){
                    System.out.println(goose(K,N));
                    students.remove(goose(K,N)-1);
                    N--;
                };
            };
            System.out.println("The winner student will be: "+students.head());
        };
    };
    static int goose(int K,int N){
        int goose=0;
        if(K!=0){
            if(K>N) goose=(K%N);
            else goose=(N%K);
        }else goose=0;
     
        if(goose==N)goose=0;
        
        return goose+1;
    };
    static LinkedList makeList(int items){
        LinkedList list=new LinkedList();
        for(int i=items;0<i;i--){
            list.addFirst(i);
        };
        return list;
    };
};


class LinkedList{
    
    private Node head;
    private int size;
    
    public LinkedList(){
        this.head=null;
        this.size=0;
    };
    public void addFirst(Object object){
        if(this.head==null)this.head=new Node(object);
        else{
            Node temporal=this.head;
            Node incoming=new Node(object);
            incoming.setNext(temporal);
            this.head=incoming;
        };
        this.size++;
    };
    public int getSize(){
        return this.size;
    };
    public Object head(){
        return getItem(0);
    };
    public Object getItem(int index){
        Node temporal=this.head;
        for(int i=1;i<index;i++){
            temporal=temporal.getNext();
        };
        return temporal.getValue();
    };
    public boolean voidList(){
        return(this.head==null)?true:false;
    };
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
    };

};


class Node{
    
    private Object value;
    private Node next;

    public Node(Object value){
        this.value=value;
    };
    public Object getValue(){
        return this.value;  
    };
    public void setNext(Node next){
        this.next=next;  
    };
    public Node getNext(){
        return this.next;
    };

};