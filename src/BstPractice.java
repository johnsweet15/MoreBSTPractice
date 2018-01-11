
public class BstPractice {

    private Node root;
    @SuppressWarnings("unused")
    private int size;

    public BstPractice() {
        root = null;
        size = 0;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node rt) {
        if (rt == null) {
            return true;
        }
        else {
            return Math.abs(height(rt.left()) - height(rt.right())) < 2;
        }
    }

    private int height(Node rt) {
        if (rt == null) {
            return 0;
        }
        else {
            return 1 + Math.max(height(rt.left()), height(rt.right()));
        }
    }

    @SuppressWarnings("rawtypes")
    public String moves(Comparable val) {
        return moves(val, root);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private String moves(Comparable val, Node rt) {
        if (rt == null) {
            return "";
        }
        else {
            if (rt.element().compareTo(val) < 0) {
                return "R" + moves(val, rt.right());
            }
            else if (rt.element().compareTo(val) > 0) {
                return "L" + moves(val, rt.left());
            }
            else {
                return "";
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public Comparable maximumElement() {
        return maximumElement(root);
    }

    @SuppressWarnings("rawtypes")
    private Comparable maximumElement(Node rt) {
        if (rt == null) {
            return null;
        }
        if (rt.right() != null) {
            return maximumElement(rt.right());
        }
        else {
            return rt.element();
        }
    }

    @SuppressWarnings("rawtypes")
    public void insert(Comparable val) {
        this.root = insertHelp(root, val);
        size++;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Node insertHelp(Node rt, Comparable val) {
        if (rt == null) {
            return new Node(val);
        }
        if (rt.element().compareTo(val) < 0) {
            rt.setRight(insertHelp(rt.right(), val));
        }
        else {
            rt.setLeft(insertHelp(rt.left(), val));
        }
        return rt;
    }

    @SuppressWarnings("rawtypes")
    public void remove(Comparable val) {
        removeHelp(root, val);
        size--;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private Node removeHelp(Node rt, Comparable val) {
        if(rt.element().compareTo(val) < 0) {
            rt.setRight(removeHelp(rt.right(), val));
        }
        else if(rt.element().compareTo(val) > 0) {
            rt.setLeft(removeHelp(rt.left(), val));
        }
        else {
            if(rt.right() == null) {
                return rt.left();
            }
            else if(rt.left() == null) {
                return rt.right();
            }
            else {
                Node node = max(rt.left());
                rt.setElement(node.element());
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }

    private Node max(Node rt) {
        if(rt.right() == null) {
            return rt;
        }
        return max(rt.right());
    }

    private Node deleteMax(Node rt) {
        if(rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deleteMax(rt.right()));
        return rt;
    }

    @SuppressWarnings("rawtypes")
    public boolean contains(Comparable val) {
        return (containsHelp(root, val) != null);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Comparable containsHelp(Node rt, Comparable val) {
        if (rt == null) {
            return null;
        }
        if (rt.element().compareTo(val) < 0) {
            return containsHelp(rt.right(), val);
        }
        else if (rt.element().compareTo(val) > 0) {
            return containsHelp(rt.left(), val);
        }
        else {
            return rt.element();
        }
    }

    public String preorder() {
        return preorder(root);
    }

    private String preorder(Node rt) {
        String str = "";
        if (rt == null) {
            return "";
        }
        str += rt.element().toString() + " ";
        str += preorder(rt.left());
        str += preorder(rt.right());
        if (rt == root) {
            str = "< " + str + ">";
        }
        return str;
    }
    
    public void removeMax() {
        remove(maximumElement());
    }
}
