package com.book.cloud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.cloud.entity.ClientiAppuntamentiEntity;

@Repository
public interface PrenotazioneRepository extends CrudRepository<ClientiAppuntamentiEntity, Long> {

}
