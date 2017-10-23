/* Represent a list of integers, where all the "list" work is delegated
 * to a naked IntList. */

public class SList<Blorp> implements List61B<Blorp>{
	public class Node {
		public Blorp item;     /* Equivalent of first */
		public Node next; /* Equivalent of rest */

		public Node(Blorp i, Node h) {
			item = i;
			next = h;		
		}
	} 

	private Node sentinel;
	public int size;

	/** Creates an empty list. */
	public SList() {
		size = 0;
		sentinel = new Node(null,null);
	}

	public SList(Blorp x) {
		size = 1;
		sentinel = new Node(null, null);
		sentinel.next = new Node(x, null);
	}

	/** Adds an item of the front. */
	@Override
	public void insertFront(Blorp x) {
		Node oldfront = sentinel.next;
		Node newnode = new Node(x, oldfront);
		sentinel.next = newnode;
		size += 1;
	}
	public void insertFront2(Blorp x) {
		Node oldFrontNode = sentinel.next;
		Node newNode = new Node(x, oldFrontNode);
		sentinel.next = newNode;
		size += 1;
	}


	/** Gets the front item of the list. */
	@Override
	public Blorp getFront() {
		return sentinel.next.item;
	}

	/** Puts an item at the back of the list. */
	@Override
	public void insertBack(Blorp x) {
		size = size + 1;
		Node p = sentinel;
		while(p.next != null){
			p = p.next;
		}
		p.next = new Node(x, null);
	}

	/** Returns the back node of our list. */
	private Node getBackNode() {
		Node p = sentinel;
		while(p.next != null){
			p = p.next;
		}
		return p;
	}

	/** Returns last item */
	@Override
	public Blorp getBack() {
		Node back = getBackNode();
		return back.item;
	}

	public int size() {
		return size;
	}

	public Blorp get(int position){
		if(position == 0 || sentinel.next == null){
			return getFront();
		}
		Node currentNode = sentinel.next.next;
		while(position > 1){
			currentNode = currentNode.next;
			position = position -1;
		}
		return currentNode.item;
	}
	@Override
	public void insert(Blorp item, int position){
		if(position == 0){
			insertFront(item);
			return;
		}
		Node currentNode = sentinel.next.next;
		while(position > 1){
			currentNode = currentNode.next;
			position = position -1;
		}
		Node newnode = new Node(item, currentNode.next);
		currentNode.next = newnode;
	}
	public void print() {
		for (Node p = sentinel.next; p != null; p = p.next) {
			System.out.print(p.item +  " ");
		}
		System.out.println();
	}

	public Blorp deleteBack(){
		Node back = getBackNode();
		if(back == sentinel){
			return null;
		}
		Node p = sentinel;
		while(p.next != back){
			p = p.next;
		}
		p.next = null;
		return back.item;
	}
	
} 