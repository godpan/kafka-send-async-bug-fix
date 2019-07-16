package com.godpan

import java.util.concurrent.{Callable, FutureTask}
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

import org.apache.kafka.clients.producer.{Callback, KafkaProducer, ProducerRecord, RecordMetadata}

class ProducerF[K,V](kafkaProducer: KafkaProducer[K,V]) {

  val executor: ExecutorService = Executors.newScheduledThreadPool(1)
  def sendAsync(producerRecord: ProducerRecord[K,V], callback: Callback) = {
    executor.submit(new Callable[RecordMetadata]() {
      def call = kafkaProducer.send(producerRecord, callback).get()
    })
  }
}