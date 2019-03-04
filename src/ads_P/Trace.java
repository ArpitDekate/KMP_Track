/*
    @author Arpit Dekate
    RollNo: 49
    6th Sem
    ADS assignment
 */

/*This class shows the trace of  kmp algo for input file and input pattern by the user*/
package ads_P;

import java.awt.Color;
import static java.awt.SystemColor.text;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;


public class Trace extends javax.swing.JFrame {
    int comps ;
    String ctrace="",timeTrace="",preftab="";
    public Trace() {
        initComponents();
    }
    public Trace(String s,String p) throws BadLocationException 
    {
        initComponents();
        
        ipstr=s;
        pattern=p;
        jTextArea1.setText(s);
      
      Highlighter highlighter = jTextArea1.getHighlighter();
      HighlightPainter painter = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
            search(p,s);

    }
    int[] prefixtable(String pat, int M, int pival[]) 
	{ 
    	    int len = 0; 
	    int i = 1; 
		pival[0] = 0; 
                while (i < M) { 
			if (pat.charAt(i) == pat.charAt(len)) { 
			     len++; 
			     pival[i] = len; 
			     i++; 
			} 
			else  
			{ if (len != 0) 
                           { 
                              len = pival[len - 1]; 
			   } 
			   else 
			    { pival[i] = len; 
			      i++; 
		           } 
			} 
		}
                
                for(int j=0;j<pival.length;j++)
                {
                    preftab=preftab+" "+pival[j];
                }
                return pival;
        }
        
    void search(String pat, String txt) throws BadLocationException 
	{  
            Highlighter highlighter =
                    jTextArea1.getHighlighter();
           HighlightPainter painter = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
           
           HighlightPainter painter2 = 
             new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
           
              int p0=0; 
              int p1=0;
              
          long startTime = 0,endTime;
            
            int M = pat.length(),N = txt.length(); 
                int pival[] = new int[M]; 
		int j = 0,ocs=0; 
		pival=prefixtable(pat, M, pival); 
		int i = 0;  
		while (i < N) 
                { 
			if (pat.charAt(j) == txt.charAt(i)) 
                        { 
                            comps=comps+1;
                            startTime=System.nanoTime();
                            ctrace+="Comparing-"+pat.charAt(j)+"-"+" with-"+txt.charAt(i)+"\n";
                            j++; 
                            i++; 
                    	} 
			if (j == M)
                        {
                            endTime=System.nanoTime();
                             long elapsedTime = endTime - startTime;  
                             ocs++;
                             timeTrace+="Next Occurance -> No. "+ocs+" found in Time(Nanos) : "+elapsedTime+"\n";
                            ctrace+="Pattern present at index " + (i - j)+"\n";
                             highlighter.addHighlight(i-j, i-j+M, painter2);
                           j = pival[j - 1];
                           
			} 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) 
                        {
                            ctrace+="Comparing-"+pat.charAt(j)+"-"+" with-"+txt.charAt(i)+"\n";
                            comps=comps+1;
                            if (j != 0) 
                              j = pival[j - 1]; //move back one place if not reached LHS of patterns
                            else{
                              i = i + 1;
                              if(i==N)
                              {
                              }
                            }
                        } 
                }
             comparisons.setText(ctrace);
             ocr.setText(""+ocs);
             TimeTrace.setText(timeTrace);
             compares.setText(""+comps);
             pref.setText(""+preftab);
	} 
    
    
    // the method below initializes all the  swing components present.

    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        comparisons = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        ocr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TimeTrace = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        compares = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pref = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel1.setText("Flow Of Execution");

        comparisons.setColumns(20);
        comparisons.setRows(5);
        jScrollPane2.setViewportView(comparisons);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel2.setText("Number Of Occurances :");

        ocr.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel3.setText("Time Trace");

        TimeTrace.setColumns(20);
        TimeTrace.setRows(5);
        jScrollPane3.setViewportView(TimeTrace);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel4.setText("Number Of Comparisons :");

        compares.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel5.setText("Prefix Table");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ocr, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(compares, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(162, 181, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addComponent(pref)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ocr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pref, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                        

        public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Trace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trace().setVisible(true);
            }
        });
    }
        
 // this is the variable decleration of all the components       
    private javax.swing.JTextArea TimeTrace;
    private javax.swing.JTextField compares;
    private javax.swing.JTextArea comparisons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField ocr;
    private javax.swing.JTextField pref;
    private String pattern;
    private String ipstr;
}
