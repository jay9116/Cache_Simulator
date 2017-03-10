import java.util.Scanner;

public class cacheSimulator
{
	 static int read_miss = 0;
	 static int read_hits = 0;
	 static int write_miss = 0;
	 static int write_hits = 0;
	 static int[][] array_main_memory;
	 static int[][] array_cache;
     
	public static void main(String[] args)
	{
		String choice;
		array_main_memory = initialize_main_memory();
		array_cache = initialize_cache();
		print_memory(array_main_memory);
	    print_cache(array_cache);
	    print_cache_performance();
	    print_cache_perform();
	int a=-1;
		
	while(a<3)
	{	
		Scanner sca = new Scanner(System.in);
		System.out.println("Enter choice:");
		System.out.println("[0] to read from mem");
		System.out.println("[1] to write to mem");
		System.out.println("[2] to quit");
		
		
		choice = sca.nextLine();
		a=Integer.parseInt(choice);

		if(choice.equals("0"))
	    {
	    	System.out.println("Reading from Memory");
	    	read_from_mainmemory_to_cache(0);
	    	print_cache_performance();
	    	print_cache_perform();
			print_memory(array_main_memory);
		    print_cache(array_cache);
	    }
	    else if(choice.equals("1")) 
	    {
	    	System.out.println("Writing To Memory");
	    	write_to_memory(0,0,0);
	    	print_cache_performance();
	    	print_cache_perform();
			print_memory(array_main_memory);
		    print_cache(array_cache);
		}
	    else if (choice.equals("2")) 
	    {
	    	a=3;
	    	System.out.println("Exit");
		}
	}
			        
}
	
	 static int[][] initialize_main_memory()
     {
         int array_main_memory[][] =  {
                                              
      		   
      		   {	0,	1,	2,	3,	4,	5,	6,	7,	8,	9,	10,	11,	12,	13,	14,	15	}, 
      		   {	10,	11,	12,	13,	14,	15,	16,	17,	18,	19,	20,	21,	22,	23,	24,	25	}, 
      		   {	20,	21,	22,	23,	24,	25,	26,	27,	28,	29,	30,	31,	32,	33,	34,	35	}, 
      		   {	30,	31,	32,	33,	34,	35,	36,	37,	38,	39,	40,	41,	42,	43,	44,	45	}, 
      		   {	40,	41,	42,	43,	44,	45,	46,	47,	48,	49,	50,	51,	52,	53,	54,	55	}, 
      		   {	50,	51,	52,	53,	54,	55,	56,	57,	58,	59,	60,	61,	62,	63,	64,	65	}, 
      		   {	60,	61,	62,	63,	64,	65,	66,	67,	68,	69,	70,	71,	72,	73,	74,	75	}, 
      		   {	70,	71,	72,	73,	74,	75,	76,	77,	78,	79,	80,	81,	82,	83,	84,	85	}, 
      		   {	80,	81,	82,	83,	84,	85,	86,	87,	88,	89,	90,	91,	92,	93,	94,	95	}, 
      		   {	90,	91,	92,	93,	94,	95,	96,	97,	98,	99,	100,	101,	102,	103,	104,	105	}, 
      		   {	100,	101,	102,	103,	104,	105,	106,	107,	108,	109,	110,	111,	112,	113,	114,	115	}, 
      		   {	110,	111,	112,	113,	114,	115,	116,	117,	118,	119,	120,	121,	122,	123,	124,	125	}, 
      		   {	120,	121,	122,	123,	124,	125,	126,	127,	128,	129,	130,	131,	132,	133,	134,	135	}, 
      		   {	130,	131,	132,	133,	134,	135,	136,	137,	138,	139,	140,	141,	142,	143,	144,	145	}, 
      		   {	140,	141,	142,	143,	144,	145,	146,	147,	148,	149,	150,	151,	152,	153,	154,	155	}, 
      		   {	150,	151,	152,	153,	154,	155,	156,	157,	158,	159,	160,	161,	162,	163,	164,	165	}
                                            
                };

         return array_main_memory;
         
     }
	   
	   static int[][] initialize_cache()
     {

         int array_cache[][] =  {
                               {	0,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	1,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	2,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	3,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0   },
                               {	4,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	5,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	6,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	7,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	8,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	9,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	10,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	11,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0   },
                               {	12,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	13,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	14,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	},
                               {	15,	0,	-99,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0	}
                     
                                };

         return array_cache;

     }

	static void read_from_mainmemory_to_cache(int block_number)
    {
		read_miss++;
		Scanner sca = new Scanner(System.in);	
		
		String block;
		
		System.out.println("Enter Block Number:(Value  0 to 15)");
		block = sca.nextLine();	
		block_number = Integer.parseInt(block);
		System.out.println("action = READ, block :"+block+"");
        for(int j=0;j<16;j++)
        {
        	if(array_cache[j][2]==block_number)
        	{
        		read_hits++;
        	}
        }

		for(int i=0;i<16;i++)
        {
        	array_cache[block_number][i+3]=array_main_memory[block_number][i];
        }
		array_cache[block_number][2] = block_number;
        array_cache[block_number][1]=1;
    }
	
	
	static void write_to_memory(int block_number, int offSet, int value)
    {
        Scanner in = new Scanner(System.in);	
		int l=0;
		String block;
		String offset_number;
		String value_entered;
		
		System.out.print("\nEnter Block Number:(Value  0 to 15)");
		block = in.nextLine();	
		block_number = Integer.parseInt(block);
		
		System.out.print("\nEnter offset_number Number:(Value  0 to 15)");
		offset_number = in.nextLine();
		offSet = Integer.parseInt(offset_number);
		
		System.out.print("\nEnter Value:");
		value_entered = in.nextLine();
		value = Integer.parseInt(value_entered);
        for(int j=0;j<16;j++)
        {
        	if(array_cache[block_number][j+3]==value)
        	{
        		write_hits++;
        	}
        	else
        	{
        		l++;
        	}
        }
        if(l>14)
        {
        	write_miss++;
        	l=0;
        }
		
        array_main_memory[block_number][offSet] = value;
 }
	
	static void print_memory(int arrayMainmemory[][])
    {
		System.out.println("Printing Memory");
        for (int i = 0; i < 16; i++ )
        {
            for (int j = 0; j < 16; j++)
            {
            	System.out.print("\t"+array_main_memory[i][j]);
            }
            System.out.println("");
        }
    }
	
	static void print_cache_performance()
	{
		System.out.println("Write Misses out put: "+write_miss);
		System.out.println("Write Hits out put : "+write_hits);
	}

	static void print_cache_perform()
	{
		System.out.println("Read Misses out put : "+read_miss);
		System.out.println("Read Hits out put: "+read_hits);
	}
	
	static void print_cache(int arrayCache[][])
     {
		 System.out.println("Print Cache");
		 
         for (int i = 0; i < 16; i++)
         {
             for (int j = 0; j < 19; j++)
             {
                 String prefix = "";

                 if (j == 0)
                 {
                     prefix = "Set =";
                 }
                 else if (j == 1)
                 {
                     prefix = "V =";
                 }
                 else if (j == 2)
                 {
                     prefix = "Tag =";
                 }
                 System.out.print("\t"+prefix+"  "+array_cache[i][j]);
             }
             System.out.println("");
         }
     }
	  
}
