import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PalindromeChecker extends PApplet {

public void setup()
{
  String lines[] = loadStrings("palindromes.txt");
  println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      println(lines[i] + " IS a palidrome.");
    }
    else
    {
      println(lines[i] + " is NOT a palidrome.");
    }
  }
}
public boolean palindrome(String word)
{
  String editWord = "";
  String drow = "";
  for(int i = 0; i < word.length(); i++)
  {
    if((String)(word.substring(i,i+1)) != " " && (String)(word.substring(i,i+1)) != "," && (String)(word.substring(i,i+1)) != "!" && (String)(word.substring(i,i+1)) != "'")
    if(!((word.substring(i,i+1)).equals(" ")) && !((word.substring(i,i+1)).equals(",")) && !((word.substring(i,i+1)).equals("!")) && !((word.substring(i,i+1)).equals("'")))
    {
      editWord = editWord + (word.substring(i,i+1).toLowerCase());
    }
  }
  for(int i = editWord.length()-1; i >= 0; i--)
  {
    //if(((String)(editWord.substring(i,i+1)).equals(" ")) && ((String)(editWord.substring(i,i+1)).equals(",")) && ((String)(editWord.substring(i,i+1)).equals("!")) && ((String)(editWord.substring(i,i+1)).equals("'")))
    if(!((editWord.substring(i,i+1)).equals(" ")) && !((editWord.substring(i,i+1)).equals(",")) && !((editWord.substring(i,i+1)).equals("!")) && !((editWord.substring(i,i+1)).equals("'")))
    {
      drow = drow + (editWord.substring(i,i+1));
    }
  }
  //editWord.toLowerCase();
  println(drow+" is the reversal of "+editWord);
  if(editWord.equals(drow)){return true;}
  else{return false;}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PalindromeChecker" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
