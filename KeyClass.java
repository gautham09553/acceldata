import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class KeyClass {

	public static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		File fout = new File();
//		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\GK186019\\projects\\Test1\\src\\main\\java\\input.txt",true));
	      
	      try { 
	    	  BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\GK186019\\projects\\Test1\\src\\main\\java\\input.txt"));	    	  
	    	  String c = null;
			  while ((c = br.readLine()) != null) {
	    		  String str[] = c.split(" ");
	    		  if (str[0].equals("post") || str[0].equals("put"))
	    			  map.put(str[1],str[2]);
	    		  else if (str[0].equals("del")) {
	    			  map.remove(str[1]);
	    		  }
	    		  
	    	  }
	      }
		  catch(Exception e) {
			  System.out.println("check issue while loading "+ e);				  
		  }
	      try {		      
	    	  int input = 0;
		      while (input != -1) {
		    	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    	  System.out.println("0: Post Operation");
		    	  System.out.println("1: PUT Operation");
		    	  System.out.println("2: DEL Operation");
		    	  System.out.println("3: GET Operation");
		    	  input = Integer.parseInt(br.readLine());
		    	  String key  =null, value =null, operation = null;
		    	  switch(input) {
		    	  case 0:   key = br.readLine().trim();
		    	  			value = br.readLine().trim();
		    	  			operation = "post " + key + " " + value; 
		    	  			bw.append(operation);
		    	  			bw.newLine();
		    	  			doPost(key,value);
		    	  			break;
		    	  case 1:   key = br.readLine().trim();
			  	  			value = br.readLine().trim();
			  	  			operation = "put " + key + " " + value; 
			  	  			bw.append(operation);
			  	  			bw.newLine();
			  	  			doPut(key,value);
			  	  			break;
		    	  case 2: 	key = br.readLine().trim();
			  	  			operation = "del " + key; 
			  	  			bw.append(operation);
			  	  			bw.newLine();
			  	  			doDelete(key);
			  	  			break;
		    	  case 3: 	key = br.readLine().trim();
			  	  			System.out.println(doGet(key));
			  	  			break;
		    	  }
		      }	    	  
	      } catch (Exception e) {
	    	  System.out.println(e);
	      } finally {
	    	  bw.close();
	      }
	 	}

	public static void doPost(String key, String value) {
		map.put(key, value);
	}

	public static String doGet(String key) {
		return map.get(key);
	}

	public static void doDelete(String key) {
		if (map.containsKey(key))
			map.remove(key);
	}

	public static void doPut(String key, String value) {
		if (map.containsKey(key)) {
			map.put(key, value);
		}
	}

}
