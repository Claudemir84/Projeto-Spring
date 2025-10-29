package controle_produtos.controle_produtos.controller;


import jakarta.validation.Valid;
import controle_produtos.controle_produtos.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import controle_produtos.controle_produtos.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto) {

        Produto novoProduto = produtoService.criar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        List<Produto> produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Produto>> listarAtivos() {
        List<Produto> produtos = produtoService.listarAtivos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {

        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@PathVariable String categoria) {
        List<Produto> produtos = produtoService.buscarPorCategoria(categoria);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> buscarPorNome(@RequestParam String nome) {
        List<Produto> produtos = produtoService.buscarPorNome(nome);
        return ResponseEntity.ok(produtos);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Produto produtoDetalhes) {

        Produto produtoAtualizado = produtoService.atualizar(id, produtoDetalhes);
        return ResponseEntity.ok(produtoAtualizado);
    }


    @PatchMapping("/{id}/estoque")
    public ResponseEntity<Produto> atualizarEstoque(
            @PathVariable Long id,
            @RequestParam Integer quantidade) {

        Produto produto = produtoService.atualizarEstoque(id, quantidade);
        return ResponseEntity.ok(produto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}/permanente")
    public ResponseEntity<Void> deletarPermanente(@PathVariable Long id) {
        produtoService.deletarPermanente(id);
        return ResponseEntity.noContent().build();
    }
}