
/**
 * ArrayList - an array-based implementation of List interface 
 * CSCI 230: Data Structures and Algorithms Summer 2019
 * 
 * HW 1: < John-Anthony Thevos >
 *
 * @param <AnyType> Any Comparable type can be stored - all elements of the same type 
 */
public class ArrayList<AnyType extends  Comparable<? super AnyType>> implements List<AnyType> {
     
    // instance variables
    private AnyType[] array;
    private int size = 0;
    private final static int MINIMUM_CAPACITY = 10;
    private int capacity = MINIMUM_CAPACITY;
    
    /**
     * Constructs an empty list with an initial capacity
     * (for this assignment initial capacity is 10 - see 
     * constant instance variable)
     * 
     */
    
    @SuppressWarnings("unchecked")
	public ArrayList() {
        
        array = (AnyType[]) new Comparable[ capacity ];
        
    } // end constructor
    
    /**
     * Do not modify this method.
     * Only use for testing purposes.
     * 
     * @return
     */
    public int getCapacity() {
        
        return capacity;
        
    } // end getCapacity() method
 
    /**
     * Appends the specified element to the end of this list.
     * 
     * @param t - element to be inserted
     */
    public void add( AnyType t) throws NullPointerException {
         
        if (t == null) throw new NullPointerException();
        
        if ( size >= capacity )
            grow();
        
        array[size]=t;
        size++;
         
    } // end add() method
 
    /**
     * Inserts the specified element at the specified position in this list.
     * 
     * @param index  - index at which the specified element is to be inserted
     * @param t - element to be inserted
     * @throws IndexOutOfBoundsException if index is out of range where values can be stored; 
     *          valid index must be between 0 and size(), inclusive
     * @ throws NullPointerException if t is null
     */
    public void add(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
             
        
    } // end add() method
 
    /**
     * Replaces the element at the specified position in this list with the specified element.
     * 
     * @param index - index of the element to replace
     * @param t - element to be inserted
     * @throws IndexOutOfBoundsException if index is out of range where values can be stored; 
     *             valid index must be between 0 and size(), inclusive
     * @ throws NullPointerException if t is null
     */
    public void set(int index, AnyType t) throws IndexOutOfBoundsException, NullPointerException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
     
        
        
        
         
    } // end set() method
 
    /**
     * Removes the element at the specified position in this list. Elements,if any, that
     *   follow the one removed, "move up" one position
     * 
     * @param index - index of the element to be removed
     * @return
     * @throws IndexOutOfBoundsException if index is out of range where values can be stored
     */
    public AnyType remove( int index ) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API) to perform left or right
         * shift operations
         * 
         */
    	return null; // this will change - just here so file compiles
         
        
         
    } // end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index - index of the element to be returned
     * @return
     * @throws IndexOutOfBoundsException if index is out of range where values can be stored
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
         
    	return null; // this will change - just here so file compiles 
        
                
         
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
         
        return ( size == 0 );
         
    } // end isEmpty() method
     
     
    /**
     * Removes all of the elements from this list and 
     * the capacity is reset to the MINIMUM_CAPACITY
     * 
     */
    public void clear() {
         
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         */
        
        
            
         
    } // end clear method
        

    
    /**
     * The capacity of the array is resized using this function:
     * 
     * new capacity = old capacity * 2  
     * 
     * data in this, when grow called, must be copied over into this new larger array
     * 
     */
    
    private void grow() {
        
        /**
         * -------------------------------------------
         * TODO: You fully implement this method
         * 
         * Requirement - you must use loops (i.e. may not use
         * System.arraycopy, or any other array copy operation 
         * available in the Java API)
         * 
         */
    
    	// declare new array list of size++
    	// capture new value to be added
    	// loop through old array and copy all old items over + new item
        
        
        
    } // end grow() method
    
    
    /**
     * For debugging purposes :)
     * 
     * Note: this only works for integer values 
     * hence, the %d format specifier in the 
     * string format method. If you want a 
     * different specifier, like string %s, 
     * you can change.
     * 
     */
    public String toString() {
        
        StringBuffer buffer = new StringBuffer();
        
        buffer.append( String.format( "Size=%d, A = [ ", size ) );
        
        if ( !isEmpty() ) {
            
            for ( int i=0; i<size-1; i++ ) {
                buffer.append( String.format( "%d, ", array[i] ) );    
            }
            
            buffer.append( String.format( "%d ]", array[size-1] ) );
            
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
         
        /**
         * -------------------------------------------
         * TODO: Put your test cases here
         * 
         */   
         System.out.println("does this compile?");
    } // end main() method
  
} // end ArrayList class definition