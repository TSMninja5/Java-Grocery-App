import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //First block creates an array of items in the produce category
    Item produce[] = new Item[5];
    produce[0] = new Item("apple", .89, .2, "Produce", 100);
    produce[1] = new Item("lettuce", 1.75, .5, "Produce", 150);
    produce[2] = new Item("banana", .70 , .15, "Produce", 95);
    produce[3] = new Item("tomato", 2.99, 05, "Produce", 50);
    produce[4] = new Item("cucumber", 2.99, 05, "Produce", 50);

  //Creates an array of Items in the dairy category
    Item dairy[] = new Item[5];
    dairy[0] = new Item("skim milk", 4.99, 1.0, "Dairy", 100);
    dairy[1] = new Item("butter", 1.75, .5, "Dairy", 150);
    dairy[2] = new Item("cheese", 3.65 , .25, "Dairy", 95);
    dairy[3] = new Item("yogurt", 2.99, 0.75, "Dairy", 50);
    dairy[4] = new Item("whipped cream", 2.99, 0.3, "Dairy", 50);

//creates an array of Items in the freezer category
    Item freezer[] = new Item[5];
    freezer[0] = new Item("ice cream", .89, .2, "Freezer", 100);
    freezer[1] = new Item("frozen peas", 1.75, .5, "Freezer", 150);
    freezer[2] = new Item("TV dinner", .70 , .15, "Freezer", 95);
    freezer[3] = new Item("sorbet", 2.99, 05, "Freezer", 50);
    freezer[4] = new Item("frozen lasagna", 2.99, 05, "Freezer", 50);    

