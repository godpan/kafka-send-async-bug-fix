# kafka-send-async-bug-fix
Fix kafka producer send async maybe block main thread


when kafka border or topic break, not exists, kafka producer async send data also will be block main thread.

because before send client will be sync metadata，it's block. [see detail](https://github.com/apache/kafka/blob/25f4e3c7d4a50a55e3d66ea479e40a38c841ba39/clients/src/main/java/org/apache/kafka/clients/producer/KafkaProducer.java#L876)