class Item{
  //instance variables
  String name;
  double price;
  double weight;
  String category;
  int quantity;

  //Constructors

  Item( String n, double p,double w, String c, int q){
    name = n;
    price =p;
    weight = w;
    category = c;
    quantity = q;
  }

  Item(Item i, int h){
    name = i.getName();
    price = i.getPrice()  ;
    weight = i.getWeight();
    category = i.getCategory();
    quantity = h;
  }
//Methods

  public String getName(){
    return name;
  }

  public double getPrice(){
    return price;
  }

  public double getWeight(){
    return weight;
  }

  public String getCategory(){
    return category;
  }

  public int getQuantity(){
    return quantity;
  }

  public void setQuantity(int q){
    quantity = q;
  }
  
  public void print(){
 
    System.out.println(name + " $" + price + " " + weight + "kg " + category + " " + quantity);
    
  }
  
}