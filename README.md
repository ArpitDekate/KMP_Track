# KMP_Track
This is an application to show the implementation of the KMP algorithm. 
It takes input from file as a string or reads from an input file and pattern is also given by the user.

********************************************************************************************************************************************************
Problem Definition: Q6.A text file is given as input it is required to perform search on the txt file using KMP alorithm
                       the pattern is user input. The code will demonstrate time required,its repeated occurances,
                       total  number of compas=risons required and total time required it  pattern is not present in the
                       text.The text file may be any recent article on sport domain. 
                      
                   -->The KMP is a pattern matching algorithm which is used to search a pattern in given string and is faster than regular
                      Brute Force pattern searching algorithms that has a O(m*n) TC where as KMP has O(m+n) TC which is significant reduction.
                      Prefix table is maintained to perform SKIP operation.
                      As pe the problem definition we were required to demonsotrate KMP working,search a user provided pattern in user-
                      choosen string,give time required to find pattern if present,number of occurances of the pattern and its Trace.
                      
Technology Stack : 1.Netbeans 8.0.1(IDE)
                   2.Java (for logical implementation)
                   3.Swings( for UI)
                   
Function Definitions:File name-
                    1. (src/ads_P/Trace.java)
                        
                          a. public Trace(String s,String p): This is the constructor of the Trace.java class.This initializes the inputs 
                             recieved from user (from first window),the string and the pattern.

                          b. int[] prefixtable(String pat, int M, int pival[])
                             This is used to find the prefix table for the given pattern to be searched.

                          c. void search(String pat, String txt)
                             This is  the actual implementation of KMP algo and user prefix table.

                          d.private void initComponents()
                             This initialzes the swing elements for 2nd window.

                     2. (src/ads_P/kmp.java)
                          a.private void initComponents()
                             This initialzes the swing elements for the first window where user provides string and pattern.
                          
                          b.private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
                            This invokes an event when pressed.It open a file dialouge box for choosing input string file.
                          
                          c. private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
                            Used to start the trace whestrin and pattern is provided and moves onto second window.
                          
DB connectivity: There is no need of Database connectivity as the user provides String( file based input) and pattern at the runtime.
                        
                      
