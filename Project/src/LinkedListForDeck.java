import java.util.Random;

public class LinkedListForDeck
{
	private NodeForDeck front;
	private int count;
	
	//constructor	
	public LinkedListForDeck()
	{
		front = null;
		count = 0;
	}
	
	//add a node to the front of the linked list
	public void addToFront(Card d)
	{
		NodeForDeck n;
		n = new NodeForDeck(d, front);
		front = n;
		count++;
	}
	
	//get the current size of the list
	public int size()
	{
		return count;
	}
	
	
	//clear the list
	public void clear()
	{
		front = null;
		count=0;
	}
	
	//get the content of the first node
	public Card getFrontData()
	{
		if (front==null){
         System.out.println("Deck is Empty");
			return null;
         }
		else
			return front.getData();
	}
	
	//new method added - get the first node
	public NodeForDeck getFront()
	{
		return front;
	}
	
	
	
	//remove front node
	public void removeFront()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else
		{
			front = front.getNext();
			count--;
		}
	}
	
	

	
	//add a node to the end
	public void addToEnd(Card c)
	{
		NodeForDeck n = new NodeForDeck(c, null);
		NodeForDeck curr = front;
		if (front==null)
			front = n;
		else
		{
			while (curr.getNext()!=null)
				curr = curr.getNext();
			curr.setNext(n);
		}
		count++;		
	}
	
	//remove last node
	public void removeLast()
	{
		if (front==null)
		{
			System.out.println("Empty list");
		}
		else if (front.getNext()==null)
		{
			front = null;
			count--;
		}
		else
		{
			NodeForDeck curr = front;
			while (curr.getNext().getNext()!=null)
				curr = curr.getNext();
			curr.setNext(null);
			count--;
		}
			
	}

	
	//add a node at a given index
	public void add(int index, Card d)
	{
		if (index<0 || index>size())
			System.out.println("Can't add. Index out of bounds");
		else
		{
	
			if (index==0)
				addToFront(d);
			else
			{
				NodeForDeck curr = front;
				for(int i=0; i<index-1; i++)
					curr = curr.getNext();
				NodeForDeck n = new NodeForDeck(d,curr.getNext());
				curr.setNext(n);
				count++;
			}
		}
		
	}
	
	//remove a node at a given index
	public void remove(int index)
	{
		if (index<0 || index>=size())
			System.out.println("Can't remove. Index out of bounds");
		else if (index==0)
			removeFront();
		else if (index==size()-1)
			removeLast();
		else{
			NodeForDeck curr = front;
			for(int i=0;i<index-1;i++)
				curr = curr.getNext();
			curr.setNext(curr.getNext().getNext());
			count--;
		}
	}
	public void shuffleDeck()
	{
		LinkedListForDeck d = new LinkedListForDeck();
		Random r = new Random();
		
		NodeForDeck curr = front;
		
		d.addToFront(curr.getData());
		curr = curr.getNext();
		
		while(curr != null)
		{
			d.add(r.nextInt(d.size()), curr.getData());
			curr = curr.getNext();
		}
		clear();
		curr = d.getNode(r.nextInt(d.size()));
		addToFront(curr.getData());
		d.remove(curr);
		curr = null;
		while(d.size() > 0)
		{
			while(curr == null)
			{
				curr = d.getNode(r.nextInt(d.size()));
			}
			this.add(r.nextInt(size()), curr.getData());
			d.remove(curr);
			curr = null;
		}
	}
	//get a node data given an index
	public Card get(int index)
	{
		NodeForDeck curr = front;
		int i=0;
		while (curr!=null && i!=index)
		{
			curr=curr.getNext();
			i++;
		}
		if (curr==null){
         System.out.println("Index out of Bounds");         
			return null;
         }
		else
			return(curr.getData());
	}
	public NodeForDeck getNode(int index)
	{
		NodeForDeck curr = front;
		int i = 0;
		while(curr != null && i != index)
		{
			curr = curr.getNext();
			i++;
		}
		if(curr == null)
		{
			System.out.println("ERROR CODE 2");
			return null;
		}
		else
			return curr;
	}
	public void remove(NodeForDeck n)
	{
		NodeForDeck curr = front;
		int i = 0;
		
		while(curr != n && curr != null)
		{
			curr = curr.getNext();
			i++;
		}
		if(curr != n)
		{
			System.out.println("Node not in list");
			return;
		}
		remove(i);
	}
}