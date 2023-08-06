import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class numberException extends Exception{
	public numberException()
	{
		super();
	}
}
public class fileWrite {

	
	public static void main(String[] args) throws IOException, numberException {
		Scanner scan = new Scanner(System.in);
		
	
		System.out.println("Enter the String to be written to the file.Enter exit to stop reading to complete reading");
		int i=0,j=0;
		String input;

		BufferedWriter writeAlpha = null ;
		BufferedWriter writeConsonants = null ;
		BufferedWriter writeVowels = null ;
		
		File fileAlpha = new File("alphabet.txt");
		try {
        writeAlpha = new BufferedWriter(new FileWriter(fileAlpha));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
		while(!(input=scan.nextLine()).equalsIgnoreCase("exit"))
		{
			writeAlpha.write(input);
			writeAlpha.newLine();
		}

		writeAlpha.close();
        scan.close();
        System.out.println("Writing successful");
		
        File fileConsonants = new File("consonants.txt");
        File fileVowels = new File("vowels.txt");
        writeConsonants = new BufferedWriter(new FileWriter(fileConsonants));
        writeVowels= new BufferedWriter(new FileWriter(fileVowels));
        
        BufferedReader readAlpha = new BufferedReader(new FileReader(fileAlpha));
        while((input=readAlpha.readLine())!=null)
        {	
        	i=0;
        	char ch;
        	for(i=0;i<input.length();i++)
        	{
        		ch=input.charAt(i);
        		if(ch==' ')continue;
        		else
        		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
        		{
        			writeVowels.write(ch);
        			writeVowels.newLine();
        		}
        		else
        		if(ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9')
        			try{throw new numberException();}
        		catch(numberException e)
        		{
        			System.out.println("Number encountered");
        		}
        		else
        		{
        			writeConsonants.write(ch);
        			writeConsonants.newLine();
        		}
        	}
        	
        }
        writeVowels.close();
		writeConsonants.close();
	}

}
