public interface SetInterface<T> {

    int getCurrentSize();
    boolean isEmpty();

    /** Adds a new entry to this set, avoiding duplicates.
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if the item already is in the set. */
    boolean add(T newEntry);

    /** Removes a specific entry from this set, if possible.
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not */
    boolean remove(T anEntry);
    
    T remove();

    void clear();

    boolean contains(T anEntry);
    
    /** Counts the number of times a given entry appears in this bag.
     * @paramanEntry  The entry to be counted.
     * @return The number of times anEntry appears in the bag.*/
    int getFrequencyOf(T anEntry);

    T[] toArray();

    boolean subset(SetInterface<T> rhs);

    boolean equals(SetInterface<T> rhs);

    LinkedSet<T> union(SetInterface<T> rhs);

    String toString();
}