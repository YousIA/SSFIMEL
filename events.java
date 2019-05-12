/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arm.apriori.core;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author mobntic
 */




public class events extends CsvSource {
String[][] TabEvents=new String[150][20];
    List<String> att = new ArrayList<String>();
    boolean[][] transactions=new boolean[150][30];
    int nb=0;
    void open() throws IOException
    {
    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {


        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document document= builder.parse(new File("C:\\Users\\mobntic\\Desktop\\abir\\ProcessMining\\exemple1.xml"));
        //System.out.println("*************PROLOGUE************");
        //System.out.println("version : " + document.getXmlVersion());
        //System.out.println("encodage : " + document.getXmlEncoding());
        //System.out.println("standalone : " + document.getXmlStandalone());
        final Element racine = document.getDocumentElement();
       // System.out.println("\n*************RACINE************");
        //System.out.println(racine.getNodeName());
        final NodeList racineNoeuds = racine.getChildNodes();
        final int nbRacineNoeuds = racineNoeuds.getLength();
        for (int i = 0; i<nbRacineNoeuds; i++) {
            if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
                final Element trace = (Element) racineNoeuds.item(i);
              //System.out.println("***************trace number ****"+ i);
         //  System.out.println("key : " + personne.getAttribute("key"));
                final NodeList events = trace.getElementsByTagName("event");
                final int nbeventsElements = events.getLength();
                //System.out.println("number of events is: "+ nbeventsElements);
                //System.out.println("number of events is: "+ events.item(0).getChildNodes());
                 //final NodeList e=events.item(0).getChildNodes();
                //System.out.println("the name of node is: "+ e.item(0).getLocalName());
                for (int j=0; j<nbeventsElements; j++)
                {
                //System.out.println("events number "+ nb);

                //if(events.item(j).getNodeType() == Node.ELEMENT_NODE) {
                final Element event = (Element) events.item(j);
                final NodeList dates = event.getElementsByTagName("date");
                final int nbdatesElements = dates.getLength();
                //System.out.println("number of dates is: "+ nbdatesElements);
                int k;
                //System.out.println(nbdatesElements);
                for(k = 0; k<nbdatesElements; k++) {
                final Element date = (Element) dates.item(k);
                //System.out.print(date.getAttribute("key") + " " +date.getAttribute("value")+" ");
                //TabEvents[i][k]=new String();
                TabEvents[nb][k]=date.getAttribute("value");
               // System.out.print(TabEvents[i][k]+" ");
                                                        }
                final NodeList string1 = event.getElementsByTagName("string");
                final int nbstringElements = string1.getLength();
                //System.out.println("number of strings is: "+ nbstringElements);
                //System.out.println(nbstringElements);
                for(int s = 0; s<nbstringElements; s++) {
                final Element text1 = (Element) string1.item(s);
                //System.out.print(text1.getAttribute("key") +" "+text1.getAttribute("value")+ " ");
                TabEvents[nb][s+k]=text1.getAttribute("value");
                //System.out.print(TabEvents[i][s+k]+" ");

                //System.out.print(text1.getAttribute("value")+ " ");
                                                           }
                nb++;
                 //System.out.println();
                }

            }

        }

        }

        catch (final ParserConfigurationException e) {

            e.printStackTrace();

        }


       catch (final SAXException e) {

           e.printStackTrace();
            }


        }
 /****************************************************/
  List<String> TransString()
    {

List<String> s = new ArrayList<String>();
 for (int i=0;i<nb;i++ )
   {
     s.add(TabEvents[i][0]+","+ TabEvents[i][1]+"," +TabEvents[i][2]+ ","+ TabEvents[i][3]);
   }


return s;
    }

/***************************************************/
void displaysTabEvents()
{

   System.out.println("Number of events is "+nb);
   for (int i=0;i<nb;i++ )
   {
   System.out.print("event "+ i +": "+TabEvents[i][0]+" "+ TabEvents[i][1]+  " " +TabEvents[i][2]+ " "+ TabEvents[i][3]);
   System.out.println();
   }

}
/*********************************************/

void CreateIndex()
{

    for (int i=0;i<nb; i++)
    {
     for (int j=0;j<30; j++)
     {
     transactions[i][j]=false;
     }

    }

    for (int i=0; i<nb; i++)
    {
      for (int j=0; j<4; j++)
       {
        boolean exist=false;
        String s=TabEvents[i][j];

        for (int k=0;k<att.size() && exist==false; k++)
        {
        String l=att.get(k);
           if (l.compareTo(s)==0)
            {
            exist=true;
            transactions[i][k]=true;
            }
        }
        if (exist==false)
        {
        att.add(s);
        transactions[i][att.size()]=true;
        }
      }

    }
}
/************************************************/
void DispalyIndex()
{
    for (int i=0;i<att.size(); i++)
    {
    System.out.println(i+": "+ att.get(i));
    }
}
/******************************************************/

void DispalyTransactions()
{
    for (int i=0;i<nb; i++)
    {
       for (int j=0;j<att.size(); j++)
       {
    System.out.print(transactions[i][j]+" ");

       }
        System.out.println();
    }
}
		@Override
	public List<Itemset> generate() {
        /*try {
            open();
        } catch (IOException ex) {
            Logger.getLogger(events.class.getName()).log(Level.SEVERE, null, ex);
        }*/
           preprocessing p=new preprocessing();
        try {
            p.format();
        } catch (IOException ex) {
            Logger.getLogger(events.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(events.class.getName()).log(Level.SEVERE, null, ex);
        }

            List<String> sources = new ArrayList<String>();
		
			int i=0;
                        String s;
			while (i<p.ListEvents.size()){
                            s="";
                            /*
 s = s + "," + p.ListEvents.get(i).Activity + "," + p.ListEvents.get(i).Ressource + ","+p.ListEvents.get(i).StartTimeStamp + ","+
         p.ListEvents.get(i).EndTimeStamp + ","+p.ListEvents.get(i).Duration+ "," +p.ListEvents.get(i).TimeOfYear;
				*/

                            // only for the production
                            s = s + "," + p.ListEvents.get(i).Activity + "," + p.ListEvents.get(i).Ressource + ","+p.ListEvents.get(i).StartTimeStamp + ","+
         p.ListEvents.get(i).EndTimeStamp + ","+p.ListEvents.get(i).Duration+ "," +p.ListEvents.get(i).TimeOfYear+"," +p.ListEvents.get(i).span
                                    +"," +p.ListEvents.get(i).work+ "," +p.ListEvents.get(i).part+"," +p.ListEvents.get(i).WorkerID
                                    +"," +p.ListEvents.get(i).Report+ "," +p.ListEvents.get(i).QtyCompleted+"," +p.ListEvents.get(i).QtyRejected
                                    +"," +p.ListEvents.get(i).QtyMRB;


                                    sources.add(s);
                              i++;
			}
	
		return fromCsvStrings(sources);
	}
}
