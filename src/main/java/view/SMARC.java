/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import agentes.AgParaconsist;
import agentes.AgNicot;
import agentes.AgObesi;
import agentes.AgPressArt;
import agentes.AgSedet;
import agentes.Agente;
import java.util.ArrayList;
import teste.Comunicador;

/**
 *
 * @author Usuario
 */
public class SMARC extends javax.swing.JDialog {

    ArrayList<Double> dados = new ArrayList<>();
    Comunicador comunicador = new Comunicador();
    Agente agp = new AgParaconsist("Paraconsistente", comunicador);
    
    Comunicador cmNicotina = new Comunicador();
    Comunicador cmObesidade = new Comunicador();
    Comunicador cmPressao = new Comunicador();
    Comunicador cmSedent = new Comunicador(); 
    
    private Agente agnict = new AgNicot("Agente nicotina", cmNicotina);
    private Agente agobsei = new AgObesi("Agente obesidade", cmObesidade);
    private Agente agpress = new AgPressArt("Agente pressão", cmPressao);
    private Agente agsed = new AgSedet("Agente sedentarismo", cmSedent);
    /**
     * Creates new form SMARC
     */
    public SMARC(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtAltura = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtAtividadeFis = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPressArtSis = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPressArtDias = new javax.swing.JTextField();
        txtPontuacaoFangerstrom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SMARC");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Altura do Paciente");

        txtAltura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlturaActionPerformed(evt);
            }
        });

        jLabel3.setText("Peso do Paciente");

        txtPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesoActionPerformed(evt);
            }
        });

        txtAtividadeFis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtividadeFisActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantas atividades fisicas realiza por semana?");

        jLabel5.setText("Pressão arterial sistolica");

        txtPressArtSis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPressArtSisActionPerformed(evt);
            }
        });

        jLabel6.setText("Pressão arterial diastolica");

        txtPressArtDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPressArtDiasActionPerformed(evt);
            }
        });

        txtPontuacaoFangerstrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPontuacaoFangerstromActionPerformed(evt);
            }
        });

        jLabel7.setText("Pontuação Fagerstrom");

        btnEnviar.setText("Enviar questionario");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel9.setText("Resultado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtAtividadeFis, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtPressArtSis, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtPressArtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtPontuacaoFangerstrom, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviar)
                            .addComponent(jLabel9))
                        .addGap(0, 218, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAtividadeFis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPressArtSis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPressArtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPontuacaoFangerstrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlturaActionPerformed

    private void txtPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesoActionPerformed

    private void txtAtividadeFisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtividadeFisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtividadeFisActionPerformed

    private void txtPressArtSisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPressArtSisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPressArtSisActionPerformed

    private void txtPressArtDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPressArtDiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPressArtDiasActionPerformed

    private void txtPontuacaoFangerstromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPontuacaoFangerstromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPontuacaoFangerstromActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            // Coletar os dados da interface
            dados.add(Double.valueOf(txtPeso.getText()));
            dados.add(Double.valueOf(txtAltura.getText()));
            dados.add(Double.valueOf(txtAtividadeFis.getText()));
            dados.add(Double.valueOf(txtPontuacaoFangerstrom.getText()));
            dados.add(Double.valueOf(txtPressArtSis.getText()));
            dados.add(Double.valueOf(txtPressArtDias.getText()));
            
            //Envia dados para o agente paraconsistente
            agp.setDados(dados);
            
            //Envia e recebe os dados para cada agente
            agp.enviarDadosAgenteNicotina();
            agp.enviarDadosAgenteObesidade();
            agp.enviarDadosAgentePressao();
            agp.enviarDadosAgenteSedentarismo();
            
            agnict.receberDados();
            agobsei.receberDados();
            agpress.receberDados();
            agsed.receberDados();
            
            

            
            // Criar os agentes
            /*Agente agenteObesidade = new AgObesi("Agente Obesidade", peso, altura);
            Agente agentePressao = new AgPressArt("Agente Pressão", pressaoSistolica, pressaoDiastolica);
            Agente agenteSedentarismo = new AgSedet("Agente Sedentarismo", atividadeFisica);
            Agente agenteNicotina = new AgNicot("Agente Nicotina", pontuacaoNicotina);

            // Criar threads para cada agente
            Comunicador threadObesidade = new Comunicador(agenteObesidade);
            Comunicador threadPressao = new Comunicador(agentePressao);
            Comunicador threadSedentarismo = new Comunicador(agenteSedentarismo);
            Comunicador threadNicotina = new Comunicador(agenteNicotina);

            // Iniciar as threads
            threadObesidade.start();
            threadPressao.start();
            threadSedentarismo.start();
            threadNicotina.start();

            // Esperar threads terminarem e coletar os dados
            threadObesidade.join();
            threadPressao.join();
            threadSedentarismo.join();
            threadNicotina.join();

            DadosAgente dadosObesidade = threadObesidade.getAgente().processarDados();
            DadosAgente dadosPressao = threadPressao.getAgente().processarDados();
            DadosAgente dadosSedentarismo = threadSedentarismo.getAgente().processarDados();
            DadosAgente dadosNicotina = threadNicotina.getAgente().processarDados();

            // Criar e processar o agente cardíaco
            Agente agenteCardiaco = new AgParaconsist("Agente Cardíaco", dadosSedentarismo, dadosNicotina, dadosObesidade, dadosPressao);
            DadosAgente dadosCardiaco = agenteCardiaco.processarDados();

            // Exibir o resultado no jTextArea1
            jTextArea1.setText("Resultado do Agente Cardíaco:\n");
            jTextArea1.append("Grau de Evidência: " + dadosCardiaco.getGrauEvidencia() + "\n");
            jTextArea1.append("Classificação: " + dadosCardiaco.getClassificacao() + "\n");*/
        } catch (NumberFormatException e) {
            jTextArea1.setText("Erro: Verifique os valores inseridos. Todos os campos devem estar preenchidos corretamente.");
        }/* catch (InterruptedException e) {
            jTextArea1.setText("Erro: As threads foram interrompidas inesperadamente.");
        }*/
    }//GEN-LAST:event_btnEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SMARC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SMARC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SMARC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SMARC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SMARC dialog = new SMARC(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtAtividadeFis;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPontuacaoFangerstrom;
    private javax.swing.JTextField txtPressArtDias;
    private javax.swing.JTextField txtPressArtSis;
    // End of variables declaration//GEN-END:variables
}
