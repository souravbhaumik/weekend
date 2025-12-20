What is collections?

    A collection is simply an object that represents a group of objects, known as it's elements.

```
Iterable
|
Collection
|
|----List ( Ordered Collection, allow duplicates, index based access )
        |
        |----ArrayList
        |----LinkedList
        |----Vector
        |----Stack
        |----CopyOnWriteArrayList
|
|----Set ( Unordered, does not allow duplicates )
        |
        |----HashSet
        |----LinkedHashSet
        |----TreeSet
        |----EnumSet
        |----ConcurrentSkipListSet
        |----SortedSet
        |----CopyOnWriteArraySet
|
|----Queue ( FIFO )
        |----
|
|----Deque
|
|----Map ( Key-Value pair )
```

* Collection interface methods
```
1. int size();
2. boolean isEmpty();
3. boolean contains(Object o);
4. Iterator<E> iterator();
5. Object[] toArray();
6. <T> T[] toArray(T[] a);
7. default <T> T[] toArray(IntFunction<T[]> generator) {
       return toArray(generator.apply(0));
   }
8. boolean add(E e);
9. boolean remove(Object o);
10. boolean containsAll(Collection<?> c);
11. boolean addAll(Collection<? extends E> c);
12. boolean removeAll(Collection<?> c);
13. default boolean removeIf(Predicate<? super E> filter);
14. boolean retainAll(Collection<?> c);
15. void clear();
16. boolean equals(Object o);
17. int hashCode();
18. default Spliterator<E> spliterator();
19. default Stream<E> stream();
20. default Stream<E> parallelStream();
```

* List
```
Ordered Collection
Signature - public interface List<E> extends Collection<E>

```

* <h3 id="arraylist">ArrayList</h3>
```
An ArrayList is a resizable array implementation of List interface. Unlike arrays in Java, which have a fixed size, an ArrayList can change it's size dynamically as elements are added or removed. This flexibility makes it a popular choice when the number of elements in a list isn't known in advance.
```
```
Special methods -
    list.add(2, 50);    // Add 50 at index 2, and shift rest of the items to right by i index.
    list.set(2, 50);    // removes the existing value from index 2, and set 50 at index 2.
    list.trimToSize();  // Shrinks the capacity of an ArrayList
```

Internal working of ArrayList
```
Unlike a regular array, which has a fixed size, an ArrayList can grow and shrink as elements are added or removed. This dynamic resizing is achieved by creating a new array when the current array is full and copying the elements to the new array.
Internally, the ArrayList is implemented as an array of object references, when you add elements to an ArrayList, you essentially storing these elements in this internal array.
When you create an ArrayList, it has an initial capacity (default is 10). The capacity refers to the size of the internal array that can hold elements before needing to resize.
```

When an element being added to the ArrayList, the following steps occur:
```
• Check Capacity - Before adding a new element, ArrayList checks if there is enough space in the internal array(elementData). If the array is full, then it needs to be resized.
• Resize if Necessary - If the internal array size is full, then ArrayList will create a new Array with larger capacity(1.5 times of current capacity), and copy elements from old array to new array.
• Add the element - The new element is then added to the new internal array at the appropriate index and the size is incremented.
```

Following steps occurs when an element is being removed from an ArrayList:
```
• Check Bound - The ArrayList first checks if the index is within the valid range.
• Remove the element - The element is removed and all the elements of the right of the removed element are shifted one position to fill the gap.
• Reduce size - The size is decremented by 1.
```

Following steps occurs during resizing the Array:
```
• Initial Capacity - By default, the initial capacity is 10. This means the internal array can hold 10 elements before it needs to grow.
• Growth Factor - When the internal array is full, a new array is created with with a size of 1.5 times the old array. This growth factor balances memory efficiency and resizing cost.
• Copying elements - When resizing occurs, all elements from the old array are copied to a new array, which is an O(n) operation, where n is the number of elements in the ArrayList.
```

Check the capacity of an ArrayList
```
Field field = ArrayList.class.getDeclaredField("elementData");
field.setAccessible(true);
Object[] elementData = (Object[]) field.get(shoppingList);
System.out.println("ArrayList capacity: " + elementData.length);
```

Various ways to create ArrayList <br>
1.

    // Add is not supported but replace is supported in `Arrays.asList` method
    List<String> shoppingList = Arrays.asList("Apple", "Banana", "Orange");
    System.out.println(shoppingList.getClass()); // class java.util.Arrays$ArrayList
    shoppingList.add("Ginger"); // throws java.lang.UnsupportedOperationException
    shoppingList.set(1, "Ginger"); // Replaces the value at index 1 with Ginger
<br>
2. 

    String[] myArr = {"Apple", "Banana", "Orange"};
    List<String> shoppingList = Arrays.asList(myArr);
<br>
3. 

    List shoppingList = List.of("Apple", "Banana", "Orange");
    shoppingList.add("Ginger"); // throws java.lang.UnsupportedOperationException

    With Arrays.asList(), new values can not be added, but values can be replaced in the existing index.
    With List.of(), neither values can be added, nor values can be replaced in the existing index.
<br>
4. 

    List<String> shoppingList = List.of("Apple", "Banana", "Orange");
    List<String> newArrList = new ArrayList<>(shoppingList); // Create a new ArrayList from an existing List
    newArrList.add("Mango"); // Adds Mango into existing ArrayList
    newArrList.addAll(shoppingList); // Adds all element of shoppingList into existing ArrayList
    
    If there are duplicates in a list and newArrList.remove("duplicate_item"); has been written, then first duplicate item will be removed from the list.

* <h3 id="arraylist">Comparator</h3>

    It compares two object of same type and determine their order.