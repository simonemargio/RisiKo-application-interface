/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risiko;

import java.awt.Component;
//import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Types;
import javax.swing.JOptionPane;
import static risiko.MenuNewPartita.verificaCarattere;
//import javax.swing.SwingUtilities;
import static risiko.Query.catturaErrori;

/**
 *
 * @author ikaros
 */
/* 
    DESCRIZIONE GENERALE

Permette di poter effettuare:
- Ripercorrere una partita 
Ripercorrere una partita sfrutta il file generato durante lo svolgimento di una partita.
Esso viene creato nel path principale dove viene avviato l'applicativo e viene richimato da esso
per poi visuallizrlo all'utente tramite l'interfaccia grafica.
L'uso del file di ottenere in maniera semplice e veloce tutte le informazioni di una partita senza dover
effettuare di nuovo opportune interrogazioni al database per riaccedere ai stessi dati che invece
vengono forniti run time durante lo svolgimento della partita.
Altre informazioni come lo stato della partita, vincitore, ed altri vengono visualizzati all'utente.
  
- Eliminare una partita
L'eliminazione di una partita consiste nell'eliminare tramite il database il nome della partita. 
Successivamente per la struttura dei vincoli verranno eliminate tutte le informazioni della partita
da tutte le altre taballe. Infine si procede all'eliminazione del file log della partita.

Gestione del file
La gestione del file viene effettuata creando un file di testo dato dalla composizione del nome della partita
scelto dall'utente unito al testo "_lol.txt" che permette di identificare il file come insieme di infomazioni 
di una partita.
Esso vienee creato quando si inizia una partita usando il form MenuNewPartita. Successivamente per la scrittura
delle informazioni nel file si procede a chiamare una "procedura" che prende in ingresso una stringa contenente
le informazioni. Essa apre, scrive la nuova riga e richiude il file.
Caso in cui il file non è iù presente allora si provvede alla sua nuova creazione inserendo una stringa iniziale
che informa l'utente che eventuali informazioni prese in precedenza sono andate perse.

*/
public class MenuTools extends javax.swing.JFrame {

