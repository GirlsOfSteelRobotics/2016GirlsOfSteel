
public class IceCreamExample {
	public static void main(String[] args) {
		int icecreamScoops = Integer.parseInt(args[0]);
		if (icecreamScoops>10) 
		{
			System.out.println("Very very very Happy"); 
		} else if (icecreamScoops==10) {
			System.out.println("really happy"); 
		}
		else if (icecreamScoops<=9 && icecreamScoops>=5) {
			System.out.println("Sad");
		} else {
			System.out.println("Super Sad");
		}

	}
}
