package exemple2_List;

import java.util.*;

/**
 * Exemple 2.2 – Démo Arrays.toString(Object[] a), List.toArray(),  et Stack
 */
public class Ex2_2ArrayVectorStack {
    List<Integer> arrayList;
    Stack<Integer> stack;
    Integer[] tableau;

    public Ex2_2ArrayVectorStack() {
        demoToArray();
        demoStack();
    }

    private void demoToArray() {
        tableau = new Integer[5];
        List list = Arrays.asList(new Integer[]{2, 3, 4, 5});

        arrayList = new ArrayList<>(list);

        arrayList.toArray(tableau);
        System.out.println("tableau rempli avec arrayList: " + arrayList + " tableau:" + Arrays.toString(tableau));
    }

    private void demoStack() {
        stack = new Stack<>();
        stack.push(1);
        System.out.println("stack.push(1) stack=" + stack);
        stack.push(2);
        System.out.println("stack.push(2) stack=" + stack);
        stack.push(3);
        System.out.println("stack.push(3) stack=" + stack);

        System.out.println("stack.peek() retourne : " + stack.peek() + " stack=" + stack);
        System.out.println("stack.pop() retourne : " + stack.pop() + " stack=" + stack);

        stack.remove(0);
        System.out.println("stack.remove(0) (oui, c'est bizarre : Stack hérite de Vector) stack=" + stack);
    }

    public static void main(String[] args) {
        new Ex2_2ArrayVectorStack();
    }
}
/**
 * exécution :
 * arrayList rempli avec des add : [2, 3, 4, 5]
 * tableau rempli avec arrayList: [2, 3, 4, 5] tableau:[2, 3, 4, 5, null]
 * Rempli le Vector avec l'arrayList: [2, 3, 4, 5] vector:[2, 3, 4, 5]
 * vector:[2, 3, 4, 5, 9]
 * stack.push(1) stack=[1]
 * stack.push(2) stack=[1, 2]
 * stack.push(3) stack=[1, 2, 3]
 * stack.peek() retourne : 3 stack=[1, 2, 3]
 * stack.pop() retourne : 3 stack=[1, 2]
 * stack.remove(0) (oui, c'est bizarre : Stack hérite de Vector) stack=[2]
 */


