# weather_test

## Description

Demo automation project

## Usage

Put your API key in Dockerfile & run
`docker run --rm -it $(docker build -q .)
`
## Notes

1. WeatherEndpoints - interface class for yandex weather API
2. WeatherManager - intermediate layer with meta validation (status code, content type)
3. WeatherFunctions - Utility class for direct usage
4. WeatherServiceTests - Test class with tests
5. WeatherServiceAsserts - Assertions for tests 



