public class LinkedSet<T> implements SetInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedSet() {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    public boolean subset(SetInterface<T> rhs) {
        Node current = firstNode;
        int match = 0;
        
        // Base Case
        if (current == null) return true;
        
        for(T item : rhs.toArray())
            if (contains(item))
                match++;
        return match == getCurrentSize() ? true : false;
    }

    public boolean equals(SetInterface<T> rhs) {
        Node current = firstNode;
        boolean result = false;
        int index = 0;
        
        if (getCurrentSize() == rhs.getCurrentSize()) {
            LinkedSet<T> temp1 = new LinkedSet<>();
            LinkedSet<T> temp2 = new LinkedSet<>();
            T[] bag = rhs.toArray();
            
            while((current != null) && (index < numberOfEntries)) {
                temp1.add(current.data);
                temp2.add(bag[index]);
                index++;
                current = current.next;
            }

            Node currTemp2 = temp2.firstNode;
            while(!temp1.isEmpty() && !temp2.isEmpty()) {
                if (temp1.contains(currTemp2.data)) {
                    currTemp2 = currTemp2.next;
                    temp2.remove();
                }
            }
            temp1.clear();
            result = temp2.isEmpty();
        }
        return result;
    }
    
    public LinkedSet<T> union(SetInterface<T> rhs) {
        LinkedSet<T> cBag = new LinkedSet<>();
        
        for(T item : rhs.toArray())
            add(item);
        
        T[] temp = toArray();
        for(T item : temp)
            if (!cBag.contains(item))
                cBag.add(item);
        return cBag;
    }
    
    public String toString() {
        Node current = firstNode;
        String str = "";
        return "{" + traverse(current, str) + "}";
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public boolean add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        numberOfEntries++;
        return true;
    }

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

    public T remove() {
        T result = null;
        if (firstNode != null) {
            result = firstNode.data;
            firstNode = firstNode.next;
            numberOfEntries--;
        }

        return result;
    }

    public void clear() {
        while(!isEmpty())
            remove();
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)) {
            if(anEntry.equals(currentNode.data)) {
                found = true;
            }
            else {
                currentNode = currentNode.next;
            }
        }
        return found;
    }

    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        int loopCounter = 0;
        Node currentNode = firstNode;

        while ((loopCounter < numberOfEntries) && (currentNode != null)) {
            if(anEntry.equals(currentNode.data)) {
                frequency++;
            }
            loopCounter++;
            currentNode = currentNode.next;
        }
        return frequency;
    }

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

    private String traverse(Node node, String str) {
        if (node != null)
            return node.next != null ? traverse(node.next, str) + ", " + node.data : node.data + "";
        return "";
    }

    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)) {
            if(anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        }

        return currentNode;
    }
}
