# MN data 

Simple project Micronaut Data 

## Get started 

1. Create a project skeleton :

    mn create-app --lang groovy mn-data -f hibernate-jpa

2. Add MN data deps as described in the documentation 

    annotationProcessor 'io.micronaut.data:micronaut-data-processor:1.0.0.M4'
    implementation 'io.micronaut.data:micronaut-data-hibernate-jpa:1.0.0.M4'

3. Add basic *Book* entity and repository as as described in the documentation

4. Test fails with the following error message:

```
java.lang.IllegalStateException: Micronaut Data method is missing compilation time query information. Ensure that the Micronaut Data annotation processors are declared in your build and try again with a clean re-build.
	at io.micronaut.data.intercept.DataIntroductionAdvice.intercept(DataIntroductionAdvice.java:82)
	at io.micronaut.aop.chain.MethodInterceptorChain.proceed(MethodInterceptorChain.java:69)
	at mn.data.BookRepositoryTest.should save book(BookRepositoryTest.groovy:21)
```





