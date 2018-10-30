public class LinkedListDeque<sometims>{
    private IntNode sentinel;
    private int size;
    private IntNode last;

    public class IntNode{

        public sometims item;
        public IntNode pre;
        public IntNode next;

        public IntNode(sometims i,IntNode m,IntNode n){
           this.item=i;
           this.pre=m;
           this.next=n;
        }
    }
    public  LinkedListDeque(){
        sentinel = new IntNode(null,null,null);
        size = 0;
        last = sentinel;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

     public void printDeque(){
        IntNode p = sentinel.next;
        if(p!=null){
            System.out.print(" " + p.item +" ");
            p=p.next;
        }
    }
    public void addFirst(sometims item){
        IntNode x = new IntNode(item,sentinel,sentinel.next);
        sentinel.next=x;
        last=x;
        size=size+1;
    }

     public void addLast(sometims item){
            IntNode x =new IntNode(item,last,null);
            last=x;
            size=size+1;
        }
     public sometims removeFirst(){
        if(sentinel.next!=null) {
            IntNode p = sentinel.next;
            sentinel.next = p.next;
            p.next.pre=sentinel;
            size = size - 1;
            return p.item;
        }else
            return null;

    }
    public sometims removeLast(){
        if(last==sentinel) {
            return null;
        }
        IntNode p = last;
        last=last.pre;
        last.next = null;
        size =size-1;
        return p.item;
    }

    public sometims get(int index){
        if(index > size) return null;
        if(index < 0) return null;
        IntNode p = sentinel.next;
        for(int i = 0;i < index; i++){
            p = p.next;
        }
        return p.item;
        }
     public sometims getRecursive(int index){
        if(index>size)return null;
        if(index<0)return null;
        return getrecursive( index,sentinel.next);
    }
    public sometims getrecursive(int i,IntNode node){
        if(i==0)return  node.item;
        return getrecursive(i-1,node.next);
    }
}