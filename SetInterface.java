//  Name:   Pham, Vinh 
//  Project:  #2 
//  Due:        7 October 2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Implementation of Set ADT using LinkedList.
//    With union, equals, and subset methods introduced.

public interface SetInterface<T> {

    /**
     * Gets the current size of the set
     * 
     * @return the number of entries
     */
    int getCurrentSize();

    /**
     * Checks if the set is empty or not
     * 
     * @return true if the set is empty, false if not.
     */
    boolean isEmpty();

    /**
     * Adds a new entry to this set, avoiding duplicates.
     * 
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if the item already is
     *         in the set.
     */
    boolean add(T newEntry);

    /**
     * Removes a specific entry from this set, if possible.
     * 
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not
     */
    boolean remove(T anEntry);

    /**
     * Removes one unspecific entry from the set, if possible.
     * 
     * @return Either the removed entry, if the removal was successful, or null
     */
    T remove();

    /**
     * Removes all items within the set
     */
    void clear();

    /**
     * Tests whether this bag contains a given entry.
     * 
     * @param anEntry the entry to locate
     * @return True if the bag contains anEntry, or false otherwise.
     */
    boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     * 
     * @return A newly allocated array of all the entries in the bag.
     */
    T[] toArray();

    /**
     * Tests if every entry in left hand side is a subset of right hand side
     * 
     * @param rhs set that is getting compared
     * @return True if every element in the lhs set is in rhs set, false otherwise
     */
    boolean subset(SetInterface<T> rhs);

    /**
     * Tests if every entry in left hand side is the same in right hand side
     * 
     * @param rhs set that is getting compared
     * @return True if both sets contain the same elements, false otherwise
     */
    boolean equals(SetInterface<T> rhs);

    /**
     * Combines both sets into one while the original sets remain the same
     * 
     * @param rhs
     * @return a set that contains all elements in left hand side set and right hand
     *         side set,
     *         but only list duplicates once
     */
    SetInterface<T> union(SetInterface<T> rhs);

    /**
     * Converts the set into a formatted set.
     * 
     * @return a string of what is inside the set
     */
    String toString();
}