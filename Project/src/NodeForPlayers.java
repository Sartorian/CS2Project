
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
 