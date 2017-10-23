public class ArrayDeque <Blorp>{
	
	public Blorp[] items;
	public int size;
	public int front;
	public int rear;    
	private static int RFACTOR = 2;

    public void resize(int cap){
        Blorp[] a = (Blorp[])new Object[cap];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

	public ArrayDeque(){
		size = 0;
		items = (Blorp[])new Object[8];
		front = items.length - 2;
		rear = items.length - 1;
	}

	public boolean isEmpty(){
		boolean res = true;
		if(size > 0){
			res = false;
		}
		return res;
	}

	public void addFirst(Blorp item){
		if (size == items.length) {
            resize(size * RFACTOR);
        }
		size = size + 1;
		items[front] = item;
		front = (front-1) % items.length;
	}

	public void addLast(Blorp item){
		if (size == items.length) {
            resize(size * RFACTOR);
        }
        size = size + 1;
		items[rear] = item;
		rear = (rear+1) % items.length;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		int pt = front+1;
		while(pt != rear%items.length){
			
			System.out.print(items[pt] +" ");
			pt = (pt + 1)%items.length;
			
		}
	}

	public Blorp removeFirst(){
		size = size - 1;
		Blorp todel = items[front + 1];
		front = (front + 1) % items.length;
		return todel;
	}

	public Blorp removeLast(){
		size = size - 1;
		Blorp todel = items[rear - 1];
		rear = (rear - 1) % items.length;
		return todel;
	}
	public Blorp get(int index){
		return (Blorp)String.valueOf(items[index]);
	}






}