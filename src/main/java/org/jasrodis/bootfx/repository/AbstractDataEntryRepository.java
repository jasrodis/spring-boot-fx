package org.jasrodis.bootfx.repository;

import org.jasrodis.bootfx.dto.AbstractDataEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractDataEntryRepository<T extends AbstractDataEntry> extends MongoRepository<T, String> {

	public T findById(String id);

//	@Query("{field1: ?0, filed: ?1}")
//	public List<T> findByField(String field1, String field2);

}
