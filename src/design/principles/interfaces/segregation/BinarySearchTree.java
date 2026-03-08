package design.principles.interfaces.segregation;

public class BinarySearchTree implements Tree {

    @Override
    public void insert() {
        System.out.println("Insert a given item...");
    }

    @Override
    public void delete() {
        System.out.println("Removing a given item...");
    }

    @Override
    public void traverse() {
        System.out.println("In-order traversal in O(N)...");
    }

}
