public class LinkedSet<T> implements SetInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedSet() {
        firstNode = null;
        numberOfEntries = 0;
    }
    
    public boolean subset(SetInterface<T> rhs) {
        
        return false;
    }

    public boolean equals(SetInterface<T> rhs) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public LinkedSet<T> union(SetInterface<T> rhs) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String toString() {
        Node current = firstNode;
        String str = "";

        
        // int index = 0;
        // while((current != null) && (index < numberOfEntries)) {
        //     str += current.data + " ";
        //     current = current.next;
        //     index++;
        // }
        traverse(current);
        return str +"{" + "}";
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
        while(!isEmpty()) {
            remove();
        }
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

    private void traverse(Node node) {
        
        if(node != null) {
            traverse(node.next);
            System.out.println(node.data);
        }
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
