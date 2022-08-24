#### Zipkin

__Collector__ – Once any component sends the trace data, it arrives to Zipkin collector daemon. Here the trace data is validated, stored, and indexed for lookups by the Zipkin collector.
__Storage__ – This module store and index the lookup data in backend. Cassandra, ElasticSearch and MySQL are supported.
__Search__ – This module provides a simple JSON API for finding and retrieving traces stored in backend. The primary consumer of this API is the Web UI.
__Web UI__ – A very nice UI interface for viewing traces.

#### Sleuth

* requests made with the RestTemplate etc.
* requests that pass through a Netflix Zuul microproxy
* HTTP headers received at Spring MVC controllers
* requests over messaging technologies like Apache Kafka or RabbitMQ etc.