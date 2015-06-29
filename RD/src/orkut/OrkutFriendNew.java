package orkut;



	import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

	public class OrkutFriendNew {

		public static void main(String[] args) {
			System.out.println(" starts "+new Date());
			Map<String, Integer> freq = new HashMap<String, Integer>();
		     BufferedReader br=null;
			try {
                InputStream is = new FileInputStream("com-orkut.ungraph.txt");
                 // create new input stream reader
                 InputStreamReader instrm = new InputStreamReader(is);
                 // Create the object of BufferedReader object
                  br = new BufferedReader(instrm); 
                 String strLine; 
                 // Read one line at a time 
                 while((strLine = br.readLine()) != null)
                 {    
                		String[] linesFile = strLine.split("\\s+");
     		           for(String l:linesFile){
     		           int count = freq.containsKey(l) ? freq.get(l) : 0;
     		           freq.put(l, count + 1);
     		           }
                 }
	 
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				//System.out.println("Input");
				//System.out.println(new Date());
				}
		     FileOutputStream fop = null;
				File file;
			
			
			/*output*/
			try {
                InputStream is = new FileInputStream("queries.txt");
                 // create new input stream reader
                file = new File("Result.txt");
    			fop = new FileOutputStream(file);

    			InputStreamReader instrm = new InputStreamReader(is);
              
                 // Create the object of BufferedReader object
                  br = new BufferedReader(instrm); 
                 String strLine; 
                 String content;
                 int count;
                 String[] linesFile;
                 byte[] contentInBytes;
                 // Read one line at a time 
                 while((strLine = br.readLine()) != null)
                 {    
                		 linesFile = strLine.split("\\s+");
                		
                		
     		           for(String l:linesFile){
     		        	
     		          count = freq.containsKey(l) ? freq.get(l) : 0;
     		          content = l+":"+count+"\n";
     		          contentInBytes = content.getBytes();
     				  fop.write(contentInBytes);
     				  fop.flush();
     				//fop.close();
     		           
     		           }
     		          
                 }
	 
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				
				//System.out.println("Output end"+new Date());
				System.out.println(" ends "+new Date());
				}
			
			}
	

	}
	



