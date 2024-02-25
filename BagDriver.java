
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

        //Difference test
        BagInterface<String> aBag = new ResizableArrayBag<>(3);
        BagInterface<String> bBag = new ResizableArrayBag<>(3);

        String[] contentsOfBag1 = {"a", "b", "c"};
        String[] contentsOfBag2 = {"b", "b", "d", "e"};
        arrayBagtestDifference(aBag, bBag, contentsOfBag1, contentsOfBag2);
        arrayBagtestDifference(bBag, aBag, contentsOfBag2, contentsOfBag1);

        System.out.println();

        BagInterface<String> cBag = new LinkedBag1<>();
        BagInterface<String> dBag = new LinkedBag1<>();

        String[] contentsOfBag3 = {"x", "y", "z"};
        String[] contentsOfBag4 = {"y", "y", "w", "v"};
        linkedBagtestDifference(cBag, dBag, contentsOfBag3, contentsOfBag4);
		linkedBagtestDifference(dBag, cBag, contentsOfBag4, contentsOfBag3);

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
    
    // Tests the method difference.
	private static void arrayBagtestDifference(BagInterface<String> aBag, BagInterface<String> bBag, String[] content, String[] content2)
	{
        System.out.print("aBag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
            System.out.print(content[index] + " ");
		} // end for
        System.out.println();
        System.out.print("bBag: ");
        for (int index = 0; index < content2.length; index++)
		{
			bBag.add(content2[index]);
            System.out.print(content2[index] + " ");
		} // end for

        System.out.println();
        BagInterface<String> leftOver1 = aBag.difference(bBag);
        displayBag(leftOver1);
        aBag.clear();
        bBag.clear();
        leftOver1.clear();
	} // end testAdd

    private static void linkedBagtestDifference(BagInterface<String> aBag, BagInterface<String> bBag, String[] content, String[] content2)
    {
        System.out.print("aBag: ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
            System.out.print(content[index] + " ");
		} // end for
        System.out.println();
        System.out.print("bBag: ");
        for (int index = 0; index < content2.length; index++)
		{
			bBag.add(content2[index]);
            System.out.print(content2[index] + " ");
		} // end for

        System.out.println();
        BagInterface<String> leftOver1 = aBag.difference(bBag);
        displayBag(leftOver1);
        aBag.clear();
        bBag.clear();
        leftOver1.clear();
    } // end testAdd

    private static void displayBag(BagInterface<String> aBag)
	{
		System.out.print("The bag contains " + aBag.getCurrentSize() +
		                   " string(s), as follows: ");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
}
