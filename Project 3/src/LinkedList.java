import java.util.ArrayList;

public class LinkedList {
    private static class Node {
        /**
         * Initialize data
         */
        private Contact data;
        /**
         * Initialize next
         */
        private Node next;

        /**
         * Node constructor
         * @param s contact
         */
        public Node(Contact s) {
            data = s;
            next = null;
        }

        /**
         * Overloaded node constructor
         * @param s contact
         * @param n node
         */
        public Node(Contact s, Node n) {
            data = s;
            next = n;
        }
    }

    /**
     * Initialize first
     */
    private Node first;
    /**
     * Initialize last
     */
    private Node last;

    /**
     * Constructor for linked list
     */
    public LinkedList() {
        first = null;
        last = null;
    }

    /**
     * Checks if linked list empty
     * @return true if empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Add contact
     * @param s contact
     */
    public void add(Contact s) {
        if (first == null) {
            first = new Node(s);
            last = first;
        } else {
            Node n = new Node(s);
            last.next = n;
            last = n;
        }
    }

    /**
     * Add contact at index
     * @param i index
     * @param s contact
     */
    public void add(int i, Contact s) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            first = new Node(s, first);
            if (last == null) {
                last = first;
            }
        } else {
            Node n = first;
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }
            for (int j = 1; j < i; j++) {
                n = n.next;
                if (n == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            n.next = new Node(s, n.next);
            if (n.next.next == null) {
                last = n.next;
            }
        }
    }

    /**
     * Get contact at index
     * @param i index
     * @return contact at i
     */
    public Contact get(int i) {
        if (first == null || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for (int j = 0; j < i; j++) {
            n = n.next;
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return n.data;
    }

    /**
     * Set a contact at an index
     * @param i index
     * @param s contact
     */
    public void set(int i, Contact s) {
        if (first == null || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node n = first;
        for (int j = 0; j < i; j++) {
            n = n.next;
            if (n == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        n.data = s;
    }

    /**
     * Size of list
     * @return size
     */
    public int size() {
        int count = 0;
        Node n = first;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }

    /**
     * Turn list into string
     * @return list as string
     */
    @Override
    public String toString() {
        String str = "";
        Node n = first;
        int count = 1;
        while (n != null) {
            str = str + count + ". " + n.data + "\n";
            n = n.next;
            count += 1;
        }
        return str;
    }

    /**
     * Remove contact by index
     * @param i index
     * @return removed contact
     */
    public Contact remove(int i) {
        Contact rem;
        if (first == null || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i == 0) {
            rem = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node n = first;
            for (int j = 1; j < i; j++) {
                n = n.next;
                if (n == null) {
                    throw new IndexOutOfBoundsException();
                }
            }
            if (n.next == null) {
                throw new IndexOutOfBoundsException();
            }
            rem = n.next.data;
            n.next = n.next.next;
            if (n.next == null) {
                last = n;
            }
        }
        return rem;
    }

    /**
     * Remove contact with full name
     * @param s
     * @return true if removed
     */
    public boolean remove( Contact s ) {
        if (first != null) {
            if (s.equals(first.data)) {
                first = first.next;
                if (first == null) {
                    last = null;
                }
                return true;
            } else {
                Node n = first;
                while (n.next != null && !n.next.data.equals(s)) {
                    n = n.next;
                }
                if (n.next != null) {
                    n.next = n.next.next;
                    if (n.next == null) {
                        last = n;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Search contact using full name
     * @param fullName
     * @return first contact with matching full name, returns no match if no contact found
     */
    public Contact searchName(Contact fullName) {
        if (first != null) {
            Node n = first;
            while (n != null && !n.data.equals(fullName)) {
                n = n.next;
            }
            if (n == null) {
                return null;
            }
            return n.data;
        } else {
            return null;
        }
    }

    /**
     * Search contact using last name
     * @param lastName
     * @return array of contacts with matching last name
     */
    public ArrayList<Contact> searchName(String lastName) {
        ArrayList<Contact> sameLastNames = new ArrayList<Contact>();
        if (first != null) {
            Node n = first;
            while (n != null) {
                if ( n.data.getLastName().equals( lastName ) ) {
                    sameLastNames.add( n.data );
                }
                n = n.next;
                if ( n == null ) {
                    return sameLastNames;
                }
            }
        }
        return sameLastNames;
    }

    /**
     * Search contact using zip code
     * @param zipCode
     * @return array of contacts with matching zip code
     */
    public ArrayList<Contact> searchZip( String zipCode ) {
        ArrayList<Contact> sameZipCode = new ArrayList<Contact>();
        if ( first != null ) {
            Node n = first;
            while ( n != null ) {
                if ( n.data.getZipCode().equals( zipCode ) ) {
                    sameZipCode.add( n.data );
                }
                n = n.next;
                if ( n == null ) {
                    return sameZipCode;
                }
            }
        }
        return sameZipCode;
    }

    /**
     * Sort list of contacts using compareTo and Bubble Sort
     */
    public void sort() {
        boolean swapped = false;
        do{
            swapped = false;
            Node n = first;
            while ( n.next != null ){
                if ( n.data.compareTo( n.next.data ) > 0 ){
                    Contact swap = n.data;
                    n.data = n.next.data;
                    n.next.data = swap;
                    swapped = true;
                }
                n = n.next;
            }
        } while( swapped );
    }

    /**
     * Write the contacts into a string
     * @return string of contacts
     */
    public String toFile(){
        String contact = "";
        Node n = first;
        while ( n != null ){
            contact = contact + n.data.toString() + "\n";
            n = n.next;
        }
        return contact;
    }

}