package com.cub.ao.asset.service;

import org.springframework.stereotype.Service;

@Service
public class AssetKafkaService {/*
	
	@Autowired
	AssetSummaryDao assetSummaryDao;
	
	@Autowired
	PollableChannel fromKafka;
	
	@Autowired
	KafkaProducerMessageHandler<String,String> aomdKafkaHandler;
	
	@Value("${asset.offset.db.key}")
	private String offsetDbKey;
	
	private static long assetOffset;
	private static int kafkaExecCounter = 0;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AssetKafkaService.class);
	
	public void getMessagesFromKafka() {
		Gson gson = new Gson();
		
		LOGGER.info("Getting msg from Kafka");
		try {
			Message<?> received = fromKafka.receive();
			AssetSummaryVO assetVO=null; 
			while (true) {
				try {				
					if(received != null) {
						kafkaExecCounter++;
						assetOffset = (Long) received.getHeaders().get("kafka_offset");						
						assetVO = gson.fromJson(received.getPayload().toString(), AssetSummaryVO.class);
						CasaSummary casa = Utility.buildCasaEntity(assetVO);
						if(null != casa){
							boolean assetUpdated = assetSummaryDao.saveUpdateBancsDetails(casa);
							if(assetUpdated) {
								sendToKafkaForSync(casa.getAccountNumber(),casa.getAcSyncTimestamp().toString());
							}
						}
						if(kafkaExecCounter % 100 == 0) {
							updateOffsetValue();
							kafkaExecCounter = 0;
						}
					}
				} catch (Exception e) {
					LOGGER.error("Error while processing kafka receive : "  , assetVO);
					LOGGER.error(e.getMessage()  ,e);
				}
				received = fromKafka.receive();
			}			
		} catch (Exception e) {
			LOGGER.error("Error in getMessagesFromKafka()", e.getMessage());
		}				
	}
	
	private void sendToKafkaForSync(String accountNo, String acSyncTimestamp) {
		
		String messageToSend = acSyncTimestamp + "," + accountNo;
		Message<String> message = MessageBuilder.withPayload(messageToSend).build();
		LOGGER.info("Sendind Message to Kafka for Sync"+ message);
		aomdKafkaHandler.handleMessage(message);
	}
	
	@PreDestroy
	public void updateOffsetBeforeDestroy() {
		updateOffsetValue();
	}
	@PostConstruct
	public void init(){
		assetOffset = assetSummaryDao.getAssetOffset();
	}
	
	public void updateOffsetValue() {
		LOGGER.info("Asset Offset:"+assetOffset);
		AoProperties aoPropObj = new AoProperties();
		aoPropObj.setPropertyName(offsetDbKey);
		aoPropObj.setPropertyValue(String.valueOf(assetOffset));
		assetSummaryDao.updateAssetOffset(aoPropObj);
	}
	
*/}
