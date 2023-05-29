package com.cibertec.CL2.repository;

import com.cibertec.CL2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.NomUsuario = :nomusuario")
    Usuario findByNomUsuario(@Param("nomusuario") String nomusuario);
}
