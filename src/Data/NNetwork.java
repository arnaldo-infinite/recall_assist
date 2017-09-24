/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.Random;

/**
 *
 * @author User
 */
public class NNetwork 
{
    private double [] data1;
    private double [] data2;
    private double [] data3;
    
    private double w1;
    private double w2;
    private double b;
    
    public NNetwork (double [] data1, double [] data2, double [] data3)
    {
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
        
        train();
    }
    
    public NNetwork ()
    {
    
    }
    
    private void train()
    {
        Random rand = new Random();
        
        w1 = rand.nextDouble();
        w2 = rand.nextDouble();
        b = rand.nextDouble();
        double lrate = 0.2;
        
        for(int i = 0;i<50000;i++)
        {
          double r = rand.nextDouble(); //pick random point
          r=r*data1.length;
          int random = (int)r;
          double target = data3[random];    //target stored in data3
           
          
          double wsum = w1 * data1[random] + w2 * data2[random] + b;
          double predict1 = sigmoid(wsum);  //activate function
          
          
         // double cost = (predict1-target) * (predict1-target);
          
          
          double dcost_dpred = 2 * (predict1-target); // power rule
          
          double dpred_dwsum = sigmoid(wsum) * (1-sigmoid(wsum));  
          
          double dwsum_dw1 = data1[random];
          double dwsum_dw2 = data2[random];
          double dwsum_db = 1;
            
          double dcost_dw1 = dcost_dpred * dpred_dwsum * dwsum_dw1;
          double dcost_dw2 = dcost_dpred * dpred_dwsum * dwsum_dw2;
          double dcost_db = dcost_dpred * dpred_dwsum * dwsum_db;
          
          w1 -= lrate * dcost_dw1;
          w2 -= lrate * dcost_dw2;
          b -= lrate * dcost_db;
        }
        System.out.println("W1: "+w1+" W2: "+w2+" b "+b);
    }
    
    private static double sigmoid(double x)
    {
    return 1 / (1 + Math.exp(-x));
    }
    
    public double setPrediction(double [] input1, double [] input2)
    {
        int count = input1.length;
        double sum=0;
        double predict;
        
        for (int i=0;i<count;i++)
        {
        double wsum2 = w1 * input1[i] + w2 * input2[i] + b;
        predict = sigmoid(wsum2); 
        sum=sum+predict;
        }
        sum=sum/count;
        return sum*100;
    }
    
    
    
}
