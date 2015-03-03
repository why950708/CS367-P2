import java.util.*;

public class DLinkedList<E> implements ListADT<E>{
	/**			variables			**/
	private Listnode<E> head;
	private Listnode<E> tail;
	private int numItems;
	
	/**		constructor		**/
	public DLinkedList(){
		numItems = 0;
		head = null;
		tail = null;
	}
	/**		methods		**/
	
	/**
	 * add the new item to the tail
	 * @param new item to be added
	 * @throws IllegalArgumentException if the new tiem is null
	 */
	public void add(E item) {
		// check whether the item is null
		if(item == null) throw new IllegalArgumentException();
		// set the head to the new item if the list is empty
		if(head == null) head = new Listnode<E>(item);
		// general case
		else {
			Listnode<E> curr = head;
			Listnode<E> newNode = new Listnode<E>(item);
			// traverse the list node to the last one
			for (int i = 0; i < numItems; i++)
				curr = curr.getNext();
			// add the new item at on the tail
			curr.setNext(newNode);
			tail = newNode;
			// update the next and prev
			tail.setNext(null);
			tail.setPrev(curr);
		}
		// increment the number of items in the list
		numItems++;
	}
	/** add the new item to the specified position
	 * @param position to be added in
	 * @param new item to be added
	 * @throws IndexOutOfBoundException if pos is less than 0 or bigger or equal to list node size
	 * @throws IllegalArgumentException if the new item is null
	 */
	public void add(int pos, E item) {
		if( pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
		if( item == null) throw new IllegalArgumentException();
		// if the item is added to the head
		if(pos == 0) 	head = new Listnode<E>(item);
		// if the item is added to the tail
		if(pos == numItems - 1) 	this.add(item);
		
		// general case
		else {
			Listnode<E> curr = head;
			Listnode<E> newItem = new Listnode<E>(item);
			// traverse to the item just before the position where the item is added at
			for(int i = 1; i < pos; i++)
				curr = curr.getNext();
			// update the next
			newItem.setNext(curr.getNext().getNext());
			curr.setNext(newItem);
			// update the prev 
			newItem.setPrev(curr);
			newItem.getNext().setPrev(newItem);
		}
		// increment the number of items 
		numItems++;
	}

	/**
	 * Returns true iff item is in the List (i.e., there is an item x in the List 
	 * such that x.equals(item))
	 * 
	 * @param item the item to check
	 * @return true if item is in the List, false otherwise
	 * @throws IllegalArguemntException if the item is null
	 */
	public boolean contains(E item) {
		// throw exception if the item is null
		if(item == null) throw new IllegalArgumentException();
		Listnode<E> checkedItem = new Listnode<E>(item);
		
		// traverse the whole list
		for(int i = 0; i < numItems; i++) 
			// return true if there is a match
			if(this.get(i).equals(checkedItem))		return true;
		
		return false;
	}
	/**
	 * Returns the item at position pos in the List.
	 * 
	 * @param pos the position of the item to return
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException if pos is less than 0 or greater than
	 * or equal to size()
	 */
	public E get(int pos) {
		if(pos < 0 || pos >= numItems) throw new IndexOutOfBoundsException();
		// return the head if the pos is 0
		if (pos == 0)  return head.getData();
		// general case
		else {
			Listnode<E> curr = head;
			// traverse the list
			for(int i = 0; i < pos; i++)
				curr = curr.getNext();
			return curr.getData();
		}
			
	}
	/**
	 * Returns true iff the List is empty.
	 * 
	 * @return true if the List is empty, false otherwise
	 */
	public boolean isEmpty(){
		if(numItems == 0) 	return true;
		else 	return false;
	}
	/**
	 * Removes and returns the item at position pos in the List, moving the items 
	 * originally in positions pos+1 through size() - 1 one place to the left to 
	 * fill in the gap.
	 * 
	 * @param pos the position at which to remove the item
	 * @return the item at position pos
	 * @throws IndexOutOfBoundsException if pos is less than 0 or greater than
	 * or equal to size()
	 */
	public E remove(int pos) {
		if(pos < 0 || pos >= numItems)	throw new IndexOutOfBoundsException();
		// remove the head
		if(pos == 0) {
			head = head.getNext();
			head.setPrev(null);
			numItems--;
			return head.getData();
			
		}
		// remove the tail
		if(pos == numItems - 1)
		
		// general case
		return null;
	}
	
	public int size(){
		
		return 0;
	}
}
