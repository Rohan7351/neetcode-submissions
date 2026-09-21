class PrefixTree {

    private Node root;
    class Node {
        Node[] links = new Node[26];
        boolean flag = false;
    }

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {

        Node curr = root;

        for (char ch : word.toCharArray()) {

            int ind = ch - 'a';

            if (curr.links[ind] == null) {
                curr.links[ind] = new Node();
            }

            curr = curr.links[ind];
        }

        curr.flag = true;
    }

    public boolean search(String word) {

        Node curr = root;

        for (char ch : word.toCharArray()) {

            int ind = ch - 'a';

            if (curr.links[ind] == null) {
                return false;
            }

            curr = curr.links[ind];
        }

        return curr.flag;
    }

    public boolean startsWith(String prefix) {

        Node curr = root;

        for (char ch : prefix.toCharArray()) {

            int ind = ch - 'a';

            if (curr.links[ind] == null) {
                return false;
            }

            curr = curr.links[ind];
        }

        return true;
    }
}