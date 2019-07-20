package hw1;
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
             	
    	if (index > size) throw new IndexOutOfBoundsException("The specified index at which to add is larger than the array.");
    	if (index < 0) throw new IndexOutOfBoundsException("Index cannot be negative.");
    	if (t == null) throw new NullPointerException("Cannot add a null object");
    	
    	int newSize = size + 1;
    	AnyType[] newArray = (AnyType[]) new Comparable[newSize];
    	    	
    	if (newSize >= capacity) grow();
    	
    	for (int i = 0; i < index; i++) {
    		newArray[i] = array[i];
    	}
    	newArray[index] = t;
    	for (int i = index + 1; i < newArray.length; i++) {
    		if (i >= size) grow();
    		newArray[i] = array[i-1];
    	}
    	size++;
    	array = newArray;
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
         
    	if (index >= size || index < 0 ) {
    		throw new IndexOutOfBoundsException("Index is out of bounds.");
    	} else if (t == null) {
    		throw new NullPointerException("Cannot add a null object.");
    	} else {
    		array[index] = t;
    	}
    	        
         
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
    	
    	AnyType item;
    	if (index < size && index >= 0) {
    		item = array[index];
    	} else {
    		throw new IndexOutOfBoundsException("Invalid index.");
    	}
    	size--;
    	
    	for (int i = index; i < size; i++) {
    		array[i] = array[i+1];
    	}
    	// this should return a reference to what was removed
    	System.out.println("The item removed was: " + Integer.toString((Integer)(item)));
    	return item;     
    	
    } // end remove() method
 
    /**
     * Returns the element at the specified position in this list.
     * 
     * @param index - index of the element to be returned
     * @return
     * @throws IndexOutOfBoundsException if index is out of range where values can be stored
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {

    	AnyType item;
    	
    	if (index < size) {
    		item = array[index];
    	} else {
    		throw new IndexOutOfBoundsException("Index given is out of bounds.");
    	}
    	return item; // this will change - just here so file compiles 
        
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
    	array = (AnyType[]) new Comparable[MINIMUM_CAPACITY];
    	size = 0;
    } // end clear method
            
    private void grow() {
            	
    	capacity = capacity * 2;
    	AnyType[] newArray = (AnyType[]) new Comparable[capacity];
    	
    	// loop here
    	for (int i = 0; i < array.length; i++) {
    		newArray[i] = array[i];
    	}
    	
    	array = newArray;
        
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
    
    public static void testAddAtIndex(ArrayList<Integer> testArray) {
    	try {
        	testArray.add(1, 11);
        	System.out.println(testArray);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    		
    	try {
        	testArray.add(2, 22);
        	System.out.println(testArray);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    		
    	try {
        	testArray.add(3, 33);
        	System.out.println(testArray);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    		
    	try {
        	testArray.add(1, null);
        	System.out.println(testArray);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		testArray.add(-1, 12);
    		System.out.println(testArray);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
        	testArray.add(33,33);
        	System.out.println(testArray);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
       
    public static void testGet(ArrayList<Integer> testArray) {
    	try {
        	testArray.get(11);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		testArray.get(-22);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
        	testArray.get(5);
        	System.out.println("Value at given index is " + Integer.toString(testArray.get(5)));
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public static void testRemove(ArrayList<Integer> testArray) {
    	try {
        	testArray.remove(27);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		testArray.remove(-22);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
        	testArray.remove(5);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public static void testSet(ArrayList<Integer> testArray) {
    	try {
    		System.out.println("Current item at position 5 is: " + Integer.toString(testArray.get(5)));
    		testArray.set(5, 55);
    		System.out.println("New item at position 5 is: " + Integer.toString(testArray.get(5)));
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		testArray.set(30, 30);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		testArray.set(5, null);
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public static void testGrow(ArrayList<Integer> testArray) {
    	System.out.println("Current size is: " + testArray.size());
    	testArray.add(17);
    	System.out.println("New size after grow() is: " + testArray.size());
    }
    
    public static void testClear(ArrayList<Integer> testArray) {
    	System.out.println("Current size before clear() is: " + testArray.size());
    	testArray.clear();
    	System.out.println("New size after clear() is: " + testArray.size());
    }
    
    public static void main( String[] args ) {
         
        /**
         * -------------------------------------------
         * TODO: Put your test cases here
         * 
         */   
    	
    	// hard coded test cases - no command line input
    	
    	ArrayList<Integer> testArray = new ArrayList<>();
    	
    	// populate
    	for (int i = 0; i < 10; i++) {
    		testArray.add(i);
    	}
    	
    	// add
    	testAddAtIndex(testArray);
    	
    	// get
    	testGet(testArray);
    		
    	// remove
    	testRemove(testArray);
    	
    	// grow
    	testGrow(testArray);
    	
    	// set
    	testSet(testArray);
    	
    	// clear
    	testClear(testArray);
    	
    } // end main() method
  
} // end ArrayList class definition