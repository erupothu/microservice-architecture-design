#### Spring boot

##### spring boot annotations
@EnableEurekaServer
* Netflix Eureka Service Registry & Discovery.  

@EnableEurekaClient
* register with Eureka Server
  
@EnableFeignClients
* In Microservices, communication among multiple services happens on the concept of producer-consumer.
  
@EnableConfigServer
* Config Server is a central configuration server that provides configurations (properties) to each microservice connected to it.
  
@RateLimiter(name = "getMessageRateLimit", fallbackMethod = "getMessageFallBack")
* Rate Limiter limits the number of requests for a given period.
  
@Retry(name = "getInvoiceRetry", fallbackMethod = "getInvoiceFallback") 
* Suppose Microservice ‘A’  depends on another Microservice ‘B’. Let’s assume Microservice ‘B’ is a faulty service and its success rate is only upto 50-60%. However, fault may be due to any reason, such as service is unavailable, buggy service that sometimes responds and sometimes not, or an intermittent network failure etc. However, in this case, if Microservice ‘A’ retries to send request 2 to 3 times, the chances of getting response increases.
  
@CircuitBreaker(name = "getInvoiceCB", fallbackMethod = "getInvoiceFallback") 
* In order to escape the multiple microservices from becoming erroneous as a result of cascading effect, we stop calling the faulty Microservice ‘B’. Instead, we call a dummy method that is called a ‘Fallback Method’. Therefore, calling a fallback method instead of an actual service due to a fault is called breaking the circuit.
  
@Bulkhead(name = "getMessageBH", fallbackMethod = "getMessageFallBack")
* f we want to limit the number of concurrent requests, we can use Bulkhead as an aspect.
  
@TimeLimiter(name = "getMessageTL")
* Time Limiting is the process of setting a time limit for a Microservice to respond. Suppose Microservice ‘A’ sends a request to Microservice ‘B’, it sets a time limit for the Microservice ‘B’ to respond. If  Microservice ‘B’ doesn’t respond within that time limit, then it will be considered that it has some fault
* 