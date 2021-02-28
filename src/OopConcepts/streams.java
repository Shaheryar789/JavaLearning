package OopConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class streams {

	public static void main(String[] args) {

/* using Streams APIs we can perform different operations on data collections with optimize code.
	 it also uses lambda --> arrow operator
							Left side is the parameter which can also be empty and right side specifies the action of the mabda expression.
	
	Three step to perform:	
		 1- create a stream by converting collection to 		.stream
		 2-  perform any number of intermediate Operations	.filetr  .map  . sort  . distinct .limit etc
		 3- perform terimal operation 						.foreach  .collect   .reduce
*/
		
		ArrayList<String> AL  = new ArrayList<String> ();
		
		AL.add("Ali"); AL.add("Aamir"); AL.add("Salman");
		
		for (int i=0; i<AL.size(); i++)
		{
			System.out.println(AL.get(i));
		}
		
		
		// use cany combination of following to get desired results from Stream
		
		// using Streams : simple print
		
		AL.stream().forEach(S-> System.out.println(S));
		
		// sort and then print
		
		AL.stream().sorted().forEach(S-> System.out.println("sort and print: " +S));
		
		// filter 
		
		AL.stream().filter(s-> s.startsWith("A")).forEach(S-> System.out.println("Filter: "+S));
		
		//  limit result
		
        AL.stream().limit(1).sorted().forEach(S-> System.out.println("limit: "+S));
        
        // only certain length of string
		
        AL.stream().filter(s->s.length()<4).forEach(S-> System.out.println("Length limit: "+S));
        
        // Distinct values means no duplicates
        List <Integer> I = Arrays.asList(4,4,2,2,3,3,1);
               
        I.stream().distinct().sorted().forEach(s->System.out.println("remove duplicate and sort: "+s));
        
		// In Java 8, stream().map() lets you convert an object to something else.
        // u can use map when you need modification after you filter resilts
        
        AL.stream().filter(s->s.length()<4).map(s->s.toLowerCase()).forEach(s-> System.out.println("map with lower case: "+s));
		
		// concat 2 or more streams
        
        List <String> A = Arrays.asList("Rizwan","Munir");
        List <String> B = Arrays.asList("Nabbel","Umer");
        Stream <String> CStream=  Stream.concat (A.stream(),B.stream());
        
        CStream.sorted().forEach(S-> System.out.println("Concated streams: "+ S));
        
        // return true or false using match
        
    //  boolean flag =   CStream.anyMatch(s->s.equalsIgnoreCase("umer"));
     // return flag;  it will show true or false
        // also can use this to mark test case pass or fail:  Assert.assertTrue(flag);
        
        
        
        // Stream Collect : is used to change list into stream , do operation and then convert back to List again
        // u need to then store in list variable and then print it 
        
        
        List <String> L = A.stream().sorted().collect(Collectors.toList());
        
        System.out.println(L);
        
        L.stream().forEach(s->System.out.println("Print new collect list: "+s));
        
        
 
        
	}

}
