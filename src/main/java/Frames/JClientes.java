package Frames;

import Arquivo.ArquivoCliente;
import Registros.Endereco;
import Registros.PessoaFisica;
import Registros.PessoaJuridica;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 *
 * @author BEATRIZ CUNHA RODRIGUES 201776038
 * @author DANIEL RIBEIRO LAVRA 201735042
 * @author IVANYLSON HONÓRIO GONÇALVES 201776002
 * @author JAKSON DUARTE MARTINS JÚNIOR	201435004
 * @author MIKAELA CRISTINY QUITZ 201676014
 *
 */
public class JClientes extends javax.swing.JFrame {

    DefaultTableModel tabela = new DefaultTableModel();
    String vetTabela[] = new String[18];
    ArquivoCliente arquivoCliente;
    int posicao;

    public JClientes() {
        initComponents();
        arquivoCliente = new ArquivoCliente();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tabela.addColumn("Tipo");
        tabela.addColumn("Nome");
        tabela.addColumn("CPF");
        tabela.addColumn("Sexo");
        tabela.addColumn("Telefone");
        tabela.addColumn("CNPJ");
        tabela.addColumn("IE");
        tabela.addColumn("Data Nasc");
        tabela.addColumn("Data R.");
        tabela.addColumn("CEP");
        tabela.addColumn("Rua");
        tabela.addColumn("Número");
        tabela.addColumn("Bairro");
        tabela.addColumn("Cidade");
        tabela.addColumn("Estado");
        tabela.addColumn("País");
        tabela.addColumn("Complemento");
        tabela.addColumn("Num Compras");
        txtNome.setEnabled(false);
        txtTel.setEnabled(false);
        cmbSexo.setEnabled(false);
        txtBairro.setEnabled(false);
        txtCEP.setEnabled(false);
        txtCNPJ.setEnabled(false);
        txtCPF.setEnabled(false);
        txtCidade.setEnabled(false);
        txtComplemento.setEnabled(false);
        txtDataNasc.setEnabled(false);
        txtDataRegis.setEnabled(false);
        txtIE.setEnabled(false);
        txtNumero.setEnabled(false);
        txtPais.setEnabled(false);
        txtRua.setEnabled(false);
        cmbEstado.setEnabled(false);
        btnEnviar.setEnabled(false);
        txtCPF3.setEnabled(false);
        txtCNPJ3.setEnabled(false);
        txtNome2.setEnabled(false);
        txtTel2.setEnabled(false);
        cmbSexo2.setEnabled(false);
        txtBairro2.setEnabled(false);
        txtCEP2.setEnabled(false);
        txtCNPJ2.setEnabled(false);
        txtCPF2.setEnabled(false);
        txtCidade2.setEnabled(false);
        txtComplemento2.setEnabled(false);
        txtDataNasc2.setEnabled(false);
        txtDataRegis2.setEnabled(false);
        txtIE2.setEnabled(false);
        txtNumero2.setEnabled(false);
        txtPais2.setEnabled(false);
        txtRua2.setEnabled(false);
        cmbEstado2.setEnabled(false);
        btnAlterar.setEnabled(false);

    }

    public void limparCadastro() {
        cmbTipo.setSelectedItem("Selecione...");
        txtNome.setText("");
        txtTel.setText("");
        txtCPF.setText("");
        cmbSexo.setSelectedItem("Selecione...");
        txtCEP.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtCNPJ.setText("");
        txtIE.setText("");
        txtDataNasc.setText("");
        txtDataRegis.setText("");
        txtNumero.setText("");
        cmbEstado.setSelectedItem("Selecione...");
        txtPais.setText("");
        txtComplemento.setText("");
    }

    public void limparAlterar() {
        cmbTipo3.setSelectedItem("Selecione...");
        txtNome2.setText("");
        txtTel2.setText("");
        txtCPF2.setText("");
        cmbSexo2.setSelectedItem("Selecione...");
        txtCEP2.setText("");
        txtRua2.setText("");
        txtBairro2.setText("");
        txtCidade2.setText("");
        txtCNPJ2.setText("");
        txtIE2.setText("");
        txtDataNasc2.setText("");
        txtDataRegis2.setText("");
        txtNumero2.setText("");
        cmbEstado2.setSelectedItem("Selecione...");
        txtPais2.setText("");
        txtComplemento2.setText("");
    }

