package lab11;

public class MyList {
	
	public ListElem head = null;
	public ListElem tail = null;
	private int count = 0;
	//private int countNumberElem = 0;
	private boolean err = false;
	private boolean rightOrLeft = false;
	private ListElem activeElem = head;
	
	public void AddToHead(String newValue) {
		ListElem elem = new ListElem();
		elem.value = newValue;
		
		if (count == 0) {              //��������
			tail = elem;
		}
		else {
			head.prev = elem;
		}
		elem.next = head;
		head = elem;
		
        /*if(this.head == null){         //��������
            this.head = elem;
            this.tail = elem;
        }else {
            //node.next = this.head;
            elem.setNext(this.head);
            head.setPrev(elem);
            head = elem;
        }*/
		count++;
		activeElem = head;
	}
	
	public void AddToTail(String newValue) { 
		ListElem elem = new ListElem();
		elem.value = newValue;
		
		if (count == 0) {
			head = elem;
		}
		else {
			tail.next = elem;
		}
		elem.prev = tail;
		tail = elem;
		
		/*elem.next = null;
		elem.prev = tail;
		if (tail != null) {
			tail.next = elem;
		}
		else {
			tail = elem;
		}*/
		if (tail != null || head != null) {
			count++;
		}
		activeElem = head;
	}
	
	public void addByIndex(String newValue, int index) {
		
		err = false;
		if (index < 0 || index > count) {
			err = true;
			return;
		}
		else if (index == 0) {
			AddToHead(newValue);
			return;
		}
		else if (index == count) {
			AddToTail(newValue);
			return;
		}
		
		ListElem elem = new ListElem();
		ListElem listElem = head;
		int c = 0;
		
		while (listElem != null && c != index) {
			listElem = listElem.next;
			c++;
		}
		
		elem.value = newValue;
		listElem.prev.next = elem;
		elem.prev = listElem.prev;
		listElem.prev = elem;
		elem.next = listElem;
		
		count++;
		activeElem = head;
	}
	
	public boolean error() {
		if (err) {
			return true;
		}
		return false;
	}
	
	public void delFirst () {
		if (head == null) {
			return;
		}
		head = head.next;
		if (head != null) {
			head.prev = null;
		}
		else {
			tail = null;
		}
		
		count--;
		if (count == 0) {
			clear();
		}
	}
	
	public void delLast () {
		if (tail == null) {
			return;
		}
		tail = tail.prev;
		if (tail != null) {
			tail.next = null;
		}
		else {
			head = null;
		}
		
		count--;
		if (count == 0) {
			clear();
		}
	}
	
	public void deleteElement(String newValue) {
		ListElem listElem = head;
		//ListElem oldElem = null;
		boolean flag = false;
		

		if (head.value.compareTo(newValue) == 0) {
			delFirst();
			return;
		} 
		else if (tail.value.compareTo(newValue) == 0) {
			delLast();
			return;
		}
		
		while (listElem != null) {
			if (listElem.value.compareTo(newValue) == 0) {
				listElem.prev.next = listElem.next;
				listElem.next.prev = listElem.prev;
				count--;
			}
			listElem = listElem.next;
		}
		
		if (count == 0) {
			clear();
		}
		activeElem = head;
	}
	
	public String displayList() {
		ListElem ListElem = head;
		String output = "";
		
		while (ListElem != null) {
			output += ListElem.getData() + " ";
			ListElem = ListElem.getNext();
		}
		
		return output;
	}
	
	public String displayElemHead() {
		//ListElem activeElem = head;
		
		if (activeElem.next == null) {
			rightOrLeft = true;
			return "Tail";
		}
		else if (rightOrLeft) {
			activeElem = head;
			rightOrLeft = false;
		}
		else {
			activeElem = activeElem.next;
			//countNumberElem++;
		}
		
		return activeElem.value;
	}
	
	public String displayElemTail() {
		//ListElem activeElem = tail;

		if (activeElem.prev == null) {
			rightOrLeft = true;
			return "Head";
		}
		else if (rightOrLeft) {
			activeElem = tail;
			rightOrLeft = false;
		}
		else {
			activeElem = activeElem.prev;
			//countNumberElem--;
		}
		
		return activeElem.value;
	}
	
	/*public void reverseList () {
		
		 if (head == null || head.getNext() == null) {
			return;
		} else {
			ListElem p = head;
			ListElem q = head.getNext();
			p.setNext(null);
			ListElem temp = null;
			while (q != null) {
				temp = q.getNext();
				q.setNext(p);
				p = q;
				q = temp;
			}
			if (q == null) {
				head = p;
				q = null;			
			}
			
		}		
	}*/
	
	public int size(MyList list) {
		ListElem headElem = head;
		int count = 1;
		
		if (list.isEmpty()) {
			return 0;
		}
		
		while (headElem.next != null) {
			headElem = headElem.next;
			count++;
		}
		
		return count;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void clear() {
		head = null;
		count = 0;
	}
	
	public String toString() {
		String str = "";
		ListElem pos = head;
		while (pos !=  null) {
			str += pos.value + " ";
			pos = pos.next;
		}
		return str;
	}
	
	public String toStringReverse() {
		String str = "";
		ListElem pos = tail;
		while (pos !=  null) {
			str += pos.value + " ";
			pos = pos.prev;
		}
		return str;
	}
}