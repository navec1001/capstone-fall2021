import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringManip {
    public static void main(String [] args) {
        //setting up a scanner for user inputs
        Scanner input = new Scanner(System.in);
        //setting up a "dictionary" to compare user input to, note that dict indexes match up between name and purpose
        List<Ingredient>ingDict = new ArrayList<>();
        ingDict.add(new Ingredient("Sodium Hyaluronate","Humectant that can hold 1000x it's molecular weight in water, greatly helps with hydration"));
        ingDict.add(new Ingredient("Glycerin","A humectant already present in the skin that helps with hydration, and is less likely to cause irritation"));
        ingDict.add(new Ingredient("Citric Acid","A very light AHA exfoliant that can also contains antioxidants"));

        //getting user input and repeating it back
        System.out.println("Enter a comma-separated list below: \n > ");
        String commaInput = input.nextLine();
        System.out.println("The list you input is: ");
        System.out.println(commaInput);

        //converting large user input string into a separated list (with no whitespace!)
        List<String> list = new ArrayList<>(Arrays.asList(commaInput.split("\\s*,\\s*")));
        System.out.println("\nBut when it's separated it looks like this: \n");
        for (String ing : list) {
            System.out.println(ing);
        }

        System.out.println(); //used for a newline(\n)

        //passes user inputted list to the userList of Ingredients
        List<Ingredient> userList = new ArrayList<>();
        System.out.println("Let's convert that to a Ingredient:tm: List");
        for (String ing : list) {
            userList.add(new Ingredient(ing));
        }
        //and then spits it out for debugging purposes
        System.out.println("And this is what that now looks like: \n");
        for (Ingredient ing : userList) {
            System.out.println(ing.getName());
        }

        //compares the userList Ingredient names to the ingDict Ingredient names
        //an enhanced for loop didn't work for this :(
        System.out.println("\nAnd here's what some of the ingredients do for you: \n");
        for(int i=0; i < userList.size(); i++) {
            for (int j=0; j < ingDict.size(); j++) {
                //when a match is found, copy the desc from the ingDict Ingredient to the userList Ingredient desc
                if (userList.get(i).getName().equals(ingDict.get(j).getName())) {
                    userList.get(i).setDesc(ingDict.get(j).getDesc());
                }
            }
        }
        //and the nspit it all out :)
        for (Ingredient ing : userList) {
            System.out.println(ing);
        }
    }
}