//creates an array of Items in the grocery category
    Item grocery[] = new Item[5];
    grocery[0] = new Item("cereal", 2.99, .3, "Grocery", 100);
    grocery[1] = new Item("canned soup", 1.75, .4, "Grocery", 150);
    grocery[2] = new Item("crackers", 3.65 , .25, "Grocery", 95);
    grocery[3] = new Item("cake mix", 1.75, 0.5, "Grocery", 50);
    grocery[4] = new Item("flour", 2.99, 1.0, "Grocery", 50);    
    
    //the boolean is used to initialize the while loop 
    boolean storeOpen = true;

    //cart for the user to put stuff in
    Cart myCart = new Cart();
    //take input from the user
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to The FoodLand");

    while (storeOpen){ //loop runs when storeOpen is set to true. If user quits, storeOpen is set to false and the loop doesnt run anymore

     //user options
      System.out.println("Choose an action:");
      System.out.println("Press 1 to add an item");
      System.out.println("Press 2 to remove an item");
      System.out.println("Press 3 to checkout");
      System.out.println("Press 4 to quit");      
      int userActionChoice = scan.nextInt();

      //if user chooses 1, they are presented with more options
      if (userActionChoice == 1){
        System.out.println("Choose which type of item you would like to add:");
        System.out.println("Press 1 for produce");
        System.out.println("Press 2 for dairy");
        System.out.println("Press 3 for freezer");
        System.out.println("Press 4 for grocery");
        System.out.println("Press 5 to quit");    

        int groceryType = scan.nextInt();



//Different kinds of items are stored in different arrays. each if and else if statement prints out the items for the user. 
        if (groceryType == 1){
          for (int j = 0; j < 5; j++){
            System.out.print((j+1)+": ");
            produce[j].print();
          }
        }
        else if (groceryType == 2){
          for (int j = 0; j < 5; j++){
            System.out.print((j+1)+": ");
            dairy[j].print();
           }
          }
        else if (groceryType == 3){
          for (int j = 0; j < 5; j++){
            System.out.print((j+1)+": ");
            freezer[j].print();
           }
          }
        else if (groceryType == 4){
          for (int j = 0; j < 5; j++){
            System.out.print((j+1)+": ");
            grocery[j].print();
          }
        }        
        else if (groceryType == 5){
          storeOpen = false;
        }
        else {
          System.out.println("Invalid choice");          
        }

          //takes input for their choice
        int itemChoice = scan.nextInt();

        //Asks the user how many items they would like to add into the cart. The statement makes sure that the items are in range.
        if (itemChoice >= 1 && itemChoice <= 5){
          System.out.println("How many of the item would you like to add?");
          int howMany = scan.nextInt();

          //these statements add the item in the cart based on the users choice
          if (groceryType == 1){
            Item newItem = new Item(produce[itemChoice - 1], howMany);
            myCart.addItem(newItem);
            System.out.println("Item added to cart.");
          }
          else if(groceryType == 2){
            Item newItem = new Item (dairy[itemChoice - 1], howMany);
            myCart.addItem(newItem);
            System.out.println("Item added to cart.");

          }
          else if(groceryType == 3){
            Item newItem = new Item (freezer[itemChoice - 1], howMany);
            myCart.addItem(newItem);
             System.out.println("Item added to cart.");

          }
          else if(groceryType == 4){
            Item newItem = new Item (grocery[itemChoice - 1], howMany);
            myCart.addItem(newItem); 
            System.out.println("Item added to cart.");

          }
        }

        
        else System.out.println("Invalid choice");          
      }
      //This runs if the user presses 2 to remove an item:
      else if(userActionChoice == 2){
        //it only takes out an item if the cart has something in it
        if (!myCart.isEmpty()){
          System.out.println("Choose which item you would like to remove:");
          myCart.print();
          int whichItemRemove = scan.nextInt();
          if (whichItemRemove >= 1 && whichItemRemove <= myCart.numUniqueItems()){
            System.out.println("How many of the item would you like to remove?");

            int removequant = scan.nextInt();

            if (removequant >= myCart.selected(whichItemRemove - 1).getQuantity())
            {
            myCart.removeItem(myCart.selected(whichItemRemove - 1));
            System.out.println("Item has been removed from the cart.");
            }

            else{
              int temp = (myCart.selected(whichItemRemove - 1).getQuantity() - removequant);

              myCart.selected(whichItemRemove -1).setQuantity(temp);
              System.out.println("Item has been removed from the cart.");
            }

          }
          else {
            System.out.println("Invalid choice");
          }
        }
        else
          System.out.println("Your cart is empty!");
      }
      //checkout. Calculates the total price and lets the user chekout whatever is in the cart.
      else if (userActionChoice == 3){
        if (!myCart.isEmpty()){
        System.out.println("Your cart: ");
        myCart.print();
        double total = 0;

          for(int j = 0; j < myCart.nextEmpty; j++){ //calculates the total price

            total+= (myCart.selected(j).getPrice() * myCart.selected(j).getQuantity());}
            System.out.println("Your total is $" + total);
            System.out.println("1. Pay now?");
            System.out.println("2. Exit");
            int pay = scan.nextInt();

            if(pay == 1) {
              System.out.println("Thankyou for shopping at Foodland.");
              System.out.println("Would you like a receipt?");
              System.out.println("1. Yes");
              System.out.println("2. No");

              int receipt =scan.nextInt();

              if (receipt == 1){
              myCart.print();
              System.out.println("Total paid: $" + total);}

              if (receipt == 2){
              System.out.println("Have a good day");
              System.out.println("Total paid: $" + total);
              storeOpen = false;
              System.exit(0);}
            }
            else if (pay == 2)
            storeOpen = false;
            System.exit(0);
          

    
          }


      else System.out.println("Your cart is empty!");
      }

      //Closes the program if the user selects 4
      else if(userActionChoice == 4){
        System.out.println("bye bye!");
        storeOpen = false;
        System.exit(0);
      }
      else
      System.out.println("Invalid selection.");
    }
}}














//attempt to write the cart to a text file

//else if(userActionChoice == 5){
  //     FileWriter fw = new FileWriter("file.txt");
    //    String strs[] = new String [myCart];
      //  for (int i = 0; i < strs.length; i++) {
      //fw.write(strs[i] + "\n");
   // }
//}


