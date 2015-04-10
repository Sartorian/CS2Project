
class circleLinkedList
{
    protected NodeForPlayers front ;
    protected NodeForPlayers end ;
    public int size ;
 
    public circleLinkedList()
    {
        front = null;
        end = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return front == null;
    }

    public int getSize()
    {
        return size;
    }
    
    public void addToFront(Player addMe)
    {
        NodeForPlayers something = new NodeForPlayers(addMe, null);    
        something.setNext(front);
        if(front == null)
        {            
            front = something;
            something.setNext(front);
            end = front;            
        }
        else
        {
            end.setNext(something);
            front = something;        
        }
        size++ ;
    }
    
    public void addToEnd(Player addMe)
    {
        NodeForPlayers something = new NodeForPlayers(addMe, null);    
        something.setNext(front);
        if(front == null)
        {            
            front = something;
            something.setNext(front);
            end = front;            
        }
        else
        {
            end.setNext(something);
            end = something;            
        }
        size++ ;
    }

    public void displayPlayers()
    {
        System.out.print("\nPlayers include ");
        NodeForPlayers curr = front;
        if (size == 0) 
        {
            System.out.print("No Players\n");
            return;
        }
        if (front.getNext() == front) 
        {
            System.out.print(front.getPlayerData()+ " and "+curr.getPlayerData()+ "\n");
            return;
        }
        System.out.print(front.getPlayerData()+ " and ");
        curr = front.getNext();
        while (curr.getNext() != front) 
        {
            System.out.print(curr.getPlayerData()+ " and ");
            curr = curr.getNext();
        }
        System.out.print(curr.getPlayerData()+ " and ");
        curr = curr.getNext();
        System.out.print(curr.getPlayerData()+ "\n");
    }
}


