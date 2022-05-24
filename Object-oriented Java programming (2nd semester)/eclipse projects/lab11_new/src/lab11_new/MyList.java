package lab11_new;

public class MyList {
	
	private ListElem head = null;
	private ListElem tail = null;
	
	public void AddToHead(String newValue) {
		ListElem elem = new ListElem();
		elem.value = newValue;
		elem.next = head;
		elem.prev = head;
		head = elem;
		
	}
	
	public void AddToTail(String newValue) { 
		ListElem elem = new ListElem();
		elem.value = newValue;
		elem.prev = tail;
		tail.next = elem;                   //////�������� ������
		tail = elem;
	}
	
	public void deleteElement(String newValue) {
		
		ListElem listElem = head;
		ListElem oldElem = null;
		while (listElem != null) {

			
			if (listElem.value.compareTo(newValue) == 0) {
				
				ListElem nextElem = listElem.next;
				if (oldElem != null) {
					oldElem.next = nextElem;
				}
				else {
					head = nextElem;
				}
				
				
			}
			oldElem = listElem;
			
			listElem = listElem.getNext();
		}
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
	
	public String displayList() {
		ListElem ListElem = head;
		String output = "";
		
		while (ListElem != null) {
			output += ListElem.getData() + " ";
			ListElem = ListElem.getNext();
		}
		
		return output;
	}
	// 3 2 1
	public void reverseList () {
		
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
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void clear() {
		head = null;
	}
	
}
