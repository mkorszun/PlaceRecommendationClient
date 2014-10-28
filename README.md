[![Build Status](https://travis-ci.org/mkorszun/PlaceRecommendationClient.svg)](https://travis-ci.org/mkorszun/PlaceRecommendationClient)
[![Coverage Status](https://coveralls.io/repos/mkorszun/PlaceRecommendationClient/badge.png?branch=master)](https://coveralls.io/r/mkorszun/PlaceRecommendationClient?branch=master)
# Place Recommendation Client

## Build
~~~bash
$ mvn clean package
~~~

## Usage
~~~bash
$ java -jar bin/GoEuroTest.jar SEARCH_PHRASE
~~~

## Example:
~~~bash
$ java -jar bin/GoEuroTest.jar BERLIN
$ cat cat out.csv
376217,Berlin,location,52.52437,13.41053
448103,Berlingo,location,45.50298,10.04366
425332,Berlingerode,location,51.45775,10.2384
425333,Berlingen,location,50.23894,6.71934
314826,Berlin Tegel,airport,52.5548,13.28903
314827,Berlin Schönefeld,airport,52.3887261,13.5180874
~~~
