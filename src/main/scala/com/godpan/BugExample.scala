package com.godpan

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord, RecordMetadata}

object BugExample extends App {

  val props = new Properties()
  props.put("max.block.ms", "3000")
  props.put("bootstrap.servers", "localhost:9092")
  props.put("client.id", "ProducerSendBugExample")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)
  val topic = "topic-trace-one"
  val userId = "godpan"
  val msg = "login wechat"
  val data = new ProducerRecord[String, String](topic, userId, msg)

  val startTime = System.currentTimeMillis()
  producer.send(data, (metadata: RecordMetadata, exception: Exception) => {
    println(s"[producer-send] data userId: ${userId}, msg: ${msg}, cost time: ${System.currentTimeMillis() - startTime},  exception: ${exception}")
  })

  System.exit(0)
}