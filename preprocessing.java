/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arm.apriori.core;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author mobntic
 */
public class preprocessing {
    List<event> ListEvents = new ArrayList<event>();
public void format()
throws IOException, ParseException { {
BufferedReader lecteurAvecBuffer = null;
		String ligne;
               

		try {
			/*** L'ouvertuure du benchmark ***/
lecteurAvecBuffer = new BufferedReader(new FileReader("C:\\Users\\mobntic\\Desktop\\abir\\ProcessMining\\instances\\real\\production\\ProductionData.txt"));
//lecteurAvecBuffer = new BufferedReader(new FileReader("C:\\Users\\mobntic\\Desktop\\abir\\ProcessMining\\instances\\synthetic\\disco\\PurchasingExample\\PurchasingExample.txt"));
// lecteurAvecBuffer= new BufferedReader(new FileReader("C:\\Users\\mobntic\\Desktop\\abir\\ProcessMining\\instances\\real\\spaghetti\\Hospital.txt"));
//lecteurAvecBuffer = new BufferedReader(new FileReader("C:\\Users\\mobntic\\Desktop\\abir\\ProcessMining\\instances\\real\\Lasagna\\RFP.txt"));
                } catch
                        (FileNotFoundException exc) {
			System.out.println("Erreur d'ouverture");
		}

		int i = 0;
                int j=5;
		String str[];
		/*** La recupèration du fichier ligne par ligne ***/
		while ((ligne = lecteurAvecBuffer.readLine()) != null) {
			// System.out.println(" " + i);
			// System.out.println(ligne)
				// decomposée la ligne par rapport a l'espace pour avoir les
				// diffèrentes partie
				str = ligne.split(",");

                               event e=new event();
                               e.CaseID=str[0];
                               e.Activity=str[1];
                               e.Ressource=str[2];
                               e.StartTimeStamp=str[3];
                               e.EndTimeStamp=str[4];

                                //e.type=str[5];
                               // only for the production
                                  e.span=str[5];
                                  e.work=str[6];
                                  e.part=str[7];
                                  e.WorkerID=str[8];
                                  e.Report=str[9];
                                  e.QtyCompleted=str[10];
                                  e.QtyRejected=str[11];
                                  e.QtyMRB=str[12];
                                  //e.Rework=str[13];

                              Calendar mydate1 = new GregorianCalendar();
                              Calendar mydate2 = new GregorianCalendar();
                              //DateFormat format = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
                           //  DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+'Z", Locale.ENGLISH);
                              DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss", Locale.ENGLISH);
                              Date date1 = format.parse(e.StartTimeStamp);
                              Date date2 = format.parse(e.EndTimeStamp);
                             mydate1.setTime(date1);
                              mydate2.setTime(date2);
                              e.Duration=(mydate2.getTimeInMillis()-mydate1.getTimeInMillis())/1000;
                              int x=mydate1.get(Calendar.MONTH);
                             // Random r =new Random();
                              //int x=r.nextInt(13);
                              switch (x) {
            case 0:  e.TimeOfYear ="First Quarter";
                     break;
            case 1:  e.TimeOfYear = "First Quarter";
                     break;
            case 2:  e.TimeOfYear = "First Quarter";
                     break;
            case 3:  e.TimeOfYear = "Second Quarter";
                     break;
            case 4:  e.TimeOfYear = "Second Quarter";
                     break;
            case 5:  e.TimeOfYear = "Second Quarter";
                     break;
            case 6:  e.TimeOfYear = "Third Quarter";
                     break;
            case 7:  e.TimeOfYear = "Third Quarter";
                     break;
            case 8:  e.TimeOfYear = "Third Quarter";
                     break;
            case 9:  e.TimeOfYear = "Fourth Quarter";
                     break;
            case 10: e.TimeOfYear = "Fourth Quarter";
                     break;
            case 11: e.TimeOfYear = "Fourth Quarter";
                     break;
            default: e.TimeOfYear = "Invalid month";
                     break;
        }

                           //   System.out.println(e.StartTimeStamp+ "le mois est"+x);
                             // System.out.println(mydate2.getTime()+" "+mydate1.getTime()+" "+e.Duration);
                              //System.out.println(mydate2.getTime());
				/*for (int j = 1; j < str.length; j++) {
					//produit = Integer.parseInt(str[j]);
					System.out.print(str[j]+ "  ");

                                        ListEvents.add();
				}*/
                                ListEvents.add(e);

                               //

			i++;
    }

		lecteurAvecBuffer.close();

 /*for (int j = 0; j < ListEvents.size(); j++) {
					//produit = Integer.parseInt(str[j]);
System.out.print(ListEvents.get(j).CaseID+ "  "+ListEvents.get(j).Activity+ " "+
        ListEvents.get(j).Ressource+ " " +ListEvents.get(j).StartTimeStamp+ " "+
        ListEvents.get(j).EndTimeStamp + " "+ ListEvents.get(j).Duration);
                                        System.out.println();
				}
*/
    }
    }}