    /**
     * Creates new form MenuTools
     */
    public MenuTools() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ripercorri una partita");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton5.setText("Indietro");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Inserisci il nome della partita");

        jTextField1.setText("nome partita..");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Partite presenti");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jButton1.setText("Ripercorri la partita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Riassunto della partita");

        jLabel4.setText("Stato della partita");

        jLabel5.setText("Vincitore");

        jLabel6.setText("Totale turni");

        jLabel7.setText("Totale combattimenti");

        jTextField2.setEditable(false);

        jTextField3.setEditable(false);

        jTextField4.setEditable(false);

        jButton2.setText("Elimina la partita");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField6.setEditable(false);

        jButton3.setText("Altre info");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // BOTTONE: Indietro
        
        this.setVisible(false);
        dispose();
        new MenuBase().setVisible(true);
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // APERTURA FORM: MENU TOOLS
        
        /* Dichiarazione variabili */
        Connection conn = null;
        PreparedStatement rset = null;
        String partita = null;
        
        /* Query da effettuare */
        String query = "SELECT NOME_PARTITA FROM PARTITA";
        
      try
         {
            conn = ConnessioneDB.getDefaultConnection();
          //  rset = conn.prepareStatement("SELECT NOME_PARTITA FROM PARTITA");
            rset = conn.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet respartita = rset.executeQuery();
            
            /* Prelevo e mostro ogni partita */
            while(respartita.next())
            {
               partita = respartita.getString("NOME_PARTITA");
               jTextArea1.append(partita + "\n");        
            }
           
         }catch(SQLException e)
            {
              catturaErrori(e);
            }finally 
                   { 
                      Query.conrsetClose(conn, rset);
                   }  
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BOTTONE: RIPERCORRI LA PARTITA
        
       /* Dichiarazione variabili */
       Component err = null;
       Query dbms = new Query();
       
       /* Prendo l'id della partita selezionata dal giocatore */
       String idp = dbms.idPartita(jTextField1.getText());
       
       /* La partita non esiste */
       if(idp == null)
        {
          JOptionPane.showMessageDialog(err,"La partita " + jTextField1.getText() + " non è presente.\nVerificare la correttezza del nome" ,"Attenzione",JOptionPane.WARNING_MESSAGE);  
        }
       else
       {
           /* La partita esiste */
           
           /* Pulisco */
           jTextArea2.setText("");
           
           /* Modifico il nome della partita per il file */
           String nomep = jTextField1.getText();
           nomep = nomep + "_log.txt";
               
           try
             {
                FileReader f =  new FileReader(nomep);
                BufferedReader b = new BufferedReader(f);

                String s;
                
                /* Leggo ogni riga del file e la mostro */
                while(true) 
                  {
                    s=b.readLine();
                    if(s==null) break;
                    jTextArea2.append(s+"\n");
                  }
                           
             /* Caso in cui il file non è presente */
             } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(err,"File " + nomep + " non si trova nella directory principale dell'apllicativo.\nVerificare che il file non sia stato cancellato." ,"Errore",JOptionPane.ERROR_MESSAGE);  
             }
            
            /* Prendo il nome della partita */
            nomep = jTextField1.getText();
            
            /* Verifico che ci sia un vincitore */
            int vinc = dbms.checkVincitore(nomep);
            
            /* Se diverso da zero allora la partita è finita e c'è un vincitore */
            if(vinc != 0)
            {
                jTextField4.setText("Finita"); 
                /* Prendo il nik del giocatore vincente e lo mostro */
                String vincitore = dbms.nicknameGiocatore(String.valueOf(vinc),idp);
                jTextField2.setText(vincitore);
            }
            else /* La partita è in corso e nessuno ha ancora vinto */
            {
                jTextField4.setText("In corso");
                jTextField2.setText("Nessuno");
            }
            
            /* Calcolo e mostro quanti combattimenti sono avvenuti */
            int n = dbms.toolsTotCombattimenti(idp);
            jTextField6.setText(String.valueOf(n));
            
            /* Calcolo e mostro quanti turni sono avvenuti */
            n = dbms.toolsTotTurni(idp);
            /*
               Eliminiamo un turno che corrisponde alla fase in cui si distribuiscono carte,
               territori, obiettivi ed altro ai giocatori
            */
            n = n - 1; 
            jTextField3.setText(String.valueOf(n));      
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // BOTTONE: ELIMINA LA PARTITA
        
        /* Dichiarazione variabili */
        Component err = null;
        Query dbms = new Query();
        
        /* Prelevo l'id partita scritta dall'utente */
        String idp = dbms.idPartita(jTextField1.getText());
        
        /* La partita esiste */
        if(idp != null)
        {
            /* Chiamo uscitaForzataDel per cancellare dal dms la partita */
            Query.uscitaForzataDel(jTextField1.getText());
            /* Elimino il file della partita */
            Query.delFile(jTextField1.getText());
            dbms.delVista(idp);
            JOptionPane.showMessageDialog(err,"La partita " + jTextField1.getText() + " è stata eliminata!" ,"Eseguito",JOptionPane.INFORMATION_MESSAGE);  
             
            /* Pulisco in modo da aggiornare le partite */
            jTextArea1.setText("");
            
            /* Dichiarazione variabili */
            Connection conn = null;
            PreparedStatement rset = null;
            String partita = null;
        
            try
            {
                conn = ConnessioneDB.getDefaultConnection();
                rset = conn.prepareStatement("SELECT NOME_PARTITA FROM PARTITA");
                ResultSet respartita = rset.executeQuery();

                while(respartita.next())
                {
                   partita = respartita.getString("NOME_PARTITA");
                   jTextArea1.append(partita + "\n");        
                }
            }catch(SQLException e)
            {
              catturaErrori(e);
            }finally 
                   { 
                      Query.conrsetClose(conn, rset);
                   }
        }
        else /* PArtita non esistente */
        {
            JOptionPane.showMessageDialog(err,"La partita " + jTextField1.getText() + " non esiste!" ,"Attenzione",JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // BOTTONE: INFO
        
        this.setVisible(false);
        dispose();
        new Info().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // KEY TYPED PER EVITARE CARATTERI NON CONSONI PER IL RICHIAMO DELLA PARTITA      
        
       /* Prendo il carattere digitato */
       char c = evt.getKeyChar();
       /* Verifico che sia accettabile */
       int i = verificaCarattere(c);
       /* Carattere non consono lo scarto */
       if(i != 1) evt.consume();
       /* Imposto lunghezza massima di 20 caratteri */
       if(jTextField1.getText().length()>= 20) evt.consume();
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // KEY PRESSED PER IL NOME DELLA PARTITA
        
        /* Elimino la possibilità di usare incolla */
        jTextField1.setTransferHandler(null);
    }//GEN-LAST:event_jTextField1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

 }