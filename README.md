# url-utility

urlShortener is a url utility project that hosts a server with the following functions:
1. Shortens a long url into a short url (7 characters)
2. On accessing short url, redirect the short url to the original long url

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Prerequisites

What things you need to install the software and how to install them

install redis server

### Installing

A step by step series of examples that tell you how to get a development env running

End with an example of getting some data out of the system or using it for a little demo

curl -v -X POST -H "Accept: application/json" -H "Content-Type: application/json"  -d '{"url":"https://www.quora.com/What-is-the-most-efficient-algorithm-to-find-the-kth-smallest-element-in-an-array-having-n-unordered-elements"}' http://localhost:8080/urlShortner/url/

place url obtained from above into browser. You should be redirected to the long url.

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

mvn clean install

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

## Authors

* **Pooja Jadhav** - 


## License


## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
