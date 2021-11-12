import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product {
    private String name = "";
    private List<Ingredient> ingList = new ArrayList<>();

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
    public void printInfo() {
        System.out.print("Here is the information on the product: ");
        System.out.print(name);
        System.out.print("\n");
        System.out.println("Ingredient List: ");
        for (int i=0; i < this.ingList.size(); i++) {
            System.out.println(this.ingList.get(i));
        }
    }
    public void importIngList(String newIngList) {
        ArrayList<String> convIngList = new ArrayList<>(Arrays.asList(newIngList.split("\\s*,\\s*")));
        for (String ing : convIngList) {
            this.ingList.add(new Ingredient(ing));
        }
    }
}
