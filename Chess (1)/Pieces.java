public class Pieces {
  
    // Instance variables
    private String name;
    String color;
    int row;
    int column;
    int value;
    boolean captured;
    String shape;
    boolean hasMoved;

    // Constructor (automatically called when we create an object in this class)
    public Pieces(String name, String color, int row, int column, int value, String shape) {

        this.captured = false;
        this.name = name;
        this.color = color;
        this.value = value;
        this.row = row;
        this.column = column;
        this.shape = shape;
        this.hasMoved = false;

    }

    // Other methods

    public String toString() {
        return this.color + " " + this.name + " at row " +            this.row + " column " + this.column + " is worth " +          this.value + " points." + this.shape;
    }

    // Setters (Mutator) 
    public void setName(String n) {
        this.name = n;
    }
    public void setCaptured(boolean cap){
        this.captured = cap;
    }
    public void setColor(String col){
        this.color = col;
    }
    public void setValue(int val){
        this.value = val; 
    }
    public void setRow(int y){
        this.row = y;
    }
    public void setColumn(int x){
        this.column = x;
    }
    // Getters (Accessor)
    public String getName() {
        return this.name; // could also "return name"
    }
    public boolean getCaptured(){
      return this.captured;
    }
    public String getColor(){
      return this.color;
 }
    public int getValue(){
      return this.value;
    }
    public int getRow(){
      return this.row;
    }
    public int getColumn(){
      return this.column;
    }


    
}