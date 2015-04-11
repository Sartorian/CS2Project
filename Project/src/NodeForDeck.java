public class NodeForDeck
{
	private Card data;
	private NodeForDeck next;
   
	public NodeForDeck(Card d, NodeForDeck n)
	{
		data = d;
		next = n;
	}
	public Card getData()
	{
		return data;
	}
	public NodeForDeck getNext()
	{
		return next;
	}
	public void setData(Card d)
	{
		data = d;
	}
	public void setNext(NodeForDeck n)
	{
		next = n;
	}
}