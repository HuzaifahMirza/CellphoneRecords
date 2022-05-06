import java.util.NoSuchElementException;

//Huzaifah Mirza 40136913
//COMP249 
//Assignment #4 part #1
//April 15, 2022

/**
* @author Huzaifah Mirza
*
*/
public class CellList implements Cloneable {
	private CellNode head;
	private int size;

	/**default constructor
	 * 
	 */
	public CellList() {
		this.head = null;
		this.size = 0;
	}

	/**copy constructor, does not work for linked lists.
	 * @param list
	 */
	public CellList(CellList list) {
		this.head = list.head;
		this.size = list.size;
	}

	/**
	 *clone method
	 */
	public CellList clone() {
		CellList list = new CellList();
		CellNode pos = this.head;
		list.addToStart(pos.cell);

		while (pos != null) {

			list.insertAtIndex(pos.cell, list.size - 1);
			pos = pos.next;

		}
		list.deleteFromStart();
		return list;
	}

	/**adds a new node to beginning of List
	 * @param cell
	 */
	public void addToStart(Cellphone cell) {
		CellNode newNode = new CellNode(cell, null);
		newNode.next = this.head;
		this.head = newNode;
		this.size++;

	}

	/**inserts a new node at index in list
	 * @param x
	 * @param index
	 */
	public void insertAtIndex(Cellphone x, int index) {
		CellNode newNode = new CellNode(x, null);
		CellNode pos = this.head;
		int i = 0;
		try {
			if (index >= (this.size) || index < 0) {
				throw new NoSuchElementException("no such element found. index does not exist.");

			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return;
		}

		if (index == 0) {
			this.addToStart(x);
			System.out.println("new head inserted");

		} else {
			while (i != index) {
				pos = pos.next;
				i++;
			}
			if (index == this.size - 1) {

				pos.next = newNode;
				this.size++;
			} else {
				newNode.next = pos.next;
				pos.next = newNode;
				this.size++;
			}

			System.out.println("new link inserted");
		}
	}

	/**delets node at index
	 * @param index
	 */
	public void deleteFromIndex(int index) {
		CellNode pos = this.head;
		int i = 0;
		try {
			if (index > (this.size - 1) || index < 0) {
				throw new NoSuchElementException("no such element found. index does not exist.");

			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return;
		}

		if (index == 0) {
			this.head = this.head.next;
			this.size--;
			System.out.println("head deleted");

		} else {
			while (i != index - 1) {
				pos = pos.next;
				i++;
			}

			if (index == this.size - 1) {
				pos.next = null;
				this.size--;
				System.out.println("tail deleted");
			} else {
				pos.next = pos.next.next;
				this.size--;
				System.out.println("link deleted");
			}

		}
	}

	/**deletes head node
	 * 
	 */
	public void deleteFromStart() {

		if (this.head == null) {
			return;
		}
		CellNode pos = this.head;
		this.head = pos.next;

		this.size--;
	}

	/**replaces data in node at index
	 * @param cell
	 * @param index
	 */
	public void replaceAtIndex(Cellphone cell, int index) {
		if (this.head == null) {
			return;
		}
		CellNode pos = this.head;
		int i = 0;
		try {
			if (index >= (this.size) || index < 0) {
				throw new NoSuchElementException("no such element found. index does not exist.");

			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return;
		}
		while (i < index) {
			pos = pos.next;
			i++;
		}
		pos.setCell(cell);
	}

	/**find node that matches the serial number
	 * @param serial
	 * @return
	 */
	public CellNode find(long serial) {
		if (this.head == null) {
			return null;
		}
		CellNode pos = this.head;
		while (pos != null) {
			if (pos.cell.getSerialNum() == serial) {
				return pos;
			} else {
				pos = pos.next;
			}
		}

		return null;

	}

	/** checks list for prompted data
	 * @param serial
	 * @return
	 */
	public boolean contains(long serial) {
		if (find(serial) != null) {

			return true;
		}

		return false;
	}

	/**outputs the list into the console
	 * 
	 */
	public void showContents() {
		CellNode pos = this.head;
		System.out.println("\nThe current size of the list is " + this.size + ". Here are the contents of the list");
		System.out.println("====================================================================");
		while (pos != null) {

			System.out.print(pos.cell.toString());
			pos = pos.next;
		}

		System.out.println("X\n");
	}

	/**compares the data in the nodes of 2 lists without matching the serial numbers
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (this.getClass() != obj.getClass()) {
			return false;
		}
		CellList obj2 = (CellList) obj;

		CellNode pos = this.head;
		CellNode pos2 = obj2.head;
		if (!(this.size == obj2.size)) {
			return false;
		}
		while (pos != null && pos2 != null) {
			if (pos.getCell().equals(pos2.getCell())) {
				pos = pos.next;
				pos2 = pos2.next;
			} else {
				return false;
			}
		}

		return true;

	}

	// has privacy leak, could be fixed by making the method private
	/**get method for head parameter
	 * @return
	 */
	public CellNode getHead() {
		return head;
	}

	// has privacy leak, could be fixed by making the method private
	/**sets head parameter
	 * @param head
	 */
	public void setHead(CellNode head) {
		this.head = head;
	}

	// has privacy leak, could be fixed by making the method private
	/**get size parameter
	 * @return
	 */
	public int getSize() {
		return size;
	}

	// has privacy leak, could be fixed by making the method private
	/** set size parameter
	 * @param size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * CellNode class, used as node objects for CellList class
	 *
	 */
	class CellNode {
		private Cellphone cell;
		private CellNode next;

		/**default constructor
		 * 
		 */
		private CellNode() {
			this.cell = null;
			this.next = null;
		}

		/**parameterized constructor
		 * @param cell
		 * @param next
		 */
		private CellNode(Cellphone cell, CellNode next) {
			this.cell = cell;
			this.next = next;
		}

		/**copy constructor
		 * @param node
		 */
		private CellNode(CellNode node) {
			this.cell = node.cell;
			this.next = node.next;

		}

		/**clone method
		 *
		 */
		protected CellNode clone() {
			return new CellNode(this);
		}

		/**gets cell parameter
		 * @return
		 */
		private Cellphone getCell() {
			return cell;
		}

		/**sets cell parameter
		 * @param cell
		 */
		private void setCell(Cellphone cell) {
			this.cell = cell;
		}

		/**gets next parameter
		 * @return
		 */
		private CellNode getNext() {
			return next;
		}

		/**sets next parameter
		 * @param next
		 */
		private void setNext(CellNode next) {
			this.next = next;
		}

	}
}
