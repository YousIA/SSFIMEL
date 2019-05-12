/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arm.apriori.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mobntic
 */
public class NewClass {
      
  public static void main(String[] args) {
        // TODO code application logic here

 List<Itemset> R=new ArrayList<Itemset>();

AprioriAlgorithm algorithm = new AprioriAlgorithm();
    int sup=10;
int conf=1;
//SSFIM algorithm =new SSFIM();
//GAApriori algorithm =new GAApriori();
//TransactionSource source;
events source =new events();
algorithm.setSource(source);
algorithm.getTransactions();
//algorithm.main_process(); // just for GAApriori
//long startTime = System.currentTimeMillis();
 //      algorithm.Generate(); // just for SSFIM
  //long endTime   = System.currentTimeMillis();
//long totalTime = (endTime - startTime)/1000;
//System.out.println(totalTime +"Sec");
String s;
R=algorithm.run(sup, conf);

/*for (int i=0;i<R.size();i++)
{
s=algorithm.Freq.get(i).toString();
System.out.println(s);
}
 */

for (int i=1;i<=100;i++)
{
      long startTime = System.currentTimeMillis();
       R=algorithm.run(i, conf);
       long endTime   = System.currentTimeMillis();
float totalTime = (float)(endTime - startTime)/1000;
System.out.println("Supp is "+i+ "  Runtime of Apriori (Sec) is "+ totalTime +  "  Number of frequent Itemsets is "+algorithm.Freq.size());
algorithm.Freq.clear();
}
/*
			for (int i = 0; i < R.size(); ++i) {

				Itemset r=R.get(i);
         // System.out.println(r.getPremise().toString()+""+r.getConclusion().toString()+"  "+r.getSupport()+ " "+r.getRelativeSupport()+" "+r.getConfidence());
                                System.out.println(r.toString());
	                                   }*/
/*
       long startTime = System.currentTimeMillis();
       int cost=algorithm.FirstStrategy();
       //algorithm.SecondStrategy();
         long endTime   = System.currentTimeMillis();
float totalTime = (float)(endTime - startTime)/1000;
//System.out.println("time for the first strategy is "+totalTime +"Sec");


//float x=(float)cost/algorithm.transactions.size();
//System.out.println("Coverage rate  "+ x+"  NFIs "+algorithm.Freq.size()+ "  NumberCoveredTrans "+cost+"  M "+algorithm.transactions.size());


System.out.println("*********Second strategy**********************");
algorithm.SecondStrategy(2);
System.out.println("*****Specific trends*****");
for (int i=0;i< algorithm.Specific.size();i++)
         {
String ss=algorithm.Specific.get(i).toString();
         System.out.println(ss);

       }

System.out.println("*****General trends*****");
for (int i=0;i< algorithm.General.size();i++)
         {
String ss=algorithm.General.get(i).toString();
         System.out.println(ss);

       }
System.out.println("*********Third strategy*********************");
algorithm.grouping(algorithm.Freq, 3);


System.out.println("********Fourth strategy*********************");
algorithm.grouping(algorithm.Specific, 3);



/*
for (int i=0;i< 10;i++)
         {
startTime = System.currentTimeMillis();
algorithm.SecondStrategy(i);
endTime   = System.currentTimeMillis();
totalTime = (float)(endTime - startTime)/1000;
   float x1=(float)algorithm.Specific.size()/algorithm.Freq.size();
float x2=(float)algorithm.General.size()/algorithm.Freq.size();
System.out.println("*****the thereshold is "+ i);
System.out.println("Specific Rate is "+x1);
System.out.println("General Rate is "+x2);
System.out.println("time for the second  strategy is "+totalTime +"Sec");
     algorithm.Specific.clear();
     algorithm.General.clear();
      }

for (int i=1;i< 20;i++)
         {
startTime = System.currentTimeMillis();
algorithm.grouping(algorithm.Freq, i);
endTime   = System.currentTimeMillis();
totalTime = (float)(endTime - startTime)/1000;

System.out.println("*****the number of cluster is "+ i);
System.out.println("time for the time  strategy is "+totalTime +"Sec");
     
      }
*/
    }

  }
   
     
    
  

