using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace CodeMaster
{
    class Program
    {   
        // output file
        static readonly string outputfile = Environment.CurrentDirectory + @"\Problem2_output.txt";

        static Dictionary<string, int> ones = new Dictionary<string, int>();     


        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Code Master v-4.0 - Problem2");
            Console.WriteLine("Please provide the full path of input file...");

            string textFile = Console.ReadLine();
            Prepare();

            Console.WriteLine("Please wait while we are generating output file...");

            try
            {
                Process(textFile);
                Console.WriteLine("The output file has been generated.");               
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            Console.WriteLine("Press any key to exit. Thanks.");
            Console.ReadKey();
        }

        static void Process(string textFile)
        {
            if (File.Exists(textFile))
            {
                // Read file using StreamReader. Reads file line by line  
                using (StreamReader file = new StreamReader(textFile))
                {                    
                    string ln;
                    int counter = 0;
                    while ((ln = file.ReadLine()) != null)
                    {
                        counter++;

                        if (counter == 1 )
                        {
                            continue;
                        }

                        List<int> array = new List<int>();
                        
                        foreach (var item in ones)
                        {
                            string number = item.Key;
                            bool flag = true;
                            char ch = '0';

                            foreach (var c in number.ToCharArray())
                            {
                                if (ln.Contains(c) == false)                                
                                {
                                    flag = false;
                                    break;
                                }
                            }

                            if (flag)
                            {     
                                ch = number[0];

                                if (ln.Count(f => (f == ch)) > 1 )
                                {
                                    SeeForDuplicate(ln, item, ref array);
                                }
                                else
                                {
                                    array.Add(item.Value);
                                }                                
                            }
                        }
                        
                        using (StreamWriter sw = File.AppendText(outputfile))
                        {
                            sw.WriteLine($"Room-{counter - 1}: { string.Join("", array)}");
                        }                        
                    }

                    file.Close();                    
                }
            }
            else
            {
                throw new Exception("The file does not exists. Please make sure the file exists in the specified folder.");
            }
        }

        private static void SeeForDuplicate(string ln, KeyValuePair<string, int> item, ref List<int> array)
        {
            string number = item.Key;
            bool flag = true;

            char ch = number[0];
            int count = ln.Count(f => (f == ch));

            while (count > 0)
            {
                foreach (var c in number.ToCharArray())
                {
                    if (ln.Contains(c))
                    {
                        ln = ln.Remove(ln.IndexOf(c), 1);
                    }
                    else
                    {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                {
                    array.Add(item.Value);                    
                }

                count--;
            }            
        }

        static void Prepare()
        {
            ones.Add("ZERO", 0);
            ones.Add("ONE", 1);
            ones.Add("TWO", 2);
            ones.Add("THREE", 3);
            ones.Add("FOUR", 4);
            ones.Add("FIVE", 5);
            ones.Add("SIX", 6);
            ones.Add("SEVEN", 7);
            ones.Add("EIGHT", 8);
            ones.Add("NINE", 9);


            // Deleting file if exists
            if (File.Exists(outputfile))
            {
                File.Delete(outputfile);
            }
        }
    }
}
