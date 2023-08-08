import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class primeFile {
	 static int noEle=10;
	public static void main(String[] args)throws IOException {
		File file = new File("numbers.txt");
		int ele;
		int[] arr = new int[noEle];
		String Element = new String();
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Random random = new Random();
		for(int i=0;i<noEle;i++)
		{
			ele = random.nextInt(1000);
			writer.write(Integer.toString(ele));
			writer.newLine();
		}
		writer.close();
		for(int i=0;i<noEle;i++)
		{
			Element=reader.readLine();
			ele=Integer.parseInt(Element);
			arr[i]=ele;
		}
		System.out.println("Genereated succesfully");
		for(int i=0;i<noEle;i++)
		{
			int k=2;
			boolean flag=false;
			while(k<arr[i]/2)
			{
				if(arr[i]%k==0)
				{
					flag=true;
					break;
				}
				k++;
			}
			if(flag)
				System.out.println(arr[i]+" true");
			else
				System.out.println(arr[i]+" false");
		}
	}

}
