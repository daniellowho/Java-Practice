public class LinkedList {

    Node head;
    Node tail;
    int length=0;

    public LinkedList(int value){
        Node node  = new Node(value);
        head = node;
        tail = node;
        length++;
    }

    public void PrintList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void Insert(int value){
        //Leaving Edge Cases
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        length++;
    }

    public void InsertFirst(int value){
        Node node = new Node(value);

        //Leaving Edge Cases
        node.next = head;
        head = node;
        length++;
    }

    public void DeleteFirst(){
        Node temp = head ;
        head = head.next;
        temp.next = null;
        length--;

    }

    public void DeleteLast(){
        Node temp=head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        length--;

    }

    public void GetLength(){
        System.out.println(length);
    }

    public void InsertAtIndex(int index , int value){
        //Ignoring Edge Cases
        Node temp = head;
        Node node = new Node(value);
        int num=0;
        while (num < index){
            temp = temp.next;
            num++;
        }
        Node nextNode = temp.next;
        temp.next = node;
        node.next = nextNode;
        length++;
    }

    public void Search(int data){

        Node temp = head;
        boolean flag = false;
        while (temp !=null){

            if(temp.value ==data){
                System.out.println("Exists!");
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (!flag){
            System.out.println("Does Not Exists");
        }
    }

    public void Update(int oldValue , int newValue){

        Node temp = head;
        boolean flag = false;
        while(temp != null){
            if(temp.value == oldValue){
                temp.value =newValue;
                flag = true;
                System.out.println("Element Found and Updated");
                break;
            }
            temp = temp.next;

        }
        if(!flag){
            System.out.println("Element not found !");
        }
    }

    public void DeleteAtIndex(int index){
        Node temp = head;
        Node ptr= temp.next;
        for (int i = 0; i <= index-2; i++) {
            temp = ptr;
            ptr=ptr.next;
        }
        temp.next=ptr.next;
    }
    public void GetTail(){
        System.out.println(tail.value);
    }


}

class Node{
    int value;
    Node next;
    public Node(int value){
        this.value = value;
        this.next = null;

    }
}
