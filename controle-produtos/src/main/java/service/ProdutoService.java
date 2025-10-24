package service;

import model.Produto;
import repository.ProdutoRepository;
import exception.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    private Produto buscarOuFalhar(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID " + id + " não encontrado."));
    }


    public Produto criar(Produto produto) {

        if (produto.getEstoque() == null) {
            produto.setEstoque(0);
        }
        produto.setAtivo(true); // Assumindo que você tem o campo 'ativo'
        return produtoRepository.save(produto);
    }


    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }


    public List<Produto> listarAtivos() {
        // Este método precisa ser criado no ProdutoRepository
        return produtoRepository.findByAtivoTrue();
    }

    public Produto buscarPorId(Long id) {
        return buscarOuFalhar(id);
    }


    public List<Produto> buscarPorCategoria(String categoria) {
        return produtoRepository.findByCategoriaContainingIgnoreCase(categoria);
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Produto atualizar(Long id, Produto produtoDetalhes) {
        Produto produtoExistente = buscarOuFalhar(id);


        produtoExistente.setNome(produtoDetalhes.getNome());
        produtoExistente.setDescricao(produtoDetalhes.getDescricao());
        produtoExistente.setPreco(produtoDetalhes.getPreco());
        produtoExistente.setEstoque(produtoDetalhes.getEstoque());
        produtoExistente.setAtivo(produtoDetalhes.isAtivo());

        return produtoRepository.save(produtoExistente);
    }


    public Produto atualizarEstoque(Long id, Integer quantidade) {
        Produto produtoExistente = buscarOuFalhar(id);


        if (quantidade < 0 && produtoExistente.getEstoque() + quantidade < 0) {
            throw new IllegalArgumentException("Estoque insuficiente para a operação.");
        }

        produtoExistente.setEstoque(produtoExistente.getEstoque() + quantidade);
        return produtoRepository.save(produtoExistente);
    }

    public void deletar(Long id) {
        Produto produto = buscarOuFalhar(id);
        produto.setAtivo(false);
        produtoRepository.save(produto);
    }


    public void deletarPermanente(Long id) {
        Produto produto = buscarOuFalhar(id);
        produtoRepository.delete(produto);
    }
}