package design.principles.interfaces.segregation;

public class BalancedTree implements RotationTree {

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

    @Override
    public void leftRotation() {
        System.out.println("Left rotation...");
    }

    @Override
    public void rightRotation() {
        System.out.println("Right rotation...");
    }

}
