package Frames;

import Arquivo.ArquivoVenda;
import Registros.Blusas;
import Registros.Calcas;
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
 * @author BEATRIZ CUNHA RODRIGUES 201776038
 * @author DANIEL RIBEIRO LAVRA 201735042
 * @author IVANYLSON HONÓRIO GONÇALVES 201776002
 * @author JAKSON DUARTE MARTINS JÚNIOR	201435004
 * @author MIKAELA CRISTINY QUITZ 201676014
 *
 */
public class JVendas extends javax.swing.JFrame {

    public void setIndex0() {
        jTabbedPane1.setSelectedIndex(0);
    }

    public void setIndex1() {
        jTabbedPane1.setSelectedIndex(1);
    }
    DefaultTableModel tabela = new DefaultTableModel();
    String vetTabela[] = new String[12];
    ArquivoVenda arquivoVenda;
    int codigo = 0;
    int posicao;

    public JVendas() {
        initComponents();
        arquivoVenda = new ArquivoVenda();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        tabela.addColumn("Código");
        tabela.addColumn("Tipo");
        tabela.addColumn("Tipo Cliente");
        tabela.addColumn("CPF");
        tabela.addColumn("CNPJ");
        tabela.addColumn("Data Regis.");
        tabela.addColumn("Cod. Produto");
        tabela.addColumn("Tipo Produto");
        tabela.addColumn("Quant.");
        tabela.addColumn("Val. Total");
        tabela.addColumn("Parcelas");
        tabela.addColumn("Valor Parcela");
        txtCPF.setEnabled(false);
        txtCNPJ.setEnabled(false);
        txtValorParc.setEnabled(false);
        cmbParcela.setEnabled(false);
        txtDesconto.setEnabled(false);
        txtValorTotal.setEnabled(false);
        txtCPF2.setEnabled(false);
        txtCNPJ2.setEnabled(false);
        txtCPF1.setEnabled(false);
        txtCNPJ1.setEnabled(false);
        txtValorParc1.setEnabled(false);
        cmbParcela1.setEnabled(false);
        txtDesconto1.setEnabled(false);
        txtValorTotal1.setEnabled(false);
        cmbTipoProduto.setEnabled(false);

    }

    public void limpaCadastro() {
        cmbTipo.setSelectedIndex(0);
        cmbCliente.setSelectedIndex(0);
        txtCPF.setText("");
        txtCNPJ.setText("");
        txtData.setText("");
        txtProd.setText("");
        txtQtde.setText("");
        txtValorTotal.setText("");
        cmbParcela.setSelectedIndex(0);
        txtValorParc.setText("");
        txtDesconto.setText("");
        cmbTipoProduto.setSelectedIndex(0);
    }

    public void limpaAlterar() {
        cmbTipo1.setSelectedIndex(0);
        cmbCliente1.setSelectedIndex(0);
        txtCPF1.setText("");
        txtCNPJ1.setText("");
        txtData1.setText("");
        txtProd1.setText("");
        txtQtde1.setText("");
        txtValorTotal1.setText("");
        cmbParcela1.setSelectedIndex(0);
        txtValorParc1.setText("");
        txtDesconto1.setText("");
        cmbTipoProduto1.setSelectedIndex(0);
    }

    public boolean vazioCadastro() {
        boolean vazio = false;
        if (cmbTipo.getSelectedIndex() == 0 || cmbCliente.getSelectedIndex() == 0 || txtData.getText().equals("  /  /    ") || txtProd.getText().equals("")
                || txtQtde.getText().equals("") || txtValorTotal.getText().equals("")) {
            vazio = true;
        } else {
            if (cmbCliente.getSelectedIndex() == 1) {
                if (txtCPF.getText().equals("   .   .   -  ")) {
                    vazio = true;
                }
            } else {
                if (cmbCliente.getSelectedIndex() == 2) {
                    if (txtCNPJ.getText().equals("  .   .   /    -  ")) {
                        vazio = true;
                    }
                } else {
                    if (cmbCliente.getSelectedIndex() == 0) {
                        vazio = true;
                    }
                }
            }
        }
        return vazio;
    }

    public boolean vazioAlterar() {
        boolean vazio = false;
        if (cmbTipo1.getSelectedIndex() == 0 || cmbCliente1.getSelectedIndex() == 0 || txtData1.getText().equals("  /  /    ") || txtProd1.getText().equals("")
                || txtQtde1.getText().equals("") || txtValorTotal1.getText().equals("")) {
            vazio = true;
        } else {
            if (cmbCliente1.getSelectedIndex() == 1) {
                if (txtCPF1.getText().equals("   .   .   -  ")) {
                    vazio = true;
                }
            } else {
                if (cmbCliente1.getSelectedIndex() == 2) {
                    if (txtCNPJ1.getText().equals("  .   .   /    -  ")) {
                        vazio = true;
                    }
                } else {
                    if (cmbCliente1.getSelectedIndex() == 0) {
                        vazio = true;
                    }
                }
            }
        }

        return vazio;
    }

