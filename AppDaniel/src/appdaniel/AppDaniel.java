
package appdaniel;


public class AppDaniel {

    public static void main(String[] args) {
        
    }
    
    public void remove(Node node){
        Node aux = primero;
    }
    
    
    
    
    class Node{
        Object value;
        Node next;
        
        public Node(){
            this.next = null;
        }
        public Node(Object value){
            this.value = value;
        }
        public void setValue(Object value) {
            this.value = value;
        }    
        public Object getValue(){
            return this.value;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    
    class LinkedList{
        
        Node first;
        Node end;
        
        public LinkedList(){
            first.setNext(first);
            first.setNext(null);
        }
        
         
        
    }
}
