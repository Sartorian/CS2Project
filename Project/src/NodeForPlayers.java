class NodeForPlayers
{
    protected Player playerData;
    protected NodeForPlayers next;
 
    public NodeForPlayers()
    {
        next = null;
        playerData = null;
    }    
    //2 constructors
    public NodeForPlayers(Player p, NodeForPlayers n)
    {
        playerData = p;
        next = n;
    }    

    public void setNext(NodeForPlayers n)
    {
        next = n;
    }    
    
    public void setPlayerData(Player p)
    {
        playerData = p;
    }    
    
    public NodeForPlayers getNext()
    {
        return next;
    }    
   
    public Player getPlayerData()
    {
        return playerData;
    }
}
 

/* public class NodeForPlayers 
{
	private Player data;
	private NodeForPlayers next;
	
	public NodeForPlayers(Player data, NodeForPlayers next)
	{
		this.data = data;
		this.next = next;
	}
	
	public void setData(Player data2)
	{
		this.data = data2;
	}
	
	public void setNext(NodeForPlayers next2)
	{
		this.next = next2;
	}
	
	public Player getData()
	{
		return this.data;
	}
	
	public NodeForPlayers getNext()
	{
		return this.next;
	}
} */
