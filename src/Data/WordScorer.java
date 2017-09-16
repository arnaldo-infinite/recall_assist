/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.StringTokenizer;

/**
 *
 * @author User
 */
public class WordScorer 
{
   private String Sentence;
   private String [] wordarray;
   private int [] wordscorearray;
   
   
   private final String [] unwantedwords = {"ABOARD","ABOUT","ABOVE","ACROSS","AFTER","AGAINST","ALONG","AMID","AMONG","ANTI","AROUND",
       "AS","AT","BEFORE","BEHIND","BELOW","BENEATH","BESIDE","BESIDES","BETWEEN","BEYOND","BUT","BY","CONCERNING","CONSIDERING",
       "DESPITE","DOWN","DURING","EXCEPT","EXCEPTING","EXCLUDING","FOLLOWING","FOR","FROM","IN","INSIDE","INTO","LIKE","MINUS",
       "NEAR","OF","OFF","ON","ONTO","OPPOSITE","OUTSIDE","OVER","PAST","PER","PLUS","REGARDING","ROUND","SAVE","SINCE","THAN",
       "THROUGH","TO","TOWARD","TOWARDS","UNDER","UNDERNEATH","UNLIKE","UNTIL","UP","UPON","VERSUS","VIA","WITH","WITHIN","WITHOUT","IS","THE"};
   
   public WordScorer (String Sentence)
    {
    this.Sentence=Sentence;
    }   
   
   public WordScorer ()
   {
   
   }
   
   private void wordSeparator()
   {
        StringTokenizer token = new StringTokenizer(Sentence);
        String word ="";
        int count=token.countTokens(); //get number of token
        wordarray = new String[count];
        
        count=0;        // reset count variable to 0 to use in the while loop
        
        while(token.hasMoreTokens())
        {
            word = token.nextToken();
            wordarray[count]=word;
            count++;
        }
    }
   
   private int scorer(char character)
   {
       int A = 1, B = 2, C = 3, D = 4, E = 5, F = 6, G = 7, H = 8, I = 9,
        J = 10, K = 11, L = 12, M = 13, N = 14, O = 15, P = 16, Q = 17,
        R = 18, S = 19, T = 20, U = 21, V = 22, W = 23, X = 24,
        Y = 25, Z = 26;
       
       switch (character)
       {
            case 'A':    return A;
            case 'B':    return B;    
            case 'C':    return C;
            case 'D':    return D;
            case 'E':    return E;
            case 'F':    return F;
            case 'G':    return G;
            case 'H':    return H;
            case 'I':    return I;    
            case 'J':    return J;
            case 'K':    return K;
            case 'L':    return L;
            case 'M':    return M;
            case 'N':    return N;
            case 'O':    return O;
            case 'P':    return P;
            case 'Q':    return Q;
            case 'R':    return R;
            case 'S':    return S;
            case 'T':    return T;
            case 'U':    return U;
            case 'V':    return V;
            case 'W':    return W;
            case 'X':    return X;
            case 'Y':    return Y;
            case 'Z':    return Z;
                
            default:    return 0;
       }
   }   
   
   private void addString(String [] array)
   {
       int arraycount = array.length;
       int score = 0;
       wordscorearray = new int[arraycount];
       
       for (int z =0;z<arraycount;z++)
       {
        int wordlength = array[z].length();  //length of current word
        for(int i=0;i<wordlength;i++)
        {
            score = 0; //reset score to 0 for next word
            for(int j=0;j<array[z].length();j++)    // calculating within a word
            {
                char temp = array[z].charAt(j);
                int charscore = scorer(temp);

                int charvalue = charscore * (j+1);
                score = score + charvalue;
            }
        }
        wordscorearray[z]=score;
       }
   }
   
   private void removeString ()
   {
       int arraycount = this.wordarray.length;
       int count = unwantedwords.length;
       int unwanted = 0;
       
       for (int z =0; z<arraycount ; z++)
       {
           for(int y=0; y<count; y++)
           {
                if (this.wordarray[z].contentEquals(unwantedwords[y]))
                {
                    this.wordarray[z]="";
                    unwanted++;
                }
           }
       }
       generateWordsOnlyArray(wordarray,unwanted);
   }
   
   private void generateWordsOnlyArray(String [] arrayAllWords, int unwanted)
   {
       int count = arrayAllWords.length;
       String [] temp = new String [count-unwanted];
       
       for(int z= 0, x=0; z<count ; z++)
       {
           if (arrayAllWords[z] != null && !arrayAllWords[z].isEmpty()) 
           {
            temp[x]=arrayAllWords[z];
            x++;
           }
        }
       this.wordarray=temp;
    }
   
   
   
   
   

   
   
   
   
   
   
   
   
   
   
   
  
   
   public String[] getarraywords()
   {
       return wordarray;
   }
   
   public int[] getarraycountscore()
   {
       return wordscorearray;
   }
   
    public int gettotalscore ()
   {
       int sum = 0;
       for (int i = 0;i<wordscorearray.length;i++)
       {
           sum=sum+wordscorearray[i];
       }
       return sum;
   }
   
   public void processData()
   {
       wordSeparator();
       addString(wordarray);
   }
   
   public void processUnwantedData()
   {
       removeString();
       addString(wordarray);
   }
   
   

   
   
   
   
   
   
   
   
   
   
}
   
 





