# Please follow this notes :

There are ways to implement caching in spring boot application :

1. Default Caching Implementation
2. Implementing Cache Provide

Currently, the Default Caching is configured in the application.

In order to configure EhCache as Cache Provider, follow the below steps :

1. Remove the **_@EnableCaching_** annotation from the Spring Boot main class.
2. Uncomment this property : **_spring.cache.ehcache.config=classpath:ehcache.xml_** from the **application.properties** file.
3. Uncomment the code from the **CacheConfig.java** file which is required for EhCache Configuration.
4. Uncomment the dependencies required for EhCache in the **pom.xml** file which are commented.
