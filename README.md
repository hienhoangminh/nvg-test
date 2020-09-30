# nvg-test

This is my first try to implements an automation testing framework with:
- Factory patter desing: Using DriverFactory and enum driverType
- Manage test data with json file and serialize/deserialize data to object and vice versa.
- Apply method chaining to trigger the test following specific order.

To run the test:
- Simply cd to the folder and mvn clean install

Improvement later:
- Add logger and push the log to Grafana/Kibana
- Implement helper for all repetitive actions : sendKeys, etc...
- Dockerize the tests
- Apply Spring to manage data and states.
- Manage the locator in JSON file
