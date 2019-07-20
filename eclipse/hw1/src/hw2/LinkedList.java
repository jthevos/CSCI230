import java.lang.Math;

/**
 * Doubly Linked List Data Structure
 * 
 * CSCI 230: Data Structures and Algorithms Summer 2019
 * 
 * Completed by: <Add your name here>
 *
 * @param <AnyType>
 */
public class LinkedList<AnyType extends Comparable<? super AnyType>> implements List<AnyType> {
    
    // instance variables
    private Node<AnyType> headNode = null;
    private Node<AnyType> tailNode = null;
    
    private int size = 0;
    
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t
     */
    public void add( AnyType t) throws NullPointerException {

    	if ( t == null ) throw new NullPointerException();
        
    	// Node created in call
        addNode( new Node<AnyType>(t) ); 
        
    } // end add() method
    
    /**
     * 
     * Does work for public add(AnyType t) method which appends
     * @param t
     */
    private void addNode(Node<AnyType> t) {
     
    	// special case when list is empty - head and tail updated
        if ( isEmpty() ) { 	
        	headNode = t;
        	tailNode = headNode;
        // all other cases only tail is updated	
        } else { // append
        	
        	Node<AnyType> node = getNode( size-1 );
        	node.setNextNode( t );
        	t.setPreviousNode( node );
        	
        	tailNode = t;
        	
        }
        
        size++;
        
    } // end addNode() method
    
    
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index
     * @param t
     * @throws @throws IndexOutOfBoundsException if index is out of range where values can be stored; 
     *          valid index must be between 0 and size(), inclusive
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {
    	
    	if ( t == null ) throw new NullPointerException();
    	if (index > size) throw new IndexOutOfBoundsException();
        
    	// Create node and send it to helper method
        addNode( index, new Node<AnyType>(t) );
        
    } // end add() method
    
    /*
     * 
     * Helper method for public add(int index, AnyType t) method
     * Precondition: index in range 0 to size()
     * 
     */
    private void addNode(int index, Node<AnyType> t) throws IndexOutOfBoundsException {      
    	// case when list is empty and insert at index 0 - head and tail updated
        if ( index == 0 && isEmpty() ) { 	
        	headNode = t;
        	tailNode = headNode;
            size++;
        } 
        // case when list not empty and insert at 0 - new node goes first
        else if (index == 0) { // & not !isEmpty()
        	// make t point to what headNode currently points to
        	t.setNextNode(headNode);
        	// make node headNode currently points to, point to t
        	headNode.setPreviousNode(t);
        	// make headNode point to t
        	headNode = t;
            size++;
        }       	
        else if (index == size){ // append
        	addNode(t);      	// adds and increments size
        }
        // case where node goes in middle of list somewhere
        else { 
        	// find the node at index (could use getNode, when written)
        	Node<AnyType> walker = getNode(index);
        	// walker points to node that t belongs immediately before
        	// make node before index point to t
            walker.getPreviousNode().setNextNode( t );
            // make t's previous link point to node before index
            t.setPreviousNode( walker.getPreviousNode() );
            // make previous link of node at index point to t
            walker.setPreviousNode( t );
            // make t's next link point to node at index
            t.setNextNode( walker ); 
            size++;
        }
        
        
    } // end addNode() method
    
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException, NullPointerException
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {

    	if ( t == null ) throw new NullPointerException();
    	
        setNode( index, new Node<AnyType>(t) );
        
    } // end set() method
    
    /**
     * 
     * @param index
     * @param t
     * @throws IndexOutOfBoundsException
     */
    private void setNode( int index, Node<AnyType> t )  throws IndexOutOfBoundsException, NullPointerException {
        
    	if (t == null) throw new NullPointerException("Node does not exist.");
    	if (index >= size) throw new IndexOutOfBoundsException("Specified index is out of bounds.");
    	
    	Node<AnyType> targetNode = getNode(index);

    	System.out.println("targetNode pre set: " + targetNode.toString());
    	targetNode.setData(t.getData());
    	System.out.println("targetNode post set: " + targetNode.toString());
    	    
    } // end setNode() method
    
    
    /**
     * Removes the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
        
        return removeNode( index ).getData();
        
    } // end remove() method
    
    /**
     * Internal/private method that removes node at specific index from this list
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    private Node<AnyType> removeNode( int index ) throws IndexOutOfBoundsException {

    	// Note there are at least 3 cases: 
    	//      remove first node, remove from middle, remove last node
    	
    	// How to null coalesce: int y = (x != null) ? x : -1;
    	// something happens when there is only one item in the list forcing me to call clear?
    	Node<AnyType> targetNode = getNode(index);
    	
    	if (index == 0) {
    		Node<AnyType> newHead = targetNode.getNextNode();
    		if (newHead == null) {
    			headNode = targetNode;
    		} else {
        		newHead.setPreviousNode(null);
        		headNode = newHead;
    		}
    	} else if (size == 1) {
    		clear();
    	} else if (index == size -1 ) {
    		Node<AnyType> newTail = targetNode.getPreviousNode();
    		newTail.setNextNode(null);
    		tailNode = newTail;
    	} else {
    		targetNode.getNextNode().setPreviousNode(targetNode.getPreviousNode());
    		targetNode.getPreviousNode().setNextNode(targetNode.getNextNode());
    	}
    	size--;
    	System.out.println("Removed Node: " + targetNode);
    	return targetNode; // this will change, included only so code compiles
        
    } // end removeNode() method
    
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    public AnyType get( int index ) throws IndexOutOfBoundsException {      
        return getNode( index ).getData();
        
    } // end get() method
    
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {

    	if (index >= size || index < 0) {
    		throw new IndexOutOfBoundsException("Index out of bounds.");
    	} else {
    		return index <= Math.floor(size/2) ? traverseFromHead(index) : traverseFromTail(index);
    	}

    } // end get() method
    
    public Node<AnyType> traverseFromHead(int index) {
    	System.out.println("traversing from head");
    	Node<AnyType> walker = headNode;
    	int where = 0;
    	while (where < index) {
    		walker = walker.getNextNode();
    		where++;
    	} 
    	return walker;
    }
    
    public Node<AnyType> traverseFromTail(int index) {
    	System.out.println("traversing from tail");
    	Node<AnyType> walker = tailNode;
    	int where = size-1;
    	while (where > index) {
    		walker = walker.getPreviousNode();
    		where--;
    	} 
    	return walker;
    }
    
    /**
     * Returns the number of elements in this list. 
     * 
     * @return
     */
    public int size() {
        
        return size;
        
    } // end size() method
    
