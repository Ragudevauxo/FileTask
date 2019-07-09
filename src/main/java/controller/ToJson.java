package controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ToJson {

	
	
	public static String returnWord(String pattern,String path) throws Exception
	{
		String temp="";
		String fileName = path;
		File file=new File(fileName);
		String s="";
		
		FileReader fr=new FileReader(file);
		BufferedReader  br=new BufferedReader(fr);
		while((s=br.readLine())!=null)
 		{
			
 			String v=s;
 			int size=pattern.length();
 	     		 Pattern p = Pattern.compile(pattern);
 	     	    Matcher m = p.matcher(s);
 	     	    if(m.find())
 	     	    {
 	     	    	 return s;
 	     	    }
 	     	   
 				
 			}		
		return temp;
 		}
	public static String delimiter(String str)
	{
		StringTokenizer st=new StringTokenizer(str,":");
		st.nextToken();
		return st.nextToken();
	}
		
	//"D:\\sample1.txt"


		public  String[] toJson(String path) throws Exception
		{
		
			
			String s="";
			String result[]=new String[6];
     		String arr[]= {"Name:","Street Name:","City:","Postal Code:","Phone:","Email Address:"};
     		
     		for(int i=0;i<arr.length;i++)
     		{
     			result[i]=delimiter(returnWord(arr[i],path));
     			System.out.println();
     			if(result[i]=="")
     			{
     				result[i]=delimiter(returnWord("Mail:",path));
     				//result[i]=result[i].substring(10,result[i].length());
     			}
     		}
     		//System.out.print(Arrays.deepToString(result));
     		//FileUploadController fl=new FileUploadController();
     		//fl.setValue(result);
     		return result;
			
		}
		
}
