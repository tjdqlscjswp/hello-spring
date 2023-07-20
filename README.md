# hello-spring
practice for springboot

2023-07-03
Uploaded my project to practice Spring boot.
Today I learned about testing code with jUnit.


2023-07-17
1. Continueing practice test in Spring boot.
2. Writing D.I sample code
3. Using Window shortcut(Try to practice other keymap)


2023-07-18
1. Continueing practice DI in Spring Boot
3 Ways of DI.

https://velog.io/@gillog/Spring-DIDependency-Injection-%EC%84%B8-%EA%B0%80%EC%A7%80-%EB%B0%A9%EB%B2%95

1) Field Injection. Add @Autowired right infront of the field. ex) @Autowired private SampleService sampleService;
It is not a good way cause it becomes too easy to add injections below Autowired annotation.
And also it violate the rule of mmutability.

2) Setter injection
Useful when we use optional dependency. It used by set Method
It has loose dependence but without inject the concrete class of the Service class, Controller object can be generated.
So the methods inside the Service can be called, but if it called there will be a NullPointException cause the concrete class of Service has not injected by set yet.
So the problem is that it is possible to generate as much object as I want without injection of the essential object.

3) Constructor Injection
Put Autowired annotation infront of the Constructor.
Is is a recommended way. This is because it can be forced not to create an instance without a dependency that must be used.