    /**
     * Returns true if this list contains no elements.
     * 
     * @return
     */
    public boolean isEmpty() {
        
        return ( size == 0 ) ? true : false;
        
    } // end isEmpty() method
    
    
    /**
     * Removes all of the elements from this list. 
     * 
     */
    public void clear() {

    	headNode = null;
        tailNode = null;
        size = 0;
        
    } // end clear method
    
    
    /**
     * 
     * For debugging and testing purpose
     * 
     * !!! Do not remove or modify !!!
     * 
     */
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append( String.format( "Size=%d, A = [ ", size ) );
        
        if ( !isEmpty() ) {
            
            for ( int i=0; i<size-1; i++ ) {
                buffer.append( String.format( "%d, ", get(i) ) );    
            }
            
            buffer.append( String.format( "%d ]", get(size-1 ) ) );
            
        } else {
            
            buffer.append( "] " );
        }
        
        return buffer.toString();
        
    } // end toString()
    
    public static void testGetNode(LinkedList<Integer> list) {
    	System.out.println("\n######## TESTING GET NODE ########");
    	for (int i = -1; i < list.size() + 1; i++) {
        	try {
        		System.out.println("\n");
        		System.out.println("Test Value: " + Integer.toString(i));
                System.out.println(list.getNode(i));
        	} catch (Exception e) {
        		System.out.println(e.getMessage());
        	}
    	}
    	System.out.println("\n######## DONE TESTING GET NODE ######## \n");
    }
    
    public static void testSetNode(LinkedList<Integer> list) {
    	System.out.println("\n######## TESTING SET NODE ########");
    	for (int i = -1; i < list.size() + 1; i++) {
        	try {
        		int x = (int)(100.0 * Math.random());
        		System.out.println("\n");
        		System.out.println("Test Index: " + Integer.toString(i));
        		System.out.println("Test Value: " + Integer.toString(x));
                list.setNode(i, new Node(x));
        	} catch (Exception e) {
        		System.out.println(e.getMessage());
        	}
    	}
    	System.out.println("New List = " + list);
    	System.out.println("\n######## DONE TESTING SET NODE ######## \n");
    }
    
    public static void testClear(LinkedList<Integer> list) {
    	System.out.println("\n######## TESTING CLEAR ######## \n");
    	System.out.println("\nList Pre Clear: " + list);
    	list.clear();
    	System.out.println("New List Post Clear: " + list);
    	System.out.println("\n######## DONE TESTING CLEAR ######## \n");
    }
    
    public static void testRemoveNode(LinkedList<Integer> list) {
    	System.out.println("\n######## TESTING REMOVE NODE ########");
    	for (int i = list.size() ; i >= -1; i--) {
        	try {
        		System.out.println("\n");
        		System.out.println("Test Index: " + Integer.toString(i));
                list.removeNode(i);
        	} catch (Exception e) {
        		System.out.println(e.getMessage());
        	}
    	}
    	System.out.println("New List = " + list);
    	System.out.println("\n######## DONE TESTING REMOVE NODE ######## \n");
    }
    
    public static void populateList(LinkedList<Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);     
        list.add( 0, 4 );
        list.add( 1, 10 ); 
        list.add( 4, 14 );
        list.add( list.size(), 44 );
    }
    
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
    	
        LinkedList<Integer> list = new LinkedList<>();
        populateList(list);
        
        System.out.println( list );
        
        testGetNode(list);
        testSetNode(list);
        testRemoveNode(list);
        populateList(list);
        testClear(list);
        
    } // end main() method
    
} // end DoublyLinkedList class definition