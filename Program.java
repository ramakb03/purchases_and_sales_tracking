package woodProject;
import java.io.*;
import java.util.Scanner;
public class Program {

	public static void main(String[] args) throws FileNotFoundException, UnavailableNodeException {
	
		Scanner input = new Scanner(new File("input.txt"));
		PrintWriter outFile = new PrintWriter("output.txt");
		
		LinkedLists oakWood = new LinkedLists();
		LinkedLists cherryWood = new LinkedLists();
		
		String transactionNature, type;
		int quantity;
		int totalOak = 0;
		int totalCherry = 0;
		double discount = 0;
		while(input.hasNext()) {
			
			transactionNature = input.next();
			
			if(transactionNature.equals("R")) {
				
				//It's a receipt
				
				type = input.next();
				quantity = input.nextInt();
				double price = Double.parseDouble(input.next().substring(1));
				
				if(type.equals("O")) {
					
					type = "Oak Wood";
					oakWood.push(quantity, price);
					totalOak += quantity;
				}
				else {
					
					type = "Cherry Maple Wood";
					cherryWood.push(quantity, price);
					totalCherry += quantity;
				}
				
				outFile.println(quantity + " widgets received from " + type +
						" at $" + price + " each");
				outFile.println();
				
			}
			
			else if(transactionNature.equals("S")) {
				
				type = input.next();
				quantity = input.nextInt();
				
				double price, sales, totalSale = 0;
				
				if(type.equals("O")) {
					
					if(quantity <= totalOak) {
						
						outFile.println(quantity + " pieces of Oak Wood sold");
						totalOak -= quantity;
						
					}
					else {
						
						outFile.println("Remainder of " + quantity + " pieces of oak not available.");
						
						if(totalOak > 0 ) {
							
							outFile.println(totalOak + " widgets sold"); 
						}
							quantity = totalOak;
							totalOak = 0;
						}
					
					while(quantity > 0) {
						
						if(quantity < oakWood.peek().getQuantity()) {
							
							oakWood.peek().setQuantity(oakWood.peek().getQuantity() - quantity);
							price = (0.4 * oakWood.peek().getPrice()) + oakWood.peek().getPrice();
							sales = quantity * price;
							sales -= sales * (discount / 100.0);
							totalSale += sales;
							
							outFile.printf("\t     " + quantity + " at $" + price + " each. "
									+ "   Sales: $%.2f",  sales);
							outFile.println();
					
							quantity = 0;
						}
								
						else {
							
							//if quantity >= quantityHead
							price = (0.4 * oakWood.peek().getPrice()) + oakWood.peek().getPrice();
							sales = oakWood.peek().getQuantity() * price;
							sales -= sales * (discount / 100.0);
							totalSale += sales;
							
							quantity -= oakWood.peek().getQuantity();
							
							outFile.printf("\t     " + oakWood.peek().getQuantity() + " at $" + price + " each. "
									+ "   Sales: $%.2f",  sales);
							outFile.println();
							oakWood.pop();
						}
					}
					discount = 0;
					
					outFile.printf("\t             " + "Total sale = $%.2f",  totalSale);
					outFile.println();
					outFile.println();
				}
				
				else {
					
					//it's a request for cherry maple
					
					if(quantity <= totalCherry) {
						
						outFile.println(quantity + " pieces of Cherry Maple Wood sold");
						totalCherry -= quantity;
						
					}
					else {
						
						outFile.println("Remainder of " + quantity + " pieces of Cherry Maple Wood not available.");
						
						if(totalCherry > 0) {
							
						outFile.println(totalCherry + " widgets sold"); 
						}
						
						quantity = totalCherry;
						totalCherry = 0;
						}
					
					while(quantity > 0) {
						
						if(quantity < cherryWood.peek().getQuantity()) {
							
							cherryWood.peek().setQuantity(cherryWood.peek().getQuantity() - quantity);
							price = (0.4 * cherryWood.peek().getPrice()) + cherryWood.peek().getPrice();
							sales = quantity * price;
							sales -= sales * (discount / 100.0);
							totalSale += sales;
							
							outFile.printf("\t     " + quantity + " at $" + price + " each. "
									+ "   Sales: $%.2f",  sales);
							outFile.println();
					
							quantity = 0;
						}
								
						else {
							
							//if quantity >= quantityHead
							price = (0.4 * cherryWood.peek().getPrice()) + cherryWood.peek().getPrice();
							sales = cherryWood.peek().getQuantity() * price;
							sales -= sales * (discount / 100.0);
							totalSale += sales;
							
							quantity -= cherryWood.peek().getQuantity();
							
							outFile.printf("\t     " + cherryWood.peek().getQuantity() + " at $" + price + " each. "
									+ "   Sales: $%.2f",  sales );
							outFile.println();
							cherryWood.pop();
						}
					}
					discount = 0;
					
					outFile.println("\t             " + "Total sale = $" + totalSale); 
					outFile.println();
				}
			}
			else {
				
				//it's a promotion card
				discount = Double.parseDouble(input.next().substring(0,2));
				outFile.println("A promotion of " +  discount +  "% will be applied to the next customer.");
			}
			//input.nextLine();
			//input.nextLine();
		}
		input.close();
		
		outFile.println(totalOak + " pieces of oak wood remaining in stock");
		
		int lengthOak = oakWood.getLength();
		for(int i = 0; i <lengthOak ; i++) {
			
			outFile.println("\t" + oakWood.peek().getQuantity() 
					+ " pieces at $" + oakWood.peek().getPrice());
			oakWood.pop();
		}
		
		outFile.println(totalCherry + " pieces of cherry maple wood remaining in stock");
		
		int lengthCherry = cherryWood.getLength();
		
		for(int i = 0; i < lengthCherry; i++) {
			
			outFile.println("\t" + cherryWood.peek().getQuantity() 
					+ " pieces at $" + cherryWood.peek().getPrice());
			cherryWood.pop();
		}
		
		outFile.close();
	}
}
