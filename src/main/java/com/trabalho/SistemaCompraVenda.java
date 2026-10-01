package com.trabalho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaCompraVenda {
    private final Map<String, Usuario> usuarios = new HashMap<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Fornecedor> fornecedores = new ArrayList<>();
    private final List<Produto> produtos = new ArrayList<>();
    private final List<FormaPagamento> formasPagamento = new ArrayList<>();
    private final List<Venda> vendas = new ArrayList<>();
    private final List<Compra> compras = new ArrayList<>();

    public SistemaCompraVenda() {
        usuarios.put("admin@empresa.com", new Usuario(1, "Administrador", "admin@empresa.com", "123"));

        clientes.add(new Cliente(1, "Maria Silva", "123.456.789-00", "maria@email.com", "(11) 99999-0001"));
        fornecedores.add(new Fornecedor(1, "Tech Supply", "12.345.678/0001-90", "(11) 3333-4444", "contato@techsupply.com"));
        produtos.add(new Produto(1, "Notebook Dell", "Notebook para trabalho e estudo", 3500.00, 10, "Eletrônicos"));
        formasPagamento.add(new FormaPagamento(1, "Cartão", "Pagamento com cartão de crédito ou débito"));
        formasPagamento.add(new FormaPagamento(2, "Dinheiro", "Pagamento em dinheiro"));
    }

    public boolean autenticar(String email, String senha) {
        Usuario usuario = usuarios.get(email);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        if (nome == null || nome.isBlank() || email == null || email.isBlank() || senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Todos os campos do usuário são obrigatórios.");
        }

        if (usuarios.containsKey(email)) {
            throw new IllegalArgumentException("Já existe um usuário com este e-mail.");
        }

        int proximoId = usuarios.size() + 1;
        usuarios.put(email, new Usuario(proximoId, nome, email, senha));
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios.values());
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public List<Fornecedor> listarFornecedores() {
        return new ArrayList<>(fornecedores);
    }

    public List<Produto> listarProdutos() {
        return new ArrayList<>(produtos);
    }

    public List<FormaPagamento> listarFormasPagamento() {
        return new ArrayList<>(formasPagamento);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void adicionarFormaPagamento(FormaPagamento formaPagamento) {
        formasPagamento.add(formaPagamento);
    }

    public void registrarVenda(Venda venda) {
        vendas.add(venda);
    }

    public void registrarCompra(Compra compra) {
        compras.add(compra);
    }

    public String relatorioResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuários: ").append(usuarios.size()).append("\n");
        sb.append("Clientes: ").append(clientes.size()).append("\n");
        sb.append("Fornecedores: ").append(fornecedores.size()).append("\n");
        sb.append("Produtos: ").append(produtos.size()).append("\n");
        sb.append("Formas de pagamento: ").append(formasPagamento.size()).append("\n");
        sb.append("Vendas: ").append(vendas.size()).append("\n");
        sb.append("Compras: ").append(compras.size());
        return sb.toString();
    }
}
