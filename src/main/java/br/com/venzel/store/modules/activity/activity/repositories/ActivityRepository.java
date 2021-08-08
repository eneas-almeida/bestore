package br.com.venzel.store.modules.activity.activity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.activity.activity.entities.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {}
