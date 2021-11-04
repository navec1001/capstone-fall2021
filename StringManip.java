import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringManip {
    public static void main(String [] args) {
        //setting up a scanner for user inputs
        Scanner input = new Scanner(System.in);
        //setting up "dictionaries" to compare user input to, note that dict indexes match up between name and purpose
        List<String>nameDict = Arrays.asList(
                "Sodium Hyaluronate",
                "Glycerin",
                "Citric Acid");
        List<String>purposeDict = Arrays.asList(
                "Humectant, helps with hydration",
                "Another humectant that helps with hydration",
                "A very light AHA exfoliant that can also contains antioxidants");

        //getting user input and repeating it back
        System.out.println("Enter a comma-separated list below: \n > ");
        String commaInput = input.nextLine();
        System.out.println("The list you input is: ");
        System.out.println(commaInput);

        //converting large user input string into a separated list (with no whitespace!)
        List<String> list = new ArrayList<String>(Arrays.asList(commaInput.split("\\s*,\\s*")));
        System.out.println("\nBut when it's separated it looks like this: ");
        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /*comparing user list strings to name dictionary strings
        Storing matching indexes
        Using those indexes to output the name dictionary and purpose dictionary information
        (In the order the matching indexes were found in the first comparison)
         */
        System.out.println("\nAnd here's what some of the ingredients do for you: ");
        List<Integer>indRem = new ArrayList<Integer>();
        for (int j=0; j < list.size(); j++) {
            for (int k=0; k < nameDict.size(); k++){
                if (list.get(j).equals(nameDict.get(k))) {
                    indRem.add(k);
                }
            }
        }
        for (int l=0; l < indRem.size(); l++) {
            System.out.print(nameDict.get(indRem.get(l)));
            System.out.print(" : ");
            System.out.print(purposeDict.get(indRem.get(l)));
            System.out.print("\n");
        }
    }
}
