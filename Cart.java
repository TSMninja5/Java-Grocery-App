class Cart {

  // Instance variables
  Item ourCart[] = new Item[10];
  int nextEmpty;
  double weight;
  double price;
  int numItems;

  // constructors
  Cart() {
    for (int j = 0; j < 10; j++) {
      ourCart[j] = null;
    }
    nextEmpty = 0;
    weight = 0.0;
    price = 0.0;
    numItems = 0;
  }
  // methods

  public void addItem(Item i) {
    boolean itemFound = false;
    for (int j = 0; j < nextEmpty; j++) {
      // updates quantity for two or more of the same item
      if (ourCart[j].getName().equals(i.getName())) {
        ourCart[j].setQuantity(ourCart[j].getQuantity() + i.getQuantity());
        itemFound = true;
      }
    }
    if (!itemFound) {
      ourCart[nextEmpty] = i;
      nextEmpty++;
    }
    numItems += i.getQuantity();
    price += i.getPrice();
    weight += i.getWeight();

  }

  //public void Update(Item)

  public void removeItem(Item i){
    for (int j = 0; j < nextEmpty; j++){
      if (ourCart[j].getName().equals(i.getName())){
        
        if (i.getQuantity() < ourCart[j].getQuantity()){
          ourCart[j].setQuantity(ourCart[j].getQuantity()-i.getQuantity());
          numItems -= i.getQuantity();
          price -= i.getPrice();
          weight -= i.getWeight();
        }
        else{
          numItems -= ourCart[j].getQuantity();
          price -= ourCart[j].getPrice();
          weight -= ourCart[j].getWeight();          
          ourCart[j] = null;
          for (int k = j; k < nextEmpty - 1; k++){
            ourCart[k] = ourCart[k+1];
          }
          ourCart[nextEmpty - 1] = null;
          nextEmpty--;
        }
      }
    }

  }
  public void print(){
    for( int j = 0; j < nextEmpty; j++){
      System.out.print( j+1 + ": ");
      ourCart[j].print();
    } 
  }
  public boolean isEmpty(){
    return (nextEmpty == 0);
  }
  public int numUniqueItems(){
    return nextEmpty;
  }
  public Item selected(int n){
    return ourCart[n];
  }

}