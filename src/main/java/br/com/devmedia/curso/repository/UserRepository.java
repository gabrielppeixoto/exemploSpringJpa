package br.com.devmedia.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devmedia.curso.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	
}
