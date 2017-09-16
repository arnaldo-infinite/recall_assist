/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author User
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        String sentence="Report to manager";
        sentence=sentence.toUpperCase();

        WordScorer obj = new WordScorer(sentence);
        obj.processData();
        int sentencescore = obj.gettotalscore();
        obj.processUnwantedData();
        
        int wordsscore = obj.gettotalscore();
        
        System.out.println(wordsscore);
        System.out.println(sentencescore);
        
        
        String temp = "2017-08-10-1";
        
        String str = temp.substring(temp.lastIndexOf('-') + 1);
        System.out.println(str);

        String Today="";
         
        DateManager dmanager = new DateManager();
        Today=dmanager.getToday();
        System.out.println(Today);
        
        
//        ByDay byday = new ByDay("2017-09-03-1");
//        
//        String [] Occurence=byday.getOccureDates();
//        
//        ByOneDay byoneday = new ByOneDay("2017-09-03-1", Occurence);
//        
//        double [] output = byoneday.getOutputs();
//
//        for (int i =0; i<output.length;i++)
//        {
//            System.out.println(output[i]);
//        }
//        
        
//        // **************************************************//
//        
//        ByDayy byday = new ByDayy("2017-09-04-2");
//        String [] Occurence=byday.getOccureDates();
//        int Occurance=byday.getOccurance();
//        String [] OccurArray = byday.getOccureDates();
//        float DayPredict = (float)Occurance*100/6;
//        
////---------------  ------------------------    -------------------------------------------
//        
//        ByOneDay byoneday = new ByOneDay("2017-09-04-2", OccurArray);
//        
//        double [] data1 =  byoneday.gettWS();
//        double [] data2 =  byoneday.gettWC();
//        double [] data3 =  byoneday.getOutputs();
//        
//        NNetwork net = new NNetwork(data1, data2, data3);
//        
//        double [] input1 = {870,588,678,1193};
//        double [] input2 = {3,2,2,3};
//        double predict1 = net.setPrediction(input1, input2);
//        
// //---------------  ------------------------    -------------------------------------------
//        
//        ByTwoDay bytwoday = new ByTwoDay("2017-09-04-2", OccurArray);
//        
//        double [] data11 =  bytwoday.gettWS();
//        double [] data22 =  bytwoday.gettWC();
//        double [] data33 =  bytwoday.getOutputs();
//        
//        NNetwork net2 = new NNetwork(data11, data22, data33);
//        
//        double predict2 = net2.setPrediction(input1, input2);
//
// //---------------  ------------------------    -------------------------------------------       
//        
//        System.out.println("Day Predit "+DayPredict);
//        System.out.println("DayOnePredict "+predict1);
//        System.out.println("DayTwoPredict "+predict2);
//        
//        DecimalFormat df=new DecimalFormat("0.00");
//        
//        double totalpercentage = Math.round((DayPredict+predict1+predict2)/3)*100/100;
//        
//        System.out.println("\nTotal Percentage "+totalpercentage+"%");
//
//        Calendar cal=Calendar.getInstance();
//        System.out.println(new SimpleDateFormat("EEE").format(cal.getTime()));
    }
    
}
