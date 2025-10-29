package controle_produtos.controle_produtos.repository;

import controle_produtos.controle_produtos.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    List<Produto> findByAtivoTrue();


    List<Produto> findByNomeContainingIgnoreCase(String nome);


    List<Produto> findByCategoriaContainingIgnoreCase(String categoria);


}