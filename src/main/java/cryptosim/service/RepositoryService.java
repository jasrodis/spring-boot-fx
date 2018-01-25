package cryptosim.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cryptosim.repository.BinanceRepository;
import cryptosim.repository.BitfinexRepository;
import cryptosim.repository.CexRepository;
import cryptosim.repository.GdaxRepository;
import cryptosim.repository.KrakenRepository;
import cryptosim.repository.PoloniexRepository;

@Service
public class RepositoryService {

	private static final Logger log = LoggerFactory.getLogger(RepositoryService.class);
	private final BinanceRepository binanceRepository;
	private final KrakenRepository krakenRepository;
	private final GdaxRepository gdaxRepository;
	private final PoloniexRepository poloniexRepository;
	private final CexRepository cexRepository;
	private final BitfinexRepository bitfinexRepository;

	public RepositoryService(BinanceRepository binanceRepository, KrakenRepository krakenRepository,
			GdaxRepository gdaxRepository, PoloniexRepository poloniexRepository, CexRepository cexRepository,
			BitfinexRepository bitfinexRepository) {

		this.binanceRepository = binanceRepository;
		this.bitfinexRepository = bitfinexRepository;
		this.poloniexRepository = poloniexRepository;
		this.gdaxRepository = gdaxRepository;
		this.cexRepository = cexRepository;
		this.krakenRepository = krakenRepository;
	}

}