    public boolean vazioCadastro() {
        boolean vazio = false;
        if (cmbTipo.getSelectedIndex() == 0) {
            vazio = true;
        } else {
            if (cmbTipo.getSelectedIndex() == 1) {
                if (txtNome.getText().equals("") || txtTel.getText().equals("(  )          ") || txtCPF.getText().equals("   .   .   -  ") || cmbSexo.getSelectedItem().equals("Selecione aqui...")
                        || txtDataNasc.getText().equals("  /  /    ") || txtDataRegis.getText().equals("  /  /    ") || txtCEP.getText().equals("     -   ")
                        || txtRua.getText().equals("") || txtBairro.getText().equals("") || txtCidade.getText().equals("") || txtNumero.getText().equals("")
                        || cmbEstado.getSelectedItem().equals("Selecione aqui...") || txtPais.getText().equals("") || txtComplemento.getText().equals("")) {
                    vazio = true;
                }
            } else {
                if (cmbTipo.getSelectedIndex() == 2) {
                    if (txtNome.getText().equals("") || txtTel.getText().equals("(  )          ") || txtCNPJ.getText().equals("  .   .   /    -  ") || txtIE.getText().equals("")
                            || txtDataRegis.getText().equals("  /  /    ") || txtCEP.getText().equals("     -   ") || txtRua.getText().equals("") || txtBairro.getText().equals("")
                            || txtCidade.getText().equals("") || txtNumero.getText().equals("") || cmbEstado.getSelectedItem().equals("Selecione aqui...")
                            || txtPais.getText().equals("") || txtComplemento.getText().equals("")) {
                        vazio = true;
                    }
                }
            }
        }
     return vazio ;
}

public boolean vazioAlterar() {
        boolean vazio = false;
        if (cmbTipo3.getSelectedIndex() == 0) {
            vazio = true;
        } else {
            if (cmbTipo3.getSelectedIndex() == 1) {
                if (txtNome2.getText().equals("") || txtTel2.getText().equals("(  )          ") || txtCPF2.getText().equals("   .   .   -  ") || cmbSexo2.getSelectedItem().equals("Selecione aqui...")
                        || txtDataNasc2.getText().equals("  /  /    ") || txtDataRegis2.getText().equals("  /  /    ") || txtCEP2.getText().equals("     -   ")
                        || txtRua2.getText().equals("") || txtBairro2.getText().equals("") || txtCidade2.getText().equals("") || txtNumero2.getText().equals("")
                        || cmbEstado2.getSelectedItem().equals("Selecione aqui...") || txtPais2.getText().equals("") || txtComplemento2.getText().equals("")) {
                    vazio = true;
                } else {
                    if (cmbTipo3.getSelectedIndex() == 2) {
                        if (txtNome2.getText().equals("") || txtTel2.getText().equals("(  )          ") || txtCNPJ2.getText().equals("  .   .   /    -  ") || txtIE2.getText().equals("")
                                || txtDataRegis2.getText().equals("  /  /    ") || txtCEP2.getText().equals("     -   ") || txtRua2.getText().equals("") || txtBairro2.getText().equals("")
                                || txtCidade2.getText().equals("") || txtNumero2.getText().equals("") || cmbEstado2.getSelectedItem().equals("Selecione aqui...")
                                || txtPais2.getText().equals("") || txtComplemento2.getText().equals("")) {
                            vazio = true;
                        } else {
                            vazio = false;
                        }
                    }
                }
            }
        }
        return vazio;
    }

