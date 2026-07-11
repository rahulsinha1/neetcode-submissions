class LRUCache {

    Map <Integer, Node> map;
    int capacity;

    Node start;
    Node end;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.start = new Node (-1, -1);
        this.end = new Node (-1, -1);

        start.next = end;
        end.prev = start;
    }
    
    public int get(int key) {

        if (!map.containsKey(key)){
            return -1;
        }
        Node current = map.get(key);

        current.prev.next = current.next;
        current.next.prev = current.prev;

        current.next = end;
        current.prev = end.prev;
        end.prev.next = current;
        end.prev = current;

        return current.value; 
    }
    
    public void put(int key, int value) {
        Node current = null;
        if (map.containsKey(key)){
            current = map.get(key);
            current.value = value;

            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        else{
            current = new Node(key, value);
            map.put(key, current);
        }

        current.next = end;
        current.prev = end.prev;
        end.prev.next = current;
        end.prev = current;

        if(map.size()>capacity){
            Node toRemove = start.next;
            map.remove(toRemove.key);
            start.next = start.next.next;
            toRemove.next.prev = start;
        }

    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    Node(){}

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    Node(int key, int value, Node next, Node prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}