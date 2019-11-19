package Frames;

import Arquivo.ArquivoEstoque;
import Arquivo.ArquivoVenda;
import Registros.Blusas;
import Registros.Calcas;
import Registros.PessoaFisica;
import Registros.PessoaJuridica;
import Registros.VendaAPrazo;
import Registros.VendaAVista;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public class JVendas extends javax.swing.JFrame {
    DefaultTableModel tabela=new DefaultTableModel();
    String vetTabela[]=new String[11];
    ArquivoVenda arquivoVenda;
    public JVendas() {
        initComponents();
        arquivoVenda = new ArquivoVenda();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tabela.addColumn("Código");tabela.addColumn("Tipo");tabela.addColumn("CPF");tabela.addColumn("CNPJ");tabela.addColumn("Data Regis.");
        tabela.addColumn("Cod. Produto"); tabela.addColumn("Quant."); tabela.addColumn("Val. Total");
        tabela.addColumn("Parcelas");tabela.addColumn("Valor Parcela");
        txtCPF.setEnabled(false);txtCNPJ.setEnabled(false); txtValorParc.setEnabled(false);cmbParcela.setEnabled(false);
        txtDesconto.setEnabled(false);txtValorTotal.setEnabled(false);
        
    }
    
    public void limpaCadastro(){
        cmbTipo.setSelectedIndex(0); cmbCliente.setSelectedIndex(0);txtCPF.setText("");txtCNPJ.setText("");
        txtData.setText("");txtProd.setText("");txtQtde.setText("");txtValorTotal.setText("");cmbParcela.setSelectedIndex(0);
        txtValorParc.setText("");txtDesconto.setText("");
    }
    
    public boolean vazioCadastro(){
        if(cmbTipo.getSelectedIndex() == 0 && cmbCliente.getSelectedIndex() == 0 && txtData.getText().equals("") && txtProd.getText().equals("")
            && txtQtde.getText().equals("") && txtValorTotal.getText().equals(""))
            return true;
        else
            return false;
    }
    
    public void getQuantidade(){
        int codigoProd = Integer.parseInt(txtProd.getText());
        int quantidade = Integer.parseInt(txtQtde.getText());
        if(cmbTipo.getSelectedIndex() == 1){
            VendaAVista vendaVista = new VendaAVista();
            List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
            List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
            for(int i=0;i<listaBlusas.size();i++){
                if(listaBlusas.get(i).getCodigo() == codigoProd){
                    if((listaBlusas.get(i).getQtde() < quantidade) || (listaBlusas.get(i).getQtde() > quantidade) ){
                        JOptionPane.showMessageDialog(null, "Não ha quantidade suficiente no estoque.");
                        txtQtde.setText("");
                        break;
                    }
                }
            }
            for(int i=0;i<listaCalcas.size();i++){
                if(listaCalcas.get(i).getCodigo() == codigoProd){
                    if((listaCalcas.get(i).getQtde() < quantidade) || (listaCalcas.get(i).getQtde() > quantidade) ){
                        JOptionPane.showMessageDialog(null, "Não ha quantidade suficiente no estoque.");
                        txtQtde.setText("");
                        break;
                    }
                }
            }
        }else{
            if(cmbTipo.getSelectedIndex() == 2){
                VendaAPrazo vendaPrazo = new VendaAPrazo();
                List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                for(int i=0;i<listaBlusas.size();i++){
                    if(listaBlusas.get(i).getCodigo() == codigoProd){
                        if((listaBlusas.get(i).getQtde() < quantidade) || (listaBlusas.get(i).getQtde() > quantidade) ){
                            JOptionPane.showMessageDialog(null, "Não ha quantidade suficiente no estoque.");
                            txtQtde.setText("");
                        }
                    }
                }
                for(int i=0;i<listaCalcas.size();i++){
                    if(listaCalcas.get(i).getCodigo() == codigoProd){
                        if((listaCalcas.get(i).getQtde() < quantidade) || (listaCalcas.get(i).getQtde() > quantidade) ){
                            JOptionPane.showMessageDialog(null, "Não ha quantidade suficiente no estoque.");
                            txtQtde.setText("");
                            break;
                        }   
                    }
                }
            }
        }
    }
    
    File fileV = new File("arquivoVendaVista.json");
    File fileP = new File("arquivoVendaPrazo.json");
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        txtProd = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtQtde = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbParcela = new javax.swing.JComboBox<String>();
        txtValorParc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        btnBuscaProduto = new javax.swing.JButton();
        txtCPF = new javax.swing.JFormattedTextField();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDesconto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoProduto = new javax.swing.JComboBox();
        btnPreencher = new javax.swing.JButton();
        btnVerifica = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmbTipo1 = new javax.swing.JComboBox<String>();
        jLabel25 = new javax.swing.JLabel();
        btnLimpar2 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVoltar3 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        cmbCliente1 = new javax.swing.JComboBox<String>();
        jLabel27 = new javax.swing.JLabel();
        txtProd1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtQtde1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtValorTotal1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        cmbParcela1 = new javax.swing.JComboBox<String>();
        txtValorParc1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtData1 = new javax.swing.JFormattedTextField();
        btnBuscaProduto1 = new javax.swing.JButton();
        txtCPF1 = new javax.swing.JFormattedTextField();
        txtCNPJ1 = new javax.swing.JFormattedTextField();
        jLabel36 = new javax.swing.JLabel();
        txtDesconto1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<String>();
        jLabel20 = new javax.swing.JLabel();
        txtCPF3 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCNPJ3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnVoltar2 = new javax.swing.JButton();
        btnAlterar1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Tipo de Pagamento:");

        jLabel6.setText("CPF:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Vista", "Prazo" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel9.setText("Cliente:");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel5.setText("CNPJ:");

        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Físico", "Jurídico" }));
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Código Produto:");

        txtProd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProdFocusLost(evt);
            }
        });
        txtProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdActionPerformed(evt);
            }
        });

        jLabel1.setText("Quantidade:");

        txtQtde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtdeFocusLost(evt);
            }
        });
        txtQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdeActionPerformed(evt);
            }
        });

        jLabel3.setText("Valor Total:");

        jLabel4.setText("Parcelas:");

        cmbParcela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "1x", "2x", "3x", "4x", "5x", "6x c/ juros", "7x c/ juros", "8x c/ juros" }));
        cmbParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParcelaActionPerformed(evt);
            }
        });

        jLabel8.setText("Valores:");

        jLabel22.setText("Data Registro:");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnBuscaProduto.setText("Buscar");
        btnBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaProdutoActionPerformed(evt);
            }
        });

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("Desconto:");

        txtDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescontoActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo Produto:");

        cmbTipoProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Camisa", "Camiseta", "Moletom", "Calça", "Bermuda", "Short" }));
        cmbTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoProdutoActionPerformed(evt);
            }
        });

        btnPreencher.setText("Preencher");
        btnPreencher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreencherActionPerformed(evt);
            }
        });

        btnVerifica.setText("Verifica");
        btnVerifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(btnVoltar))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbTipo, 0, 190, Short.MAX_VALUE)
                                .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCPF))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(131, 131, 131))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorParc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(129, 129, 129))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnVerifica)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(107, 107, 107))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtProd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnBuscaProduto)
                        .addGap(18, 18, 18)
                        .addComponent(btnPreencher)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaProduto)
                    .addComponent(btnPreencher))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addComponent(btnVerifica))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtValorParc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnEnviar)
                    .addComponent(btnVoltar))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setText("Tipo de Pagamento:");

        jLabel24.setText("CPF:");

        cmbTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Á vista", "Á prazo" }));
        cmbTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipo1ActionPerformed(evt);
            }
        });

        jLabel25.setText("Cliente:");

        btnLimpar2.setText("Limpar");
        btnLimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar2ActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnVoltar3.setText("Voltar");
        btnVoltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar3ActionPerformed(evt);
            }
        });

        jLabel26.setText("CNPJ:");

        cmbCliente1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Físico", "Jurídico" }));
        cmbCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCliente1ActionPerformed(evt);
            }
        });

        jLabel27.setText("Código Produto:");

        jLabel28.setText("Quantidade:");

        jLabel29.setText("Valor Total:");

        jLabel30.setText("Parcelas:");

        cmbParcela1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "1x", "2x", "3x", "4x", "5x", "6x c/ juros", "7x c/ juros", "8x c/ juros" }));
        cmbParcela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParcela1ActionPerformed(evt);
            }
        });

        jLabel31.setText("Valor:");

        jLabel32.setText("Data Registro:");

        try {
            txtData1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnBuscaProduto1.setText("Buscar");
        btnBuscaProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaProduto1ActionPerformed(evt);
            }
        });

        try {
            txtCPF1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCNPJ1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel36.setText("Desconto:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(btnLimpar2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtData1)
                                    .addComponent(cmbTipo1, 0, 190, Short.MAX_VALUE)
                                    .addComponent(cmbCliente1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCPF1)
                                    .addComponent(txtCNPJ1))
                                .addGap(115, 115, 115)))
                        .addGap(103, 103, 103)
                        .addComponent(btnVoltar3))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel31)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtProd1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnBuscaProduto1))
                            .addComponent(cmbParcela1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorParc1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQtde1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cmbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtProd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscaProduto1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cmbCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtQtde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbParcela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtCNPJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorParc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar2)
                    .addComponent(btnAlterar)
                    .addComponent(btnVoltar3))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Alterar", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setText("Cliente: ");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Cliente Físico", "Cliente Jurídico" }));

        jLabel20.setText("CPF:");

        jLabel21.setText("CNPJ:");

        table.setModel(tabela);
        jScrollPane1.setViewportView(table);

        btnBuscar.setText("Buscar");

        btnVoltar2.setText("Voltar");
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });

        btnAlterar1.setText("Alterar");

        btnExcluir.setText("Excluir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCNPJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnVoltar2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addComponent(btnAlterar1)
                        .addGap(125, 125, 125)
                        .addComponent(btnExcluir)
                        .addContainerGap(185, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(btnBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtCNPJ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar2)
                    .addComponent(btnAlterar1)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        JPrincipal principal = new JPrincipal();
        if(principal.isVisible() == false){
           principal.setVisible(true);
           this.setVisible(false);
        }else{
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        JPrincipal principal = new JPrincipal();
        if(principal.isVisible() == false){
           principal.setVisible(true);
           this.setVisible(false);
        }else{
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       limpaCadastro();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        if(cmbCliente.getSelectedIndex() == 0){
           txtCPF.setEnabled(false);txtCNPJ.setEnabled(false); 
        }
        if(cmbCliente.getSelectedIndex() == 1){
            txtCPF.setEnabled(true);txtCNPJ.setEnabled(false);
        }
        if(cmbCliente.getSelectedIndex() == 2){
            txtCPF.setEnabled(false);txtCNPJ.setEnabled(true);
        }
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParcelaActionPerformed
        if(cmbParcela.getSelectedIndex() == 0){
            txtValorParc.setEnabled(false);
        }else{
            txtValorParc.setEnabled(true);
        }
        
    }//GEN-LAST:event_cmbParcelaActionPerformed

    private void btnBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProdutoActionPerformed
        JEstoque estoque = new JEstoque();
        estoque.setVisible(true);
        estoque.setIndex3();
        
    }//GEN-LAST:event_btnBuscaProdutoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        VendaAVista vendaVista = new VendaAVista();
        
        if(vazioCadastro() == true){
            JOptionPane.showMessageDialog(null, "Há campos vazios.");
        }else{
            String tipoPag = cmbTipo.getSelectedItem().toString();
            String tipoCliente = cmbCliente.getSelectedItem().toString();
            String cpf = txtCPF.getText();
            String cnpj = txtCNPJ.getText();
            String data = txtData.getText();
            int codigoProd = Integer.parseInt(txtProd.getText());
            int quantidade = Integer.parseInt(txtQtde.getText());
            double valorTotal = Double.parseDouble(txtValorTotal.getText());
            String tipoProduto = cmbTipoProduto.getSelectedItem().toString();
            double desconto=0;
            double valor=0;
            if(tipoPag.equals("Vista")){
                List<PessoaFisica> lista = vendaVista.getCliente().outputPessoaFisica();
                List<Blusas> blusas = vendaVista.getEstoque().outputBlusas();
                List<Blusas> calcas = vendaVista.getEstoque().outputBlusas();
                
                for(int i=0;i<lista.size();i++){
                    if(lista.get(i).getNumCompras() > 5){
                        txtDesconto.setText("15%");
                        desconto = vendaVista.getDesconto();
                        break;
                    }
                }
                valor = valorTotal + (valorTotal * desconto);
                getQuantidade();
                if(tipoCliente.equals("Cliente Físico")){

                    try{    
                        arquivoVenda.cadastraVendaVista(0, tipoPag, tipoCliente, cpf, cnpj, codigoProd, tipoProduto, data, quantidade, valor, desconto);
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                        if(tipoProduto.equals("Camisa") || tipoProduto.equals("Camisa") || tipoProduto.equals("Moletom")){
                            for(int i=0;i<blusas.size();i++){
                                if(blusas.get(i).getCodigo() == codigoProd){
                                    blusas.get(i).setQtde(blusas.get(i).getQtde() - quantidade);
                                }
                            }
                        }else{
                           if(tipoProduto.equals("Calça") || tipoProduto.equals("Bermuda") || tipoProduto.equals("Short")){
                                for(int i=0;i<calcas.size();i++){
                                    if(calcas.get(i).getCodigo() == codigoProd){
                                        calcas.get(i).setQtde(calcas.get(i).getQtde() - quantidade);
                                    }
                                }
                            }    
                        }
                        limpaCadastro();
                    } catch (IOException ex) {
                        Logger.getLogger(JVendas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
       if(cmbTipo.getSelectedIndex() == 0){
            cmbParcela.setEnabled(false);
        }else{
           if(cmbTipo.getSelectedIndex() == 1){
               cmbParcela.setEnabled(false);
           }else{
               cmbParcela.setEnabled(true);
           }
            
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void cmbTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipo1ActionPerformed

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpar2ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltar3ActionPerformed

    private void cmbCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCliente1ActionPerformed

    private void cmbParcela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParcela1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbParcela1ActionPerformed

    private void btnBuscaProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProduto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscaProduto1ActionPerformed

    private void cmbTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoProdutoActionPerformed
        
    }//GEN-LAST:event_cmbTipoProdutoActionPerformed

    private void txtProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdActionPerformed
        
    }//GEN-LAST:event_txtProdActionPerformed

    private void txtQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdeActionPerformed

    private void txtProdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdFocusLost
        
        
    }//GEN-LAST:event_txtProdFocusLost

    private void txtDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescontoActionPerformed

    private void txtQtdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdeFocusLost
        
         
    }//GEN-LAST:event_txtQtdeFocusLost

    private void btnPreencherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreencherActionPerformed
        int codigoProd = Integer.parseInt(txtProd.getText());
        double valorTotal;
        String tipoProduto;
        
           if(cmbTipo.getSelectedIndex() == 1){
            VendaAVista vendaVista = new VendaAVista();
            List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
            List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
            for(int i=0;i<listaBlusas.size();i++){
                if(listaBlusas.get(i).getCodigo() == codigoProd){
                    valorTotal = listaBlusas.get(i).getValor();
                    txtValorTotal.setText(valorTotal+"");
                    tipoProduto = listaBlusas.get(i).getTipo();
                    cmbTipoProduto.setSelectedItem(tipoProduto);
                }
            }
            for(int i=0;i<listaCalcas.size();i++){
                if(listaCalcas.get(i).getCodigo() == codigoProd){
                    valorTotal = listaCalcas.get(i).getValor();
                    txtValorTotal.setText(valorTotal+"");
                    tipoProduto = listaCalcas.get(i).getTipo();
                    cmbTipoProduto.setSelectedItem(tipoProduto);
                    break;
                }
            }
        }else{
            if(cmbTipo.getSelectedIndex() == 2){
                VendaAPrazo vendaPrazo = new VendaAPrazo();
                List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                for(int i=0;i<listaBlusas.size();i++){
                    if(listaBlusas.get(i).getCodigo() == codigoProd){
                        valorTotal = listaBlusas.get(i).getValor();
                        txtValorTotal.setText(valorTotal+"");
                        tipoProduto = listaBlusas.get(i).getTipo();
                        cmbTipoProduto.setSelectedItem(tipoProduto);
                    }
                }
                for(int i=0;i<listaCalcas.size();i++){
                    if(listaCalcas.get(i).getCodigo() == codigoProd){
                        valorTotal = listaCalcas.get(i).getValor();
                        txtValorTotal.setText(valorTotal+"");
                        tipoProduto = listaCalcas.get(i).getTipo();
                        cmbTipoProduto.setSelectedItem(tipoProduto);
                        break;
                    }
                }
            }else{
                if(cmbTipo.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Preencha o tipo de pagamento.");
                }
            }
        } 
    }//GEN-LAST:event_btnPreencherActionPerformed

    private void btnVerificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificaActionPerformed
        int codigoProd = Integer.parseInt(txtProd.getText());
        int quantidade = Integer.parseInt(txtQtde.getText());
       
           if(cmbTipo.getSelectedIndex() == 1){
            VendaAVista vendaVista = new VendaAVista();
            List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
            List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
            for(int i=0;i<listaBlusas.size();i++){
                if(listaBlusas.get(i).getCodigo()== codigoProd){
                    if((listaBlusas.get(i).getQtde() < quantidade)){
                        JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                        txtQtde.setText("");
                        break;
                    }
                }
            }
            for(int i=0;i<listaCalcas.size();i++){
                if(listaCalcas.get(i).getCodigo() == codigoProd){
                    if((listaCalcas.get(i).getQtde() < quantidade)){
                        JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                        txtQtde.setText("");
                        break;
                    }
                }
            }
        }else{
            if(cmbTipo.getSelectedIndex() == 2){
                VendaAPrazo vendaPrazo = new VendaAPrazo();
                List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                for(int i=0;i<listaBlusas.size();i++){
                    if(listaBlusas.get(i).getCodigo() == codigoProd){
                        if((listaBlusas.get(i).getQtde() < quantidade)){
                            JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                            txtQtde.setText("");
                            break;
                        }
                    }
                }
                for(int i=0;i<listaCalcas.size();i++){
                    if(listaCalcas.get(i).getCodigo() == codigoProd){
                        if((listaCalcas.get(i).getQtde() < quantidade)){
                            JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                            txtQtde.setText("");
                            break;
                        }    
                    }
                }
            }
        } 
    }//GEN-LAST:event_btnVerificaActionPerformed

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
            java.util.logging.Logger.getLogger(JVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterar1;
    private javax.swing.JButton btnBuscaProduto;
    private javax.swing.JButton btnBuscaProduto1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnPreencher;
    private javax.swing.JButton btnVerifica;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JButton btnVoltar3;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbCliente1;
    private javax.swing.JComboBox<String> cmbParcela;
    private javax.swing.JComboBox<String> cmbParcela1;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> cmbTipo1;
    private javax.swing.JComboBox cmbTipoProduto;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCNPJ1;
    private javax.swing.JTextField txtCNPJ3;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPF1;
    private javax.swing.JTextField txtCPF3;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JTextField txtDesconto;
    private javax.swing.JTextField txtDesconto1;
    private javax.swing.JTextField txtProd;
    private javax.swing.JTextField txtProd1;
    private javax.swing.JTextField txtQtde;
    private javax.swing.JTextField txtQtde1;
    private javax.swing.JTextField txtValorParc;
    private javax.swing.JTextField txtValorParc1;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorTotal1;
    // End of variables declaration//GEN-END:variables
}
