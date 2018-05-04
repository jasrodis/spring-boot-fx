package org.jasrodis.bootfx.service;

import org.jasrodis.bootfx.repository.BinanceRepository;
import org.jasrodis.bootfx.repository.BitfinexRepository;
import org.jasrodis.bootfx.repository.CexRepository;
import org.jasrodis.bootfx.repository.GdaxRepository;
import org.jasrodis.bootfx.repository.KrakenRepository;
import org.jasrodis.bootfx.repository.PoloniexRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
