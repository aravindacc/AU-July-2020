# Chain of Responsibility

##### What
This is a behavioral design pattern, also known as CoR. It allows us to pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain. We can understand this as an object-oriented linked list with recursive traversal.

##### When to use
 > We can use CoR when the program is expected to process different kinds of requests in various ways, but the exact types of requests and their sequences are unknown beforehand.

 > When we need to execute several handlers in a particular order. We can link the handlers in the chain in the required order, all requests will get through the chain exactly as you planned.

 > When the set of handlers and their order are supposed to change at runtime, we can provide setters for a reference field inside the handler classes and then we can insert, remove or reorder handlers dynamically.

##### Problem
Suppose we are creating an online ordering system. We want to restrict access to the system to only those users who are either authenticated or who have administrative permissions to place the orders. For that we created an application which authenticates a user to the system whenever it receives a request that contains the user’s credentials, if the credentials aren’t correct and authentication fails, we fail the request then and there.

After some time, we added more of the functionalities to the application. We added an extra validation step to sanitize the data in a request. Then we added another check which could speed up the system by returning cached results on repeated requests containing the same data.

Now the code becomes cumbersome, looks like a mess and expensive to maintain, becoming more and more bloated as we added each new feature. Changing one check sometimes affected the others. Worst of all, when we tried to reuse the checks to protect other components of the system, we had to duplicate some of the code since those components required some of the checks, but not all of them.

##### Solution
Like many other behavioral design patterns, the Chain of Responsibility relies on transforming particular behaviors into stand-alone objects called handlers. In this case, each check should be extracted to its own class with a single method that performs the check. The request, along with its data, is passed to this method as an argument.

The CoR pattern suggests that you link these handlers into a chain. Each linked handler has a field for storing a reference to the next handler in the chain. In addition to processing a request, handlers pass the request further along the chain. The request travels along the chain until all handlers have had a chance to process it. A handler can decide not to pass the request further down the chain and effectively stop any further processing.


In this example with ordering systems, a handler performs the processing and then decides whether to pass the request further down the chain. Assuming the request contains the right data, all the handlers can execute their primary behavior, whether it’s authentication checks or caching.

##### Example

The Chain of Responsibility pattern avoids coupling the sender of a request to the receiver by giving more than one object a chance to handle the request. ATMs use the Chain of Responsibility in money giving mechanism.

##### Implementation
#

```sh
public class Currency {
	private int amount;
	public Currency(int amt){ this.amount=amt; }
	public int getAmount(){
		return this.amount;
	}
}

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency cur);
}

public class Dollar50Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 50){
			int num = cur.getAmount()/50;
			int remainder = cur.getAmount() % 50;
			System.out.println("Dispensing "+num+" 50$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}
}

public class Dollar20Dispenser implements DispenseChain{
	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain=nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if(cur.getAmount() >= 20){
			int num = cur.getAmount()/20;
			int remainder = cur.getAmount() % 20;
			System.out.println("Dispensing "+num+" 20$ note");
			if(remainder !=0) this.chain.dispense(new Currency(remainder));
		}else{
			this.chain.dispense(cur);
		}
	}
}

public class ATMDispenseChain {
	private DispenseChain c1;
	public ATMDispenseChain() {
		// initialize the chain
		this.c1 = new Dollar50Dispenser();
		DispenseChain c2 = new Dollar20Dispenser();
		c1.setNextChain(c2);
		c2.setNextChain(c3);
    }

	public static void main(String[] args) {
		ATMDispenseChain atmDispenser = new ATMDispenseChain();
		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			Scanner input = new Scanner(System.in);
			amount = input.nextInt();
			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				return;
			}
			// process the request
			atmDispenser.c1.dispense(new Currency(amount));
		}
	}
}
```

##### Implementation Checklist

- The base class maintains a "next" pointer.
- Each derived class implements its contribution for handling the request.
- If the request needs to be "passed on", then the derived class "calls back" to the base class, which delegates to the "next" pointer.
- The client (or some third party) creates and links the chain (which may include a link from the last node to the root node).
- The client "launches and leaves" each request with the root of the chain.

##### N.B.

- CoR follows Single Responsibility Principle, i.e. we can decouple classes that invoke operations(sender) from classes that perform operations(receiver).
- CoR follows Open/Closed Principle, i.e. we can introduce new handlers into the app without breaking the existing client code.
- CoR is often used in conjunction with Composite Design Patterns. When a child component gets a request, it may pass it through the chain of all of the parent components down to the root of the object tree.
- CoR can use Command to represent requests as objects. we can execute the same operation in a series of different contexts linked into a chain.
