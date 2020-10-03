import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NeoxLookup
{

	public static void files() throws IOException
	{
		//String dirName = "/Users/cisne/Desktop/Misc";
			Files.newDirectoryStream(Paths.get("."),
        	path -> path.toString().endsWith(".txt"))
            .forEach(System.out::println);
	}
	
	public static void readFiles(String name) throws IOException
	{	

		String fileName = "./" + name + "_Smirnoff.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null)
		{
			//process the line
			System.out.println(line);
		}	

	}
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		String input = null;
		boolean quit = false;
		
		System.out.println("\n" + 
				" __          __  _                            _          _   _                   _____ _ _         \n" + 
				" \\ \\        / / | |                          | |        | \\ | |                 / ____(_) |        \n" + 
				"  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___   |  \\| | ___  _____  __ | |     _| |_ _   _ \n" + 
				"   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | . ` |/ _ \\/ _ \\ \\/ / | |    | | __| | | |\n" + 
				"    \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |\\  |  __/ (_) >  <  | |____| | |_| |_| |\n" + 
				"     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_| \\_|\\___|\\___/_/\\_\\  \\_____|_|\\__|\\__, |\n" + 
				"                                                                                              __/ |\n" + 
				"                                                                                             |___/ \n" + 
				"");
		System.out.println("\n" + 
				"   _____ _ _   _                 _                 _                \n" + 
				"  / ____(_) | (_)               | |               | |               \n" + 
				" | |     _| |_ _ _______ _ __   | |     ___   ___ | | ___   _ _ __  \n" + 
				" | |    | | __| |_  / _ \\ '_ \\  | |    / _ \\ / _ \\| |/ / | | | '_ \\ \n" + 
				" | |____| | |_| |/ /  __/ | | | | |___| (_) | (_) |   <| |_| | |_) |\n" + 
				"  \\_____|_|\\__|_/___\\___|_| |_| |______\\___/ \\___/|_|\\_\\\\__,_| .__/ \n" + 
				"                                                             | |    \n" + 
				"                                                             |_|    \n" + 
				"");
		
		try
		{
		    Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		
		System.out.println("Let us start by looking up by surname. What surname would you like to look up?");
		input = scan.nextLine();
		
		if(input.equalsIgnoreCase("smirnoff"))
			
		{
			try
			{
				for(int i = 0; i < 10; i++)
				{
					Thread.sleep(1000);
				    System.out.print(". ");
				}
				System.out.println();
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			
			try 
			{
				files();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			while(quit == false)
			{
				System.out.println("Please enter the first name of the person whose file you would like to read.");
				input  = scan.nextLine();
				
				try 
				{
					try
					{
						for(int i = 0; i < 10; i++)
						{
							Thread.sleep(1000);
						    System.out.print(". ");
						}
						System.out.println();
						System.out.println();
					}
					catch(InterruptedException ex)
					{
					    Thread.currentThread().interrupt();
					}
					
					readFiles(input);
				} 
				catch (IOException e) 
				{
					System.err.println("404: FILE NOT FOUND");

				}
				
				System.out.println("Would you like to look up another person under this surname?");
				input = scan.nextLine();
				
				if(input.equalsIgnoreCase("n"))
					quit = true;
			}
		}
		
		else
			System.err.println("404: FILE NOT FOUND");

	}

}
