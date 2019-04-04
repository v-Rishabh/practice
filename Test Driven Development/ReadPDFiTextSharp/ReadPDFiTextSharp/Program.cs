using System;
using System.IO;
using System.Text;
using iTextSharp.text.pdf;
using iTextSharp.text.pdf.parser;
using System.Collections.Generic;

namespace ReadPDFiTextSharp
{
    public class Program
    {
        private static Dictionary<string, List<string>> PDF_Data = new Dictionary<string, List<string>>();
        static void Main(string[] args)
        {
            string path = @"C:\Users\rishabh.verma\Downloads\DMRC.pdf";
            //ReadAllPDF(path);
            ReadLineByLine(path);
            //Console.WriteLine("Count of Records : "+PDF_Data.Count);
            //foreach (KeyValuePair<string, List<string>> entry in PDF_Data)
            //{
            //    //foreach(string val in entry)
            //    Console.WriteLine("\nKey = " + entry.Key);
            //    Console.WriteLine("==============");
            //    foreach (string value in entry.Value) {
            //        Console.WriteLine(value);
            //    }
            //}

            WriteToExcel writeFile = new WriteToExcel(PDF_Data);
            string result = writeFile.convertToExcel();
            Console.WriteLine(result);
            Console.ReadLine();
        }

        public Dictionary<string, List<string>> tests() {
            string path = @"C:\Users\rishabh.verma\Downloads\DMRC.pdf";
            ReadLineByLine(path);
            return PDF_Data;
        }
        /// <summary>
        /// Read all lines of PDF at once.
        /// </summary>
        /// <param name="path">Absolute path of PDF</param>
        public static void ReadAllPDF(string path) {
            if (File.Exists(path))
            {
                using (PdfReader reader = new PdfReader(path))
                {
                    StringBuilder text = new StringBuilder();
                    for (int i = 1; i <= reader.NumberOfPages; i++)
                    {
                        text.Append(PdfTextExtractor.GetTextFromPage(reader, i));
                    }
                    Console.WriteLine(text.ToString());
                }
            }
            else
            {
                Console.WriteLine("File Not Found at the location specified");
            }
        }
        /// <summary>
        /// Reading PDF File line by line.
        /// word[] contains lines of PDF.
        /// </summary>
        /// <param name="path">Absolute path of PDF</param>
        public static void ReadLineByLine(string path) {
            if (File.Exists(path))
            {
                PdfReader reader = new PdfReader(path);
                int intPageNum = reader.NumberOfPages;
                string[] words;
                string line;
                string text;
                for (int i = 1; i <= intPageNum; i++)
                {
                    text = PdfTextExtractor.GetTextFromPage(reader, i, new LocationTextExtractionStrategy());
                    words = text.Split('\n');
                    for (int j = 0, len = words.Length; j < len; j++)
                    {
                        line = Encoding.UTF8.GetString(Encoding.UTF8.GetBytes(words[j]));
                        //Console.WriteLine(line);
                        if (line.Substring(0, 5).Equals("DIMTS")) {
                            //Console.WriteLine(line);
                            string[] lineArray = line.Split(' ');
                            //Console.WriteLine(lineArray[0]+" "+lineArray[1]);
                            // Add Data to Dictionary
                            PDF_Data.Add(lineArray[1], new List<string>());
                            PDF_Data[lineArray[1]].Add(lineArray[2]);
                            PDF_Data[lineArray[1]].Add(lineArray[3]+" "+ lineArray[4]+" "+ lineArray[5]);
                            PDF_Data[lineArray[1]].Add(lineArray[6]);
                            PDF_Data[lineArray[1]].Add(lineArray[7]);
                        }

                    }
                } 
            }
            else
            {
                Console.WriteLine("File Not Found at the location specified");
            }
        }
    }
}
