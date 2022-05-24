package lab11_new;

import java.util.Iterator;

import lab11_new.Node;

public class LinkList {
	public Node head;
	
	  public void createLinkList (String x) {// —оздать св€занный список
		Node pnew; // ќпределить новый узел
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
	
	 
	 
	 public String displayLinkList () {// ¬се содержимое выходного св€занного списка пр€мой последовательности
		Node node =  head.getNext();
		String output = "";
		while (node != null) {
			output += node.getData() + " ";
			node = node.getNext();
		}
		output += "null";
		return output;
	}
	
	 public void reverseLinkList () {// ¬ывести все содержимое св€занного списка в обратном пор€дке
		 if (head == null || head.getNext () == null) {// ≈сли св€занный список имеет только один головной узел или только один узел, обратный пор€док €вл€етс€ исходным св€занным списком, поэтому возвращайте напр€мую
			return;
		} else {
			Node p = head.getNext();
			Node q = head.getNext().getNext();
			 p.setNext (null); // —ледующий узел первого узла будет пустым, иначе будет кольцо
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