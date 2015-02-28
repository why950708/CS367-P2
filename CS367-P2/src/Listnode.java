/**
 * Generic doubly linked list node. It serves as the basic building block for 
 * storing data in doubly linked chains of nodes.
 * 
 * <b>Do not modify this file in any way!</b>
 */
class Listnode<E> {
	private E data;                // data to be stored 
	private Listnode<E> next;   // connection to next node
	private Listnode<E> prev;   // connection to previous node
	
	/**
	 * Constructs a new list node with no links to its next or previous node.
	 * @param data the data to be stored in this node
	 */
	Listnode(E data) {
		this(data, null, null);
	}
	
	/**
	 * Constructs a new list node with links to its next and previous.
	 * @param data the data to be stored in this node
	 * @param next the node after this one
	 * @param prev the node before this one
	 */
	Listnode(E data, Listnode<E> next, Listnode<E> prev) {
		this.data = data;
		this.next = next;
		this.prev=prev;
	}

	/**
	 * Returns the current data.
	 * @return the current data
	 */
	E getData() {
		return data;
	}

	/**
	 * Returns the current next node.
	 * @return the current next node
	 */
	Listnode<E> getNext() {
		return next;
	}
	
	/**
	 * Returns the current previous node.
	 * @return the current previous node
	 */
	Listnode<E> getPrev() {
		return prev;
	}

	/**
	 * Sets the data to the given new value.
	 * @param data the new data
	 */
	void setData(E data) {
		this.data = data;
	}

	/**
	 * Sets the next node to the given new value.
	 * @param next the new next node
	 */
	void setNext(Listnode<E> next) {
		this.next = next;
	}
	
	/**
	 * Sets the previous node to the given new value.
	 * @param prev the new previous node
	 */
	void setPrev(Listnode<E> prev) {
		this.prev = prev;
	}
	
}
