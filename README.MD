# Test java task implementation
---

    To run all tests:
    $ git clone https://github.com/polesskiy-dev/united-thinkers-test-task
    $ cd united-thinkers-test-task
    $ mvn clean
    $ mvn test
    
## Solution structure
---

Entities for "sale request" were implemented in separated classes, 
they're represents just major fields of "Components" from documentation. 
"component_entities" package:
> AuthInfo, AccountInfo, TransactionInfo, BillingAddressInfo, AccountData, AccountInfo

"Sale requests" classes are "class containers" - they're encapsulate component entities.
Major method - toMap() converts all aggregated classes as KeyValue map by reflection, 
where:

 * Key - component entity appropriate field (from documentation)
 * Value - actual value (assigned after class construct)
 
Sale requests class hierarchy:

| Sale request (abstract) | |
| --- | --- |
|  SaleRequestWithAccountData | SaleRequestWithAccountNumber |
|  SaleAVSRequestWithAccountData | SaleAVSRequestWithAccountNumber |

Also, utils package include HttpRequest class with SendGet(String url) method, which 
send GET request to URL and waits for response, response read through IO.

## About test classes
---
Previously, I read that we shouldn't use inheritance in unit tests,
so every test represents separate case
> ResponseCode, AVS, CSC

In test I just construct suitable Sale request class, 
convert all aggregated objects fields to GET parameters string and assert for right part of server response.

Test are parameterized by 3 values - min, max bound and some value from inside, 
and expecting response codes. 

Test will fail if timeout occurs - more than 3 seconds waiting 
or if server response not with 200 "OK" http code.
 





  
  
 
 

 
