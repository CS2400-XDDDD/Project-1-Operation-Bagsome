
import ResizeableArrayBag;

public class BagDriver {

    public static <T> void printBag(BagInterface<T> bag) {
        T[] contents = bag.toArray();
        for (T item : contents) {
            System.out.print(item + " ");
        }
    }
    public static void main(String[] args) {
        BagInterface<String> bagOne = new ResizableArrayBag<>();
        bagOne.add("1");
        bagOne.add("2");
        bagOne.add("3");
        bagOne.add("4");
        bagOne.add("5");
        bagOne.add("6");

        BagInterface<String> bagTwo = new ResizableArrayBag<>();
        bagTwo.add("2");
        bagTwo.add("3");
        bagTwo.add("5");
        bagTwo.add("7");
        bagTwo.add("7");
        bagTwo.add("8");

        BagInterface<String> bagThree = new LinkedBag1<>();
        bagThree.add("4");
        bagThree.add("8");
        bagThree.add("10");


        BagInterface<String> unionBag = bagOne.union(bagTwo);
        printBag(unionBag);

        System.out.println();
        BagInterface<String> unionBagTwo = bagOne.union(bagThree);
        printBag(unionBagTwo);

        BagInterface<String> intersectionBagOne = bagOne.intersection(bagTwo);
        System.out.print("\n The intersection of Bags One and Two:");
        printBag(intersectionBagOne);
        
        BagInterface<String> intersectionBagTwo = bagTwo.intersection(bagThree);
        System.out.print("\n The intersection of Bags Two and Three:");
        printBag(intersectionBagTwo);

        BagInterface<String> intersectionBagUnion = unionBag.intersection(unionBagTwo);
        System.out.print("\n The intersection of Union Bags One and Two:");
        printBag(intersectionBagUnion);

        //unionBag = bagOne.union(bagTwo);
        //printBag(unionBag);
        
        /* 
        BagInterface<Integer> unionBag = bagOne.union(bagTwo);
        Integer[] result = unionBag.toArray();

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        */
    }
}
