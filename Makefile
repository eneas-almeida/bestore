.PHONY: build

build:
	clear && ./mvnw package

.PHONY: run

run:
	clear && mvn spring-boot:run

.PHONY: clean

clean:
	clear && mvn clean package

.PHONY: up

up:
	docker-compose up -d

.PHONY: down

down:
	docker-compose down
