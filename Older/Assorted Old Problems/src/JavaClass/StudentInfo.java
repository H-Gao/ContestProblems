package JavaClass;

import java.io.*;
import java.util.Scanner;

public class StudentInfo 
{
	public static void main(String[] args)
	{
		Double average;
		
		File file = new File("C:\\JavaFiles\\StudentInfo.txt");
		
		try{
		PrintWriter writer = new PrintWriter("C:\\JavaFiles\\Logs.txt");
		
		if (file.exists())
		{
			FileReader fileReader = new FileReader(file);
				
			Scanner scanner = new Scanner(fileReader);
			
			String[] info = scanner.next().split("_");
			
			Double savedAverage[] = new Double[(info.length)/7];
			
			for (int n = 0;n != info.length;n += 7)
			{
				average = (Double.parseDouble(info[n+3]) +  Double.parseDouble(info[n+4]) +  Double.parseDouble(info[n+5]) +  Double.parseDouble(info[n+6]))/4;
				savedAverage[n/7] = average;
				say("Name: " + info[n] + "\nAge: " + info[n + 1] + "\nGrade: " + info[n + 2] + "\nPeriod One Mark: " + info[n + 3] + "\nPeriod Two Mark: " + info[n + 4] + "\nPeriod Three Mark: " + info[n + 5] + "\nPeriod Four Mark: " + info[n + 6] + "\nMean Semester Mark: " + average + "\n", writer);
			}
			
			Double totalAverage = (double)0;
			
			for (int n = 0;n != savedAverage.length;++n)
				totalAverage += savedAverage[n];
			
			totalAverage/=savedAverage.length;
			
			say("The average course mark is " + totalAverage, writer);
			
			writer.close();
		}
	}catch(Exception exception)
	 {
		 System.out.println("We could not locate the file!");
		 exception.printStackTrace();
	 }
   }
	
	public static void say(String n, PrintWriter writer)
	{
		System.out.println(n);
		writer.print(n);
	}
}
