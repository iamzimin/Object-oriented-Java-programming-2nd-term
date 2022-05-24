package lab11_new;

import java.util.Iterator;

import lab11_new.Node;

public class LinkList {
	public Node head;
	
	  public void createLinkList (String x) {// ������� ��������� ������
		Node pnew; // ���������� ����� ����
		Node ptail = new Node();
		head = ptail;
		String[] str = x.split(" ");
		for (int i = 0; i < str.length; i ++) {
			pnew = new Node();
			pnew.setData(str[i]);
			ptail.setNext(pnew);
			ptail = pnew;
		}		
	}
	
	 
	 
	 public String displayLinkList () {// ��� ���������� ��������� ���������� ������ ������ ������������������
		Node node =  head.getNext();
		String output = "";
		while (node != null) {
			output += node.getData() + " ";
			node = node.getNext();
		}
		output += "null";
		return output;
	}
	
	 public void reverseLinkList () {// ������� ��� ���������� ���������� ������ � �������� �������
		 if (head == null || head.getNext () == null) {// ���� ��������� ������ ����� ������ ���� �������� ���� ��� ������ ���� ����, �������� ������� �������� �������� ��������� �������, ������� ����������� ��������
			return;
		} else {
			Node p = head.getNext();
			Node q = head.getNext().getNext();
			 p.setNext (null); // ��������� ���� ������� ���� ����� ������, ����� ����� ������
			Node temp = null;
			while (q != null) {
				temp = q.getNext();
				q.setNext(p);
				p = q;
				q = temp;
			}
			if (q == null) {
				head.setNext(p);
				q = null;			
			}
		}		
	}
	 
	 public void deleteElementLinkList () {
		 //Iterator iterator = linkList.iterator();
		 //while (iterator.hasNext()) {
		 //    if (iterator.next().equals("Boxing")) {
		 //        iterator.remove();
		 //    }
		 //}
	 }
	 
	 
}