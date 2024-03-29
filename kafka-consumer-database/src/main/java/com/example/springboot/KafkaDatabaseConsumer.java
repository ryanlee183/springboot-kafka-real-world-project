package com.example.springboot;

import com.example.springboot.entity.WikimediaData;
import com.example.springboot.repository.WikiMediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikiMediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikiMediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "myGroup")
    public void consume(String eventMessaage) {
        LOGGER.info(String.format("Event message received -> %s", eventMessaage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessaage);
        dataRepository.save(wikimediaData);
    }
}
