package test.ashishjaintechg.jpa;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerInterceptor implements ConsumerInterceptor<String, String> {

	@Override
	public void configure(Map<String, ?> configs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
		// TODO Auto-generated method stub
		records.forEach(record -> {
			System.out.println(record.value());
		});
		return records;
	}

	@Override
	public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
		// TODO Auto-generated method stub
		System.out.println(offsets);

	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	

}
