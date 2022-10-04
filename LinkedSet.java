public class LinkedSet<T> implements SetInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedSet() {
        firstNode = null;
        numberOfEntries = 0;
    }

    /**
     * Tests if every entry in left hand side is a subset of right hand side
     * 
     * @param rhs set that is getting compared
     * @return True if every element in the lhs set is in rhs set, false otherwise
     */
    public boolean subset(SetInterface<T> rhs) {
        Node current = firstNode;
        int match = 0;

        // Base Case
        if (current == null)
            return true;

        for (T item : rhs.toArray())
            if (contains(item))
                match++;
        return match == rhs.getCurrentSize() ? true : false;
    }

    /**
     * Tests if every entry in left hand side is the same in right hand side
     * 
     * @param rhs set that is getting compared
     * @return True if both sets contain the same elements, false otherwise
     */
    public boolean equals(SetInterface<T> rhs) {
        Node current = firstNode;
        boolean result = false;
        int index = 0;

        if (getCurrentSize() == rhs.getCurrentSize()) {
            LinkedSet<T> temp1 = new LinkedSet<>();
            LinkedSet<T> temp2 = new LinkedSet<>();
            T[] bag = rhs.toArray();

            while ((current != null) && (index < numberOfEntries)) {
                temp1.add(current.data);
                temp2.add(bag[index]);
                index++;
                current = current.next;
            }

            Node currTemp2 = temp2.firstNode;
            while (!temp1.isEmpty() && !temp2.isEmpty()) {
                if (temp1.contains(currTemp2.data)) {
                    currTemp2 = currTemp2.next;
                    temp2.remove();
                }
            }
            result = temp2.isEmpty();
        }
        return result;
    }

    /**
     * Combines both sets into one while the original sets remain the same
     * 
     * @param rhs
     * @return a set that contains all elements in left hand side set and right hand
     *         side set,
     *         but only list duplicates once
     */
    public SetInterface<T> union(SetInterface<T> rhs) {
        SetInterface<T> cBag = new LinkedSet<>();

        for (T item : rhs.toArray())
            cBag.add(item);

        for (T item : toArray())
            if (!cBag.contains(item))
                cBag.add(item);
        return cBag;
    }

    /**
     * Converts the set into a formatted set.
     * 
     * @return a string of what is inside the set
     */
    public String toString() {
        Node current = firstNode;
        StringBuilder str = new StringBuilder();

        if (current == null)
            return str.append("{}").toString();
        else {
            str.append("{ ");
            while (current != null) {
                str.append(current.next != null ? current.data + "," : current.data);
                current = current.next;
            }
            str.append(" }");
            return str.toString();
        }
    }

    /**
     * Gets the current size of the set
     * 
     * @return the number of entries
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Checks if the set is empty or not
     * 
     * @return true if the set is empty, false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    /**
     * Adds a new entry to this set, avoiding duplicates.
     * 
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if the item already is
     *         in the set.
     */
    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (!contains(newEntry)) {
            newNode.next = firstNode;
            firstNode = newNode;
            numberOfEntries++;
            return true;
        }
        return false;
    }

    /**
     * Removes a specific entry from this set, if possible.
     * 
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not
     */
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);

        if (nodeN != null) {
            nodeN.data = firstNode.data;

            firstNode = firstNode.next;
            numberOfEntries--;
            result = true;
        }
        return result;
    }

    /**
     * Removes one unspecific entry from the set, if possible.
     * 
     * @return Either the removed entry, if the removal was successful, or null
     */
    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }

        return result;
    }

   /**
     * Removes all items within the set
     */
    public void clear() {
        while (!isEmpty())
            remove();
    }

    /**
     * Tests whether this bag contains a given entry.
     * 
     * @param anEntry the entry to locate
     * @return True if the bag contains anEntry, or false otherwise.
     */
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this bag.
     * 
     * @return A newly allocated array of all the entries in the bag.
     */
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;

        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        }

        return result;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }

        return currentNode;
    }
}
