FROM gradle:4.3-jdk-alpine
ADD . /weather_test
WORKDIR /weather_test
USER root
RUN chown -R gradle /weather_test
USER gradle
ENV YANDEX_WEATHER_API_KEY="XXX-XXX-XXX-XXX-XXX"
CMD ["./gradlew", "--stacktrace", "test"]