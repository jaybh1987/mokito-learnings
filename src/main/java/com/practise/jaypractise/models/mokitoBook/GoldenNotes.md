
Mockito Test Process

1. Creating stubs to stand in for dependencies.
2. Setting expectations on the stubs to do what you want. 
3. Injecting the stubs into the class you're planning to test. 
4. Testing the methods in the class under test by invoking its methods, which in turn call methods on stubs.
5. Checking the methods work as expected. 
6. Verifying that the methods on the dependencies got invoked the right number of times, in the right order. 


