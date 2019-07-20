
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
    
    // instance variables - protected so subclass can access them directly
    private Node<AnyType> headNode = null;
    private Node<AnyType> tailNode = null;
    
    private int size = 0;
    
 
    /**
     * Adds the specified element to the list in ascending order.
     * 
     * @param t
     * Precondition:  list is ordered (Note: an empty list is ordered.)
     * Postcondition: new data items added, list is still ordered 
     */
    public void addInOrder(AnyType t) throws NullPointerException{
    	 /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
    	
    }

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
    private void setNode( int index, Node<AnyType> t )  throws IndexOutOfBoundsException {
        
        /**
         * -------------------------------------------
         * YOU CAN IGNORE THIS METHOD
         * 
         */
        
        
        
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
        
        /**
         * -------------------------------------------
         * YOU CAN IGNORE THIS METHOD
         * 
         */
    	
    	return null; // this will change, included only so code compiles
        
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
    
    /**
     * 
     * Implementation of get(int index) method
     * 
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     * 
     */
    private Node<AnyType> getNode(int index) throws IndexOutOfBoundsException {
   
        /**
         * -------------------------------------------
         * YOU CAN IGNORE THIS METHOD
         * 
         */
    	// The following code traverses from head until the appropriate
    	// node found. Currently it assumes that the index is valid
    	Node<AnyType> walker = headNode;
    	int where = 0;
    	while (where < index) {
    		walker = walker.getNextNode();
    		where++;
    	} 
    	return walker; // reference to node at index
        
    } // end get() method
    
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
        
        /**
         * -------------------------------------------
         * YOU CAN IGNORE THIS METHOD
         * 
         */
        
        
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
    
    
    /**
     * 
     * @param args
     */
    public static void main( String[] args ) {
                
        // -------------------------------------
        // Put your test cases here
        // -------------------------------------
        
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        System.out.println( list );
        list.add(2);
        System.out.println( list );
        list.add(30);
        System.out.println( list );
        list.add(20);              
        list.add( 0, 4 );       
        System.out.println( list );
 
                
    } // end main() method
    
} // end DoublyLinkedList class definition