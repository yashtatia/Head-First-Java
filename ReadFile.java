import java.io.*;

class ReadFile
{
    public static void main(String[] args)
    {
        try
        {
            File myFile=new File("MyText.txt");
            FileReader fileReader=new FileReader(myFile);
            
            BufferedReader br=new BufferedReader(fileReader);
            
            String line=null;
            //make a string variable to hold each line as the line is ead
            
            while((line=br.readLine())!=null)
            {
                System.out.println(line);
            }
            br.close();
        }catch(Exception ex){ex.printStackTrace();}
    }
}