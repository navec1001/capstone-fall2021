public class Ingredient {
    private String name = null;
    private String desc = null;

    //Constructors
    public Ingredient() {
        this.name = null;
        this.desc = null;
    }

    public Ingredient(String name) {
        this.name = name;
        this.desc = null;
    }

    public Ingredient(String name, String usage) {
        this.name = name;
        this.desc = usage;
    }

    //Setters and Getters
    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDesc(String newDesc) {
        this.desc = newDesc;
    }

    //Other functions
    @Override
    //making the print/println versions of the Ingredients look nice :)
    public String toString() {
        if (this.desc == null){
            return this.name + " : ???";
        }
        return this.name + " : " + this.desc;
    }
}