    public void pesquisa() {
        List<PessoaFisica> f = arquivoCliente.outputPessoaFisica();
        List<Endereco> ef = arquivoCliente.outputEnderecoFisico();
        List<PessoaJuridica> j = arquivoCliente.outputPessoaJuridica();
        List<Endereco> ej = arquivoCliente.outputEnderecoJuridico();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < f.size(); i++) {
            vetTabela[0] = f.get(i).getTipo();
            vetTabela[1] = f.get(i).getNome();
            vetTabela[2] = f.get(i).getCpf();
            vetTabela[3] = f.get(i).getSexo();
            vetTabela[4] = f.get(i).getTelefone();
            vetTabela[5] = "";
            vetTabela[6] = "";
            vetTabela[7] = f.get(i).getDataNasc();
            vetTabela[8] = f.get(i).getDataRegistro();
            vetTabela[9] = ef.get(i).getCEP();
            vetTabela[10] = ef.get(i).getRua();
            vetTabela[11] = ef.get(i).getNumero() + "";
            vetTabela[12] = ef.get(i).getBairro();
            vetTabela[13] = ef.get(i).getCidade();
            vetTabela[14] = ef.get(i).getEstado();
            vetTabela[15] = ef.get(i).getPais();
            vetTabela[16] = ef.get(i).getComplemento();
            vetTabela[17] = f.get(i).getNumCompras() + "";
            tabela.addRow(vetTabela);
        }
        for (int i = 0; i < j.size(); i++) {
            vetTabela[0] = j.get(i).getTipo();
            vetTabela[1] = j.get(i).getNome();
            vetTabela[2] = "";
            vetTabela[3] = "";
            vetTabela[4] = j.get(i).getTelefone();
            vetTabela[5] = j.get(i).getCnpj();
            vetTabela[6] = j.get(i).getIe();
            vetTabela[7] = "";
            vetTabela[8] = j.get(i).getDataRegistro();
            vetTabela[9] = ej.get(i).getCEP();
            vetTabela[10] = ej.get(i).getRua();
            vetTabela[11] = ej.get(i).getNumero() + "";
            vetTabela[12] = ej.get(i).getBairro();
            vetTabela[13] = ej.get(i).getCidade();
            vetTabela[14] = ej.get(i).getEstado();
            vetTabela[15] = ej.get(i).getPais();
            vetTabela[16] = ej.get(i).getComplemento();
            vetTabela[17] = j.get(i).getNumCompras() + "";
            tabela.addRow(vetTabela);
        }
    }

    public void pesquisaPorCPF() {
        List<PessoaFisica> f = arquivoCliente.outputPessoaFisica();
        List<Endereco> ef = arquivoCliente.outputEnderecoFisico();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < f.size(); i++) {
            if (txtCPF3.getText().equals(f.get(i).getCpf())) {
                vetTabela[0] = f.get(i).getTipo();
                vetTabela[1] = f.get(i).getNome();
                vetTabela[2] = f.get(i).getCpf();
                vetTabela[3] = f.get(i).getSexo();
                vetTabela[4] = f.get(i).getTelefone();
                vetTabela[5] = "";
                vetTabela[6] = "";
                vetTabela[7] = f.get(i).getDataNasc();
                vetTabela[8] = f.get(i).getDataRegistro();
                vetTabela[9] = ef.get(i).getCEP();
                vetTabela[10] = ef.get(i).getRua();
                vetTabela[11] = ef.get(i).getNumero() + "";
                vetTabela[12] = ef.get(i).getBairro();
                vetTabela[13] = ef.get(i).getCidade();
                vetTabela[14] = ef.get(i).getEstado();
                vetTabela[15] = ef.get(i).getPais();
                vetTabela[16] = ef.get(i).getComplemento();
                vetTabela[17] = f.get(i).getNumCompras() + "";

            }
        }
        tabela.addRow(vetTabela);
    }

    public void pesquisaPorCNPJ() {
        List<PessoaJuridica> j = arquivoCliente.outputPessoaJuridica();
        List<Endereco> ej = arquivoCliente.outputEnderecoJuridico();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < j.size(); i++) {
            if (txtCNPJ3.getText().equals(j.get(i).getCnpj())) {
                vetTabela[0] = j.get(i).getTipo();
                vetTabela[1] = j.get(i).getNome();
                vetTabela[2] = "";
                vetTabela[3] = "";
                vetTabela[4] = j.get(i).getTelefone();
                vetTabela[5] = j.get(i).getCnpj();
                vetTabela[6] = j.get(i).getIe();
                vetTabela[7] = "";
                vetTabela[8] = j.get(i).getDataRegistro();
                vetTabela[9] = ej.get(i).getCEP();
                vetTabela[10] = ej.get(i).getRua();
                vetTabela[11] = ej.get(i).getNumero() + "";
                vetTabela[12] = ej.get(i).getBairro();
                vetTabela[13] = ej.get(i).getCidade();
                vetTabela[14] = ej.get(i).getEstado();
                vetTabela[15] = ej.get(i).getPais();
                vetTabela[16] = ej.get(i).getComplemento();
                vetTabela[17] = j.get(i).getNumCompras() + "";
            }
        }
        tabela.addRow(vetTabela);
    }

    public void pesquisaPorTipoCliente() {
        List<PessoaFisica> f = arquivoCliente.outputPessoaFisica();
        List<Endereco> ef = arquivoCliente.outputEnderecoFisico();
        List<PessoaJuridica> j = arquivoCliente.outputPessoaJuridica();
        List<Endereco> ej = arquivoCliente.outputEnderecoJuridico();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < f.size(); i++) {
            if (cmbTipo2.getSelectedIndex() == 1) {
                vetTabela[0] = f.get(i).getTipo();
                vetTabela[1] = f.get(i).getNome();
                vetTabela[2] = f.get(i).getCpf();
                vetTabela[3] = f.get(i).getSexo();
                vetTabela[4] = f.get(i).getTelefone();
                vetTabela[5] = "";
                vetTabela[6] = "";
                vetTabela[7] = f.get(i).getDataNasc();
                vetTabela[8] = f.get(i).getDataRegistro();
                vetTabela[9] = ef.get(i).getCEP();
                vetTabela[10] = ef.get(i).getRua();
                vetTabela[11] = ef.get(i).getNumero() + "";
                vetTabela[12] = ef.get(i).getBairro();
                vetTabela[13] = ef.get(i).getCidade();
                vetTabela[14] = ef.get(i).getEstado();
                vetTabela[15] = ef.get(i).getPais();
                vetTabela[16] = ef.get(i).getComplemento();
                vetTabela[17] = f.get(i).getNumCompras() + "";
                tabela.addRow(vetTabela);

            }
        }
        for (int i = 0; i < j.size(); i++) {
            if (cmbTipo2.getSelectedIndex() == 2) {
                vetTabela[0] = j.get(i).getTipo();
                vetTabela[1] = j.get(i).getNome();
                vetTabela[2] = "";
                vetTabela[3] = "";
                vetTabela[4] = j.get(i).getTelefone();
                vetTabela[5] = j.get(i).getCnpj();
                vetTabela[6] = j.get(i).getIe();
                vetTabela[7] = "";
                vetTabela[8] = j.get(i).getDataRegistro();
                vetTabela[9] = ej.get(i).getCEP();
                vetTabela[10] = ej.get(i).getRua();
                vetTabela[11] = ej.get(i).getNumero() + "";
                vetTabela[12] = ej.get(i).getBairro();
                vetTabela[13] = ej.get(i).getCidade();
                vetTabela[14] = ej.get(i).getEstado();
                vetTabela[15] = ej.get(i).getPais();
                vetTabela[16] = ej.get(i).getComplemento();
                vetTabela[17] = j.get(i).getNumCompras() + "";
                tabela.addRow(vetTabela);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<String>();
        jLabel7 = new javax.swing.JLabel();
        txtIE = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        txtPais = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTel = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        txtCEP = new javax.swing.JFormattedTextField();
        txtDataNasc = new javax.swing.JFormattedTextField();
        txtDataRegis = new javax.swing.JFormattedTextField();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbTipo3 = new javax.swing.JComboBox<String>();
        jLabel30 = new javax.swing.JLabel();
        txtNome2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        cmbSexo2 = new javax.swing.JComboBox<String>();
        jLabel45 = new javax.swing.JLabel();
        txtIE2 = new javax.swing.JTextField();
        btnLimpar2 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVoltar3 = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtRua2 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtBairro2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtCidade2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        txtNumero2 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        cmbEstado2 = new javax.swing.JComboBox();
        jLabel53 = new javax.swing.JLabel();
        txtPais2 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtComplemento2 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        txtTel2 = new javax.swing.JFormattedTextField();
        txtCPF2 = new javax.swing.JFormattedTextField();
        txtCEP2 = new javax.swing.JFormattedTextField();
        txtDataNasc2 = new javax.swing.JFormattedTextField();
        txtDataRegis2 = new javax.swing.JFormattedTextField();
        txtCNPJ2 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cmbTipo2 = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnVoltar2 = new javax.swing.JButton();
        btnAlterar1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtCPF3 = new javax.swing.JFormattedTextField();
        txtCNPJ3 = new javax.swing.JFormattedTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Cliente:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Cliente Físico", "Cliente Jurídico" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Data Registro:");

        jLabel5.setText("CPF:");

        jLabel6.setText("Sexo:");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Feminino", "Masculino" }));

        jLabel7.setText("Data Nascimento:");

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

        jLabel22.setText("CEP:");

        jLabel23.setText("Rua:");

        jLabel24.setText("Bairro:");

        jLabel25.setText("Cidade:");

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        jLabel26.setText("Número:");

        jLabel27.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel28.setText("País:");

        jLabel29.setText("Complemento:");

        jLabel13.setText("CNPJ:");

        jLabel14.setText("IE:");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataRegis.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel2)
                            .addGap(4, 4, 4)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(397, 397, 397))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(101, 101, 101)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDataRegis, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(txtDataNasc))
                                    .addGap(90, 90, 90))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel14))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplemento))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180)
                                .addComponent(jLabel28)))
                        .addGap(4, 4, 4)
                        .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDataRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar)
                    .addComponent(btnEnviar)
                    .addComponent(btnVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Cliente:");

        cmbTipo3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Cliente Físico", "Cliente Jurídico" }));
        cmbTipo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipo3ActionPerformed(evt);
            }
        });

        jLabel30.setText("Nome:");

        jLabel31.setText("Telefone:");

        jLabel42.setText("Data Registro:");

        jLabel43.setText("CPF:");

        jLabel44.setText("Sexo:");

        cmbSexo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Feminino", "Masculino" }));

        jLabel45.setText("Data Nascimento:");

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

        jLabel47.setText("CEP:");

        jLabel48.setText("Rua:");

        jLabel49.setText("Bairro:");

        jLabel50.setText("Cidade:");

        jLabel51.setText("Número:");

        jLabel52.setText("Estado:");

        cmbEstado2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel53.setText("País:");

        jLabel54.setText("Complemento:");

        jLabel55.setText("CNPJ:");

        jLabel56.setText("IE:");

        try {
            txtTel2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCPF2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCEP2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataNasc2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtDataRegis2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCNPJ2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(4, 4, 4)
                        .addComponent(cmbTipo3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel49)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(jLabel52)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(btnLimpar2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVoltar3))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(jLabel30)
                            .addGap(4, 4, 4)
                            .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(397, 397, 397))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel31)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel44)
                                        .addComponent(jLabel43))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbSexo2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(101, 101, 101)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel42)
                                        .addComponent(jLabel45))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDataNasc2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addComponent(txtDataRegis2))
                                    .addGap(75, 75, 75))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel55)
                                        .addComponent(jLabel56))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIE2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCNPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplemento2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180)
                                .addComponent(jLabel53)))
                        .addGap(4, 4, 4)
                        .addComponent(txtPais2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRua2, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCEP2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(174, 174, 174))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(cmbTipo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel55)
                        .addComponent(txtCNPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel30)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel56)))
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(txtDataNasc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSexo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(txtDataRegis2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel51))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(txtCEP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRua2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtBairro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel52))
                    .addComponent(cmbEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(txtCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel53))
                    .addComponent(txtPais2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtComplemento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGap(52, 52, 52)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLimpar2)
                    .addComponent(btnAlterar)
                    .addComponent(btnVoltar3)))
        );

        jTabbedPane1.addTab("Alterar", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Cliente: ");

        cmbTipo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Cliente Físico", "Cliente Jurídico" }));
        cmbTipo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipo2ActionPerformed(evt);
            }
        });

        jLabel11.setText("CPF:");

        jLabel12.setText("CNPJ:");

        table.setModel(tabela);
        jScrollPane1.setViewportView(table);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVoltar2.setText("Voltar");
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });

        btnAlterar1.setText("Alterar");
        btnAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterar1ActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        try {
            txtCPF3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCNPJ3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnVoltar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAlterar1)
                .addGap(165, 165, 165)
                .addComponent(btnExcluir)
                .addGap(172, 172, 172))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCNPJ3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(btnBuscar)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(txtCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCNPJ3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar2)
                    .addComponent(btnAlterar1)
                    .addComponent(btnExcluir))
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Pesquisar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        JPrincipal principal = new JPrincipal();
        if (principal.isVisible() == false) {
            principal.setVisible(true);
            this.setVisible(false);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        JPrincipal principal = new JPrincipal();
        if (principal.isVisible() == false) {
            principal.setVisible(true);
            this.setVisible(false);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCadastro();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        if (vazioCadastro() == true) {
            JOptionPane.showMessageDialog(null, "Há campos vazios.");
        } else {
            String tipo = cmbTipo.getSelectedItem().toString();
            String nome = txtNome.getText();
            String telefone = txtTel.getText();
            int numCompras = 0;
            String dataRegistro = txtDataRegis.getText();
            String bairro = txtBairro.getText();
            String CEP = txtCEP.getText();
            String cidade = txtCidade.getText();
            String complemento = txtComplemento.getText();
            String estado = cmbEstado.getSelectedItem().toString();
            int numero = Integer.parseInt(txtNumero.getText());
            String pais = txtPais.getText();
            String rua = txtRua.getText();
            String cpf = txtCPF.getText();
            String sexo = cmbSexo.getSelectedItem().toString();
            String dataNasc = txtDataNasc.getText();
            String ie = txtIE.getText();
            String cnpj = txtCNPJ.getText();
            if (cmbTipo.getSelectedIndex() == 1) {

                try {
                    arquivoCliente.cadastraPessoaFisica(tipo, nome, cpf, sexo, telefone, dataNasc, numCompras, dataRegistro, bairro, rua, CEP, complemento, cidade, pais, estado, numero);
                    arquivoCliente.inputPessoaFisica();
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                    limparCadastro();
                

} catch (IOException ex) {
                    Logger.getLogger(JClientes.class  

.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (cmbTipo.getSelectedIndex() == 2) {

                    try {
                        arquivoCliente.cadastraPessoaJuridica(tipo, nome, cnpj, ie, telefone, numCompras, dataRegistro, bairro, rua, CEP, complemento, cidade, pais, estado, numero);
                        arquivoCliente.inputPessoaJuridica();
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                        limparCadastro();
                    

} catch (IOException ex) {
                        Logger.getLogger(JClientes.class  

.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar2ActionPerformed
        limparAlterar();
    }//GEN-LAST:event_btnLimpar2ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (vazioAlterar() == true) {
            JOptionPane.showMessageDialog(null, "Há campos vazios.");
        } else {
            String tipo = cmbTipo3.getSelectedItem().toString();
            String nome = txtNome2.getText();
            String telefone = txtTel2.getText();
            int numCompras = 0;
            String dataRegistro = txtDataRegis2.getText();
            String bairro = txtBairro2.getText();
            String CEP = txtCEP2.getText();
            String cidade = txtCidade2.getText();
            String complemento = txtComplemento2.getText();
            String estado = cmbEstado2.getSelectedItem().toString();
            int numero = Integer.parseInt(txtNumero2.getText());
            String pais = txtPais2.getText();
            String rua = txtRua2.getText();
            String cpf = txtCPF2.getText();
            String sexo = cmbSexo2.getSelectedItem().toString();
            String dataNasc = txtDataNasc2.getText();
            String ie = txtIE2.getText();
            String cnpj = txtCNPJ2.getText();
            if (cmbTipo3.getSelectedIndex() == 1) {

                try {
                    arquivoCliente.alterarFisico(tipo, nome, cpf, sexo, telefone, dataNasc, numCompras, dataRegistro, bairro, rua, CEP, complemento, cidade, pais, estado, numero, posicao);
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                    limparAlterar();
                

} catch (IOException ex) {
                    Logger.getLogger(JClientes.class  

.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (cmbTipo3.getSelectedIndex() == 2) {

                    try {
                        arquivoCliente.alterarJuridico(tipo, nome, cnpj, ie, telefone, numCompras, dataRegistro, bairro, rua, CEP, complemento, cidade, pais, estado, numero, posicao);
                        JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                        limparAlterar();
                    

} catch (IOException ex) {
                        Logger.getLogger(JClientes.class  

.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar3ActionPerformed
        JPrincipal principal = new JPrincipal();
        if (principal.isVisible() == false) {
            principal.setVisible(true);
            this.setVisible(false);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltar3ActionPerformed

    private void cmbTipo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipo3ActionPerformed
        if (cmbTipo3.getSelectedIndex() == 0) {
            txtNome2.setEnabled(false);
            txtTel2.setEnabled(false);
            cmbSexo2.setEnabled(false);
            txtBairro2.setEnabled(false);
            txtCEP2.setEnabled(false);
            txtCNPJ2.setEnabled(false);
            txtCPF2.setEnabled(false);
            txtCidade2.setEnabled(false);
            txtComplemento2.setEnabled(false);
            txtDataNasc2.setEnabled(false);
            txtDataRegis2.setEnabled(false);
            txtIE2.setEnabled(false);
            txtNumero2.setEnabled(false);
            txtPais2.setEnabled(false);
            txtRua2.setEnabled(false);
            cmbEstado2.setEnabled(false);
            btnAlterar.setEnabled(false);
        }
        if (cmbTipo3.getSelectedIndex() == 1) {
            txtNome2.setEnabled(true);
            txtTel2.setEnabled(true);
            cmbSexo2.setEnabled(true);
            txtBairro2.setEnabled(true);
            txtCEP2.setEnabled(true);
            txtCNPJ2.setEnabled(false);
            txtCPF2.setEnabled(true);
            txtCidade2.setEnabled(true);
            txtComplemento2.setEnabled(true);
            txtDataNasc2.setEnabled(true);
            txtDataRegis2.setEnabled(true);
            txtIE2.setEnabled(false);
            txtNumero2.setEnabled(true);
            txtPais2.setEnabled(true);
            txtRua2.setEnabled(true);
            cmbEstado2.setEnabled(true);
            btnAlterar.setEnabled(true);
        }
        if (cmbTipo3.getSelectedIndex() == 2) {
            txtNome2.setEnabled(true);
            txtTel2.setEnabled(true);
            cmbSexo2.setEnabled(false);
            txtBairro2.setEnabled(true);
            txtCEP2.setEnabled(true);
            txtCNPJ2.setEnabled(true);
            txtCPF2.setEnabled(false);
            txtCidade2.setEnabled(true);
            txtComplemento2.setEnabled(true);
            txtDataNasc2.setEnabled(false);
            txtDataRegis2.setEnabled(true);
            txtIE2.setEnabled(true);
            txtNumero2.setEnabled(true);
            txtPais2.setEnabled(true);
            txtRua2.setEnabled(true);
            cmbEstado2.setEnabled(true);
            btnAlterar.setEnabled(true);
        }
    }//GEN-LAST:event_cmbTipo3ActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if (cmbTipo.getSelectedIndex() == 0) {
            txtNome.setEnabled(false);
            txtTel.setEnabled(false);
            cmbSexo.setEnabled(false);
            txtBairro.setEnabled(false);
            txtCEP.setEnabled(false);
            txtCNPJ.setEnabled(false);
            txtCPF.setEnabled(false);
            txtCidade.setEnabled(false);
            txtComplemento.setEnabled(false);
            txtDataNasc.setEnabled(false);
            txtDataRegis.setEnabled(false);
            txtIE.setEnabled(false);
            txtNumero.setEnabled(false);
            txtPais.setEnabled(false);
            txtRua.setEnabled(false);
            cmbEstado.setEnabled(false);
            btnEnviar.setEnabled(false);
        }
        if (cmbTipo.getSelectedIndex() == 1) {
            txtNome.setEnabled(true);
            txtTel.setEnabled(true);
            cmbSexo.setEnabled(true);
            txtBairro.setEnabled(true);
            txtCEP.setEnabled(true);
            txtCNPJ.setEnabled(false);
            txtCPF.setEnabled(true);
            txtCidade.setEnabled(true);
            txtComplemento.setEnabled(true);
            txtDataNasc.setEnabled(true);
            txtDataRegis.setEnabled(true);
            txtIE.setEnabled(false);
            txtNumero.setEnabled(true);
            txtPais.setEnabled(true);
            txtRua.setEnabled(true);
            cmbEstado.setEnabled(true);
            btnEnviar.setEnabled(true);
        }
        if (cmbTipo.getSelectedIndex() == 2) {
            txtNome.setEnabled(true);
            txtTel.setEnabled(true);
            cmbSexo.setEnabled(false);
            txtBairro.setEnabled(true);
            txtCEP.setEnabled(true);
            txtCNPJ.setEnabled(true);
            txtCPF.setEnabled(false);
            txtCidade.setEnabled(true);
            txtComplemento.setEnabled(true);
            txtDataNasc.setEnabled(false);
            txtDataRegis.setEnabled(true);
            txtIE.setEnabled(true);
            txtNumero.setEnabled(true);
            txtPais.setEnabled(true);
            txtRua.setEnabled(true);
            cmbEstado.setEnabled(true);
            btnEnviar.setEnabled(true);
        }


    }//GEN-LAST:event_cmbTipoActionPerformed

    private void cmbTipo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipo2ActionPerformed
        if (cmbTipo2.getSelectedIndex() == 0) {
            txtCPF3.setEnabled(false);
            txtCNPJ3.setEnabled(false);
            txtCPF3.setText("");
            txtCNPJ3.setText("");
        }
        if (cmbTipo2.getSelectedIndex() == 1) {
            txtCPF3.setEnabled(true);
            txtCNPJ3.setEnabled(false);
            txtCNPJ3.setText("");
        }
        if (cmbTipo2.getSelectedIndex() == 2) {
            txtCPF3.setEnabled(false);
            txtCNPJ3.setEnabled(true);
            txtCPF3.setText("");
        }
    }//GEN-LAST:event_cmbTipo2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (cmbTipo2.getSelectedIndex() == 0) {
            pesquisa();
        }
        if (cmbTipo2.getSelectedIndex() > 0) {
            if ((cmbTipo2.getSelectedIndex() == 1) && (!txtCPF3.getText().equals(""))) {
                pesquisaPorCPF();
            } else {
                if ((cmbTipo2.getSelectedIndex() == 2) && (!txtCNPJ3.getText().equals(""))) {
                    pesquisaPorCNPJ();
                } else {
                    if (txtCPF3.getText().equals("   .   .   -  ") && txtCNPJ3.getText().equals("  .   .   /    -  ")) {
                        pesquisaPorTipoCliente();
                    }
                }
            }
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String cpf = table.getValueAt(table.getSelectedRow(), 2).toString();
        String cnpj = table.getValueAt(table.getSelectedRow(), 5).toString();
        if (table.getSelectedRow() >= 0) {

            if (JOptionPane.showConfirmDialog(null, "Deseja excluir realmente?", "Confirmação", 0) == 0) {

                try {
                    if (!cpf.equals("")) {
                        if (arquivoCliente.excluirPessoaFisica(cpf)) {
                            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                            pesquisa();
                        }
                    } else {
                        if (!cnpj.equals("")) {
                            if (arquivoCliente.excluirPessoaJuridica(cnpj)) {
                                JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                                pesquisa();
                            

}
                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(JLogin.class  

.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterar1ActionPerformed
        String cpf = table.getValueAt(table.getSelectedRow(), 2).toString();
        String cnpj = table.getValueAt(table.getSelectedRow(), 5).toString();
        if (table.getSelectedRow() >= 0) {
            if (!cpf.equals("")) {
                List<PessoaFisica> f = arquivoCliente.outputPessoaFisica();
                List<Endereco> ef = arquivoCliente.outputEnderecoFisico();
                for (int i = 0; i < f.size(); i++) {
                    if (f.get(i).getCpf().equals(cpf)) {
                        cmbTipo3.setSelectedItem(f.get(i).getTipo());
                        txtNome2.setText(f.get(i).getNome());
                        txtBairro2.setText(ef.get(i).getBairro());
                        txtCEP2.setText(ef.get(i).getCEP());
                        txtCidade2.setText(ef.get(i).getCidade());
                        txtDataNasc2.setText(f.get(i).getDataNasc());
                        cmbEstado2.setSelectedItem(ef.get(i).getEstado());
                        cmbSexo2.setSelectedItem(f.get(i).getSexo());
                        txtCPF2.setText(f.get(i).getCpf());
                        txtComplemento2.setText(ef.get(i).getComplemento());
                        txtDataRegis2.setText(f.get(i).getDataRegistro());
                        txtNumero2.setText(ef.get(i).getNumero() + "");
                        txtTel2.setText(f.get(i).getTelefone());
                        txtRua2.setText(ef.get(i).getRua());
                        txtPais2.setText(ef.get(i).getPais());
                        posicao = i;
                        break;
                    }
                }
                jTabbedPane1.setSelectedIndex(1);
            } else {
                if (!cnpj.equals("")) {
                    List<PessoaJuridica> j = arquivoCliente.outputPessoaJuridica();
                    List<Endereco> ej = arquivoCliente.outputEnderecoJuridico();
                    for (int i = 0; i < j.size(); i++) {
                        if (j.get(i).getCnpj().equals(cnpj)) {
                            cmbTipo3.setSelectedItem(j.get(i).getTipo());
                            txtNome2.setText(j.get(i).getNome());
                            txtBairro2.setText(ej.get(i).getBairro());
                            txtCEP2.setText(ej.get(i).getCEP());
                            txtCidade2.setText(ej.get(i).getCidade());
                            txtCNPJ2.setText(j.get(i).getCnpj());
                            cmbEstado2.setSelectedItem(ej.get(i).getEstado());
                            txtIE2.setText(j.get(i).getIe());
                            txtComplemento2.setText(ej.get(i).getComplemento());
                            txtDataRegis2.setText(j.get(i).getDataRegistro());
                            txtNumero2.setText(ej.get(i).getNumero() + "");
                            txtTel2.setText(j.get(i).getTelefone());
                            txtRua2.setText(ej.get(i).getRua());
                            txtPais2.setText(ej.get(i).getPais());
                            posicao = i;
                            break;
                        }
                    }
                    jTabbedPane1.setSelectedIndex(1);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma linha.");
                }
            }
        }
    }//GEN-LAST:event_btnAlterar1ActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

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
            java.util.logging.Logger.getLogger(JClientes.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JClientes.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JClientes.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JClientes.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar2;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JButton btnVoltar3;
    private javax.swing.JComboBox cmbEstado;
    private javax.swing.JComboBox cmbEstado2;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbSexo2;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> cmbTipo2;
    private javax.swing.JComboBox<String> cmbTipo3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtBairro2;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCEP2;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCNPJ2;
    private javax.swing.JFormattedTextField txtCNPJ3;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPF2;
    private javax.swing.JFormattedTextField txtCPF3;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCidade2;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtComplemento2;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JFormattedTextField txtDataNasc2;
    private javax.swing.JFormattedTextField txtDataRegis;
    private javax.swing.JFormattedTextField txtDataRegis2;
    private javax.swing.JTextField txtIE;
    private javax.swing.JTextField txtIE2;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome2;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtPais2;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtRua2;
    private javax.swing.JFormattedTextField txtTel;
    private javax.swing.JFormattedTextField txtTel2;
    // End of variables declaration//GEN-END:variables
}
