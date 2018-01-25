package cryptosim.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import cryptosim.dto.AbstractDataEntry;

@Repository
public interface AbstractDataEntryRepository<T extends AbstractDataEntry> extends MongoRepository<T, String> {

	public T findByBase(String base);

	public T findByQuote(String quote);

	@Query("{base: ?0, quote: ?1}")
	public List<T> findByPair(String base, String quote);

}
