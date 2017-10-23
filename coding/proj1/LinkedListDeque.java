public class LinkedListDeque <Blorp>{
	public class Node {
		public Blorp item;     /* Equivalent of first */
		public Node next; /* Equivalent of rest */
		public Node prior;

		public Node( Node p, Blorp i, Node n) {
			item = i;
			next = n;
			prior = p;		
		}
	} 

	private Node sentinel;
	public int size;

	public LinkedListDeque(){
		size = 0;
		sentinel = new Node(null,null,null);
		sentinel.next = sentinel;
		sentinel.prior = sentinel;
	}

	public boolean isEmpty(){
		boolean res = false;
		Node pt = this.sentinel.next;
		if(pt == sentinel){
			res = true;
		}
		return res;
	}

	public void addFirst(Blorp item){
		size = size + 1;
		Node insertnode = new Node(null, item, null);
		insertnode.next = sentinel;
		sentinel.next = insertnode;
		insertnode.prior = sentinel;
		sentinel.prior = insertnode;
	}

	public void addLast(Blorp item){
		size = size + 1;
		Node oldlastnode = sentinel.prior;
		Node insertnode = new Node(null, item, null);	
		oldlastnode.next = insertnode;
		insertnode.prior = oldlastnode;
		insertnode.next = sentinel; 
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		Node pt = sentinel.next;
		while(pt != sentinel){
			System.out.print(pt.item+" ");
			pt = pt.next;
		}
	}

	public Blorp removeFirst(){
		size = size - 1;
		Node nodetodel = sentinel.next;
		sentinel.next = sentinel.next.next;
		sentinel.next.next.prior = sentinel;
		return nodetodel.item;
	}

	public Blorp removeLast(){
		size = size - 1;
		Node nodetodel = sentinel.prior;
		sentinel.prior = sentinel.prior.prior;
		sentinel.prior.prior.next = sentinel;		
		return nodetodel.item;
	}

	public Blorp get(int index){
		int counter = 0;
		Node pt = sentinel.next;
		while(counter < index){
			counter = counter + 1;
			pt =pt.next;
		}
		return pt.item;
	}

	public Blorp getRecursive(int index){
		LinkedListDeque tail = this;
		if(index == 0){
			return sentinel.next.item;
		}
		else{
			Blorp cache = (Blorp)String.valueOf(tail.removeFirst());
			return (Blorp)String.valueOf(tail.getRecursive(index-1));
		}

	}



}