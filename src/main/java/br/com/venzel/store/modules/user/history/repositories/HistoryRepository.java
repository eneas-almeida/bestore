package br.com.venzel.store.modules.user.history.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.user.history.entities.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {}
