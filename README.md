
# Resilience4j RateLimiter Demo - Java 

A simple Spring Boot demo application demonstrating the work of Resilience4j RateLimiter.

## What does it do?
A "client service" calls a fake "remote service" that responds always succesfully. The client service uses a ***client-side rate-limiting*** to limit itself in consumption of the remote service.

## What is a Rate Limiter?
It is a design pattern that encapsulates the functionality that allows limiting access to some service. It has sense both on [server-side](https://reflectoring.io/rate-limiting-with-resilience4j/#server-side-rate-limiting) (to protect resources from overload) and on [client-side](https://reflectoring.io/rate-limiting-with-resilience4j/#client-side-rate-limiting) (to avoid unexpected service costs or other unfavorable effects of misbehaviour).

*See also:*
 - https://resilience4j.readme.io/docs/ratelimiter
 - https://reflectoring.io/rate-limiting-with-resilience4j/

## Usage
 - Start the standalone Spring Boot application with the entry point of: com.github.pongraczl.exercises.resilience4jdemo3.Resilience4jDemo3Application
 - Call one of the following URLs (for e.g., in a browser):
   - Rare call causes no rate limiting: http://localhost:8081/SlowServiceCallsClientController
   - More common call with some rate limiting: http://localhost:8081/FastServiceCallsClientController
   - Frequent call causes more rate limiting: http://localhost:8081/VeryFastServiceCallsClientController
   
## RateLimiter settings

### Settings used

*See*: [src/main/resources/application.yml](https://github.com/pongraczl/resilience4j-demo-ratelimiter-java/blob/master/resilience4j-demo-ratelimiter-java/src/main/resources/application.yml)
 - ***limitForPeriod***: the "rate" i.e. how many times does the client service has permission to call the remote service in the given period (*limitRefreshPeriod*)
 - ***limitRefreshPeriod***: the period in which the rate (*limitForPeriod*) is calculated
- ***timeoutDuration***: sets how much time the thread waits for a permission
 
### Possible settings detailed
*See*: https://resilience4j.readme.io/docs/ratelimiter#create-and-configure-a-ratelimiter

## More on Resilience4j with Spring Boot

 - https://resilience4j.readme.io/docs/getting-started-3
 - https://github.com/resilience4j/resilience4j-spring-boot2-demo
 - https://www.baeldung.com/resilience4j

