package capstone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {
    private String name = "";
    private List<Ingredient> ingList = new ArrayList<>();

    //Constructors
    public Product() {}

    public Product(String name) {
        this.name = name;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public List<Ingredient> getIngList() {
        return ingList;
    }

    public void setIngList(List<Ingredient> newIngList) {
        this.ingList.addAll(newIngList);
    }

    //complex functions
    //clears ingList by making a whole new blank list
    public void deleteIngList() {
        this.ingList = new ArrayList<>();
    }

    //not used because things went smoothly
    //if expanded upon, great for debugging
    public void printInfo() {
        System.out.print("Here is the information on the product: ");
        System.out.print(name);
        System.out.print("\n");
        System.out.println("Ingredient List: ");
        for (int i=0; i < this.ingList.size(); i++) {
            System.out.println(this.ingList.get(i));
        }
    }

    //copied from StringManip prototype backend stuff
    //takes in a comma-separated String, converts to ArrayList, and soft copied into ingList
    public void importIngList(String newIngList) {
        ArrayList<String> convIngList = new ArrayList<>(Arrays.asList(newIngList.split("\\s*,\\s*")));
        for (String ing : convIngList) {
            this.ingList.add(new Ingredient(ing));
        }
    }

    //used to make things look nice in TableView :)
    //iterates on ingList and makes all the Ingredient desc ???
    public void makeDescQuestion() {
        for (Ingredient ing : ingList) {
            if(ing.getDesc() == null)
                ing.setDesc("???");
        }
    }
}
