package com.trabalho.ui;

import com.trabalho.Cliente;
import com.trabalho.FormaPagamento;
import com.trabalho.Fornecedor;
import com.trabalho.Produto;
import com.trabalho.SistemaCompraVenda;
import com.trabalho.Usuario;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MenuPrincipalFrame extends JFrame {
    private final SistemaCompraVenda sistema;
    private final JTextArea areaResultado;

    public MenuPrincipalFrame(SistemaCompraVenda sistema) {
        this.sistema = sistema;
        setTitle("EMPRESA X - Gerenciamento de Compra e Venda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 520);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelMenu = new JPanel(new GridLayout(2, 4, 10, 10));
        painelMenu.setBorder(BorderFactory.createTitledBorder("Menu Principal"));

        JButton btnUsuario = new JButton("Usuário");
        JButton btnCliente = new JButton("Cliente");
        JButton btnFornecedor = new JButton("Fornecedor");
        JButton btnProduto = new JButton("Produto");
        JButton btnPagamento = new JButton("Forma de Pagamento");
        JButton btnVenda = new JButton("Venda");
        JButton btnCompra = new JButton("Compra");
        JButton btnResumo = new JButton("Resumo");

        painelMenu.add(btnUsuario);
        painelMenu.add(btnCliente);
        painelMenu.add(btnFornecedor);
        painelMenu.add(btnProduto);
        painelMenu.add(btnPagamento);
        painelMenu.add(btnVenda);
        painelMenu.add(btnCompra);
        painelMenu.add(btnResumo);

        add(painelMenu, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        btnUsuario.addActionListener(e -> mostrarUsuarios());
        btnCliente.addActionListener(e -> mostrarClientes());
        btnFornecedor.addActionListener(e -> mostrarFornecedores());
        btnProduto.addActionListener(e -> mostrarProdutos());
        btnPagamento.addActionListener(e -> mostrarFormasPagamento());
        btnVenda.addActionListener(e -> registrarVenda());
        btnCompra.addActionListener(e -> registrarCompra());
        btnResumo.addActionListener(e -> areaResultado.setText(sistema.relatorioResumo()));

        setVisible(true);
    }

    private void mostrarUsuarios() {
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : sistema.listarUsuarios()) {
            sb.append(usuario).append(System.lineSeparator());
        }
        areaResultado.setText(sb.length() == 0 ? "Nenhum usuário cadastrado." : sb.toString());
    }

    private void mostrarClientes() {
        StringBuilder sb = new StringBuilder();
        for (Cliente cliente : sistema.listarClientes()) {
            sb.append("ID: ").append(cliente.getId())
                    .append(" | Nome: ").append(cliente.getNome())
                    .append(" | CPF: ").append(cliente.getCpf())
                    .append(" | Email: ").append(cliente.getEmail())
                    .append(System.lineSeparator());
        }
        areaResultado.setText(sb.length() == 0 ? "Nenhum cliente cadastrado." : sb.toString());
    }

    private void mostrarFornecedores() {
        StringBuilder sb = new StringBuilder();
        for (Fornecedor fornecedor : sistema.listarFornecedores()) {
            sb.append("ID: ").append(fornecedor.getId())
                    .append(" | Nome: ").append(fornecedor.getNome())
                    .append(" | CNPJ: ").append(fornecedor.getCnpj())
                    .append(System.lineSeparator());
        }
        areaResultado.setText(sb.length() == 0 ? "Nenhum fornecedor cadastrado." : sb.toString());
    }

    private void mostrarProdutos() {
        StringBuilder sb = new StringBuilder();
        for (Produto produto : sistema.listarProdutos()) {
            sb.append("ID: ").append(produto.getId())
                    .append(" | Nome: ").append(produto.getNome())
                    .append(" | Preço: R$ ").append(produto.getPreco())
                    .append(" | Qtd: ").append(produto.getQuantidade())
                    .append(System.lineSeparator());
        }
        areaResultado.setText(sb.length() == 0 ? "Nenhum produto cadastrado." : sb.toString());
    }

    private void mostrarFormasPagamento() {
        StringBuilder sb = new StringBuilder();
        for (FormaPagamento forma : sistema.listarFormasPagamento()) {
            sb.append("ID: ").append(forma.getId())
                    .append(" | Nome: ").append(forma.getNome())
                    .append(" | Desc: ").append(forma.getDescricao())
                    .append(System.lineSeparator());
        }
        areaResultado.setText(sb.length() == 0 ? "Nenhuma forma de pagamento cadastrada." : sb.toString());
    }

    private void registrarVenda() {
        Cliente cliente = sistema.listarClientes().get(0);
        Produto produto = sistema.listarProdutos().get(0);
        FormaPagamento forma = sistema.listarFormasPagamento().get(0);

        sistema.registrarVenda(new com.trabalho.Venda(
                1,
                cliente,
                produto,
                1,
                produto.getPreco(),
                forma,
                LocalDate.now()
        ));

        areaResultado.setText("Venda registrada com sucesso!\nCliente: " + cliente.getNome() + "\nProduto: " + produto.getNome());
    }

    private void registrarCompra() {
        Fornecedor fornecedor = sistema.listarFornecedores().get(0);
        Produto produto = sistema.listarProdutos().get(0);

        sistema.registrarCompra(new com.trabalho.Compra(
                1,
                fornecedor,
                produto,
                5,
                produto.getPreco() * 5,
                LocalDate.now()
        ));

        areaResultado.setText("Compra registrada com sucesso!\nFornecedor: " + fornecedor.getNome() + "\nProduto: " + produto.getNome());
    }
}
