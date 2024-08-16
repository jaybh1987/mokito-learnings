

Stub: stub is an object that stands in for dependencies and returns 
known outputs for known inputs. 

Mock: A mock is an object that does what a stub does. Plus it keeps track of 
interactions performed. By tracking interactions, a mock verifies that stubbed methods
are called by the class under test the right number of times. 
with the correct parameters in the right order. 

Spy: A spy is an object that wraps the actual dependent object. Which 
allows you to track calls to theat object by the class under test. 
A spy is similar to a mock, in that it records which methods were called. 
but a spy inokes those methods on the actual underlying object instead of on a stub.