    public void pesquisa() {
        List<VendaAVista> vista = arquivoVenda.outputVendaVista();
        List<VendaAPrazo> prazo = arquivoVenda.outputVendaPrazo();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < vista.size(); i++) {
            vetTabela[0] = vista.get(i).getCodigo() + "";
            vetTabela[1] = vista.get(i).getTipoVenda();
            vetTabela[2] = vista.get(i).getTipoPessoa();
            vetTabela[3] = vista.get(i).getCpf();
            vetTabela[4] = vista.get(i).getCnpj();
            vetTabela[5] = vista.get(i).getData();
            vetTabela[6] = vista.get(i).getCodigoProduto() + "";
            vetTabela[7] = vista.get(i).getTipoProduto();
            vetTabela[8] = vista.get(i).getQtde() + "";
            vetTabela[9] = vista.get(i).getValor() + "";
            vetTabela[10] = "";
            vetTabela[11] = "";
            tabela.addRow(vetTabela);
        }
        for (int i = 0; i < prazo.size(); i++) {
            vetTabela[0] = prazo.get(i).getCodigo() + "";
            vetTabela[1] = prazo.get(i).getTipoVenda();
            vetTabela[2] = prazo.get(i).getTipoPessoa();
            vetTabela[3] = prazo.get(i).getCpf();
            vetTabela[4] = prazo.get(i).getCnpj();
            vetTabela[5] = prazo.get(i).getData();
            vetTabela[6] = prazo.get(i).getCodigoProduto() + "";
            vetTabela[7] = prazo.get(i).getTipoProduto();
            vetTabela[8] = prazo.get(i).getQtde() + "";
            vetTabela[9] = prazo.get(i).getValor() + "";
            vetTabela[10] = prazo.get(i).getParcelas();
            vetTabela[11] = prazo.get(i).getValorParc() + "";
            tabela.addRow(vetTabela);
        }
    }

    public void pesquisaPorCodigoProduto(int codigo) {
        List<VendaAVista> vista = arquivoVenda.outputVendaVista();
        List<VendaAPrazo> prazo = arquivoVenda.outputVendaPrazo();

        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < vista.size(); i++) {
            if (vista.get(i).getCodigoProduto() == codigo) {
                vetTabela[0] = vista.get(i).getCodigo() + "";
                vetTabela[1] = vista.get(i).getTipoVenda();
                vetTabela[2] = vista.get(i).getTipoPessoa();
                vetTabela[3] = vista.get(i).getCpf();
                vetTabela[4] = vista.get(i).getCnpj();
                vetTabela[5] = vista.get(i).getData();
                vetTabela[6] = vista.get(i).getCodigoProduto() + "";
                vetTabela[7] = vista.get(i).getTipoProduto();
                vetTabela[8] = vista.get(i).getQtde() + "";
                vetTabela[9] = vista.get(i).getValor() + "";
                vetTabela[10] = "";
                vetTabela[11] = "";
                tabela.addRow(vetTabela);
            }
        }
        for (int i = 0; i < prazo.size(); i++) {
            if (prazo.get(i).getCodigoProduto() == codigo) {
                vetTabela[0] = prazo.get(i).getCodigo() + "";
                vetTabela[1] = prazo.get(i).getTipoVenda();
                vetTabela[2] = prazo.get(i).getTipoPessoa();
                vetTabela[3] = prazo.get(i).getCpf();
                vetTabela[4] = prazo.get(i).getCnpj();
                vetTabela[5] = prazo.get(i).getData();
                vetTabela[6] = prazo.get(i).getCodigoProduto() + "";
                vetTabela[7] = prazo.get(i).getTipoProduto();
                vetTabela[8] = prazo.get(i).getQtde() + "";
                vetTabela[9] = prazo.get(i).getValor() + "";
                vetTabela[10] = prazo.get(i).getParcelas();
                vetTabela[11] = prazo.get(i).getValorParc() + "";
                tabela.addRow(vetTabela);
            }
        }
    }

    public void pesquisaPorCodigoVenda(int codigo) {
        List<VendaAVista> vista = arquivoVenda.outputVendaVista();
        List<VendaAPrazo> prazo = arquivoVenda.outputVendaPrazo();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < vista.size(); i++) {
            if (vista.get(i).getCodigo() == codigo) {
                vetTabela[0] = vista.get(i).getCodigo() + "";
                vetTabela[1] = vista.get(i).getTipoVenda();
                vetTabela[2] = vista.get(i).getTipoPessoa();
                vetTabela[3] = vista.get(i).getCpf();
                vetTabela[4] = vista.get(i).getCnpj();
                vetTabela[5] = vista.get(i).getData();
                vetTabela[6] = vista.get(i).getCodigoProduto() + "";
                vetTabela[7] = vista.get(i).getTipoProduto();
                vetTabela[8] = vista.get(i).getQtde() + "";
                vetTabela[9] = vista.get(i).getValor() + "";
                vetTabela[10] = "";
                vetTabela[11] = "";
                tabela.addRow(vetTabela);
            }
        }
        for (int i = 0; i < prazo.size(); i++) {
            if (prazo.get(i).getCodigo() == codigo) {
                vetTabela[0] = prazo.get(i).getCodigo() + "";
                vetTabela[1] = prazo.get(i).getTipoVenda();
                vetTabela[2] = prazo.get(i).getTipoPessoa();
                vetTabela[3] = prazo.get(i).getCpf();
                vetTabela[4] = prazo.get(i).getCnpj();
                vetTabela[5] = prazo.get(i).getData();
                vetTabela[6] = prazo.get(i).getCodigoProduto() + "";
                vetTabela[7] = prazo.get(i).getTipoProduto();
                vetTabela[8] = prazo.get(i).getQtde() + "";
                vetTabela[9] = prazo.get(i).getValor() + "";
                vetTabela[10] = prazo.get(i).getParcelas();
                vetTabela[11] = prazo.get(i).getValorParc() + "";
                tabela.addRow(vetTabela);
            }
        }
    }

    public void pesquisaPorCPF(String cpf) {
        List<VendaAVista> vista = arquivoVenda.outputVendaVista();
        List<VendaAPrazo> prazo = arquivoVenda.outputVendaPrazo();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < vista.size(); i++) {
            if (vista.get(i).getCpf().equals(cpf)) {
                vetTabela[0] = vista.get(i).getCodigo() + "";
                vetTabela[1] = vista.get(i).getTipoVenda();
                vetTabela[2] = vista.get(i).getTipoPessoa();
                vetTabela[3] = vista.get(i).getCpf();
                vetTabela[4] = vista.get(i).getCnpj();
                vetTabela[5] = vista.get(i).getData();
                vetTabela[6] = vista.get(i).getCodigoProduto() + "";
                vetTabela[7] = vista.get(i).getTipoProduto();
                vetTabela[8] = vista.get(i).getQtde() + "";
                vetTabela[9] = vista.get(i).getValor() + "";
                vetTabela[10] = "";
                vetTabela[11] = "";
                tabela.addRow(vetTabela);
            }
        }
        for (int i = 0; i < prazo.size(); i++) {
            if (prazo.get(i).getCpf().equals(cpf)) {
                vetTabela[0] = prazo.get(i).getCodigo() + "";
                vetTabela[1] = prazo.get(i).getTipoVenda();
                vetTabela[2] = prazo.get(i).getTipoPessoa();
                vetTabela[3] = prazo.get(i).getCpf();
                vetTabela[4] = prazo.get(i).getCnpj();
                vetTabela[5] = prazo.get(i).getData();
                vetTabela[6] = prazo.get(i).getCodigoProduto() + "";
                vetTabela[7] = prazo.get(i).getTipoProduto();
                vetTabela[8] = prazo.get(i).getQtde() + "";
                vetTabela[9] = prazo.get(i).getValor() + "";
                vetTabela[10] = prazo.get(i).getParcelas();
                vetTabela[11] = prazo.get(i).getValorParc() + "";
                tabela.addRow(vetTabela);
            }
        }
    }

    public void pesquisaPorCNPJ(String cnpj) {
        List<VendaAVista> vista = arquivoVenda.outputVendaVista();
        List<VendaAPrazo> prazo = arquivoVenda.outputVendaPrazo();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < vista.size(); i++) {
            if (vista.get(i).getCnpj().equals(cnpj)) {
                vetTabela[0] = vista.get(i).getCodigo() + "";
                vetTabela[1] = vista.get(i).getTipoVenda();
                vetTabela[2] = vista.get(i).getTipoPessoa();
                vetTabela[3] = vista.get(i).getCpf();
                vetTabela[4] = vista.get(i).getCnpj();
                vetTabela[5] = vista.get(i).getData();
                vetTabela[6] = vista.get(i).getCodigoProduto() + "";
                vetTabela[7] = vista.get(i).getTipoProduto();
                vetTabela[8] = vista.get(i).getQtde() + "";
                vetTabela[9] = vista.get(i).getValor() + "";
                vetTabela[10] = "";
                vetTabela[11] = "";
                tabela.addRow(vetTabela);
            }
        }
        for (int i = 0; i < prazo.size(); i++) {
            if (prazo.get(i).getCnpj().equals(cnpj)) {
                vetTabela[0] = prazo.get(i).getCodigo() + "";
                vetTabela[1] = prazo.get(i).getTipoVenda();
                vetTabela[2] = prazo.get(i).getTipoPessoa();
                vetTabela[3] = prazo.get(i).getCpf();
                vetTabela[4] = prazo.get(i).getCnpj();
                vetTabela[5] = prazo.get(i).getData();
                vetTabela[6] = prazo.get(i).getCodigoProduto() + "";
                vetTabela[7] = prazo.get(i).getTipoProduto();
                vetTabela[8] = prazo.get(i).getQtde() + "";
                vetTabela[9] = prazo.get(i).getValor() + "";
                vetTabela[10] = prazo.get(i).getParcelas();
                vetTabela[11] = prazo.get(i).getValorParc() + "";
                tabela.addRow(vetTabela);
            }
        }
    }

    public void pesquisaPorCliente(String tipo) {
        List<VendaAVista> vista = arquivoVenda.outputVendaVista();
        List<VendaAPrazo> prazo = arquivoVenda.outputVendaPrazo();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i = 0; i < vista.size(); i++) {
            if (vista.get(i).getTipoPessoa().equals(tipo)) {
                vetTabela[0] = vista.get(i).getCodigo() + "";
                vetTabela[1] = vista.get(i).getTipoVenda();
                vetTabela[2] = vista.get(i).getTipoPessoa();
                vetTabela[3] = vista.get(i).getCpf();
                vetTabela[4] = vista.get(i).getCnpj();
                vetTabela[5] = vista.get(i).getData();
                vetTabela[6] = vista.get(i).getCodigoProduto() + "";
                vetTabela[7] = vista.get(i).getTipoProduto();
                vetTabela[8] = vista.get(i).getQtde() + "";
                vetTabela[9] = vista.get(i).getValor() + "";
                vetTabela[10] = "";
                vetTabela[11] = "";
                tabela.addRow(vetTabela);
            }
        }
        for (int i = 0; i < prazo.size(); i++) {
            if (prazo.get(i).getTipoPessoa().equals(tipo)) {
                vetTabela[0] = prazo.get(i).getCodigo() + "";
                vetTabela[1] = prazo.get(i).getTipoVenda();
                vetTabela[2] = prazo.get(i).getTipoPessoa();
                vetTabela[3] = prazo.get(i).getCpf();
                vetTabela[4] = prazo.get(i).getCnpj();
                vetTabela[5] = prazo.get(i).getData();
                vetTabela[6] = prazo.get(i).getCodigoProduto() + "";
                vetTabela[7] = prazo.get(i).getTipoProduto();
                vetTabela[8] = prazo.get(i).getQtde() + "";
                vetTabela[9] = prazo.get(i).getValor() + "";
                vetTabela[10] = prazo.get(i).getParcelas();
                vetTabela[11] = prazo.get(i).getValorParc() + "";
                tabela.addRow(vetTabela);
            }
        }
    }

    public boolean verificaQuantidadeCadastro() {
        int codigoProd = Integer.parseInt(txtProd.getText());
        int quantidade = Integer.parseInt(txtQtde.getText());
        boolean valida = false;
        if (cmbTipo.getSelectedIndex() == 1) {
            VendaAVista vendaVista = new VendaAVista();
            List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
            List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
            for (int i = 0; i < listaBlusas.size(); i++) {
                if (listaBlusas.get(i).getCodigo() == codigoProd) {
                    if ((listaBlusas.get(i).getQtde() < quantidade)) {
                        txtQtde.setText("");
                        valida = false;
                    } else {
                        valida = true;
                    }
                }
            }
            for (int i = 0; i < listaCalcas.size(); i++) {
                if (listaCalcas.get(i).getCodigo() == codigoProd) {
                    if ((listaCalcas.get(i).getQtde() < quantidade)) {
                        txtQtde.setText("");
                        valida = false;
                    } else {
                        valida = true;
                    }
                }
            }
        } else {
            if (cmbTipo.getSelectedIndex() == 2) {
                VendaAPrazo vendaPrazo = new VendaAPrazo();
                List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                for (int i = 0; i < listaBlusas.size(); i++) {
                    if (listaBlusas.get(i).getCodigo() == codigoProd) {
                        if ((listaBlusas.get(i).getQtde() < quantidade)) {
                            txtQtde.setText("");
                            valida = false;
                        } else {
                            valida = true;
                        }
                    }
                }
                for (int i = 0; i < listaCalcas.size(); i++) {
                    if (listaCalcas.get(i).getCodigo() == codigoProd) {
                        if ((listaCalcas.get(i).getQtde() < quantidade)) {
                            txtQtde.setText("");
                            valida = false;
                        } else {
                            valida = true;
                        }
                    }
                }
            }
        }
        return valida;
    }

    public boolean verificaQuantidadeAlterar() {
        int codigoProd = Integer.parseInt(txtProd1.getText());
        int quantidade = Integer.parseInt(txtQtde1.getText());
        boolean valida = false;
        if (cmbTipo1.getSelectedIndex() == 1) {
            VendaAVista vendaVista = new VendaAVista();
            List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
            List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
            for (int i = 0; i < listaBlusas.size(); i++) {
                if (listaBlusas.get(i).getCodigo() == codigoProd) {
                    if ((listaBlusas.get(i).getQtde() < quantidade)) {
                        txtQtde1.setText("");
                        valida = false;
                    } else {
                        valida = true;
                    }
                }
            }
            for (int i = 0; i < listaCalcas.size(); i++) {
                if (listaCalcas.get(i).getCodigo() == codigoProd) {
                    if ((listaCalcas.get(i).getQtde() < quantidade)) {
                        txtQtde1.setText("");
                        valida = false;
                    } else {
                        valida = true;
                    }
                }
            }
        } else {
            if (cmbTipo1.getSelectedIndex() == 2) {
                VendaAPrazo vendaPrazo = new VendaAPrazo();
                List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                for (int i = 0; i < listaBlusas.size(); i++) {
                    if (listaBlusas.get(i).getCodigo() == codigoProd) {
                        if ((listaBlusas.get(i).getQtde() < quantidade)) {
                            txtQtde1.setText("");
                            valida = false;
                        } else {
                            valida = true;
                        }
                    }
                }
                for (int i = 0; i < listaCalcas.size(); i++) {
                    if (listaCalcas.get(i).getCodigo() == codigoProd) {
                        if ((listaCalcas.get(i).getQtde() < quantidade)) {
                            txtQtde1.setText("");
                            valida = false;
                        } else {
                            valida = true;
                        }
                    }
                }
            }
        }
        return valida;
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
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbTipo1 = new javax.swing.JComboBox<String>();
        jLabel14 = new javax.swing.JLabel();
        btnLimpar1 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cmbCliente1 = new javax.swing.JComboBox<String>();
        jLabel16 = new javax.swing.JLabel();
        txtProd1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtQtde1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtValorTotal1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        cmbParcela1 = new javax.swing.JComboBox<String>();
        txtValorParc1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtData1 = new javax.swing.JFormattedTextField();
        btnBuscaProduto1 = new javax.swing.JButton();
        txtCPF1 = new javax.swing.JFormattedTextField();
        txtCNPJ1 = new javax.swing.JFormattedTextField();
        jLabel37 = new javax.swing.JLabel();
        txtDesconto1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        cmbTipoProduto1 = new javax.swing.JComboBox();
        btnPreencher1 = new javax.swing.JButton();
        btnVerifica1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        cmbTipoCliente = new javax.swing.JComboBox<String>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnVoltar2 = new javax.swing.JButton();
        btnAlterar1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtCPF2 = new javax.swing.JFormattedTextField();
        txtCNPJ2 = new javax.swing.JFormattedTextField();
        jLabel23 = new javax.swing.JLabel();
        txtCodVenda = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCodProduto = new javax.swing.JTextField();

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

        txtValorTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorTotalActionPerformed(evt);
            }
        });

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
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel7)
                .addGap(4, 4, 4)
                .addComponent(txtProd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnBuscaProduto)
                .addGap(18, 18, 18)
                .addComponent(btnPreencher))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(cmbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnVerifica))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(cmbParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel10)
                .addGap(4, 4, 4)
                .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel8)
                .addGap(4, 4, 4)
                .addComponent(txtValorParc, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel22)
                .addGap(4, 4, 4)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(530, 530, 530)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscaProduto)
                    .addComponent(btnPreencher))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVerifica))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4))
                    .addComponent(cmbParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorParc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel22))
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviar)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar)))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setText("Tipo de Pagamento:");

        jLabel13.setText("CPF:");

        cmbTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Vista", "Prazo" }));
        cmbTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipo1ActionPerformed(evt);
            }
        });

        jLabel14.setText("Cliente:");

        btnLimpar1.setText("Limpar");
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnVoltar1.setText("Voltar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        jLabel15.setText("CNPJ:");

        cmbCliente1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Físico", "Jurídico" }));
        cmbCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCliente1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Código Produto:");

        txtProd1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProd1FocusLost(evt);
            }
        });
        txtProd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProd1ActionPerformed(evt);
            }
        });

        jLabel17.setText("Quantidade:");

        txtQtde1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtde1FocusLost(evt);
            }
        });
        txtQtde1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtde1ActionPerformed(evt);
            }
        });

        jLabel18.setText("Valor Total:");

        jLabel33.setText("Parcelas:");

        cmbParcela1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "1x", "2x", "3x", "4x", "5x", "6x c/ juros", "7x c/ juros", "8x c/ juros" }));
        cmbParcela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbParcela1ActionPerformed(evt);
            }
        });

        jLabel34.setText("Valores:");

        jLabel35.setText("Data Registro:");

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

        jLabel37.setText("Desconto:");

        txtDesconto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesconto1ActionPerformed(evt);
            }
        });

        jLabel38.setText("Tipo Produto:");

        cmbTipoProduto1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Camisa", "Camiseta", "Moletom", "Calça", "Bermuda", "Short" }));
        cmbTipoProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoProduto1ActionPerformed(evt);
            }
        });

        btnPreencher1.setText("Preencher");
        btnPreencher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreencher1ActionPerformed(evt);
            }
        });

        btnVerifica1.setText("Verifica");
        btnVerifica1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifica1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(560, 560, 560)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addComponent(txtValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(btnLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addComponent(btnVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel37)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCNPJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel17))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cmbCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel38))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cmbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel16)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtQtde1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnVerifica1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtProd1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnBuscaProduto1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnPreencher1))
                                    .addComponent(cmbTipoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValorParc1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbParcela1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtProd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscaProduto1)
                    .addComponent(btnPreencher1))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipoProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQtde1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(btnVerifica1))))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCNPJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbParcela1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtValorParc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDesconto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(txtValorTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar)
                    .addComponent(btnLimpar1)
                    .addComponent(btnVoltar1)))
        );

        jTabbedPane1.addTab("Alterar", jPanel3);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setText("Cliente: ");

        cmbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Físico", "Jurídico" }));
        cmbTipoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoClienteActionPerformed(evt);
            }
        });

        jLabel20.setText("CPF:");

        jLabel21.setText("CNPJ:");

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
            txtCPF2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCNPJ2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel23.setText("Código Venda:");

        jLabel24.setText("Código Produto:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel20)
                        .addGap(4, 4, 4)
                        .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287)
                        .addComponent(jLabel21)
                        .addGap(11, 11, 11)
                        .addComponent(txtCNPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel23)
                        .addGap(4, 4, 4)
                        .addComponent(txtCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(237, 237, 237)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnVoltar2)
                        .addGap(254, 254, 254)
                        .addComponent(btnAlterar1)
                        .addGap(300, 300, 300)
                        .addComponent(btnExcluir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(btnBuscar)))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cmbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20))
                    .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtCNPJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel23))
                    .addComponent(txtCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnAlterar1))
                    .addComponent(btnExcluir)))
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
        if (principal.isVisible() == false) {
            principal.setVisible(true);
            this.setVisible(false);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        JPrincipal principal = new JPrincipal();
        if (principal.isVisible() == false) {
            principal.setVisible(true);
            this.setVisible(false);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaCadastro();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        if (cmbCliente.getSelectedIndex() == 0) {
            txtCPF.setEnabled(false);
            txtCPF.setText("");
            txtCNPJ.setEnabled(false);
            txtCNPJ.setText("");
        }
        if (cmbCliente.getSelectedIndex() == 1) {
            txtCPF.setEnabled(true);
            txtCNPJ.setText("");
            txtCNPJ.setEnabled(false);
        }
        if (cmbCliente.getSelectedIndex() == 2) {
            txtCPF.setEnabled(false);
            txtCPF.setText("");
            txtCNPJ.setEnabled(true);
        }
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParcelaActionPerformed
        double valor = 0.0;
        if (!txtValorTotal.getText().equals("")) {
            int quantidade = Integer.parseInt(txtQtde.getText());
            if (!txtQtde.getText().equals("")) {
                if (!txtProd.getText().equals("")) {
                    int codigoProd = Integer.parseInt(txtProd.getText());
                    VendaAPrazo vendaPrazo = new VendaAPrazo();
                    List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                    List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                    for (int i = 0; i < listaBlusas.size(); i++) {
                        if (listaBlusas.get(i).getCodigo() == codigoProd) {
                            double valorTotal = listaBlusas.get(i).getValor();
                            valor = valorTotal * quantidade;
                            txtValorTotal.setText(Math.round(valor) + "");
                            break;
                        }
                    }
                    for (int i = 0; i < listaCalcas.size(); i++) {
                        if (listaCalcas.get(i).getCodigo() == codigoProd) {
                            double valorTotal = listaCalcas.get(i).getValor();
                            valor = valorTotal * quantidade;
                            txtValorTotal.setText(Math.round(valor) + "");
                            break;
                        }
                    }
                    if (cmbParcela.getSelectedIndex() == 1) {
                        txtValorParc.setText("");
                        txtValorParc.setText(valor + "");
                        txtValorTotal.setText(valor + "");
                    }
                    if (cmbParcela.getSelectedIndex() == 2) {
                        txtValorParc.setText("");
                        txtValorParc.setText(Math.round(valor / 2) + "");
                        txtValorTotal.setText(valor + "");
                    }
                    if (cmbParcela.getSelectedIndex() == 3) {
                        txtValorParc.setText("");
                        txtValorParc.setText(Math.round(valor / 3) + "");
                        txtValorTotal.setText(valor + "");
                    }
                    if (cmbParcela.getSelectedIndex() == 4) {
                        txtValorParc.setText("");
                        txtValorParc.setText(Math.round(valor / 4) + "");
                        txtValorTotal.setText(valor + "");
                    }
                    if (cmbParcela.getSelectedIndex() == 5) {
                        txtValorParc.setText("");
                        txtValorParc.setText(Math.round(valor / 5) + "");
                        txtValorTotal.setText(valor + "");
                    }
                    if (cmbParcela.getSelectedIndex() == 6) {
                        txtValorParc.setText("");
                        double valorParcelado = Math.round((valor / 6) * 1.15);
                        txtValorParc.setText(valorParcelado + "");
                        txtValorTotal.setText(Math.round(valor * 1.15) + "");
                    }
                    if (cmbParcela.getSelectedIndex() == 7) {
                        txtValorParc.setText("");
                        double valorParcelado = Math.round((valor / 7) * 1.20);
                        txtValorParc.setText(valorParcelado + "");
                        txtValorTotal.setText(Math.round(valor * 1.20) + "");
                    }
                    if (cmbParcela.getSelectedIndex() == 8) {
                        txtValorParc.setText("");
                        double valorParcelado = Math.round((valor / 8) * 1.25);
                        txtValorParc.setText(valorParcelado + "");
                        txtValorTotal.setText(Math.round(valor * 1.25) + "");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha o código do produto.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha a quantidade.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Clique para preencher os dados.");
        }


    }//GEN-LAST:event_cmbParcelaActionPerformed

    private void btnBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProdutoActionPerformed
        JBuscaCodProduto busca = new JBuscaCodProduto();
        busca.setVisible(true);

    }//GEN-LAST:event_btnBuscaProdutoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        VendaAVista vendaVista = new VendaAVista();
        VendaAPrazo vendaPrazo = new VendaAPrazo();

        if (fileV.exists()) {
            List<VendaAVista> vista = arquivoVenda.outputVendaVista();
            int i = vista.size() - 1;
            codigo = vista.get(i).getCodigo();
            codigo = codigo + 1;
        }
        if (fileP.exists()) {
            List<VendaAPrazo> prazo = arquivoVenda.outputVendaPrazo();
            int i = prazo.size() - 1;
            codigo = prazo.get(i).getCodigo();
            codigo = codigo + 2;
        }

        if (vazioCadastro() == true) {
            JOptionPane.showMessageDialog(null, "Há campos vazios.");
        } else {
            if (verificaQuantidadeCadastro() == false) {
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
            } else {
                String tipoPag = cmbTipo.getSelectedItem().toString();
                String tipoCliente = cmbCliente.getSelectedItem().toString();
                String cpf = txtCPF.getText();
                String cnpj = txtCNPJ.getText();
                String data = txtData.getText();
                int codigoProd = Integer.parseInt(txtProd.getText());
                int quantidade = Integer.parseInt(txtQtde.getText());
                double valorTotal = Double.parseDouble(txtValorTotal.getText());
                String tipoProduto = cmbTipoProduto.getSelectedItem().toString();

                if (tipoPag.equals("Vista")) {

                    List<Blusas> blusas = vendaVista.getEstoque().outputBlusas();
                    List<Calcas> calcas = vendaVista.getEstoque().outputCalcas();

                    arquivoVenda.cadastraVendaVista(codigo, tipoPag, tipoCliente, cpf, cnpj, codigoProd, tipoProduto, data, quantidade, valorTotal);
                    try {
                        arquivoVenda.inputVendaAVista();
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                        if (tipoProduto.equals("Camisa") || tipoProduto.equals("Camisa") || tipoProduto.equals("Moletom")) {
                            for (int i = 0; i < blusas.size(); i++) {
                                if (blusas.get(i).getCodigo() == codigoProd) {
                                    blusas.get(i).setQtde(blusas.get(i).getQtde() - quantidade);
                                }
                            }
                        } else {
                            if (tipoProduto.equals("Calça") || tipoProduto.equals("Bermuda") || tipoProduto.equals("Short")) {
                                for (int i = 0; i < calcas.size(); i++) {
                                    if (calcas.get(i).getCodigo() == codigoProd) {
                                        calcas.get(i).setQtde(calcas.get(i).getQtde() - quantidade);
                                    }
                                }
                            }
                        }
                        limpaCadastro();
                    } catch (IOException ex) {
                        Logger.getLogger(JVendas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (tipoPag.equals("Prazo")) {
                        double valorParcelado = Double.parseDouble(txtValorParc.getText());
                        String parcelas = cmbParcela.getSelectedItem().toString();
                        List<Blusas> blusas = vendaPrazo.getEstoque().outputBlusas();
                        List<Calcas> calcas = vendaPrazo.getEstoque().outputCalcas();
                        if (tipoProduto.equals("Camisa") || tipoProduto.equals("Camisa") || tipoProduto.equals("Moletom")) {
                            for (int i = 0; i < blusas.size(); i++) {
                                if (blusas.get(i).getCodigo() == codigoProd) {
                                    int quant = blusas.get(i).getQtde();
                                    blusas.get(i).setQtde(quant - quantidade);
                                }
                            }
                        } else {
                            if (tipoProduto.equals("Calça") || tipoProduto.equals("Bermuda") || tipoProduto.equals("Short")) {
                                for (int i = 0; i < calcas.size(); i++) {
                                    if (calcas.get(i).getCodigo() == codigoProd) {
                                        int quant = calcas.get(i).getQtde();
                                        calcas.get(i).setQtde(quant - quantidade);
                                    }
                                }
                            }
                        }
                        arquivoVenda.cadastraVendaPrazo(codigo, tipoPag, tipoCliente, cpf, cnpj, codigoProd, tipoProduto, data, quantidade, valorTotal, parcelas, valorParcelado);
                        try {
                            arquivoVenda.inputVendaAPrazo();
                            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");

                            limpaCadastro();
                        } catch (IOException ex) {
                            Logger.getLogger(JVendas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if (cmbTipo.getSelectedIndex() == 0) {
            cmbParcela.setEnabled(false);
        } else {
            if (cmbTipo.getSelectedIndex() == 1) {
                cmbParcela.setEnabled(false);
            } else {
                cmbParcela.setEnabled(true);
            }

        }
    }//GEN-LAST:event_cmbTipoActionPerformed

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

        if (!txtProd.getText().equals("")) {
            int codigoProd = Integer.parseInt(txtProd.getText());
            if (cmbTipo.getSelectedIndex() == 1) {
                if (!txtQtde.getText().equals("")) {

                    VendaAVista vendaVista = new VendaAVista();
                    txtDesconto.setText(vendaVista.getDesconto() + "");
                    List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
                    List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
                    for (int i = 0; i < listaBlusas.size(); i++) {
                        if (listaBlusas.get(i).getCodigo() == codigoProd) {
                            if (!txtDesconto.getText().equals("")) {
                                int quantidade = Integer.parseInt(txtQtde.getText());
                                quantidade = Integer.parseInt(txtQtde.getText());
                                double desconto = Double.parseDouble(txtDesconto.getText());
                                double valorTotal = listaBlusas.get(i).getValor();
                                double valor = valorTotal * quantidade;
                                double valorT = valor - (valor * desconto);
                                txtValorTotal.setText(Math.round(valorT) + "");
                            }
                            String tipoProduto = listaBlusas.get(i).getTipo();
                            cmbTipoProduto.setSelectedItem(tipoProduto);
                        }
                    }
                    for (int i = 0; i < listaCalcas.size(); i++) {
                        if (listaCalcas.get(i).getCodigo() == codigoProd) {
                            if (!txtDesconto.getText().equals("")) {
                                int quantidade = Integer.parseInt(txtQtde.getText());
                                quantidade = Integer.parseInt(txtQtde.getText());
                                double desconto = Double.parseDouble(txtDesconto.getText());
                                double valorTotal = listaCalcas.get(i).getValor();
                                double valor = valorTotal * quantidade;
                                double valorT = valor - (valor * desconto);
                                txtValorTotal.setText(Math.round(valorT) + "");
                            }
                            String tipoProduto = listaCalcas.get(i).getTipo();
                            cmbTipoProduto.setSelectedItem(tipoProduto);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha a quantidade.");
                }

            } else {
                if (cmbTipo.getSelectedIndex() == 2) {
                    if (!txtQtde.getText().equals("")) {
                        VendaAPrazo vendaPrazo = new VendaAPrazo();
                        List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                        List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                        for (int i = 0; i < listaBlusas.size(); i++) {
                            if (listaBlusas.get(i).getCodigo() == codigoProd) {
                                double valorTotal = listaBlusas.get(i).getValor();
                                String tipoProduto = listaBlusas.get(i).getTipo();
                                cmbTipoProduto.setSelectedItem(tipoProduto);
                                int quantidade = Integer.parseInt(txtQtde.getText());
                                double valor = valorTotal * quantidade;
                                txtValorTotal.setText(Math.round(valor) + "");
                                break;
                            }
                        }
                        for (int i = 0; i < listaCalcas.size(); i++) {
                            if (listaCalcas.get(i).getCodigo() == codigoProd) {
                                double valorTotal = listaCalcas.get(i).getValor();
                                String tipoProduto = listaCalcas.get(i).getTipo();
                                cmbTipoProduto.setSelectedItem(tipoProduto);
                                int quantidade = Integer.parseInt(txtQtde.getText());
                                double valor = valorTotal * quantidade;
                                txtValorTotal.setText(Math.round(valor) + "");
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Preencha a quantidade.");
                    }

                } else {
                    if (cmbTipo.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Preencha o tipo de pagamento.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha o código.");
        }

    }//GEN-LAST:event_btnPreencherActionPerformed

    private void btnVerificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificaActionPerformed
        if (txtQtde.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a quantidade.");
        } else {
            if (txtProd.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha o código do produto.");
            } else {
                if (verificaQuantidadeCadastro() == false) {
                    JOptionPane.showMessageDialog(null, "Quantidade insuficiente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Quantidade suficiente.");
                }
            }
        }

    }//GEN-LAST:event_btnVerificaActionPerformed

    private void cmbTipoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoClienteActionPerformed
        if (cmbTipoCliente.getSelectedIndex() == 0) {
            txtCPF2.setEnabled(false);
            txtCPF2.setText("");
            txtCNPJ2.setEnabled(false);
            txtCNPJ2.setText("");
        }
        if (cmbTipoCliente.getSelectedIndex() == 1) {
            txtCPF2.setEnabled(true);
            txtCNPJ2.setText("");
            txtCNPJ2.setEnabled(false);
        }
        if (cmbTipoCliente.getSelectedIndex() == 2) {
            txtCPF2.setEnabled(false);
            txtCPF2.setText("");
            txtCNPJ2.setEnabled(true);
        }
    }//GEN-LAST:event_cmbTipoClienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (cmbTipoCliente.getSelectedIndex() == 0 && txtCodProduto.getText().equals("") && txtCodVenda.getText().equals("")) {
            pesquisa();
        }
        if (!txtCodProduto.getText().equals("")) {
            int codigo = Integer.parseInt(txtCodProduto.getText());
            pesquisaPorCodigoProduto(codigo);
            txtCodProduto.setText("");
        }
        if (!txtCodVenda.getText().equals("")) {
            int codigo = Integer.parseInt(txtCodVenda.getText());
            pesquisaPorCodigoVenda(codigo);
            txtCodVenda.setText("");
        }
        if (cmbTipoCliente.getSelectedIndex() == 1) {
            if (!txtCPF2.getText().equals("")) {
                String cpf = txtCPF2.getText();
                pesquisaPorCPF(cpf);
                txtCPF2.setText("");
            }
        }
        if (cmbTipoCliente.getSelectedIndex() == 2) {
            if (!txtCNPJ2.getText().equals("")) {
                String cnpj = txtCNPJ2.getText();
                pesquisaPorCNPJ(cnpj);
                txtCNPJ2.setText("");
            }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int codProd = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        if (table.getSelectedRow() >= 0) {

            if (JOptionPane.showConfirmDialog(null, "Deseja excluir realmente?", "Confirmação", 0) == 0) {

                try {
                    if (arquivoVenda.excluir(codProd)) {
                        JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                        pesquisa();

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
        String tipo = table.getValueAt(table.getSelectedRow(), 1).toString();
        int cod = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        if (table.getSelectedRow() >= 0) {
            if (tipo.equals("Vista")) {
                List<VendaAVista> vv = arquivoVenda.outputVendaVista();

                for (int i = 0; i < vv.size(); i++) {
                    if (vv.get(i).getCodigo() == cod) {
                        cmbTipo1.setSelectedIndex(1);
                        cmbCliente1.setSelectedItem(vv.get(i).getTipoPessoa());
                        txtCPF1.setText(vv.get(i).getCpf());
                        txtCNPJ1.setText(vv.get(i).getCnpj());
                        txtData1.setText(vv.get(i).getData());
                        txtProd1.setText(vv.get(i).getCodigoProduto() + "");
                        txtQtde1.setText(vv.get(i).getQtde() + "");
                        txtValorTotal1.setText(vv.get(i).getValor() + "");
                        cmbParcela1.setSelectedIndex(0);
                        txtValorParc1.setText("");
                        txtDesconto1.setText(vv.get(i).getDesconto() + "");
                        cmbTipoProduto1.setSelectedItem(vv.get(i).getTipoProduto());

                        posicao = i;
                        break;
                    }
                }
                jTabbedPane1.setSelectedIndex(1);
            } else {
                if (tipo.equals("Prazo")) {
                    List<VendaAPrazo> vp = arquivoVenda.outputVendaPrazo();

                    for (int i = 0; i < vp.size(); i++) {
                        if (vp.get(i).getCodigo() == cod) {
                            cmbTipo1.setSelectedIndex(1);
                            cmbCliente1.setSelectedItem(vp.get(i).getTipoPessoa());
                            txtCPF1.setText(vp.get(i).getCpf());
                            txtCNPJ1.setText(vp.get(i).getCnpj());
                            txtData1.setText(vp.get(i).getData());
                            txtProd1.setText(vp.get(i).getCodigoProduto() + "");
                            txtQtde1.setText(vp.get(i).getQtde() + "");
                            txtValorTotal1.setText(vp.get(i).getValor() + "");
                            cmbParcela1.setSelectedItem(vp.get(i).getParcelas());
                            txtValorParc1.setText(vp.get(i).getValorParc() + "");
                            txtDesconto1.setText("");
                            cmbTipoProduto1.setSelectedItem(vp.get(i).getTipoProduto());

                            posicao = i;
                            break;
                        }
                    }
                    jTabbedPane1.setSelectedIndex(1);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma linha.");
        }
    }//GEN-LAST:event_btnAlterar1ActionPerformed

    private void btnVerifica1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifica1ActionPerformed
        int codigoProd = Integer.parseInt(txtProd1.getText());
        int quantidade = Integer.parseInt(txtQtde1.getText());

        if (cmbTipo1.getSelectedIndex() == 1) {
            VendaAVista vendaVista = new VendaAVista();
            List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
            List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
            for (int i = 0; i < listaBlusas.size(); i++) {
                if (listaBlusas.get(i).getCodigo() == codigoProd) {
                    if ((listaBlusas.get(i).getQtde() < quantidade)) {
                        JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                        txtQtde1.setText("");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantidade suficiente.");
                    }
                }
            }
            for (int i = 0; i < listaCalcas.size(); i++) {
                if (listaCalcas.get(i).getCodigo() == codigoProd) {
                    if ((listaCalcas.get(i).getQtde() < quantidade)) {
                        JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                        txtQtde1.setText("");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantidade suficiente.");
                    }
                }
            }
        } else {
            if (cmbTipo1.getSelectedIndex() == 2) {
                VendaAPrazo vendaPrazo = new VendaAPrazo();
                List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                for (int i = 0; i < listaBlusas.size(); i++) {
                    if (listaBlusas.get(i).getCodigo() == codigoProd) {
                        if ((listaBlusas.get(i).getQtde() < quantidade)) {
                            JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                            txtQtde1.setText("");
                            break;
                        }
                    }
                }
                for (int i = 0; i < listaCalcas.size(); i++) {
                    if (listaCalcas.get(i).getCodigo() == codigoProd) {
                        if ((listaCalcas.get(i).getQtde() < quantidade)) {
                            JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
                            txtQtde1.setText("");
                            break;
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnVerifica1ActionPerformed

    private void btnPreencher1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreencher1ActionPerformed

        double valorTotal;
        String tipoProduto;
        if (!txtProd1.getText().equals("")) {
            int codigoProd = Integer.parseInt(txtProd1.getText());
            if (cmbTipo1.getSelectedIndex() == 1) {
                if (!txtQtde1.getText().equals("")) {

                    VendaAVista vendaVista = new VendaAVista();
                    txtDesconto1.setText(vendaVista.getDesconto() + "");
                    List<Blusas> listaBlusas = vendaVista.getEstoque().outputBlusas();
                    List<Calcas> listaCalcas = vendaVista.getEstoque().outputCalcas();
                    for (int i = 0; i < listaBlusas.size(); i++) {
                        if (listaBlusas.get(i).getCodigo() == codigoProd) {
                            if (!txtDesconto1.getText().equals("")) {
                                int quantidade = Integer.parseInt(txtQtde1.getText());
                                quantidade = Integer.parseInt(txtQtde1.getText());
                                double desconto = Double.parseDouble(txtDesconto1.getText());
                                valorTotal = listaBlusas.get(i).getValor();
                                double valor = valorTotal * quantidade;
                                double valorT = valor - (valor * desconto);
                                txtValorTotal1.setText(Math.round(valorT) + "");
                            }
                            tipoProduto = listaBlusas.get(i).getTipo();
                            cmbTipoProduto1.setSelectedItem(tipoProduto);
                        }
                    }
                    for (int i = 0; i < listaCalcas.size(); i++) {
                        if (listaCalcas.get(i).getCodigo() == codigoProd) {
                            if (!txtDesconto1.getText().equals("")) {
                                int quantidade = Integer.parseInt(txtQtde1.getText());
                                quantidade = Integer.parseInt(txtQtde1.getText());
                                double desconto = Double.parseDouble(txtDesconto1.getText());
                                valorTotal = listaCalcas.get(i).getValor();
                                double valor = valorTotal * quantidade;
                                double valorT = valor - (valor * desconto);
                                txtValorTotal1.setText(Math.round(valorT) + "");
                            }
                            tipoProduto = listaCalcas.get(i).getTipo();
                            cmbTipoProduto1.setSelectedItem(tipoProduto);
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha a quantidade.");
                }

            } else {
                if (cmbTipo1.getSelectedIndex() == 2) {
                    if (!txtQtde1.getText().equals("")) {
                        VendaAPrazo vendaPrazo = new VendaAPrazo();
                        List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                        List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                        for (int i = 0; i < listaBlusas.size(); i++) {
                            if (listaBlusas.get(i).getCodigo() == codigoProd) {
                                valorTotal = listaBlusas.get(i).getValor();
                                tipoProduto = listaBlusas.get(i).getTipo();
                                cmbTipoProduto1.setSelectedItem(tipoProduto);
                                int quantidade = Integer.parseInt(txtQtde1.getText());
                                double valor = valorTotal * quantidade;
                                txtValorTotal1.setText(Math.round(valor) + "");
                                break;
                            }
                        }
                        for (int i = 0; i < listaCalcas.size(); i++) {
                            if (listaCalcas.get(i).getCodigo() == codigoProd) {
                                valorTotal = listaCalcas.get(i).getValor();
                                tipoProduto = listaCalcas.get(i).getTipo();
                                cmbTipoProduto1.setSelectedItem(tipoProduto);
                                int quantidade = Integer.parseInt(txtQtde1.getText());
                                double valor = valorTotal * quantidade;
                                txtValorTotal1.setText(Math.round(valor) + "");
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Preencha a quantidade.");
                    }

                } else {
                    if (cmbTipo1.getSelectedIndex() == 0) {
                        JOptionPane.showMessageDialog(null, "Preencha o tipo de pagamento.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha o código.");
        }
    }//GEN-LAST:event_btnPreencher1ActionPerformed

    private void cmbTipoProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoProduto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoProduto1ActionPerformed

    private void txtDesconto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesconto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesconto1ActionPerformed

    private void btnBuscaProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaProduto1ActionPerformed
        JBuscaCodProduto busca = new JBuscaCodProduto();
        busca.setVisible(true);
    }//GEN-LAST:event_btnBuscaProduto1ActionPerformed

    private void cmbParcela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbParcela1ActionPerformed
        double valor = 0.0;
        if (!txtValorTotal1.getText().equals("")) {
            int quantidade = Integer.parseInt(txtQtde1.getText());
            if (!txtQtde1.getText().equals("")) {
                if (!txtProd1.getText().equals("")) {
                    int codigoProd = Integer.parseInt(txtProd1.getText());
                    VendaAPrazo vendaPrazo = new VendaAPrazo();
                    List<Blusas> listaBlusas = vendaPrazo.getEstoque().outputBlusas();
                    List<Calcas> listaCalcas = vendaPrazo.getEstoque().outputCalcas();
                    for (int i = 0; i < listaBlusas.size(); i++) {
                        if (listaBlusas.get(i).getCodigo() == codigoProd) {
                            double valorTotal = listaBlusas.get(i).getValor();
                            valor = valorTotal * quantidade;
                            txtValorTotal1.setText(Math.round(valor) + "");
                            break;
                        }
                    }
                    for (int i = 0; i < listaCalcas.size(); i++) {
                        if (listaCalcas.get(i).getCodigo() == codigoProd) {
                            double valorTotal = listaCalcas.get(i).getValor();
                            valor = valorTotal * quantidade;
                            txtValorTotal1.setText(Math.round(valor) + "");
                            break;
                        }
                    }
                    if (cmbParcela1.getSelectedIndex() == 1) {
                        txtValorParc1.setText("");
                        txtValorParc1.setText(valor + "");
                        txtValorTotal1.setText(valor + "");
                    }
                    if (cmbParcela1.getSelectedIndex() == 2) {
                        txtValorParc1.setText("");
                        txtValorParc1.setText(Math.round(valor / 2) + "");
                        txtValorTotal1.setText(valor + "");
                    }
                    if (cmbParcela1.getSelectedIndex() == 3) {
                        txtValorParc1.setText("");
                        txtValorParc1.setText(Math.round(valor / 3) + "");
                        txtValorTotal1.setText(valor + "");
                    }
                    if (cmbParcela1.getSelectedIndex() == 4) {
                        txtValorParc1.setText("");
                        txtValorParc1.setText(Math.round(valor / 4) + "");
                        txtValorTotal1.setText(valor + "");
                    }
                    if (cmbParcela1.getSelectedIndex() == 5) {
                        txtValorParc1.setText("");
                        txtValorParc1.setText(Math.round(valor / 5) + "");
                        txtValorTotal1.setText(valor + "");
                    }
                    if (cmbParcela1.getSelectedIndex() == 6) {
                        txtValorParc1.setText("");
                        double valorParcelado = Math.round((valor / 6) * 1.15);
                        txtValorParc1.setText(valorParcelado + "");
                        txtValorTotal1.setText(Math.round(valor * 1.15) + "");
                    }
                    if (cmbParcela1.getSelectedIndex() == 7) {
                        txtValorParc1.setText("");
                        double valorParcelado = Math.round((valor / 7) * 1.20);
                        txtValorParc1.setText(valorParcelado + "");
                        txtValorTotal1.setText(Math.round(valor * 1.20) + "");
                    }
                    if (cmbParcela1.getSelectedIndex() == 8) {
                        txtValorParc1.setText("");
                        double valorParcelado = Math.round((valor / 8) * 1.25);
                        txtValorParc1.setText(valorParcelado + "");
                        txtValorTotal1.setText(Math.round(valor * 1.25) + "");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha o código do produto.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Preencha a quantidade.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Clique para preencher os dados.");
        }
    }//GEN-LAST:event_cmbParcela1ActionPerformed

    private void txtQtde1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtde1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtde1ActionPerformed

    private void txtQtde1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtde1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtde1FocusLost

    private void txtProd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProd1ActionPerformed

    private void txtProd1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProd1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProd1FocusLost

    private void cmbCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCliente1ActionPerformed
        if (cmbCliente1.getSelectedIndex() == 0) {
            txtCPF1.setEnabled(false);
            txtCPF1.setText("");
            txtCNPJ1.setEnabled(false);
            txtCNPJ1.setText("");
        }
        if (cmbCliente1.getSelectedIndex() == 1) {
            txtCPF1.setEnabled(true);
            txtCNPJ1.setText("");
            txtCNPJ1.setEnabled(false);
        }
        if (cmbCliente1.getSelectedIndex() == 2) {
            txtCPF1.setEnabled(false);
            txtCPF1.setText("");
            txtCNPJ1.setEnabled(true);
        }
    }//GEN-LAST:event_cmbCliente1ActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        JPrincipal principal = new JPrincipal();
        if (principal.isVisible() == false) {
            principal.setVisible(true);
            this.setVisible(false);
        } else {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (vazioAlterar() == true) {
            JOptionPane.showMessageDialog(null, "Há campos vazios.");
        } else {
            if (verificaQuantidadeAlterar() == false) {
                JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque.");
            } else {
                String tipoPag = cmbTipo1.getSelectedItem().toString();
                String tipoCliente = cmbCliente1.getSelectedItem().toString();
                String cpf = txtCPF1.getText();
                String cnpj = txtCNPJ1.getText();
                String data = txtData1.getText();
                int codigoProd = Integer.parseInt(txtProd1.getText());
                int quantidade = Integer.parseInt(txtQtde1.getText());
                double valorTotal = Double.parseDouble(txtValorTotal1.getText());
                String tipoProduto = cmbTipoProduto1.getSelectedItem().toString();

                if (tipoPag.equals("Vista")) {

                    try {
                        arquivoVenda.alterarVendaVista(tipoPag, tipoCliente, cpf, cnpj, codigoProd, tipoProduto, data, quantidade, valorTotal, posicao);
                        JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                        limpaAlterar();

                    } catch (IOException ex) {
                        Logger.getLogger(JVendas.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (tipoPag.equals("Prazo")) {
                        double valorParcelado = Double.parseDouble(txtValorParc1.getText());
                        String parcelas = cmbParcela1.getSelectedItem().toString();

                        try {
                            arquivoVenda.alterarVendaPrazo(tipoPag, tipoCliente, cpf, cnpj, codigoProd, tipoProduto, data, quantidade, valorTotal, parcelas, valorParcelado, posicao);
                            JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                            limpaAlterar();

                        } catch (IOException ex) {
                            Logger.getLogger(JVendas.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        limpaAlterar();
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void cmbTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipo1ActionPerformed
        if (cmbTipo1.getSelectedIndex() == 0) {
            cmbParcela1.setEnabled(false);
        } else {
            if (cmbTipo1.getSelectedIndex() == 1) {
                cmbParcela1.setEnabled(false);
            } else {
                cmbParcela1.setEnabled(true);
            }

        }
    }//GEN-LAST:event_cmbTipo1ActionPerformed

    private void txtValorTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorTotalActionPerformed

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
            java.util.logging.Logger.getLogger(JVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JButton btnPreencher;
    private javax.swing.JButton btnPreencher1;
    private javax.swing.JButton btnVerifica;
    private javax.swing.JButton btnVerifica1;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbCliente1;
    private javax.swing.JComboBox<String> cmbParcela;
    private javax.swing.JComboBox<String> cmbParcela1;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JComboBox<String> cmbTipo1;
    private javax.swing.JComboBox<String> cmbTipoCliente;
    private javax.swing.JComboBox cmbTipoProduto;
    private javax.swing.JComboBox cmbTipoProduto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable table;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCNPJ1;
    private javax.swing.JFormattedTextField txtCNPJ2;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPF1;
    private javax.swing.JFormattedTextField txtCPF2;
    private javax.swing.JTextField txtCodProduto;
    private javax.swing.JTextField txtCodVenda;
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
