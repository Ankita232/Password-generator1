import java.util.Scanner;
public class Generator {
	Alphabet alphabet;
	public static Scanner keyboard;
	public Generator(Scanner scanner) {
		keyboard=scanner;
	}
	public Generator(boolean IncludeUpper,boolean IncludeLower,boolean IncludeNum, boolean IncludeSym) {
		alphabet=new Alphabet(IncludeUpper,IncludeLower, IncludeNum, IncludeSym);
		
	}
	public void mainLoop() {
		System.out.println("welcome to password Services");
		printMenu();
		String UserOption="-1";
		while(!UserOption.equals("4")) {
			UserOption=keyboard.next();
			switch (UserOption) {
			case "1": {
				
				requestPassword();
				printMenu();
			break;
			}
			case "2": {
				
				checkPassword();
				printMenu();
				break;
			}
			case "3": {
				
				printUsefulInfo();
				printMenu();
			break;
			}
			case "4": {
				
				
				printQuitMessage();
				break;
			}
			
			default:
			{
				//System.out.println();
				System.out.print("kindly select one of the available option");
				printMenu();
			}
			}
		}
		
	}
	 private void printMenu() {
	        //System.out.println();
	        System.out.println("Enter 1 - Password Generator");
	        System.out.println("Enter 2 - Password Strength Check");
	        System.out.println("Enter 3 - Useful Information");
	        System.out.println("Enter 4 - Quit");
	        System.out.print("Choice:");

	    }
	 private void printUsefulInfo() {
	        System.out.println();
	        System.out.println("Password must contain at least 1 uppercase letter,1 lowercase letter,1 Symbol And 1 number");
	        System.out.println("Password must contain at least 8 character");

	    }
	 private void requestPassword() {
	        boolean IncludeUpper = false;
	        boolean IncludeLower = false;
	        boolean IncludeNum = false;
	        boolean IncludeSym = false;

	        boolean correctParams = false;

	        System.out.println();
	        System.out.println("Hello, welcome to the Password Generator :) answer"
	                + " the following questions by Yes or No \n");

	        do {
	            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
	            String input = keyboard.next();

	            if (isInclude(input)) IncludeLower = true;{

	            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
	            input = keyboard.next();
	            }
	            if (isInclude(input)) IncludeUpper = true;

	            {System.out.println("Do you want Numbers \"1234...\" to be used? ");
	            input = keyboard.next();}

	            if (isInclude(input)) IncludeNum = true;

	            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
	            input = keyboard.next();

	            if (isInclude(input)) IncludeSym = true;

	            //No Pool Selected
	            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
	                System.out.println("You have selected no characters to generate your " +
	                        "password at least one of your answers should be Yes");
	                correctParams = true;
	               
	            }

	            System.out.println("Great! Now enter the length of the password");
	            int length = keyboard.nextInt();

	            final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
	            final Password password = generator.GeneratePassword(length);

	            System.out.println("Your generated password -> " + password);

	        } while (correctParams);
	    }

	 private void checkPassword() {
	        String Input;
	        String calculateScore;
	        final Scanner in = new Scanner(System.in);

	        System.out.print("\nEnter your password:");
	        Input = in.nextLine();

	        final Password p = new Password(Input);
	
	        System.out.println(p.calculateScore11());
	
	       // in.close();
	    }

	private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }
	
	
    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (!Input.equalsIgnoreCase("no")) {
               
            	PasswordRequestError();
            }
            return false;
        }
    }

    
   
   

    private void PasswordRequestError() {
		// TODO Auto-generated method stub
		
	}
	private void printQuitMessage() {
        System.out.println("Closing the program bye bye!");
    }
	
}
