public interface Deque<Item>{
	public void addFirst(Item it);
	public void addLast(Item it);
	public boolean isEmpty();
	public int size();
	public void printDeque();
	public Item removeFirst();
	public Item removeLast();
	public Item get(int index);
}